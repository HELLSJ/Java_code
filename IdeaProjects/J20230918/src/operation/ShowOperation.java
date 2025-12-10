package operation;
import Book.Book;
import Book.BookList;

public class ShowOperation implements IOPeration {
    @Override
    public void work(BookList bookList){
        System.out.println("打印图书！");
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
