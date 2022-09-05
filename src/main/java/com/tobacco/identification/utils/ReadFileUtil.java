package com.tobacco.identification.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileUtil {

    public static byte[] readFile(String filePath){
        File file = new File(filePath);
        InputStream input = null;
        try {
            if (file.exists()) {
                //2:实例化InputStream类对象
                input = new FileInputStream(file);
                //3:开辟一个字节数组用于数据的读取
                byte data[] = new byte[2048];
                //4:读取数据
                input.read(data); //将数据读取到字节数组中
                return data;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        throw new RuntimeException("私钥文件不存在");
    }

}
