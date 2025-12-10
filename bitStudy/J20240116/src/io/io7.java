package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class io7 {
    public static void main(String[] args) {
        //清空操作是下面这行try进行的
        try(OutputStream outputStream = new FileOutputStream("./test.txt", true)){
            byte[] buffer = new byte[]{97,98,99,100,101,102};
            outputStream.write(buffer);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
