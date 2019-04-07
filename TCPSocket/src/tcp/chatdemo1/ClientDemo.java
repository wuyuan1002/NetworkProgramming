package tcp.chatdemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端
 * tcp传输是面向连接的，它的Socket有两种，一个是客户端的一个是服务端的
 *
 *
 * 客户端socket建立过程
 * 1·创建tcp客户端的socket服务，使用的是socket对象
 *    建议该对象一创建就明确目的地(要连接的主机)
 * 2·如果连接建立成功，就说明数据传输通道，该通道就是socket流，既然是流，那么就有输入也有输出
 *    输入或者输出（接收或者发送）通过socket对象来操作
 * 3·使用输出流将数据写出（发送数据），使用输入流将数据写入（接收数据）
 * 4·关闭资源
 *
 *
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 12:02
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {

        //创建tcp客户端的socket服务，使用的是socket对象，并明确要连接的目的地
        Socket socket = new Socket("172.22.197.244",10002);

        //获取socket流中的输出流
        OutputStream outputStream = socket.getOutputStream();

        //使用输出流将数据发送出去
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        //Scanner re = new Scanner(System.in);
        String data = re.readLine();
        outputStream.write(data.getBytes());

        //获取socket流中的输入流，得到服务器端返回的数据，并打印在控制台
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String data1 = new String(bytes,0,len);
        System.out.println(data1);

        //关闭资源，断开连接
        socket.close();

    }
}
