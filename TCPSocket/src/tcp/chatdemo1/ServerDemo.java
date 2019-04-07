package tcp.chatdemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * tcp传输是面向连接的，它的Socket有两种，一个是客户端的一个是服务端的
 * <p>
 * <p>
 * 服务端socket的建立过程
 * 1·创建服务端socket服务，通过serversocket对象
 * 2·服务端必须对外提供一个端口（服务端来监听这个端口），否则客户端无法连接
 * 3·获取连接过来的客户端对象
 * 4·通过客户端对象获取socket流，获取客户端的输入流，读取客户端发送过来的数据
 * 5·根据客户端发送的数据返回数据给客户端
 * 6·与某个客户端通信结束后关闭服务端的客户端对象
 * 7·没有客户端通信后关闭服务端资源
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 12:18
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务端socket服务,并对外提供一个端口，服务端监听这个端口
        ServerSocket serverSocket = new ServerSocket(10002);
        //获取连接过来的客户端对象
        Socket socket = serverSocket.accept();
        //通过客户端对象获取socket流，获取客户端的输入流，读取客户端发送过来的数据，并打印在控制台
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String data = new String(bytes,0,len);
        System.out.println(data);

        //通过客户端对象获取socket流，获取客户端的输出流，根据客户端发送的数据返回数据给客户端
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String str = re.readLine();
        outputStream.write(str.getBytes());

        //与某个客户端通信结束后关闭服务端的客户端对象
        socket.close();


        //没有客户端通信后关闭服务端资源，但是服务端一般不关闭，因为你是服务器，要给别人提供服务
        serverSocket.close();
    }
}
