package com.andawell.material.service.impl;

import com.andawell.common.util.FileUtils;
import com.andawell.common.util.PropertyException;
import com.andawell.common.util.SQLiteUtils;
import com.andawell.material.config.Upload;
import com.andawell.material.dto.TWxNlqdDTO;
import com.andawell.material.entity.TWxNl;
import com.andawell.material.entity.TWxNlTemp;
import com.andawell.material.entity.TWxNlqd;
import com.andawell.material.entity.TWxNlqdTemp;
import com.andawell.material.enumeration.TableNameStyle;
import com.andawell.material.mapper.TWxNlMapper;
import com.andawell.material.mapper.TWxNlTempMapper;
import com.andawell.material.mapper.TWxNlqdMapper;
import com.andawell.material.mapper.TWxNlqdTempMapper;
import com.andawell.material.query.TWxNlQuery;
import com.andawell.material.query.TWxNlTempQuery;
import com.andawell.material.query.TWxNlqdQuery;
import com.andawell.material.query.TWxNlqdTempQuery;
import com.andawell.material.service.ITWxNlqdService;
import com.andawell.material.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/9
 * @description:
 */
@Slf4j
@Service
public class TWxNlqdServiceImpl implements ITWxNlqdService {

    @Autowired
    private TWxNlMapper wxNlMapper;

    @Autowired
    private TWxNlqdMapper wxNlqdMapper;

    @Autowired
    private Upload upload;

    @Autowired
    private TWxNlTempMapper tWxNlTempMapper;

    @Autowired
    private TWxNlqdTempMapper tWxNlqdTempMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(TWxNlqdDTO wxNlqdDTO) {

        TWxNl tWxNl = wxNlMapper.selectWxNl(wxNlqdDTO.getJxId(), wxNlqdDTO.getJhId());
        if (tWxNl == null) {
            tWxNl = new TWxNl();
            int maxId = wxNlMapper.selectMaxId();
            maxId = maxId + 1;
            tWxNl.setId(maxId);
            tWxNl.setJx(wxNlqdDTO.getJxId());
            tWxNl.setJh(wxNlqdDTO.getJhId());
            wxNlMapper.insertSelective(tWxNl);
        }

        TWxNlqd wxNlqd = BeanUtils.dtoTODO(wxNlqdDTO, TWxNlqd.class);
        if (wxNlqd != null) {
            wxNlqd.setPid(tWxNl.getId());
            wxNlqdMapper.insertSelective(wxNlqd);
        }
    }

    @Override
    public void update(TWxNlqdDTO wxNlqdDTO) {
        TWxNl tWxNl = wxNlMapper.selectWxNl(wxNlqdDTO.getJxId(), wxNlqdDTO.getJhId());
        Integer id = tWxNl.getId();
        TWxNlqd wxNlqd = BeanUtils.dtoTODO(wxNlqdDTO, TWxNlqd.class);
        wxNlqd.setPid(id);
        wxNlqdMapper.updateByPrimaryKeySelective(wxNlqd);
    }

