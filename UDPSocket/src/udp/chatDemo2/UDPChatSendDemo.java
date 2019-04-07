package udp.chatDemo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 需求：使用UDP编写聊天窗口
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 10:51
 */
public class UDPChatSendDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动···输入你要发送的数据吧,输入over结束");

        //创建udp的Socket服务，通过DatagramSocket对象
        DatagramSocket udpsocket = new DatagramSocket();

        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
//        Scanner bur = new Scanner(System.in);

        String line;
        while ((line = bur.readLine()) != null) {
            //把要发送的数据封装到数据包中
            byte[] da = line.getBytes();
            DatagramPacket packet = new DatagramPacket(da, da.length,
                    InetAddress.getByName("172.22.192.229"), 10000);
            //通过UDP的Socket服务把数据包发送出去
            udpsocket.send(packet);

            if ("over".equals(line)) {
                System.out.println("***************结束****************");
                break;
            }

        }

        //输入over则关闭Socket服务
        udpsocket.close();
    }
}
