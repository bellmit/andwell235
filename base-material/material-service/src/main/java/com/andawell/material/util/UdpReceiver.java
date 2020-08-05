package com.andawell.material.util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/***
 * @author lhb
 * @Date: 2020/6/23 9:32
 * @Description:
 * @version : V1.0
 */
public class UdpReceiver {

    public static void main(String[] args) {

        SocketAddress local_addr = new InetSocketAddress("192.168.1.106",8081);
        try {

            DatagramSocket receiver = new DatagramSocket(local_addr);
            while (true){
                byte[] buf = new byte[10];
                DatagramPacket data = new DatagramPacket(buf,buf.length);
                receiver.receive(data);
                String msg = new String(data.getData());
                System.out.println("receive" + msg + "from"+data.getAddress());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
