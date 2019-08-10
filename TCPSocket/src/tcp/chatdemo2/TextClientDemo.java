package tcp.chatdemo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 需求：做一个能将字符串倒序的服务器。
 *      客户端发送数据给服务端，服务端将数据倒序后返回给客户端，直到客户端输入over结束
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/23 19:27
 */
public class TextClientDemo implements Runnable {
    private Socket socket;
    
    public TextClientDemo(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        byte[] bytes = new byte[1024];
        int len;
        String data;
        try {
            OutputStream outputStream = this.socket.getOutputStream();
            InputStream inputStream = this.socket.getInputStream();
            while ((data = in.readLine()) != null) {
                outputStream.write(data.getBytes());
                if ("over".equals(data)) {
                    System.out.println("--------------------客户端结束-----------------------");
                    break;
                }
                len = inputStream.read(bytes);
                String da = new String(bytes, 0, len);
                System.out.println(da);
            }
            //如果读取结束，告诉服务器端结束了，避免阻塞式方法缺少结束标记
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
