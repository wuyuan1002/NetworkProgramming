package udp.chatDemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 需求：使用UDP编写聊天窗口
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 10:51
 */
public class UDPChatReceiveDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端启动···");


        //建立UDP的Socket服务,监听指定端口
        DatagramSocket udpsocket = new DatagramSocket(10000);

        while (true) {
            //创建数据包对象，用于存储发送过来的数据，方便使用数据包的方法解析处理这些数据
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);

            //使用Socket服务的receive方法将接受的数据存储到数据包中
            udpsocket.receive(packet);

            //通过数据包的方法解析处理接收到的数据,比如ip地址，端口，数据内容等
            String ip = packet.getAddress().getHostAddress();
            int port = packet.getPort();
            String text = new String(packet.getData(), 0, packet.getLength());

            //打印信息到控制台
            System.out.println("发送端ip地址：" + ip);
            System.out.println("发送端端口号：" + port);
            System.out.println("发送过来的数据：" + text);
            System.out.println("------------------------------------------------------");

            if ("over".equals(text)) {
                System.out.println("***************结束****************");
                break;
            }
        }

        //跳出循环后关闭Socket服务
        udpsocket.close();


    }
}
