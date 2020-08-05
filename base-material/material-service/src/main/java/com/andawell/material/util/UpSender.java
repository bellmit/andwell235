package com.andawell.material.util;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;

import java.net.*;

/***
 * @author lhb
 * @Date: 2020/6/23 9:15
 * @Description:
 * @version : V1.0
 */
@Slf4j
public class UpSender {


    public static void sender(String ipAddress,Integer port,String message) throws UnknownHostException, SocketException {

        SocketAddress local_addr = new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(),9687);
        DatagramSocket sender = new DatagramSocket(local_addr);
        try {

            byte[] buf = (message).getBytes();
            // 接收方地址
            SocketAddress receive_addr = new InetSocketAddress(ipAddress,port);
            DatagramPacket data = new DatagramPacket(buf,buf.length,receive_addr);
            try {
                sender.send(data);
                log.info("消息为："+data.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
            // 睡眠500 毫秒
           // Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sender.close();
           // sender.disconnect();
        }
    }

    public static void main(String[] args) {

        SocketAddress local_addr = new InetSocketAddress("localhost",9090);
        try {

            DatagramSocket sender = new DatagramSocket(local_addr);

            int count = 0;// 设置消息数

            while (count<100){
                count++;
                byte[] buf = (count + "hello").getBytes();
                SocketAddress receive_addr = new InetSocketAddress("localhost",8081);// 接收方地址
                DatagramPacket data = new DatagramPacket(buf,buf.length,receive_addr);
                try {
                    sender.send(data);
                    System.out.println("send"+count+"-----------message");
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            sender.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
