package tcp.uploadpicture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 需求：实现客户端上传图片到服务器端
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/24 9:13
 */
public class upLoadPictureServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10005);
        Socket socket = serverSocket.accept();
        String ip = socket.getInetAddress().getHostAddress();

        File file = new File("D:\\qwe");
        if (!file.exists()) {
            file.mkdir();
        }

        InputStream inputStream = socket.getInputStream();
        File file1 = new File(file, ip+".bmp");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,len);
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("上传成功！".getBytes());

        socket.close();
        serverSocket.close();
    }
}
