package io;

import java.io.File;

public class io3 {
    public static void main(String[] args) throws InterruptedException {
        File file = new File("./test.txt");
//        boolean ret = file.delete();
        file.deleteOnExit();
        Thread.sleep(5000);
    }
}
