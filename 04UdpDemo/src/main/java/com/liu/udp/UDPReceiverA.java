package com.liu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @program: NetworkProgramming
 * @description: 接收端
 * @author: 刘帅彪
 * @create: 2022-05-30 11:26
 **/


public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
//    虽然这是不分客户端和服务端的，理论上是两台服务启动，都可以等待发消息，不论先后，这里演示的是服务一启动就立刻发消息，所以还是分接收端和发送端。
//    1、创建一个DatagramSocket对象，准备在9999端口接收数据
        DatagramSocket socket = new DatagramSocket(9999);
//    创建一个datagramPacket对象，准备接收数据
//    udp一个数据包最大64k
        byte[] data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
//    调用接收方法，通过网络传输DatagramPacket对象
//    如果没有数据包发送数据，那么就会一直阻塞等待
        System.out.println("接收端A 等待接收数据");
        socket.receive(datagramPacket);

//       接收到之后，对packet进行拆包，去除数据，并且展示
//        获取数据长度
        int length = datagramPacket.getLength();
//        获取byte数组数据
        byte[] dataByte = datagramPacket.getData();
        String s = new String(dataByte, 0, length);
        System.out.println(s);

//        接收方回复信息
        //        将要发送的数据，封装到DatagramPacket对象里
        byte[] bytes = "好的，明天见".getBytes();
        DatagramPacket bogon = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("bogon"), 9998);
        socket.send(bogon);
        socket.close();
    }
}
