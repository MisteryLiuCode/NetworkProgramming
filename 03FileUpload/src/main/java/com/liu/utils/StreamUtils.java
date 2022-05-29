package com.liu.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: NetworkProgramming
 * @description:
 * @author: 刘帅彪
 * @create: 2022-05-29 10:49
 **/


public class StreamUtils {
    /*
    将输入流转化为字节数组
    方法逻辑：
    1、从网络通道里读取文件是输入流对象，方法入参 输入流对象
    2、输入流对象写入到输出流对象
    3、将输出流转化为字节数组
     */
    public static byte[] streamToBytes(InputStream is) throws IOException {
//      创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        创建每次读取的数组大小
         byte[] b=new byte[1024];
         int len;
//         循环读取
         while ((len = is.read(b))!=-1){
//             将读取的对象写入输出流对象
             bos.write(b,0,len);
         }
//         创建字节数组，将输出流对象转化为字节数组
        byte[] array = bos.toByteArray();
         bos.close();
         return array;
    }
}
