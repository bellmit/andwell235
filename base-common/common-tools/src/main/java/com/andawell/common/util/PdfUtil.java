
package com.andawell.common.util;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PdfUtil {
    /**
     *
     * @param fileName   写出pdf文件路径
     * @param content   待写进pdf文件字符串
     */
    public static void writePDF(final String fileName, final String content) {

        Document document = null;
        OutputStream out = null;
        try {
            // 检查文件目录是否存在，不存在则创建目录
            File file = new File(FilenameUtils.getFullPath(fileName));
            if (!file.exists()) {
                file.mkdirs();
            }

            // 初始化文件输出流
            out = new FileOutputStream(fileName);
            // 初始化ITextPDF文件流
            document = new Document();

            // 装载文件输出流
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph graph = new Paragraph(content);
            document.add(graph);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭PDF文件流
            if (document != null) {
                document.close();
            }

            // 关闭文件输出流
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//    public static void main(String[] args){
//        writePDF("C:\\software\\util\\a.pdf","sadasdauigsdaguisgdyuagysdgaugsduyasgydyu");
//    }
}

