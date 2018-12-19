/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: Client.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-06-12 10 : 49:03
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-06-12 10 : 49:03> <version>   <desc>
 */

package rpc.netty.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：leo，密码：111");
            pw.flush();
            socket.shutdownOutput();

            //获取输入流，接收服务端响应信息
            is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println("客户端接收服务端信息：" + data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
