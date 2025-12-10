package io;

import java.io.*;

public class io5 {
    public static void main(String[] args) throws IOException {
//        //因为try里面定义的inputStream finally里面访问不到，所以我们把它定义到外面
//        InputStream inputStream = null;
//        try{
//            //打开文件
//            inputStream = new FileInputStream("./test.txt");
//            //写入其他逻辑
//
//        }finally{
//            //关闭文件
//            inputStream.close();
//        }
        try(InputStream inputStream = new FileInputStream("./test.txt")){
            while (true){
//                int b = inputStream.read();
//                if(b == -1){
//                    //文件读取完毕
//                    break;
//                }
//                //不等于-1.打印这个字节的数据
//                System.out.printf("%x ",b);
                byte[] buffer = new byte[1024];
                int n = inputStream.read(buffer);
                if(n == -1){
                    //文件读取完毕
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.printf("%x ",buffer[i]);
                }
            }
        }

    }
}
