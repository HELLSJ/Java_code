package demo2;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import demo.Test3;
public class Test extends Test3{
    public void func(){
        System.out.println(super.a);
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.func();
    }
}
