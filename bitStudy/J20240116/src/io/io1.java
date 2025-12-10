package io;

import java.io.File;
import java.io.IOException;

public class io1 {
    public static void main(String[] args) throws IOException {
//        File f = new File("C:/Users/1/test.txt");
        File f = new File("./test.txt");
        System.out.println(f.getParent());
        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalFile());
    }
}
