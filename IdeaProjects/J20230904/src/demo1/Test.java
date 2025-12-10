package demo1;
class Shape{
    public void draw(){
        System.out.println("画一个图形");
    }

}
class Rect extends Shape{

    @Override
    public void draw(){
        System.out.println("矩形");
    }
}

class  Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("🔺!");
    }
}

class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("圆形!");
    }
}

public class Test {
    public static void drawMap(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
//        Shape shape = new Cycle();
//        Shape shape1 = new Triangle();
//        Shape shape2 = new Rect();

        Shape[] shapes = {new Cycle(), new Rect(), new Cycle(), new Rect(), new Triangle()};
        for(Shape shape: shapes){
            shape.draw();
        }

    }
    public static void main1(String[] args) {
        Cycle cycle = new Cycle();
        Rect rect = new Rect();
        Triangle triangle = new Triangle();
        String[] strings = {"cycle","rect","cycle","rect","triangle"};
        for(String x :strings){
            if(x.equals("cycle")){
                cycle.draw();
            }else if (x.equals("rect")){
                rect.draw();
            }else if (x.equals("triangle")){
                triangle.draw();
            }
        }
    }
}
