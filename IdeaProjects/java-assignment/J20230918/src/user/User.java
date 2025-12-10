package user;

import Book.BookList;
import operation.IOPeration;

//有抽象方法，这个类就变成了抽象类
public abstract class User {
    protected String name;//只要User在user包底下用

    protected IOPeration[] ioPerations;

    public User(String name){
        this.name = name;
    }
    public abstract int menu();//没有具体实现就是一个抽象方法

    public void doOperation(int choice, BookList bookList){
        ioPerations[choice].work(bookList);
    }
}
