package udp.chatdemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 需求：建立UDP协议的发送端
 * 步骤：
 *      1·建立UDP的Socket服务
 *      2·把要发送的数据封装到数据包中
 *      3·通过UDP的Socket服务把数据包发送出去
 *      4·关闭Socket服务
 *
 *    建立Socket后程序才可以使用底层资源进行网络通信传输数据，使用完后要关闭Socket服务关闭占用的底层资源
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 10:04
 */
public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动···");

        //创建udp的Socket服务，通过DatagramSocket对象
        DatagramSocket udpsocket = new DatagramSocket();

        //把要发送的数据封装到数据包中
        String data = "udp传输演示，哥们来啦！！！";
        byte[] da = data.getBytes();
        DatagramPacket packet = new DatagramPacket(da, da.length,
                                 InetAddress.getByName("172.22.192.229"), 10000);

        //通过UDP的Socket服务把数据包发送出去
        udpsocket.send(packet);

        //关闭Socket服务
        udpsocket.close();
    }
}