    @Override
    public void delete(Integer pId, String cfId) {
        wxNlqdMapper.deleteByPrimaryKey(pId, cfId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll(Integer id) {
        wxNlMapper.deleteByPrimaryKey(id);
        List<TWxNlqd> tWxNlqds = wxNlqdMapper.selectByPId(id);
        if (!CollectionUtils.isEmpty(tWxNlqds)) {
            tWxNlqds.stream().forEach(tWxNlqd -> {
                String cfid = tWxNlqd.getCfid();
                wxNlqdMapper.deleteByPrimaryKey(id, cfid);
            });
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean transmission(HttpServletResponse response, List<TWxNlqdQuery> tWxNlqdQuery) {
        TWxNlQuery tWxNlQuery = new TWxNlQuery();
        ArrayList<Integer> ids = new ArrayList<>();
        for (TWxNlqdQuery wxNlqdQuery : tWxNlqdQuery) {
            ids.add(wxNlqdQuery.getPid());
        }
        tWxNlQuery.setIds(ids);
        List<TWxNl> tWxNlList = wxNlMapper.selectByQuery(tWxNlQuery);
        //清楚数据,导入新信息
        SQLiteUtils.closezb(TableNameStyle.T_WX_NL.getName());
        SQLiteUtils.transmission(tWxNlList, TableNameStyle.T_WX_NL.getName());
        //清楚清单信息,导入新信息
        for (TWxNlqdQuery wxNlqdQuery : tWxNlqdQuery) {
            SQLiteUtils.closezb(TableNameStyle.T_WX_NLQD.getName());
            for (TWxNl tWxNl : tWxNlList) {
                TWxNlqd tWxNlqd = wxNlqdMapper.selectByPrimaryKey(wxNlqdQuery.getPid(), wxNlqdQuery.getCfid());
                SQLiteUtils.transmission(tWxNlqd, TableNameStyle.T_WX_NLQD.getName());
            }
        }
        FileUtils.download(response);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean upload(MultipartFile multipartFile) {
        String path = upload.getPath();
        //将前端文件保存到服务器本地
        String upload1 = FileUtils.upload(multipartFile, path);
        List<TWxNl> tWxNlList;
        List<TWxNlqd> tWxNlqdList;
        try {
            //获取db信息
            tWxNlList = SQLiteUtils.upload(new TWxNl(), TableNameStyle.T_WX_NL.getName(), upload1);
            tWxNlqdList = SQLiteUtils.upload(new TWxNlqd(), TableNameStyle.T_WX_NLQD.getName(), upload1);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
            throw new PropertyException("导入失败");
        }
        List<TWxNlTemp> tWxNlTempList = BeanUtils.copyList(tWxNlList, TWxNlTemp.class);
        for (TWxNlTemp tWxNlTemp : tWxNlTempList) {
            try {
                tWxNlTempMapper.insertSelective(tWxNlTemp);
            } catch (Exception e) {
                tWxNlTempMapper.updateByPrimaryKeySelective(tWxNlTemp);
            }
        }
        List<TWxNlqdTemp> tWxNlqdTempList = BeanUtils.copyList(tWxNlqdList, TWxNlqdTemp.class);
        for (TWxNlqdTemp tWxNlqdTemp : tWxNlqdTempList) {
            try {
                tWxNlqdTempMapper.insertSelective(tWxNlqdTemp);
            } catch (Exception e) {
                tWxNlqdTempMapper.updateByPrimaryKeySelective(tWxNlqdTemp);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean dataLocally(List<TWxNlqdTempQuery> tWxNlqdTempQuerys) {
        for (TWxNlqdTempQuery tWxNlqdTempQuery : tWxNlqdTempQuerys) {
            //将前端选择的主信息和清单信息进行迁移
            TWxNlTempQuery tWxNlTempQuery = new TWxNlTempQuery();
            tWxNlTempQuery.setId(tWxNlqdTempQuery.getPid());
            List<TWxNlTemp> tWxNlTempList = tWxNlTempMapper.selectByQuery(tWxNlTempQuery);
            for (TWxNlTemp tWxNlTemp : tWxNlTempList) {
                TWxNl tWxNl = BeanUtils.dtoTODO(tWxNlTemp, TWxNl.class);
                //当前数据有不进行操作
                try {
                    wxNlMapper.insertSelective(tWxNl);
                } catch (Exception e) {
                    e.getMessage();
                }
                //根据清单信息删除主信息
                TWxNlqdTempQuery query =new TWxNlqdTempQuery();
                query.setPid(tWxNlqdTempQuery.getPid());
                List<TWxNlqdTemp> tWxNlqdTempList = tWxNlqdTempMapper.selectByQuery(query);
                if (tWxNlqdTempList.size()==0) {
                    tWxNlTempMapper.deleteByPrimaryKey(tWxNlTemp.getId());
                }
                //导入清单信息
                TWxNlqdTemp tWxNlqdTemp = tWxNlqdTempMapper.selectByPrimaryKey(tWxNlqdTempQuery.getPid(), tWxNlqdTempQuery.getCfid());
                TWxNlqd tWxNlqd = BeanUtils.dtoTODO(tWxNlqdTemp, TWxNlqd.class);
                try {
                    wxNlqdMapper.insertSelective(tWxNlqd);
                } catch (Exception e) {
                    wxNlqdMapper.updateByPrimaryKey(tWxNlqd);
                }
                //删除当前信息
                tWxNlqdTempMapper.deleteByPrimaryKey(tWxNlqdTemp.getPid(), tWxNlqdTemp.getCfid());
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteDataLocally(List<TWxNlqdTempQuery> tWxNlqdTempQuery) {
        for (TWxNlqdTempQuery wxNlqdTempQuery : tWxNlqdTempQuery) {
            tWxNlqdTempMapper.deleteByPrimaryKey(wxNlqdTempQuery.getPid(),wxNlqdTempQuery.getCfid());
        }
        return true;
    }

    @Override
    public TWxNlqd getWxnlqd(TWxNlqdDTO wxNlqdDTO) {
        TWxNl tWxNl = wxNlMapper.selectWxNl(wxNlqdDTO.getJxId(), wxNlqdDTO.getJhId());
        if(tWxNl!=null){
            return wxNlqdMapper.selectByPrimaryKey(tWxNl.getId(),wxNlqdDTO.getCfid());
        }
        return null;
    }
}
