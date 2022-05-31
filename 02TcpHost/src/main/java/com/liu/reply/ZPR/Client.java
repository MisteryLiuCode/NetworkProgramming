package com.liu.reply.ZPR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @program: NetworkProgramming
 * @description:
 * @author: 刘帅彪
 * @create: 2022-05-29 15:58
 **/


public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        BufferedWriter bufferedWriter = null;
        OutputStreamWriter osw = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("localhost");
            int port = 9999;
            socket = new Socket(inetAddress, port);
            // 发送数据
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bufferedWriter = new BufferedWriter(osw);
            bufferedWriter.write("hello,server 字符流");
            bufferedWriter.newLine(); // 换行符
            bufferedWriter.flush(); // 刷新
            socket.shutdownOutput();
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String readLine = br.readLine();
            System.out.println(readLine);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            // 关闭资源
        }

    }



}
