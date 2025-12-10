package Book;

public class BookList {

    private Book[] books;
    private int usedSize;//记录当前书架上实际存放的书的数量

    public BookList() {
        this.books = new Book[10];//初始化后全都是null
        this.books[0] = new Book("三国演义","罗贯中",10,"小说");
        this.books[1] = new Book("西游记","吴承恩", 9, "小说");
        this.books[2] = new Book("红楼梦","曹雪芹", 19, "小说");

        this.usedSize = 3;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getBook(int pos){
        return books[pos];
    }
    public void setBook(int pos, Book book){
        books[pos] = book;
    }

    public Book[] getBooks(){
        return books;
    }


}
