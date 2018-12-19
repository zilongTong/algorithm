package org.tzl.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class ByteIODemo {

    public static void main(String[] args) {

        createFile();
    }

    /**
     * 文件处理示例
     */
    public static void createFile() {
        File f = new File("E:/电脑桌面/jar/files/create.txt");
        try {
            f.createNewFile();  //当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
            System.out.println("该分区大小" + f.getTotalSpace() / (1024 * 1024 * 1024) + "G"); //返回由此抽象路径名表示的文件或目录的名称。
            f.mkdirs();  //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
//            f.delete(); //  删除此抽象路径名表示的文件或目录
            System.out.println("文件名  " + f.getName());  //  返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("文件父目录字符串 " + f.getParent());// 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileInputStream() {
        int count = 0;  //统计文件字节长度
        InputStream streamReader = null;   //文件输入流
        try {
            //TODO 自动生成的方法存根
            streamReader = new FileInputStream(new File("D:/David/Java/java 高级进阶/files/tiger.jpg"));
          /*1.new File()里面的文件地址也可以写成D:\\David\\Java\\java 高级进阶\\files\\tiger.jpg,前一个\是用来对后一个
           * 进行转换的，FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
          */
            while (streamReader.read() != -1) {  //读取文件字节，并递增指针到下一个字节
                count++;
            }
            System.out.println("---长度是： " + count + " 字节");
        } catch (final IOException e) {
            //TODO 自动生成的 catch 块
            e.printStackTrace();
        } finally {
            try {
                streamReader.close();
            } catch (IOException e) {
                //TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }

    public static void fileInputStreambuffer() {
        // TODO自动生成的方法存根
        byte[] buffer = new byte[512];   //一次取出的字节数大小,缓冲区大小
        int numberRead = 0;
        FileInputStream input = null;
        FileOutputStream out = null;
        try {
            input = new FileInputStream("D:/David/Java/java 高级进阶/files/tiger.jpg");
            out = new FileOutputStream("D:/David/Java/java 高级进阶/files/tiger2.jpg"); //如果文件不存在会自动创建

            while ((numberRead = input.read(buffer)) != -1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，
                out.write(buffer, 0, numberRead);       //否则会自动被填充0
            }
        } catch (final IOException e) {
            // TODO自动生成的 catch 块
            e.printStackTrace();
        } finally {
            try {
                input.close();
                out.close();
            } catch (IOException e) {
                // TODO自动生成的 catch 块
                e.printStackTrace();
            }

        }
    }

    public   static   void   ObjetStream(){
        // TODO自动生成的方法存根
        ObjectOutputStream objectwriter=null;
        ObjectInputStream objectreader=null;

        try {
            objectwriter=new ObjectOutputStream(new FileOutputStream("D:/David/Java/java 高级进阶/files/student.txt"));
            objectwriter.writeObject(new Student("gg", 22));
            objectwriter.writeObject(new Student("tt", 18));
            objectwriter.writeObject(new Student("rr", 17));
            objectreader=new ObjectInputStream(new FileInputStream("D:/David/Java/java 高级进阶/files/student.txt"));
            for (int i = 0; i < 3; i++) {
                System.out.println(objectreader.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO自动生成的 catch 块
            e.printStackTrace();
        }finally{
            try {
                objectreader.close();
                objectwriter.close();
            } catch (IOException e) {
                // TODO自动生成的 catch 块
                e.printStackTrace();
            }

        }

    }
static class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }


}
}

