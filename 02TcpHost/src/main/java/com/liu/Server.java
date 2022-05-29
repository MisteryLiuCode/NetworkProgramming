package com.liu;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: NetworkProgramming
 * @description: 服务端
 * @author: 刘帅彪
 * @create: 2022-05-27 18:16
 **/


public class Server {
    public static void main(String[] args) throws IOException {
//        服务端监听一个端口，比如9999，等待连接，要保证这个端口没有被占用
        ServerSocket serverSocket = new ServerSocket(9999);
//        如果有客户端连接上了，就会返回一个Socket连接对象，程序会继续，否则会一直在监听端口的地方等待
        System.out.println("服务端，在9999端口监听，等待连接");
        Socket socket = serverSocket.accept();
        System.out.println("socket="+serverSocket);
//        服务端接收客户端接收的数据
        InputStream inputStream = socket.getInputStream();
//        使用IO读取
        byte[] bytes = new byte[1024];
        int readLen=0;
        while ((readLen=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readLen));
        }
//        关闭流
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
