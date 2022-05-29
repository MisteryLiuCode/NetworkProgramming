package com.liu.upload;

import com.liu.utils.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
//        向客户端回复"收到图片"
//        通过socket获取输出流（字符）
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
//        将数据内容刷新到数据通过
        bufferedWriter.flush();
//        设置写入结束
        socket.shutdownOutput();
//        关闭资源
        bufferedOutputStream.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
