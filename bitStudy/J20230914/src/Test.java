//接口是抽象类的进一步抽象
interface Shape{
//    public int a = 1;
//    public static int b = 2;
//    public static final int c = 3;
    void draw();

//    public void test(){
//        System.out.println("fdsfa");
//    }
}
class Rect implements Shape{
    @Override
    public void draw() {
        System.out.println("矩形！");
    }
}
class Flower implements Shape{
    @Override
    public void draw() {
        System.out.println("花！");
    }
}


public class Test {
    private static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        //Shape shape = new Shape();//无法实例化，抽象的抽象类
        Shape shape1 = new Rect();
        Shape shape2 = new Flower();
        
        drawMap(shape1);
        drawMap(shape2);
        System.out.println("===========");
        Shape[] shapes = {new Rect(), new Rect(), new Flower(), new Flower()};//多态，接口也可以发生向上转型和动态绑定

        for(Shape shape: shapes){
            shape.draw();
        }
    }
}
