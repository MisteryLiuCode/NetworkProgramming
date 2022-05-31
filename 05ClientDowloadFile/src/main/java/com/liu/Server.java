package com.liu;

import com.liu.utils.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: NetworkProgramming
 * @description: 服务端
 * @author: 刘帅彪
 * @create: 2022-05-31 10:00
 **/


public class Server {
    public static void main(String[] args) throws IOException {
//        监听9999端口等待接收数据
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听");
//        等待客户端连接
        Socket accept = serverSocket.accept();
//        读取客户端发送过来的文件名
        InputStream inputStream = accept.getInputStream();
//        读取文件名
        byte[] bytes = new byte[1024];
        int len=0;
        String downLoadName="";
        while ((len=inputStream.read(bytes)) != -1){
            downLoadName+=new String(bytes,0,len);
        }
        System.out.println("客户端接收到的下载名"+downLoadName);
//        如果客户端要下载purpose文件，那么就返回该文件，否则一律返回无名
        String resFileName="";
        if ("purpose".equals(downLoadName)){
            resFileName="/Users/liushuaibiao/Library/Mobile Documents/com~apple~CloudDocs/个人日常/2022年05月27日_网络编程/NetworkProgramming/05ClientDowloadFile/src/main/java/com/liu/file/sourceFile/purpose.jpg";
        }
        else{
            resFileName="/Users/liushuaibiao/Library/Mobile Documents/com~apple~CloudDocs/个人日常/2022年05月27日_网络编程/NetworkProgramming/05ClientDowloadFile/src/main/java/com/liu/file/sourceFile/nameless.jpg";
        }
//        创建一个输入流，读取文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));
//        读取文件为字符数组
        byte[] bytes1 = StreamUtils.streamToBytes(bufferedInputStream);
//        得到socket输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(accept.getOutputStream());
//        将文件写入到数组中
        bufferedOutputStream.write(bytes1);
//        关闭相关的资源
        bufferedOutputStream.close();
        bufferedInputStream.close();
        System.out.println("服务端退出");
    }
}
