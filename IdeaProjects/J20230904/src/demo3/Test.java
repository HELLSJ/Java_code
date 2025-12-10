package demo3;

/**
 * @Author 12629
 * @Description：
 */

abstract class Shape {

  /*  public String name;
    public static int a ;

    public void eat() {

    }*/

    public abstract void draw();

}

abstract class A extends Shape {
    public abstract void testA();
}

class B extends A {

    @Override
    public void draw() {

    }

    @Override
    public void testA() {

    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("○！");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("矩形！");
    }
}

public class Test {

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        //Shape shape = new Shape();
        Shape shape = new Cycle();
        Shape shape1 = new Rect();
        drawMap(shape);
        drawMap(shape1);
    }
}