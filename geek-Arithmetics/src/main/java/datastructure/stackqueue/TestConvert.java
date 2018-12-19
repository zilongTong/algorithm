package datastructure.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 十进制转换成二进制
 *
 * @author Administrator
 */
public class TestConvert {

    public static void main(String[] args) {
        //给定一个十进制数
        int n = 100;

        //把十进制数转换成二进制
        int t = n;//被除数
        //String str = "";
        //定义一个空栈
        Deque stack = new LinkedList();
        do {
            //除以2求余数
            int mod = t % 2;
            //输出余数
            //System.out.println(mod);
            //str =mod +str;
            //入栈
            stack.push(mod);
            //除以2得到商
            //int result = t / 2;
            //使用商做被除数
            //t = result;
            t = t / 2;

        } while (t > 0);//商>0

        //输出结果
        System.out.print(n + "------>");
        while (!stack.isEmpty()) {//栈非空
            System.out.print(stack.pop());
        }

    }

}
