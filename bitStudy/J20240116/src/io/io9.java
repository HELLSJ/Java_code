package io;

import java.io.File;
import java.util.Scanner;

public class io9 {
    public static void main(String[] args) {
        //1.输入必要的信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的文件名：");
        String fileName = scanner.next();
        System.out.println("请输入要搜索的目录：");
        String rootPath = scanner.next();
        File rootFile = new File(rootPath);
        if(!rootFile.isDirectory()){
            System.out.println("输入的路径有误");
            return;
        }
        //2.有了路径之后就可以按照递归的方式来搜索
        //知道递归的起点还需要知道要查询的文件名
        scanDir(rootFile, fileName);
    }
    private static void scanDir(File rootFile, String fileName){
        //1.把当前目录中的文件和目录都列出来
        File[] files = rootFile.listFiles();
        if(files == null){
            //空的目录就直接返回
            return;
        }
        //2.遍历上述files，判定每一个file是目录还是文件
        for(File f : files){
            System.out.println("当前遍历到： "+f.getAbsolutePath());
            if(f.isFile()){
                //普通文件，判定文件名是否是搜索的文件
                if(fileName.equals(f.getName())){
                    System.out.println("找到了符合要求的文件！ "+f.getAbsolutePath());
                }
            } else if (f.isDirectory()) {
                //目录文件，需要进一步的递归
                scanDir(f, fileName);
            }else{
                ;
            }
        }
    }
}
