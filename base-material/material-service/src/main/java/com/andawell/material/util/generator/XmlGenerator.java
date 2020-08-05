package com.andawell.material.util.generator;

import java.io.*;

import com.andawell.common.util.XmlUtil;
import com.andawell.search.entity.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.http.impl.conn.Wire;

import java.nio.charset.Charset;
import java.util.*;

/**
 * @Date： 2020/5/8 20:04
 */
public class XmlGenerator {
    
    public static XmlResource getResouceXml(){


        XStream xStream = new XStream(new DomDriver());
        xStream.autodetectAnnotations(true);
        xStream.processAnnotations(XmlResource.class);
        xStream.allowTypesByWildcard(new String[]{
                "com.**"
        });

        InputStreamReader o =null;

        XmlResource resource = null;



        File file = new File("E:\\new1.xml");


        try {
            o = new FileReader(file);

           // resource = XmlUtil.filetoBean(file,XmlResource.class);
            // XmlUtil.toBean(file,XmlResource.class);
            resource = (XmlResource) xStream.fromXML(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(o!=null){
                try {
                    o.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        //System.out.println(resource.toString());
        return resource;
    } 

    private static void exportResource() {
        XStream xStream = new XStream(new DomDriver());
        String caption = "调拨单打印";
        XmlTableList xmlTableList = new XmlTableList();
        List<XmlTable> xmlTables = new ArrayList<>();
        XmlResource resource = getResouceXml();
        for (View view : resource.getColumnList()) {
            XmlTable xmlTable = new XmlTable();

            // 存储 XmlTableInfo
            XmlTableInfo tableInfo = new XmlTableInfo();
            tableInfo.setCaption(caption);
            tableInfo.setSql(view.getSQL());
            tableInfo.setTableName(view.getNAME());
            xmlTable.setXmlTableInfo(tableInfo);

            // 存储 xmlTableConfig
            XmlTableConfig xmlTableConfig  = new XmlTableConfig();

            // 存储 tableColumns
            XmlTableColumns tableColumns = new XmlTableColumns();

                // 存储 tableOptions
                XmlTableOptions options = new XmlTableOptions();
                options.setModelName(caption);
                options.setType("table");
                options.setMutiSelect(false);
                options.setIndex(false);
                options.setBorder(true);
                options.setHeight("200");
                options.setInitTable(true);
                options.setLoading(false);
                options.setPagination(false);
                options.setStripe(false);
                tableColumns.setOptions(options);

                // 存储 XmlTableHeader
                List<XmlTableHeader> columns = new LinkedList<XmlTableHeader>();
                for (Column column :  view.getColumnList()) {
                    XmlTableHeader xmlTableHeader = new XmlTableHeader();
                    xmlTableHeader.setLabel(column.getCAPTION());
                    xmlTableHeader.setProp(column.getFIELD().toLowerCase());
                    Boolean show = false;
                    if(column.getSHOW().equals("1")){
                        show = true;
                    }
                    Integer n = (column.getCAPTION().length())*30;
                    xmlTableHeader.setWidth(n.toString());
                    xmlTableHeader.setShow(show);
                    xmlTableHeader.setAlign("center");
                    xmlTableHeader.setFixed(false);
                    xmlTableHeader.setFilters(false);
                    xmlTableHeader.setMinWidth("30");
                    xmlTableHeader.setSortable(false);
                    xmlTableHeader.setIsEdit(true);
                    xmlTableHeader.setEditType("input");
                    xmlTableHeader.setParent("false");

                    columns.add(xmlTableHeader);
                }

                tableColumns.setColumns(columns);
                xmlTableConfig.setTableColumns(tableColumns);
            xmlTable.setXmlTableConfig(xmlTableConfig);
            xmlTables.add(xmlTable);
            xmlTableList.setXmlTable(xmlTables);

            xStream.alias("tableList",XmlTableList.class);
            xStream.alias("table",XmlTable.class);
            xStream.autodetectAnnotations(true);
            //xStream.useAttributeFor(XmlTable.class,"table");
            xStream.alias("tableInfo",XmlTableInfo.class);
            xStream.alias("tableConfig",XmlTableConfig.class);
            xStream.alias("tableColumns",XmlTableColumns.class);
            xStream.alias("tableOptions",XmlTableOptions.class);
            xStream.alias("tableHeader",XmlTableHeader.class);


            String xmlFileName = "xmlTableList.xml";

            File file = new File("C:\\Users\\1\\Desktop"+xmlFileName);

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
                OutputStreamWriter writer = new OutputStreamWriter(outputStream, Charset.forName("GBK"));
                xStream.toXML(xmlTableList,writer);
                outputStream.close();
                writer.close();

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args)  {
        exportResource();
    }
}
