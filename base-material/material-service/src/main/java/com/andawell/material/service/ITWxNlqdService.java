package com.andawell.material.service;

import com.andawell.material.dto.TWxNlqdDTO;
import com.andawell.material.entity.TWxNl;
import com.andawell.material.entity.TWxNlTemp;
import com.andawell.material.entity.TWxNlqd;
import com.andawell.material.entity.TWxNlqdTemp;
import com.andawell.material.query.TWxNlQuery;
import com.andawell.material.query.TWxNlTempQuery;
import com.andawell.material.query.TWxNlqdQuery;
import com.andawell.material.query.TWxNlqdTempQuery;
import com.andawell.material.vo.TWxNlTempVO;
import com.andawell.material.vo.TWxNlqdTempVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/9
 * @description:
 */
public interface ITWxNlqdService {

    /**
     *@Auther:zje
     *@Date:2020/5/9
     *@Description:新增维修单位
     *@Param:
     *@return:
     */
    void insert(TWxNlqdDTO wxNlqdDTO);

    /**
     *@Auther:zje
     *@Date:2020/5/9
     *@Description:修改维修单位
     *@Param:
     *@return:
     */
    void update(TWxNlqdDTO wxNlqdDTO);

    /**
     *@Auther:zje
     *@Date:2020/5/9
     *@Description:删除维修单位
     *@Param:
     *@return:
     */
    void delete(Integer pId, String cfId);

    /**
     *@Auther:zje
     *@Date:2020/5/9
     *@Description:删除全部
     *@Param:
     *@return:
     */
    void deleteAll(Integer id);

    /**
     *@Author: liuys
     *@Data: 2020/6/9
     *@Description: 下发
     */
    Boolean transmission(HttpServletResponse response, List<TWxNlqdQuery> tWxNlqdQuery);

    /**
     *@Author: liuys
     *@Data: 2020/6/9
     *@Description: 上传
     */
    Boolean upload(MultipartFile multipartFile);

    /**
     *@Author: liuys
     *@Data: 2020/6/10
     *@Description: 数据的迁移
     */
    Boolean dataLocally(List<TWxNlqdTempQuery> tWxNlqdTempQuery);

    Boolean deleteDataLocally(List<TWxNlqdTempQuery> tWxNlqdTempQuery);

    TWxNlqd getWxnlqd(TWxNlqdDTO wxNlqdDTO);
}
