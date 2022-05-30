package com.liu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @program: NetworkProgramming
 * @description: udp发送数据
 * @author: 刘帅彪
 * @create: 2022-05-30 11:37
 **/


public class UDPSenderB {
    public static void main(String[] args) throws IOException {
//        创建DatagramSocket对象，准备在9998端口接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9998);
//        将要发送的数据，封装到DatagramPacket对象里
        byte[] bytes = "hello,明天吃火锅".getBytes();
        DatagramPacket bogon = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("bogon"), 9999);
        datagramSocket.send(bogon);
//        接收数据
        //    创建一个datagramPacket对象，准备接收数据
//    udp一个数据包最大64k
        byte[] data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
//    调用接收方法，通过网络传输DatagramPacket对象
//    如果没有数据包发送数据，那么就会一直阻塞等待
        System.out.println("接收端B 等待接收数据");
        datagramSocket.receive(datagramPacket);
//       接收到之后，对packet进行拆包，去除数据，并且展示
//        获取数据长度
        int length = datagramPacket.getLength();
//        获取byte数组数据
        byte[] dataByte = datagramPacket.getData();
        String s = new String(dataByte, 0, length);
        System.out.println(s);

        datagramSocket.close();
    }
}
