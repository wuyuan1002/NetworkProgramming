package ip.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * java通过InetAddress类来获取ip或主机名，把ip地址封装成了对象
 *
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/21 9:20
 */
public class InetAddressObjectTest {

    public static void main(String[] args) throws UnknownHostException {
        //获取本地ip地址对象 --- ip地址和主机名一一对应
        InetAddress lip = InetAddress.getLocalHost();
        //获取本机ip地址
        System.out.println(lip.getHostAddress());
        //获取本机主机名
        System.out.println(lip.getHostName());


        //获取其他主机的ip地址对象
        InetAddress oip1 = InetAddress.getByName("Cookie");
        System.out.println(oip1.getHostName());
        System.out.println(oip1.getHostAddress());
        InetAddress oip2 = InetAddress.getByName("172.22.192.229");
        System.out.println(oip2.getHostName());
        System.out.println(oip2.getHostAddress());

    }

}
