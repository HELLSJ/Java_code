package operation;

import Book.BookList;

public class ExitOperation implements IOPeration {
    @Override
    public void work(BookList bookList){
        System.out.println("退出系统！");
    }
}
