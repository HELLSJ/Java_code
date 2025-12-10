package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket serverSocket = null;
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true){
            //通过accept方法来接听电话
            Socket clientSocket = serverSocket.accept();
            ExecutorService pool = Executors.newCachedThreadPool();
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
//            Thread t = new Thread(()->{
//                processConnection(clientSocket);
//            });
//            t.start();
        }
    }
    //通过这个方法处理一次连接，建立连接的过程会涉及多次请求响应交互
    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线", clientSocket.getInetAddress(), clientSocket.getPort());
        //循环读取客户端请求，保存对端信息
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()){
            Scanner scanner = new Scanner(inputStream);
            while(true){
                //通过scanner读取数据
                if (!scanner.hasNext()){
                    //读取完毕，客户端断开连接，就打印读取完毕
                    System.out.printf("[%s:%d] 客户端下线", clientSocket.getInetAddress(),clientSocket.getPort());
                    break;
                }
                //1.读取请求并解析。next读到空白符才会结束
                //因此要求客户端发来的请求必须带有空白符结尾
                String request = scanner.next();
                //2.根据请求计算响应
                String response = process(request);
                //3.把响应返回给客户端
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();
                System.out.printf("[%s:%d] req: %s, resp:%s\n", clientSocket.getInetAddress(), clientSocket.getPort(),
                        request, response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
