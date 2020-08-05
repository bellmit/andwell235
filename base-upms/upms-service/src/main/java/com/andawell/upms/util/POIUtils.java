package com.andawell.upms.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/14
 * @Version:V1.0.0
 */
public class POIUtils {
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";
    private final static String DATE_FORMAT = "yyyy/MM/dd";

    public static List<String[]> readExcel(MultipartFile file) throws IOException {
        checkFile(file);
        Workbook workbook = getWorkBook(file);
        /**
         * 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
         */
        List<String[]> list = new ArrayList<>();
        if (workbook != null) {
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if (sheet == null) {
                    continue;
                }
                int firstRowNum = sheet.getFirstRowNum();
                int lastRowNum = sheet.getLastRowNum();

                for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                    Row row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }

                    int firstCellNum = row.getFirstCellNum();
                    int lastCellNum = row.getLastCellNum();
                    String[] cells = new String[row.getPhysicalNumberOfCells()];
                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
            workbook.close();
        }
        return list;
    }

    /**
     * 校验文件是否合法
     *
     * @param file
     * @throws IOException
     */
    public static void checkFile(MultipartFile file) throws IOException {

        if (null == file) {
            throw new FileNotFoundException("文件不存在!");
        }
        String filename = file.getOriginalFilename();
        if (!filename.endsWith(xls) && !filename.endsWith(xlsx)) {
            throw new IOException(filename + "不是excel文件");
        }
    }

    public static Workbook getWorkBook(MultipartFile file) {
        String filename = file.getOriginalFilename();
        Workbook workbook = null;
        try {
            InputStream inputStream = file.getInputStream();
            if (filename.endsWith(xls)) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (filename.endsWith(xlsx)) {
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }


    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }

        String dataFormatString = cell.getCellStyle().getDataFormatString();
        if (dataFormatString.equals("m/d/yy") || dataFormatString.equals("yyyy/mm/dd")) {
            if (cell.getDateCellValue() == null) {
                return null;
            }
            cellValue = new SimpleDateFormat(DATE_FORMAT).format(cell.getDateCellValue());
            return cellValue;
        }
        /**
         * 将数字按String度，避免出现1读成1.0的情况
         */
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR:
                cellValue = "非法字符";
                break;
            default:
                cellValue="未知类型";
                break;
        }
        return cellValue;
    }
}
