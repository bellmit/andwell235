package com.andawell.material.service.impl;

import com.andawell.material.entity.TJhImage;
import com.andawell.material.mapper.TJhImageMapper;
import com.andawell.material.service.ITJhImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author: zje
 * @date: 2020/5/7
 * @description:
 */
@Service
public class TJhImageServiceImpl implements ITJhImageService {

    @Autowired
    TJhImageMapper jhImageMapper;

    @Override
    public void insert(TJhImage jhImage,MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                byte[] image = new byte[(int) file.getSize()];
                InputStream inputStream = file.getInputStream();
                inputStream.read(image);
                jhImage.setImage(image);
                jhImageMapper.insert(jhImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TJhImage jhImage, MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                byte[] image = new byte[(int) file.getSize()];
                InputStream inputStream = file.getInputStream();
                inputStream.read(image);
                jhImage.setImage(image);
                jhImageMapper.updateByPrimaryKeyWithBLOBs(jhImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TJhImage select(String jh, HttpServletResponse response) {
        try {
            TJhImage jhImage = jhImageMapper.selectByPrimaryKey(jh);
            if (jhImage == null){
               return null;
            }
            byte[] image = jhImage.getImage();
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            OutputStream outputStream = response.getOutputStream();
            InputStream in = new ByteArrayInputStream(image);
            int len=0;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes,0,1024)) != -1){
                outputStream.write(bytes,0,1024);
            }
            outputStream.close();
            return jhImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(String jh) {
        jhImageMapper.deleteByPrimaryKey(jh);
    }


}
