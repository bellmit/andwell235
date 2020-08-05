package com.andawell.material.service;

import com.andawell.material.entity.TJhImage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * * @author lhb
 *  * @Date: 2020/4/27 14:40
 *  * @Description:
 *  * @version : V1.0
 */
public interface ITJhImageService {

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:添加图片
     *@Param:
     *@return:
     */
    void insert(TJhImage jhImage,MultipartFile file);

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:修改图片
     *@Param:
     *@return:
     */
    void update(TJhImage jhImage,MultipartFile file);

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:查询图片
     *@Param:
     *@return:
     */
    TJhImage select(String jh, HttpServletResponse response);

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:删除图片
     *@Param:
     *@return:
     */
    void delete(String jh);

}
