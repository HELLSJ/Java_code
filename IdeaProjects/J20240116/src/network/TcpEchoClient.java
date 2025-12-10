package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        //由于tcp是有链接的，此处可以把这里的ip和port直接传给socket对象
        socket = new Socket(serverIp,serverPort);
    }
    public void start(){
        System.out.println("客户端启动");
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {
            Scanner scannerConsole = new Scanner(System.in);//控制台
            Scanner scannerNetWork = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (true){
                //1.从控制台读取输入的字符串
                System.out.println("->");
                if(!scannerConsole.hasNext()){
                    break;
                }
                String request = scannerConsole.next();
                //2.把请求发给服务器，使用println来发送，防止发送末尾带有\n
                writer.println(request);
                //通过flush冲刷缓冲区
                writer.flush();
                //3.从服务器中读取响应
                String response = scannerNetWork.next();
                //4.把响应显示出来
                System.out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
