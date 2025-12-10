package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UdpEchoServer {
    private DatagramSocket socket = null;
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    //服务器的启动逻辑
    public void start() throws IOException {
        System.out.println("服务器启动!");
        //对于服务器来说，需要不停收到请求并返回响应
        //一般的服务器是全天运行的，所以while true没有退出的必要
        //如果想重启服务器就直接杀死进程就行
        while(true){
            //1.读取请求更新
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            //读到的字节数组转换成String，方便后序逻辑处理
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            //2.根据请求计算响应（回显服务器不用做这一步）
            String response = process(request);
            //3.把响应返回给客户端
            //构造一个DatagramPacket作为响应对象
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);

            //打印日志
            System.out.printf("[%s:%d] req: %s, resp: %s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }
    //此处是回显服务器，可以直接return
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);//通常使用的端口，大于1024，小于65535
        //注意端口别被其他进程占用
        server.start();
    }
}
