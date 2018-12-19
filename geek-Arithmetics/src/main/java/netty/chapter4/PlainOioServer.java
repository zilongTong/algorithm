/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: PlainOioServer.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-07-02 03 : 41:19
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-07-02 03 : 41:19> <version>   <desc>
 */

package netty.chapter4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PlainOioServer {


    public void serve(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        try {
            for (; ; ) {
                final Socket clientSocket = serverSocket.accept();
                System.out.println("Accept connection from " + clientSocket);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream os;
                        try {
                            os = clientSocket.getOutputStream();
                            os.write("wtf".getBytes(Charset.forName("UTF-8")));
                            os.flush();
                            clientSocket.close();
                        } catch (Exception e) {
                            try {
                                clientSocket.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        } catch (Exception e) {

        }


    }
}
