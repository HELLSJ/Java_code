package demo1;

public class KeyBoard implements USB{
    @Override
    public void openDevice() {
        System.out.println("插上键盘");
    }

    @Override
    public void closeDevice() {
        System.out.println("关上键盘");
    }
    public void input(){
        System.out.println("疯狂敲打键盘.......");
    }
}
