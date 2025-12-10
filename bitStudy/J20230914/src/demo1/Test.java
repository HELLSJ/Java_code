package demo1;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();

        Mouse mouse = new Mouse();

        KeyBoard keyBoard = new KeyBoard();

        computer.useService(mouse);
        System.out.println("===========");
        computer.useService(keyBoard);
        computer.powerOff();
    }
}
