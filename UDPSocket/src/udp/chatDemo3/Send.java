package udp.chatDemo3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 11:27
 */
public class Send implements Runnable {
    private DatagramSocket socket;

    public Send(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("发送端启动···输入你要发送的数据吧,输入over结束");

        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
//        Scanner bur = new Scanner(System.in);
        try {
            String line;
            while ((line = bur.readLine()) != null) {
                //把要发送的数据封装到数据包中
                byte[] da = line.getBytes();
                DatagramPacket packet = new DatagramPacket(da, da.length,
                        InetAddress.getByName("172.22.192.229"), 10001);
                //通过UDP的Socket服务把数据包发送出去
                this.socket.send(packet);

                if ("over".equals(line)) {
                    System.out.println("***************Send结束****************");
                    break;
                }

            }

            //输入over则关闭Socket服务
            this.socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
