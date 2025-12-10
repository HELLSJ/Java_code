package demo1;

import java.security.Key;

public class Computer {

    public void powerOn() {
        System.out.println("打开电脑");
    }


    public void powerOff() {
        System.out.println("关闭电脑");
    }
    public void useService(USB usb){
        usb.openDevice();
        if(usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.click();
        }else if(usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.input();
        }
        usb.closeDevice();
    }

}
