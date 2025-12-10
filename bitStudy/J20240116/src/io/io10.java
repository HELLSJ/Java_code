package io;

import java.io.*;
import java.util.Scanner;

public class io10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要复制的原文件：");
        String srcPath = scanner.next();
        System.out.println("请输入要复制的目标文件：");
        String destPath = scanner.next();

        //文件合法性判定
        //1）srcPath对应的文件是否存在
        File srcFile = new File(srcPath);
        if(!srcFile.isFile()){
            System.out.println("源文件路径有误");
            return;
        }
        //2）destPath 不要求对应的文件存在，但是目录得存在
        File destFile = new File(destPath);
        if(!destFile.getParentFile().isDirectory()){
            System.out.println("目标路径有误！");
            return;
        }
        //进行复制操作
        try(InputStream inputStream = new FileInputStream(srcFile);
            OutputStream outputStream = new FileOutputStream(destFile)){
            while(true){
                byte[] buffer = new byte[1024];
                int n = inputStream.read(buffer);
                if(n == -1){
                    break;
                }
                //把读到的内容写道outputStream中
                outputStream.write(buffer, 0, n);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
