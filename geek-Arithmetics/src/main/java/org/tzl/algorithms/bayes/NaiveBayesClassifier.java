package org.tzl.algorithms.bayes;

/**
 * Created by Ton on 2017/6/5.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 朴素贝叶斯分类器，只能针对有限个情况的分类下面是实例代码
 *
 * @author 鳄鱼
 *
 */
public class NaiveBayesClassifier {
    //将训练集按巡逻集合的最后一个值进行分类
    Map<String, ArrayList<ArrayList<String>>> datasOfClass(ArrayList<ArrayList<String>> datas){
    Map<String, ArrayList<ArrayList<String>>> map = new HashMap<String, ArrayList<ArrayList<String>>>();
    ArrayList<String> t = null;
    String c = "";
    for (int i = 0; i < datas.size(); i++) {
        t = datas.get(i);
        c = t.get(t.size() - 1);
        if (map.containsKey(c)) {
            map.get(c).add(t);
        } else {
            ArrayList<ArrayList<String>> nt = new ArrayList<ArrayList<String>>();
            nt.add(t);
            map.put(c, nt);
        }
    }
    return map;
}

    //在训练数据的基础上预测测试元组的类别 ，testT的各个属性在结果集里面出现的概率相乘最高的，即是结果
    public String predictClass(ArrayList<ArrayList<String>> datas, ArrayList<String> testT) {
        Map<String, ArrayList<ArrayList<String>>> doc = this.datasOfClass(datas);
        //将训练集元素划分保存在数据里
        Object classes[] = doc.keySet().toArray();
        double maxP = 0.00;
        int maxPIndex = -1;
        //testT的各个属性在结果集里面出现的概率相乘最高的，即使结果集
        for (int i = 0; i < doc.size(); i++) {
            String c = classes[i].toString();
            ArrayList<ArrayList<String>> d = doc.get(c);
            //b1除以b2得到一个精度为3的双浮点数
            double pOfC = DecimalCaculate.div(d.size(), datas.size(), 3);
            for (int j = 0; j < testT.size(); j++) {
                double pv = this.pOfV(d, testT.get(j), j);
                //b3乘以b4得到一个浮点数
                pOfC = DecimalCaculate.mul(pOfC, pv);
            }
            if(pOfC > maxP){
                maxP = pOfC;
                maxPIndex = i;
            }
        }
        return classes[maxPIndex].toString();
    }
    // 计算指定属性到训练集出现的频率
    private double pOfV(ArrayList<ArrayList<String>> d, String value, int index) {
        double p = 0.00;
        int count = 0;
        int total = d.size();
        ArrayList<String> t = null;
        for (int i = 0; i < total; i++) {
            if(d.get(i).get(index).equals(value)){
                count++;
            }
        }
        //b1除以b2得到一个精度为3的双浮点数
        p = DecimalCaculate.div(count, total, 3);
        return p;
    }
}