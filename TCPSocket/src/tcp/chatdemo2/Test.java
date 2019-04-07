package tcp.chatdemo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 需求：做一个能将字符串倒序的服务器。
 *      客户端发送数据给服务端，服务端将数据倒序后返回给客户端，直到客户端输入over结束
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/23 19:54
 */
public class Test {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10003);
        Socket socket = new Socket("172.22.197.227",10003);
        new Thread(new TextClientDemo(socket)).start();
        new Thread(new TextServerDemo(serverSocket)).start();
    }
}
