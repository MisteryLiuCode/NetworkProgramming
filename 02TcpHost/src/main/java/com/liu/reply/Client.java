package com.liu.reply;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @program: NetworkProgramming
 * @description: 客户端
 * @author: 刘帅彪
 * @create: 2022-05-28 09:38
 **/


public class Client {
    public static void main(String[] args) throws IOException {
//        客户端连接服务端思路
    /*1、连接服务端（ip+端口）
    2、连接上之后生成一个连接的socket，继续执行
    3、调用socket.getOutputStream()写入到数据通道。
    * */
//        连接本机9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端连接" + socket.getClass());
//        连接之后拿到socket输出流对象，向服务端发送数据
        OutputStream outputStream = socket.getOutputStream();
//        写数据
        outputStream.write("客户端向服务端发送的数据".getBytes());
        socket.shutdownOutput();
//        接收服务端发过来的数据
//        获取输入流
        InputStream inputStream = socket.getInputStream();
//        读数据
        //        使用IO读取
//        使用IO读取
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }
//        关闭流和对象，后打开的先关闭
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
