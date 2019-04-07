package udp.chatDemo3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 11:27
 */
public class Receive implements Runnable {
    private DatagramSocket socket;

    public Receive(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("接收端启动···");
        try {
            while (true) {
                //创建数据包对象，用于存储发送过来的数据，方便使用数据包的方法解析处理这些数据
                byte[] data = new byte[1024];
                DatagramPacket packet = new DatagramPacket(data, data.length);

                //使用Socket服务的receive方法将接受的数据存储到数据包中
                this.socket.receive(packet);

                //通过数据包的方法解析处理接收到的数据,比如ip地址，端口，数据内容等
                String ip = packet.getAddress().getHostAddress();
                int port = packet.getPort();
                String text = new String(packet.getData(), 0, packet.getLength());

                //打印信息到控制台
                System.out.println("发送端ip地址：" + ip + "发送端端口号：" + port + "发送过来的数据：" + text);
                System.out.println("------------------------------------------------------");

                if ("over".equals(text)) {
                    System.out.println("***************Receive结束****************");
                    break;
                }
            }

            //跳出循环后关闭Socket服务
            this.socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
