public class Date {
    public int year;
    public int month;
    public int day;

    public void setDate1(Date this, int y, int m, int d){
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public void setDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void print(){
        System.out.println("year: " + year + " month: " + month + " day: " + day);
    }


    public static void main(String[] args) {
        Date date = new Date();
        date.setDate(1999,1,1);
        date.print();


        Date date2 = new Date();
        date2.setDate(1989,11,11);
        date2.print();

    }
}
