package com.liu.upload;

import com.liu.utils.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: NetworkProgramming
 * @description: 上传文件服务端
 * @author: 刘帅彪
 * @create: 2022-05-29 10:25
 **/


public class UploadServer {
    public static void main(String[] args) throws IOException {
//        服务端监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听");
//        等待连接，连接上会生成一个socket对象
        Socket socket = serverSocket.accept();
//        读取客户端发送的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
//        转化为字节数组
        byte[] bytes = StreamUtils.streamToBytes(bis);
//        将字节流写入到一个文件
        String filePath = "/Users/liushuaibiao/Library/Mobile Documents/com~apple~CloudDocs/个人日常/2022年05月27日_网络编程/NetworkProgramming/03FileUpload/src/main/java/com/liu/purpose/pur.png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(bytes);

//        关闭资源
        bufferedOutputStream.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
