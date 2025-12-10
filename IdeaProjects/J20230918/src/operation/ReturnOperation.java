package operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOPeration {
    @Override
    public void work(BookList bookList){
        System.out.println("归还图书！");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还的书:");
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setBorrowed(false);
                System.out.println("归还成功");
                System.out.println(book);
                return;
            }
        }
        System.out.println("归还的图书不存在");
    }
}