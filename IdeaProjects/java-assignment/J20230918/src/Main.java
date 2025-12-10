import Book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {





    public static User login(){
        System.out.println("请输入你的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入你的身份，1：管理员   2：普通用户-->");
        int choice = scanner.nextInt();

        if(choice == 1){
            //管理员
            return new AdminUser(name);
        }else {
            //普通用户
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        BookList bookList = new BookList();//书架创建
        //user指向哪个对象就看返回值是什么？
        User user = login();
        while (true) {
            int choice = user.menu();//因为User里面么有menu方法，所以需要去User里面申明一下


            System.out.println("choice :" + choice);

            //根据choice的选择来决定调用的时哪个方法？

            user.doOperation(choice, bookList);
        }
    }
}
