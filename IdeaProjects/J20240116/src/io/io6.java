package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class io6 {
    public static void main(String[] args) {
        try(InputStream inputStream = new FileInputStream("./test.txt")) {
            while(true){
                byte[] buffer = new byte[1024];
                int n = inputStream.read(buffer);
                if(n == -1){
                    break;
                }
                String s = new String(buffer, 0 , n);
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
