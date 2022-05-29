package com.liu;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: NetworkProgramming
 * @description: 客户端
 * @author: 刘帅彪
 * @create: 2022-05-27 18:21
 **/


public class Client {
    public static void main(String[] args) throws IOException {
//        客户端连接服务端思路
    /*1、连接服务端（ip+端口）
    2、连接上之后生成一个连接的socket，继续执行
    3、调用socket.getOutputStream()写入到数据通道。
    * */
//        连接本机9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端连接"+socket.getClass());
//        连接之后拿到socket输出流对象，向服务端发送数据
        OutputStream outputStream = socket.getOutputStream();
//        写数据
        outputStream.write("客户端向服务端发送的数据".getBytes());
//        关闭流和对象，后打开的先关闭
        outputStream.close();
        socket.close();
    }
}
