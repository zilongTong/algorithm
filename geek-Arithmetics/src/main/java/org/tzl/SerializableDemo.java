package org.tzl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * java 序列化
 */
public class SerializableDemo {

    public static void main(String[] args) {
        Student st = new Student("Tom",'M',20,3.6);
        File file = new File(".\\studentgsdgsdsddsgsdg.txt");
        try
        {
            file.createNewFile();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            //Student对象序列化过程
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(st);
            oos.flush();
            oos.close();
            fos.close();

            //Student对象反序列化过程
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student st1 = (Student) ois.readObject();
            System.out.println("name = " + st1.getName());
            System.out.println("sex = " + st1.getSex());
            System.out.println("year = " + st1.getYear());
            System.out.println("gpa = " + st1.getGpa());
            ois.close();
            fis.close();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }



    static class Student implements Serializable {

        private String name;
        private char sex;
        private int year;
        private double gpa;

        public Student() {

        }

        public Student(String name, char sex, int year, double gpa) {
            this.name = name;
            this.sex = sex;
            this.year = year;
            this.gpa = gpa;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSex(char sex) {
            this.sex = sex;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

        public String getName() {
            return this.name;
        }

        public char getSex() {
            return this.sex;
        }

        public int getYear() {
            return this.year;
        }

        public double getGpa() {
            return this.gpa;
        }

    }

}
