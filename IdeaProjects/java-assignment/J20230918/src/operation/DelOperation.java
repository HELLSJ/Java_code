package operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class DelOperation implements IOPeration {
    @Override
    public void work(BookList bookList){
        System.out.println("删除图书！");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要删除的图书");
        String name = scanner.nextLine();
        int pos = -1;
        //找到有没有这本书
        int currentSize = bookList.getUsedSize();
        int i = 0;
        for (; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                pos = i;
                break;
            }
        }
        if (i == currentSize){
            System.out.println("没有你要删除的图书！");
            return;
        }
        //开始删除
        int j = pos;
        //从后往前覆盖
        for (; j < bookList.getUsedSize()-1; j++) {
            //[j] = [j+1]
            Book book = bookList.getBook(j+1);

            bookList.setBook(j,book);
        }
        //将最后一本书置空
        bookList.setBook(j,null);
        bookList.setUsedSize(currentSize-1);
    }
}
