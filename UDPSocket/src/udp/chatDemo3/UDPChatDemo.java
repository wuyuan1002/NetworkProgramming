package udp.chatDemo3;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 11:16
 */
public class UDPChatDemo {
    public static void main(String[] args) throws SocketException {
        DatagramSocket send = new DatagramSocket();
        DatagramSocket receive = new DatagramSocket(10001);
        new Thread(new Send(send)).start();
        new Thread(new Receive(receive)).start();

    }
}
