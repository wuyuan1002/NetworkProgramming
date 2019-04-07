package tcp.chatdemo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 需求：做一个能将字符串倒序的服务器。
 *      客户端发送数据给服务端，服务端将数据倒序后返回给客户端，直到客户端输入over结束
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/23 19:28
 */
public class TextServerDemo implements Runnable {
    private ServerSocket serverSocket;

    public TextServerDemo(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        byte[] data = new byte[1024];
        int len;
        try {
            Socket socket = this.serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            while ((len = inputStream.read(data)) != -1) {
                String string = new String(data, 0, len);
                StringBuilder str = new StringBuilder(string);
                outputStream.write(str.reverse().toString().getBytes());
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.serverSocket.close();
                System.out.println("--------------------服务端结束-----------------------");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
