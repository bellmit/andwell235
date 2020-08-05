package com.andawell.common.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


public class MailUtil {


    //private static Logger logger = Logger.getLogger("EmailUtil.class");

    //用户名密码验证，需要实现抽象类Authenticator的抽象方法PasswordAuthentication
    static class MyAuthenricator extends Authenticator{
        String u = null;
        String p = null;
        public MyAuthenricator(String u,String p){
            this.u=u;
            this.p=p;
        }
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(u,p);
        }
    }

    public static  void send(String title,String context){
        Properties prop = new Properties();
        //协议
        prop.setProperty("mail.transport.protocol", "smtps");
        //服务器
        prop.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
        //端口
        prop.setProperty("mail.smtp.port", "25");
        //使用smtp身份验证
        prop.setProperty("mail.smtp.auth", "true");

        //发件人，进行权限认证
        Session session = Session.getDefaultInstance(prop, new MyAuthenricator("1037497262@qq.com", "eglalhrqxnrcbdca"));
        // session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            //发件人地址
            mimeMessage.setFrom(new InternetAddress("@qq.com"));
            //收件人的地址
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("1035737243@qq.com"));
            mimeMessage.setSubject(title);
            mimeMessage.setSentDate(new Date());
            mimeMessage.setText(context);
            mimeMessage.saveChanges();
            Transport.send(mimeMessage);
        } catch (Exception e) {
            //logger.("scan 邮件异常 " +e);
            System.out.print("11111");

        }
    }



}
