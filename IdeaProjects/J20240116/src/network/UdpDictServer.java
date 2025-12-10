package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDictServer extends UdpEchoServer{
    private HashMap<String, String> hashMap = new HashMap<>();
    public UdpDictServer(int port) throws SocketException {
        super(port);
        hashMap.put("cat", "小猫");
        hashMap.put("dog", "小狗");
        hashMap.put("chicken", "坤坤");
        //此处还可以无限地添加词典程序
    }

    //start方法完全从父类继承
    //process方法继承后要重写，加入自己的业务逻辑：进行翻译
    @Override
    public String process(String request){
        //参数是一个英文单词
        //返回值就是一个对应的汉语
        return hashMap.getOrDefault(request, "您查找的单词不存在！");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
