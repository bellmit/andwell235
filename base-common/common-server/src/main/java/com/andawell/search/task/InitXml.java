package com.andawell.search.task;


import com.andawell.search.entity.*;
import com.andawell.search.mapper.XmlSearchAccountMapper;
import com.andawell.search.util.XmlUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/***
 * @author lhb
 * @Date: 2020/5/25 14:40
 * @Description:
 * @version : V1.0
 */
@Component
@Slf4j
public class InitXml {


    @Autowired
    XmlSearchAccountMapper xmlSearchAccountTestMapper;

    //@PostConstruct
    public void updateOrInsert(String xmlName){
        String filePath = this.getClass().getResource("/xml").getPath();
        List<File> fileList = initListFile(filePath);
        for (File file : fileList) {
            // 书写自己的 xml  单一的 更新和插入
            if(file.getName().equals(xmlName+".xml")){

                XmlTableList xmlTableList =  initXmlTable(file);
                insertOrUpdate(xmlTableList);
                log.info("同步数据完成");
            }
        }
    }

    // 谨慎同步
    public void updateOrInsertAll(){
        String filePath = this.getClass().getResource("/xml").getPath();
        List<File> fileList = initListFile(filePath);
        for (File file : fileList) {
            // 书写自己的 xml  单一的 更新和插入
            XmlTableList xmlTableList =  initXmlTable(file);
            insertOrUpdate(xmlTableList);
            log.info("同步数据完成");
        }
    }

    public void selectAllWriteXml(){
        List<XmlSearchAccount> list =
                xmlSearchAccountTestMapper.getList();
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("tableList", XmlTableList.class);
        xStream.alias("table", XmlTable.class);
        xStream.autodetectAnnotations(true);
        //xStream.useAttributeFor(XmlTable.class,"table");
        xStream.alias("tableInfo", XmlTableInfo.class);
        xStream.alias("tableConfig", XmlTableConfig.class);
        xStream.alias("tableColumns",XmlTableColumns.class);
        xStream.alias("tableOptions",XmlTableOptions.class);
        xStream.alias("tableHeader",XmlTableHeader.class);
        StringBuilder stringBuilder = new StringBuilder("格式不对的文件：");
        for (XmlSearchAccount xmlSearchAccount : list) {
            try {
                File file = new File("C:\\Users\\1\\Desktop\\newXML\\"+xmlSearchAccount.getTablename()+".xml");
                String s = xmlSearchAccount.getContent();
                // 替换指定的内容，去除无用的 表头
                s.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","");
                XmlTableList xmlTableList = XmlUtil.toBean(s, XmlTableList.class);
                xmlTableList.setDescribe(xmlSearchAccount.getRemarks());
                xmlTableList.setXmlName(xmlSearchAccount.getTablename());
                if(!file.exists()){
                    try {
                        file.createNewFile();
                        System.out.println("文件创建成功");

                    }catch (IOException e){
                        System.out.println("文件创建失败");
                        e.printStackTrace();
                    }
                }
                OutputStream outputStream;
                try {
                    outputStream = new FileOutputStream(file);
                    OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                    xStream.toXML(xmlTableList,writer);
                    outputStream.close();
                    writer.close();

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
                stringBuilder.append("，数据"+xmlSearchAccount.getRemarks()+":"+xmlSearchAccount.getTablename());
                log.error(xmlSearchAccount.getRemarks()+":"+xmlSearchAccount.getTablename());
            }
            // break;
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 数据源列表
     * @param filePath
     * @return
     */
    public List<File> initListFile(String filePath){
        List<File> fileList = new ArrayList<>();
        File root = new File(filePath);
        if(!root.exists()){
            log.error("文件夹是空");
        }else {
            File[] files = root.listFiles();
            for (File file : files) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    /**
     * 组装成对象
     */

    public XmlTableList initXmlTable(File file){

        XmlTableList tableList = new XmlTableList();

        XStream xStream = new XStream(new DomDriver());
        xStream.autodetectAnnotations(true);
        xStream.processAnnotations(XmlTableList.class);
        xStream.setClassLoader(tableList.getClass().getClassLoader());
        xStream.allowTypesByWildcard(new String[]{
                "com.**"
        });

        InputStreamReader o =null;


        try {
            o = new FileReader(file);
            log.info(file.getAbsolutePath());
            tableList = (XmlTableList)  xStream.fromXML(file);
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }finally {
            if(o!=null){
                try {
                    o.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return tableList;
    }


    /**
     * 更新到数据库
     */
    public void insertOrUpdate(XmlTableList xmlTableList){

        XStream xStream = new XStream(new DomDriver("UTF-8"));
        xStream.alias("tableList",XmlTableList.class);
        xStream.alias("table", XmlTable.class);
        xStream.autodetectAnnotations(true);
        //xStream.useAttributeFor(XmlTable.class,"table");
        xStream.alias("tableInfo", XmlTableInfo.class);
        xStream.alias("tableConfig", XmlTableConfig.class);
        xStream.alias("tableColumns",XmlTableColumns.class);
        xStream.alias("tableOptions",XmlTableOptions.class);
        xStream.alias("tableHeader",XmlTableHeader.class);
        if(StringUtils.isBlank(xmlTableList.getXmlName())){
            log.error(String.format("插入数据源xmlName:%s失败",xmlTableList.getXmlName()));
            return;
        }
        if(StringUtils.isBlank(xmlTableList.getDescribe())){
            log.error(String.format("插入数据源describe:%s失败",xmlTableList.getXmlName()));
            return;
        }

        XmlSearchAccount xmlSearchAccountTest =
                xmlSearchAccountTestMapper.
                        selectByTableName(xmlTableList.getXmlName());
        if(xmlSearchAccountTest == null){
            log.info( String.format("插入数据源:%s",xmlTableList.getXmlName()));
            xmlSearchAccountTest = new XmlSearchAccount();
            xmlSearchAccountTest.setTablename(xmlTableList.getXmlName());
            xmlSearchAccountTest.setRemarks(xmlTableList.getDescribe());
            xmlSearchAccountTest.setContent( xStream.toXML(xmlTableList));
            xmlSearchAccountTest.setCreateTime(new Date());
            xmlSearchAccountTest.setId(UUID.randomUUID().toString().replace("-",""));
            int n = xmlSearchAccountTestMapper.insertSelective(xmlSearchAccountTest);
            if(n<=0){
                log.error(String.format("插入数据源%s失败",xmlTableList.getXmlName()));
            }
        }
        if(xmlSearchAccountTest != null){
            log.info( String.format("更新数据源%s",xmlTableList.getXmlName()));
            xmlSearchAccountTest.setRemarks(xmlTableList.getDescribe());
            xmlSearchAccountTest.setContent(xStream.toXML(xmlTableList));
            int n = xmlSearchAccountTestMapper.updateByPrimaryKeySelective(xmlSearchAccountTest);
            if(n<=0){
                log.error(String.format("更新数据源%s失败",xmlTableList.getXmlName()));
            }
        }

    }
}
