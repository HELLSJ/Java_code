package demo5;

interface A{
    void testA();
}
interface B extends A{
    void testB();
}
class TestDemo1 implements B{
    @Override
    public void testA() {

    }

    @Override
    public void testB() {

    }
}
public class Test {
}
