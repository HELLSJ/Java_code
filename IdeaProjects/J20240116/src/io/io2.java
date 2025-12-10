package io;

import java.io.File;
import java.io.IOException;

public class io2 {
    public static void main(String[] args) throws IOException {
        File f = new File("./test.txt");
        System.out.println(f.exists());
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());

        boolean ret = f.createNewFile();
        System.out.println("ret= "+ret);
    }
}
