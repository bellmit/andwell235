package com.andawell.search.mapper;

import com.andawell.search.entity.XmlSearchAccount;
import com.andawell.search.query.XmlSearchAccountQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface XmlSearchAccountMapper {
    /**
     * xml查询功能-xml和用户绑定的表查询
     * **/
    List<XmlSearchAccount> list(@Param("query") XmlSearchAccountQuery query);


    void insert(XmlSearchAccount xmlSearchAccount);


    /**
     *
     * @mbg.generated 2020-05-25
     */
    int deleteByPrimaryKey(String id);


    /**
     *
     * @mbg.generated 2020-05-25
     */
    int insertSelective(XmlSearchAccount record);

    /**
     *
     * @mbg.generated 2020-05-25
     */
    XmlSearchAccount selectByPrimaryKey(String id);

    /**
     * 批量获取
     * @return
     */
    List<XmlSearchAccount> getList();

    /**
     *
     * @mbg.generated 2020-05-25
     */
    int updateByPrimaryKeySelective(XmlSearchAccount record);

    /**
     *
     * @mbg.generated 2020-05-25
     */
    int updateByPrimaryKeyWithBLOBs(XmlSearchAccount record);

    /**
     *
     * @mbg.generated 2020-05-25
     */
    int updateByPrimaryKey(XmlSearchAccount record);

    /**
     *
     * @mbg.generated 2020-05-25
     */
    XmlSearchAccount selectByTableName(String tableName);
}
