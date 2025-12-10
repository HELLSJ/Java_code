
class Person implements Cloneable{
    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Test {
    public static int func(){
        try{
            int[] array = null;
            System.out.println(array.length);
        }catch (NullPointerException e){
            System.out.println("捕获到空指针异常");
        }finally{
            System.out.println("执行了finally");
        }
        return 10;
    }

    public static void main(String[] args) {
        System.out.println(func());
    }
    public static void main13(String[] args) {
        System.out.println("before");
        try{
            System.out.println(10/0);
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("我来处理NullPointerException异常");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("我来处理Exception异常");
        }
        System.out.println("after");
    }
//    public static void func1() throws CloneNotSupportedException{
//        int a = 10;
//        if(a == 10){
//            throw new CloneNotSupportedException("hhhh!");
//        }
//    }
//    public static void main11(String[] args){
//        try {
//            func();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main1(String[] args) {
        int[] arr = null;
        System.out.println(arr.length);
    }
}
