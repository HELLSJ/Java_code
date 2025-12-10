package operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOPeration {
    @Override
    public void work(BookList bookList){
        System.out.println("借阅图书！");
        /**
         * 1.你要借阅什么书
         * 2.要借阅的书有没有
         * 3.借阅的方式是什么？
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅的书:");
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setBorrowed(true);
                System.out.println("借阅成功");
                System.out.println(book);
                return;
            }
        }
        System.out.println("借阅的图书不存在");
    }
}
