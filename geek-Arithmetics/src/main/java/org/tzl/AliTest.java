package org.tzl;

/**
 * Created by Ton on 2017/6/15.
 */
//在编程中i++和++i最终是一样的，不过在循环体中，i++是先取出I，再加1，＋＋i先加后取
public class AliTest {
    public static void main(String[] args) {
        int iValue=233;
        //强制把一个int类型的值转换成byte类型的值
        byte bValue=(byte) iValue;
        //将输出-23
        System.out.println(bValue);

        //char、byte、int对于英文字符，可以相互转化
        byte g = 'b';   //b对应ASCII是98
        char c='b';
        char h = (char) g;
        char i = 85;    //U对应ASCII是85
        int j = 'h';    //h对应ASCII是104
        System.out.println(c);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);
        System.out.println(j);
        String str1 = "ab" + "cd";  //1个对象
        String str11 = "abcd";
        System.out.println("str1 = str11 : "+ (str1 == str11));
    }
}