package com.liu.upload;

import com.liu.utils.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: NetworkProgramming
 * @description: 上传文件客户端
 * @author: 刘帅彪
 * @create: 2022-05-29 10:26
 **/


public class UploadClient {
    public static void main(String[] args) throws Exception {
//        创建连接，客户端连接对应的ip和端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
//        创建读取磁盘文件的输入流,读取文件
        String filePath="/Users/liushuaibiao/Library/Mobile Documents/com~apple~CloudDocs/个人日常/2022年05月27日_网络编程/NetworkProgramming/03FileUpload/src/main/java/com/liu/sourceFile/source.png";
//        这里使用输入流进行读取文件，（Me)输入流是读取文件，输出流是写入文件，跟网路有点类似，输出流是往外发送文件，输出流是接收文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
//        将流转化为字节数组
        byte[] bytes = StreamUtils.streamToBytes(bufferedInputStream);
//        socket获取输出流向外发送文件
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
//        将文件写入到输出流
        bos.write(bytes);
        socket.shutdownOutput();
//        接收从服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
//        关闭流，后打开的先关闭
        inputStream.close();
        bos.close();
        socket.close();
    }
}
