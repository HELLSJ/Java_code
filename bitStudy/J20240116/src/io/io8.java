package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class io8 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("./test.txt")){
            while(true){
                // 读取文件
                char[] buffer = new char[1024];
                int n = reader.read(buffer);

                if(n == -1){
                    break;
                }
                String s = new String(buffer, 0, n);
                System.out.println(s);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
