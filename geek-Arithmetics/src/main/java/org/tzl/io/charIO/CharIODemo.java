package org.tzl.io.charIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class CharIODemo {

    public static void main(String[] args) {
        fileReader();
    }

    public static void fileReader() {

        // TODO自动生成的方法存根
        char[] buffer = new char[512];   //一次取出的字节数大小,缓冲区大小
        int numberRead = 0;
        FileReader reader = null;        //读取字符文件的流
        PrintWriter writer = null;    //写字符到控制台的流

        try {
            reader = new FileReader("D:/David/Java/java 高级进阶/files/copy1.txt");
            writer = new PrintWriter(System.out);  //PrintWriter可以输出字符到文件，也可以输出到控制台
            while ((numberRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, numberRead);
            }
        } catch (IOException e) {
            // TODO自动生成的 catch 块
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO自动生成的 catch 块
                e.printStackTrace();
            }
            writer.close();       //这个不用抛异常
        }

    }
    public static void concennateFile(String...fileName) throws IOException{
        String str;
        //构建对该文件您的输入流
        BufferedWriter writer=new BufferedWriter(new FileWriter("D:/David/Java/java 高级进阶/files/copy2.txt"));
        for(String name: fileName){
            BufferedReader reader=new BufferedReader(new FileReader(name));

            while ((str=reader.readLine())!=null) {
                writer.write(str);
                writer.newLine();
            }
        }
    }

    /**
     * 使用StreamTokenizer来统计文件中的字符数
     * StreamTokenizer 类获取输入流并将其分析为“标记”，允许一次读取一个标记。
     * 分析过程由一个表和许多可以设置为各种状态的标志控制。
     * 该流的标记生成器可以识别标识符、数字、引用的字符串和各种注释样式。
     *
     *  默认情况下，StreamTokenizer认为下列内容是Token: 字母、数字、除C和C++注释符号以外的其他符号。
     *  如符号"/"不是Token，注释后的内容也不是，而"\"是Token。单引号和双引号以及其中的内容，只能算是一个Token。
     *  统计文章字符数的程序，不是简单的统计Token数就万事大吉，因为字符数不等于Token。按照Token的规定，
     *  引号中的内容就算是10页也算一个Token。如果希望引号和引号中的内容都算作Token，应该调用下面的代码：
     *    st.ordinaryChar('\'');
     * st.ordinaryChar('\"');
     */
    public   static   long  streamTokenizerExample(String  fileName){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            //创建分析给定字符流的标记生成器
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(
                      fileReader));

            //ordinaryChar方法指定字符参数在此标记生成器中是“普通”字符。
            //下面指定单引号、双引号和注释符号是普通字符
            st.ordinaryChar('\'');
            st.ordinaryChar('\"');
            st.ordinaryChar('/');

            String s;
            int numberSum = 0;
            int wordSum = 0;
            int symbolSum = 0;
            int total = 0;
            //nextToken方法读取下一个Token.
            //TT_EOF指示已读到流末尾的常量。
            while (st.nextToken() !=StreamTokenizer.TT_EOF) {
                //在调用 nextToken 方法之后，ttype字段将包含刚读取的标记的类型
                switch (st.ttype) {
                    //TT_EOL指示已读到行末尾的常量。
                    case StreamTokenizer.TT_EOL:
                        break;
                    //TT_NUMBER指示已读到一个数字标记的常量
                    case StreamTokenizer.TT_NUMBER:
                        //如果当前标记是一个数字，nval字段将包含该数字的值
                        s = String.valueOf((st.nval));
                        System.out.println("数字有："+s);
                        numberSum ++;
                        break;
                    //TT_WORD指示已读到一个文字标记的常量
                    case StreamTokenizer.TT_WORD:
                        //如果当前标记是一个文字标记，sval字段包含一个给出该文字标记的字符的字符串
                        s = st.sval;
                        System.out.println("单词有： "+s);
                        wordSum ++;
                        break;
                    default:
                        //如果以上3中类型都不是，则为英文的标点符号
                        s = String.valueOf((char) st.ttype);
                        System.out.println("标点有： "+s);
                        symbolSum ++;
                }
            }
            System.out.println("数字有 " + numberSum+"个");
            System.out.println("单词有 " + wordSum+"个");
            System.out.println("标点符号有： " + symbolSum+"个");
            total = symbolSum + numberSum +wordSum;
            System.out.println("Total = " + total);
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e1) {
                }
        }
    }
}
}
