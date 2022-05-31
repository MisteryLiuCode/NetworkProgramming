package com.liu;

import com.liu.utils.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @program: NetworkProgramming
 * @description: 客户端
 * @author: 刘帅彪
 * @create: 2022-05-31 10:03
 **/


public class Client {
    public static void main(String[] args) throws IOException {
//        接收用户输入，指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String downLoadName = scanner.next();
//        客户端连接服务端，发送文件名
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9999);
//        获取输出流，发送文件名
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downLoadName.getBytes());
//        设置写入结束标志
        socket.shutdownOutput();

//        获取输入流，获取文件字节数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToBytes(bufferedInputStream);
//        创建写入路径
        String path="/Users/liushuaibiao/Library/Mobile Documents/com~apple~CloudDocs/个人日常/2022年05月27日_网络编程/NetworkProgramming/05ClientDowloadFile/src/main/java/com/liu/file/purposeFile/"+downLoadName+".jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        bufferedOutputStream.write(bytes);
//        关闭资源
        bufferedOutputStream.close();
        bufferedInputStream.close();
        System.out.println("客户端下载完毕，退出");
    }






}
