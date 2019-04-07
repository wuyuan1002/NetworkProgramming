package tcp.uploadpicture;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 需求：实现客户端上传图片到服务器端
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/24 9:12
 */
public class upLoadPictureCliend {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("171.22.197.227",10005);

        File srcfile = new File("D:\\asd");
        FileInputStream fileInputStream = new FileInputStream(srcfile);
        OutputStream outputStream = socket.getOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        len = inputStream.read(bytes);
        String string = new String(bytes,0,len);
        System.out.println(string);

        fileInputStream.close();
        socket.close();
    }
}
