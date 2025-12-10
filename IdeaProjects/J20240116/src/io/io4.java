package io;

import java.io.File;
import java.util.Arrays;

public class io4 {
    public static void main(String[] args) {
        File f = new File("./test.txt");
        File dest = new File("./test2.txt");
        f.renameTo(dest);
    }
}
