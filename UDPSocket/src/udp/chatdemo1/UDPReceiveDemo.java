package udp.chatdemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *   需求：建立UDP协议的接收端
 *   步骤：
 *        1·建立UDP的Socket服务，因为要接收数据，所以创建时要明确要监听的端口号
 *        2·创建数据包对象，用于存储发送过来的数据，方便使用数据包的方法解析处理这些数据
 *        3·使用Socket服务的receive方法将接受的数据存储到数据包中
 *        4·通过数据包的方法解析处理接收到的数据
 *        5·关闭Socket服务
 *
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 10:22
 */
public class UDPReceiveDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端启动···");


        //建立UDP的Socket服务
        DatagramSocket udpsocket = new DatagramSocket(10000);

        //创建数据包对象，用于存储发送过来的数据，方便使用数据包的方法解析处理这些数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);

        //使用Socket服务的receive方法将接受的数据存储到数据包中
        udpsocket.receive(packet);

        //通过数据包的方法解析处理接收到的数据,比如ip地址，端口，数据内容等
        String ip = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        String text = new String(packet.getData(), 0, packet.getLength());

        //关闭Socket服务
        udpsocket.close();


        //打印信息到控制台
        System.out.println("发送端ip地址：" + ip);
        System.out.println("发送端端口号：" + port);
        System.out.println("发送过来的数据：" + text);
    }
}
