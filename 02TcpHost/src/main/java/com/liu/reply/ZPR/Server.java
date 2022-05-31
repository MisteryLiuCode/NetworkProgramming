package com.liu.reply.ZPR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: NetworkProgramming
 * @description:
 * @author: 刘帅彪
 * @create: 2022-05-29 15:59
 **/


public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            int port = 9999;
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            // 使用字符流读取
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String readLine = br.readLine(); // 读取一行数据
            System.out.println(readLine);
            // 返回数据给客户端
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            bw.write("hello,client 字符流");
            bw.flush();
            // 结束标记
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
