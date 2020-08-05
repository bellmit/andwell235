package com.andawell.material.service.impl;

import com.andawell.common.util.FileUtils;
import com.andawell.common.util.SQLiteUtils;
import com.andawell.material.config.SQLiteConfig;
import com.andawell.material.entity.*;
import com.andawell.material.enumeration.TableNameStyle;
import com.andawell.material.mapper.*;
import com.andawell.material.service.ISjClService;
import com.andawell.material.util.SjdcUtile;
import com.andawell.material.util.StringTabaleName;
import com.andawell.material.vo.TDataStateVO;
import com.andawell.material.vo.TDataVO;
import com.andawell.material.vo.TSjCsVO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: shs
 * @date: 2020/5/29
 * @description:数据导入导出
 */
@Service
public class SjClServiceImpl implements ISjClService, ApplicationContextAware {
    @Autowired
    private TCkCkMapper tCkCkMapper;
    @Autowired
    private TCkDxMapper tCkDxMapper;
    @Autowired
    private TCkSxMapper tCkSxMapper;
    @Autowired
    private TXtDwMapper tXtDwMapper;
    @Autowired
    private TSjCsMapper tSjCsMapper;

    private static ApplicationContext applicationContext;

    /***
     * @author shs
     * @Date: 2020/5/29 18:42
     * @Description:
     *  1.初始化文件
     *  2.复制一份db模板
     *  3.清空db文件相关表数据
     *  4.通过传入的表名判断属于那张表（库存信息，库存待修，库存送修）
     *  5.查询出对应数据
     *  6.删除db文件数据
     *  7.插入db文件对应表中
     *  8.下载db文件
     *  9.删除模板文件
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(HttpServletResponse response, List<String> list) {
        //初始化参数
        SQLiteConfig.initial();
        //拷贝db文件
        Boolean copy = FileUtils.copy();
        if (copy) {
            for (int i = 0; i < list.size(); i++) {
                String sjm = list.get(i);
                if (sjm.equals("T_CK_CK")) {
                    //对tckck所有数据进行查询
                    List<TCkC> tCkCks = tCkCkMapper.select();
                    try {
                        SQLiteUtils.closezb("T_CK_CK");
                        SQLiteUtils.transmission(tCkCks, TableNameStyle.T_CK_CK.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (sjm.equals("T_CK_DX")) {
                    //对tckdx所有数据进行查询
                    List<TCkD> tCkDxes = tCkDxMapper.select();
                    try {
                        SQLiteUtils.closezb("T_CK_DX");
                        for (TCkD tCkDx : tCkDxes) {
                            TCkD tCkD = FileUtils.convertData(tCkDx);
                            SQLiteUtils.transmission(tCkD, TableNameStyle.T_CK_DX.getName());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (sjm.equals("T_CK_SX")) {
                    //对tcksx所有数据进行查询
                    List<TCkS> tCkSxes = tCkSxMapper.select();
                    try {
                        SQLiteUtils.closezb("T_CK_SX");
                        for (TCkS tCkSx : tCkSxes) {
                            TCkS tCkS = FileUtils.convertData(tCkSx);
                            SQLiteUtils.transmission(tCkS, TableNameStyle.T_CK_SX.getName());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            FileUtils.download(response);
            FileUtils.deleteFile();
        }
    }
    /***
     * @author shs
     * @Date: 2020/6/30 18:42
     * @Description:
     *  1.获取db对应路径
     *  2.获取前端传过来的所有表名
     *  3.通过表名删除对应表中数据
     *  4.通过反射获取对应mappeer的insertSelective方法进行数据添加
     *  5.通过遍历插入所有数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploading(List<String> list, String url) {
        for (int i = 0; i < list.size(); i++) {
            //获取表名
            String bm = list.get(i);
            //查出sqlite里面对应表的数据
            try {
                //删除对应表oracle中数据
                String tabale = list.get(i);
                String s = StringTabaleName.ChangeName(tabale);
                StringBuilder pakage3 = new StringBuilder();
                pakage3.append("com.andawell.material.mapper.");
                //对传入的表名进行解析拼接承mapper
                java.lang.String tableName1 = s;
                pakage3.append(tableName1);
                //获取到对应的mapper
                Class<?> ClassMapper1 = Class.forName(pakage3.toString());
                //获取对应的方法
                Method delete = ClassMapper1.getMethod("deleteSqlLiteList");
                //获取对应的bean文件
                Object bean1 = applicationContext.getBean(ClassMapper1);
                delete.invoke(bean1);
                //添加对应表数据
                String ss = StringTabaleName.ChangeName(bm);
                StringBuilder pakage = new StringBuilder();
                pakage.append("com.andawell.material.mapper.");
                //对传入的表名进行解析拼接承mapper
                java.lang.String tableName = ss;
                pakage.append(tableName);
                //获取到对应的mapper
                Class<?> ClassMapper = Class.forName(pakage.toString());
                //获取到类名
                String Lm = StringTabaleName.BeanName(bm);
                StringBuilder pakage1 = new StringBuilder();
                pakage1.append("com.andawell.material.entity.");
                pakage1.append(Lm);
                //拿到实体类
                Class<?> STL = Class.forName(pakage1.toString());
                Method insert = ClassMapper.getMethod("insertSelective", STL);
                //获取对应的bean文件
                Object bean = applicationContext.getBean(ClassMapper);
                List<?> tList = SQLiteUtils.upload(STL.newInstance(), bm, url);
                for (int j = 0; j < tList.size(); j++) {
                    insert.invoke(bean, tList.get(j));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /***
     * @author shs
     * @Date: 2020/6/30 18:42
     * @Description:
     *  1.获得db文件路径
     *  2.查询中间表里存储对应表的名字
     *  3.根据表名去db查询对应表是否有数据
     *  4.有数据为true否则改为false
     *  5.将db文件的中间表信息查询
     *  6.返回给前端展示
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TSjCs> filelist(String upload) {
        //获得路径
        SQLiteUtils.setPath(upload);
        //通过解析db文件查看参数表中哪些表是有数据的，通过code提示前端
        List<TSjCs> cslist = tSjCsMapper.list();
        for (int i = 0; i < cslist.size(); i++) {
            //获取每一个表名
            String tabalName = cslist.get(i).getTabalName();
            //判断db文件中对应表数据，如果有code改为true，否则为false
            //TODO comm代码
            Integer count = SQLiteUtils.code(tabalName);
            if (count <= 0) {
                //无数据,sjcs表code狀態修改为false
                SQLiteUtils.update(tabalName);
            }
        }
        List<TSjCs> upload1 = null;
        String name = TableNameStyle.T_SJ_CS.getName();
        TSjCs tSjCs = new TSjCs();
        try {
            //获取修改后的db文件
            String newFile = String.valueOf(FileUtils.getNewSqlist());
            String url = newFile.replace("\\", "/");
            upload1 = SQLiteUtils.upload(tSjCs, name, url);
            return upload1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    /***
     * @author shs
     * @Date: 2020/6/30 18:42
     * @Description:
     *  1.获得db文件路径
     *  2.获取单位id
     *  3.获取对应表名
     *  4.清除对应表数据
     *  5.查出db文件对应表数据
     *  6.进行批量插入
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertOracle(List<String> list, String url) {
        //获得路径
        SQLiteUtils.setPath(url);
        String dwid = null;
        for (int i = 0; i < list.size(); i++) {
            String id = list.get(i);
            //获取单位id
            if (!(id.equals("T_CK_DX")) || !(id.equals("T_CK_SX")) || !(id.equals("T_CK_DX"))) {
                dwid = id;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String bm = list.get(i);
            if (bm.equals("T_CK_DX")) {
                //删除oracle对应数据
                tCkDxMapper.deleteCkdx(dwid);
                //查询出sqlite里面数据
                try {
                    List<TCkD> ckDxes = SQLiteUtils.upload(new TCkD(), TableNameStyle.T_CK_DX.getName(), url);
                    //判断id为选中的
                    for (int j = 0; j < ckDxes.size(); j++) {
                        //获取待修数据
                        TCkD tCkD = ckDxes.get(j);
                        if (tCkD.getDwid().equals(dwid)) {
                            tCkDxMapper.insertckdx(tCkD);
                        }
                    }
//                    List<TCkD> ckDxes = SjdcUtile.CkDxlist();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (bm.equals("T_CK_SX")) {
                //删除oracle对应数据
                tCkSxMapper.deleteCksx(dwid);
                try {
                    //从sqlite取出送修数据
                    List<TCkS> tCkSxes = SQLiteUtils.upload(new TCkS(), TableNameStyle.T_CK_SX.getName(), url);
//                    List<TCkS> tCkSxes = SjdcUtile.ckSxlist(url);
                    for (int j = 0; j < tCkSxes.size(); j++) {
                        //获取待修数据
                        TCkS tCkS = tCkSxes.get(j);
                        if (tCkS.getDwid().equals(dwid)) {
                            tCkSxMapper.insertcksx(tCkS);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (bm.equals("T_CK_CK")) {
                //清除oracle数据库相关表数据
                tCkCkMapper.deleteCkck(dwid);
                try {
                    List<TCkC> tCkCks = SQLiteUtils.upload(new TCkC(), TableNameStyle.T_CK_CK.getName(), url);
//                    List<TCkCk> tCkCks = SjdcUtile.Ckcklist();
                    for (int j = 0; j < tCkCks.size(); j++) {
                        //获取待修数据
                        TCkC tCkC = tCkCks.get(j);
                        if (tCkC.getDwid().equals(dwid)) {
                            tCkCkMapper.inserttckck(tCkC);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /***
     * @author shs
     * @Date: 2020/6/30 18:42
     * @Description:
     *  1.获得db文件路径
     *  2.查询db文件中对应表数据是否为空，并且获取对应单位id
     *  3.根据单位id查询出对应的单位名称
     *  4.将返回的单位名称添加到实体
     *  5.返回给前端展示
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public TDataVO dataStatelist(String url) {
        //获得路径
        SQLiteUtils.setPath(url);
        //查询出单位名称和动态表信息
        List<TDataStateVO> list = null;
        TDataVO tDataVO = null;
        try {
            tDataVO = SjdcUtile.dataStatelist(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<TDataStateVO> dwmc = tDataVO.getDwmc();
        for (int i = 0; i < dwmc.size(); i++) {
            //取出每一个对象
            TDataStateVO tDataStateVO = dwmc.get(i);
            //查出每一个名称
            String mc = tXtDwMapper.selectMc(tDataStateVO.getDwid());
            tDataStateVO.setMc(mc);
        }
        tDataVO.setDwmc(dwmc);
        return tDataVO;
    }

    @Override
    public List<TSjCsVO> cslist() {
        //查询出表名和描述返回给前端
        return tSjCsMapper.cslist();
    }

    /***
     * @author shs
     * @Date: 2020/5/29 15:42
     * @Description:
     *  1.初始化文件
     *  2.复制一份db模板
     *  3.清空db文件相关表数据
     *  4.通过传入的表名获取对应的mapper
     *  5.通过对应表的mapper调用getSqlLiteList方法查询出相关表数据
     *  6.将查询的数据插入对应db里的表
     *  7.删除管理表的数据
     *  8.查询管理表的数据导入对应的db文件表中
     *  9.下载db文件并导出
     *  10.清除db模板文件
     */
    @Override
    public void derivation(HttpServletResponse response, List<String> list) {
        //初始化参数
        SQLiteConfig.initial();
        Boolean copy = FileUtils.copy();
        if (copy) {
            //遍历前端发送的表集合
            for (int i = 0; i < list.size(); i++) {
                try {
                    String tabale = list.get(i);
                    //清空sql表数据
                    SQLiteUtils.closezb(tabale);
                    String s = StringTabaleName.ChangeName(tabale);
                    StringBuilder pakage = new StringBuilder();
                    pakage.append("com.andawell.material.mapper.");
                    //对传入的表名进行解析拼接承mapper
                    java.lang.String tableName = s;
                    pakage.append(tableName);
                    //获取到对应的mapper
                    Class<?> ClassMapper = Class.forName(pakage.toString());
                    //获取对应的方法
                    Method method = ClassMapper.getMethod("getSqlLiteList");
                    //获取对应的bean文件
                    Object bean = applicationContext.getBean(ClassMapper);
                    //根据表明查询出对应的list
                    List<T> tList = (List<T>) method.invoke(bean);
                    //插入到对应db文件
                    SQLiteUtils.transmission(tList, tabale);
                } catch (ClassNotFoundException | NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //删除数据管理表的数据
            SQLiteUtils.closezb(TableNameStyle.T_SJ_CS.getName());
            //加载数据管理表的数据
            List<TSjCs> list1 = tSjCsMapper.list();
            for (TSjCs tSjCs : list1) {
                TSjCs tCkSx = FileUtils.convertData(tSjCs);
                SQLiteUtils.transmission(tCkSx, TableNameStyle.T_SJ_CS.getName());
            }
            FileUtils.download(response);
            FileUtils.deleteFile();
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
