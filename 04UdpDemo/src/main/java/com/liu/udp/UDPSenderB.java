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
        datagramSocket.close();
    }








}
