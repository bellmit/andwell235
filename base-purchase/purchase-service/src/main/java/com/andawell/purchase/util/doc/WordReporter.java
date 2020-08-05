package com.andawell.purchase.util.doc;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @Author: yzy
 * @Description:   输出页面底部的循环数据
 * @Date: created in 2020/6/5 10:31
 */
public class WordReporter {

    private String tempLocalPath;
    private XWPFDocument xwpfDocument = null;
    private HWPFDocument hwpfDocument = null;
    private OutputStream outputStream = null;
    private FileInputStream inputStream = null;

    public WordReporter() {
    }

    public WordReporter(String tempLocalPath) {
        this.tempLocalPath = tempLocalPath;
    }

    /**
     * 设置模板路径
     *
     * @param tempLocalPath
     */
    public void setTempLocalPath(String tempLocalPath) {
        this.tempLocalPath = tempLocalPath;
    }

    /**
     * 初始化
     *
     * @throws IOException
     */
    public void init() {
        try {
            inputStream = new FileInputStream(new File(this.tempLocalPath));
            xwpfDocument = new XWPFDocument(inputStream);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出方法
     *
     * @param params
     * @param tableIndex
     * @return
     */
    public boolean export(List<Map<String, String>> params, int tableIndex, int tempRowNum, int blankRowNum) {
        try {
            this.insertValueTOTable(xwpfDocument, params, tableIndex,tempRowNum,blankRowNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 循环填充表格内容
     * 1.获取模板行
     * 2.获取空白行
     * 3.循环复制空白行并进行数据填写
     * 4.删除空白行和模板行
     * @param xwpfDocument
     * @param params       数据
     * @param tableIndex   第几个表格
     * @param tempRowNum   模板行第几行
     * @param blankRowNum  空白行第几行
     */
    private void insertValueTOTable(XWPFDocument xwpfDocument, List<Map<String, String>> params,
                                    int tableIndex, int tempRowNum, int blankRowNum) {
        //获取对应的表格集合
        List<XWPFTable> tableList = xwpfDocument.getTables();
        if (tableList.size() <= tableIndex) {
            try {
                throw new Exception("tableIndex对象的表格不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //获取对应的第几个表格
        XWPFTable table = tableList.get(tableIndex);
        //获取表格对应的行数
        List<XWPFTableRow> rows = table.getRows();
        if (rows.size() < 2) {
            try {
                throw new Exception("tableIndex对应的表格应该为2行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //获取标签模板对应所在的行
        XWPFTableRow tempRow = rows.get(tempRowNum);
        //获取标签模板对应的列集合
        List<XWPFTableCell> tempCells = tempRow.getTableCells();

        //获取对应的空白行配置
//        XWPFTableRow row = table.getRow(2);
        XWPFTableRow row = rows.get(blankRowNum);
        for (int i = 1; i <= params.size(); i++) {
            //获取对应的行数据
            Map<String, String> map = params.get(i-1);
            System.out.println("对应的第" + i + "行数据" + map.toString());
            //创建新的一行
//            XWPFTableRow row = table.createRow();
//            XWPFTableRow row = table.insertNewTableRow(i);
//            table.addNewRowBetween(0,1);
            //获取标签模板所在行的行高 设置为新空白行的行高
            row.setHeight(tempRow.getHeight());
            copy(table, blankRowNum, i + blankRowNum);
            //table.addRow(row, i + 2);
            //获取表格对应的行数
            //List<XWPFTableRow> rowss = table.getRows();
            //table.addNewRowBetween(rowss.size() - 1, rowss.size());
            List<XWPFTableCell> cells = table.getRow(i + blankRowNum).getTableCells();
            for (int j = 0; j < cells.size(); j++) {
                //获取模板列所在的标签
                XWPFTableCell tempCell = tempCells.get(j);
                //获取空白行所在的列
                XWPFTableCell cell = cells.get(j);
                String cellText = tempCell.getText();
//                System.out.println("cellText outer:" + cellText);
                cell.setText("");
//                System.out.println("text---111--" + cell.getText());
                if (cellText != null && !"".equals(cellText)) {
                    //转换mapKey对应的字段
                    String cellTextKey = cellText.replace("${", "").replace("}", "");
                    //替换cellTextKey的Key
                    if (map.containsKey(cellTextKey)) {
                        //填充内容，并且复制之模板行的属性
//                        cell.setText("11111111111111");
                        String value = map.get(cellTextKey);
                        //参数   模板对应的位置、空白行对应的位置  、需要替换的值
                        setCellText(tempCell, cell, value);
                        String text = cell.getText();
//                        System.out.println("text---sss--" + text);
                    }
//                    System.out.println("cellText innner" + cellText);
                }
            }

        }
        //先删除下边的表格  我的空白行在下边，模板行在上边
        table.removeRow(blankRowNum);
        table.removeRow(tempRowNum);
    }


    private void copy(XWPFTable table, int copyIndex, int rowIndex) {
        XWPFTableRow targetRow = table.insertNewTableRow(rowIndex);
        XWPFTableRow sourceRow = table.getRow(copyIndex);
        targetRow.getCtRow().setTrPr(sourceRow.getCtRow().getTrPr());
        List<XWPFTableCell> cellList = sourceRow.getTableCells();
        if (null == cellList) {
            return;
        }
        XWPFTableCell targetCell = null;
        for (XWPFTableCell sourceCell : cellList) {
            targetCell = targetRow.addNewTableCell();
            //列属性
            targetCell.getCTTc().setTcPr(sourceCell.getCTTc().getTcPr());
            //段落属性
            if (sourceCell.getParagraphs() != null && sourceCell.getParagraphs().size() > 0) {
                targetCell.getParagraphs().get(0).getCTP().setPPr(sourceCell.getParagraphs().get(0).getCTP().getPPr());
                if (sourceCell.getParagraphs().get(0).getRuns() != null && sourceCell.getParagraphs().get(0).getRuns().size() > 0) {
                    XWPFRun cellR = targetCell.getParagraphs().get(0).createRun();
                    cellR.setText(sourceCell.getText());
                    cellR.setBold(sourceCell.getParagraphs().get(0).getRuns().get(0).isBold());
                } else {
                    targetCell.setText(sourceCell.getText());
                }
            } else {
                targetCell.setText(sourceCell.getText());
            }


        }
    }

    /**
     * 设置内容
     *
     * @param tempCell
     * @param cell  表格单元格对象
     * @param text  单元格内的内容
     */
    private void setCellText(XWPFTableCell tempCell, XWPFTableCell cell, String text) {

        CTTc cttc2 = tempCell.getCTTc();
        CTTcPr ctpr2 = cttc2.getTcPr();
        CTTc ctTc = cell.getCTTc();
        CTTcPr ctPr = ctTc.addNewTcPr();

        if (ctpr2.getTcW() != null) {
            ctPr.addNewTcW().setW(ctpr2.getTcW().getW());
        }

        if (ctpr2.getVAlign() != null) {
            ctPr.addNewVAlign().setVal(ctpr2.getVAlign().getVal());
        }

        if (cttc2.getPList().size() > 0) {
            CTP ctp = cttc2.getPList().get(0);
            if (ctp.getPPr() != null) {
                if (ctp.getPPr().getJc() != null) {
                    ctTc.getPList().get(0).addNewPPr().addNewJc().setVal(ctp.getPPr().getJc().getVal());
                }
            }
        }
        if (ctpr2.getTcBorders() != null) {
            ctPr.setTcBorders(ctpr2.getTcBorders());
        }

        XWPFParagraph tempP = tempCell.getParagraphs().get(0);
        XWPFParagraph cellP = cell.getParagraphs().get(0);
        XWPFRun tempR = null;
        if (tempP.getRuns() != null && tempP.getRuns().size() > 0) {
            tempR = tempP.getRuns().get(0);
        }
        XWPFRun cellR = cellP.createRun();

        cellR.setText(text);
//        System.out.println("text1111------" + text);
        //复制字体信息
        if (tempR != null) {
            if (!cellR.isBold()) {
                cellR.setBold(tempR.isBold());
            }
            cellR.setItalic(tempR.isItalic());
            cellR.setUnderline(tempR.getUnderline());
            cellR.setColor(tempR.getColor());
            cellR.setTextPosition(tempR.getTextPosition());
            if (tempR.getFontSize() != -1) {
                cellR.setFontSize(tempR.getFontSize());
            }
            if (tempR.getFontFamily() != null) {
                cellR.setFontFamily(tempR.getFontFamily());
            }
            if (tempR.getCTR() != null) {
                if (tempR.getCTR().isSetRPr()) {
                    CTRPr tempRPr = tempR.getCTR().getRPr();
                    if (tempRPr.isSetRFonts()) {
                        CTFonts tempFonts = tempRPr.getRFonts();
                        CTRPr cellRPr = cellR.getCTR().isSetRPr() ? cellR.getCTR().getRPr() : cellR.getCTR().addNewRPr();
                        CTFonts cellFonts = cellRPr.isSetRFonts() ? cellRPr.getRFonts() : cellRPr.addNewRFonts();
                        cellFonts.setAscii(tempFonts.getAscii());
                        cellFonts.setAsciiTheme(tempFonts.getAsciiTheme());
                        cellFonts.setCs(tempFonts.getCs());
                        cellFonts.setCstheme(tempFonts.getCstheme());
                        cellFonts.setEastAsia(tempFonts.getEastAsia());
                        cellFonts.setEastAsiaTheme(tempFonts.getEastAsiaTheme());
                        cellFonts.setHAnsi(tempFonts.getHAnsi());
                        cellFonts.setHAnsiTheme(tempFonts.getHAnsiTheme());


                    }
                }
            }
        }
        //复制段落信息
        cellP.setAlignment(tempP.getAlignment());
        cellP.setVerticalAlignment(tempP.getVerticalAlignment());
        cellP.setBorderBetween(tempP.getBorderBetween());
        cellP.setBorderBottom(tempP.getBorderBottom());
        cellP.setBorderLeft(tempP.getBorderLeft());
        cellP.setBorderRight(tempP.getBorderRight());
        cellP.setBorderTop(tempP.getBorderTop());
        cellP.setPageBreak(cellP.isPageBreak());
        if (tempP.getCTP() != null) {
            if (tempP.getCTP().getPPr() != null) {
                CTPPr tempPPr = tempP.getCTP().getPPr();
                CTPPr cellPPr = cellP.getCTP().getPPr() != null ? cellP.getCTP().getPPr() : cellP.getCTP().addNewPPr();
                //复制段落间距信息
                CTSpacing tempSpacing = tempPPr.getSpacing();
                if (tempSpacing != null) {
                    CTSpacing cellSpacing = cellPPr.getSpacing() != null ? cellPPr.getSpacing() : cellPPr.addNewSpacing();
                    if (tempSpacing.getAfter() != null) {
                        cellSpacing.setAfter(tempSpacing.getAfter());
                    }
                    if (tempSpacing.getAfterAutospacing() != null) {
                        cellSpacing.setAfterAutospacing(tempSpacing.getAfterAutospacing());
                    }
                    if (tempSpacing.getAfterLines() != null) {
                        cellSpacing.setAfterLines(tempSpacing.getAfterLines());
                    }
                    if (tempSpacing.getBefore() != null) {
                        cellSpacing.setBefore(tempSpacing.getBefore());
                    }
                    if (tempSpacing.getBeforeAutospacing() != null) {
                        cellSpacing.setBeforeAutospacing(tempSpacing.getBeforeAutospacing());
                    }
                    if (tempSpacing.getBeforeLines() != null) {
                        cellSpacing.setBeforeLines(tempSpacing.getBeforeLines());
                    }
                    if (tempSpacing.getLine() != null) {
                        cellSpacing.setLine(tempSpacing.getLine());
                    }
                    if (tempSpacing.getLineRule() != null) {
                        cellSpacing.setLineRule(tempSpacing.getLineRule());
                    }
                }
                //复制段落缩进信息
                CTInd tempInd = tempPPr.getInd();
                if (tempInd != null) {
                    CTInd cellInd = cellPPr.getInd() != null ? cellPPr.getInd() : cellPPr.addNewInd();
                    if (tempInd.getFirstLine() != null) {
                        cellInd.setFirstLine(tempInd.getFirstLine());
                    }
                    if (tempInd.getFirstLineChars() != null) {
                        cellInd.setFirstLineChars(tempInd.getFirstLineChars());
                    }
                    if (tempInd.getHanging() != null) {
                        cellInd.setHanging(tempInd.getHanging());
                    }
                    if (tempInd.getHangingChars() != null) {
                        cellInd.setHangingChars(tempInd.getHangingChars());
                    }
                    if (tempInd.getLeft() != null) {
                        cellInd.setLeft(tempInd.getLeft());
                    }
                    if (tempInd.getLeftChars() != null) {
                        cellInd.setLeftChars(tempInd.getLeftChars());
                    }
                    if (tempInd.getRight() != null) {
                        cellInd.setRight(tempInd.getRight());
                    }
                    if (tempInd.getRightChars() != null) {
                        cellInd.setRightChars(tempInd.getRightChars());
                    }
                }
            }
        }
    }

    /**
     * 收尾方法
     *
     * @param outDocPath
     * @return
     * @throws IOException
     */
    public boolean generate(String outDocPath) {
        try {
            outputStream = new FileOutputStream(outDocPath);
            xwpfDocument.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.close(outputStream);
        this.close(inputStream);
        return true;
    }

    /**
     * 关闭输出流
     *
     * @param os
     */
    private void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输入流
     *
     * @param is
     */
    private void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
