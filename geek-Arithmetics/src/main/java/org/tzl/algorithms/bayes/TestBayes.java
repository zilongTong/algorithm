package org.tzl.algorithms.bayes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Ton on 2017/6/6.
 */
public class TestBayes {

  /*  假设某个体有n项特征（Feature），分别为F1、F2、...、Fn。现有m个类别（Category），分别为C1、C2、...、Cm。贝叶斯分类器就是计算出概率最大的那个分类，也就是求下面这个算式的最大值：

            　P(C|F1F2...Fn)
        　　= P(F1F2...Fn|C)P(C) / P(F1F2...Fn)
            由于 P(F1F2...Fn) 对于所有的类别都是相同的，可以省略，问题就变成了求

        　P(F1F2...Fn|C)P(C)
            的最大值。

            朴素贝叶斯分类器则是更进一步，假设所有特征都彼此独立，因此

        　P(F1F2...Fn|C)P(C)
                    　　= P(F1|C)P(F2|C) ... P(Fn|C)P(C)
    */

    public ArrayList<String> readTestData() throws IOException {
        ArrayList<String> candAttr = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (!(str = reader.readLine()).equals("")) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            while (tokenizer.hasMoreTokens()) {
                candAttr.add(tokenizer.nextToken());
            }
        }
        return candAttr;
    }


    public ArrayList<ArrayList<String>> readData() throws IOException {
        ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (!(str = reader.readLine()).equals("")) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            ArrayList<String> s = new ArrayList<String>();
            while (tokenizer.hasMoreTokens()) {
                s.add(tokenizer.nextToken());
            }
            datas.add(s);
        }
        return datas;
    }

    public static void main(String[] args) {
        TestBayes tb = new TestBayes();
        ArrayList<ArrayList<String>> datas = null;
        ArrayList<String> testT = null;
        NaiveBayesClassifier bayes = new NaiveBayesClassifier();
        try {
         /*   youth high no fair no
                youth high no excellent no
                middle_aged high no fair yes
                senior medium no fair yes
                senior low yes fair yes
                senior low yes excellent no
                middle_aged low yes excellent yes
                youth medium no fair no
                youth low yes fair yes
                senior medium yes fair yes
                youth medium yes excellent yes
                middle_aged medium no excellent yes
                middle_aged high yes fair yes
                senior medium no excellent no
            */
            System.out.println("请输入训练数据");
            datas = tb.readData();
            while (true) {
                System.out.println("请输入测试元组");
                testT = tb.readTestData();
                String c = bayes.predictClass(datas, testT);
                System.out.println("The class is: " + c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
