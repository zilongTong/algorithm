package org.tzl.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ton on 2017/6/23.
 */
public class TreeMapDemo {


    public static void main(String[] args) {

        Map<Integer,UserDemo> map= new TreeMap<Integer,UserDemo>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return -1;
                }else if(o1<02){
                    return 1;
                }
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        UserDemo  u1=new UserDemo(1,"11");
        UserDemo  u2=new UserDemo(2,"22");
        UserDemo  u3=new UserDemo(3,"33");
        map.put(1,u1);
        map.put(3,u3);
        map.put(2,u3);
        map.put(4,u2);
        map.get(3);
        Iterator it = map.keySet().iterator();
     while (it.hasNext()){
            Integer key=(int)it.next();

            System.out.println("key:"+key+"------value:"+map.get(key).getName());
        }
    }
static class   UserDemo {
    private  int id;
    private  String name;

    public UserDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDemo() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
}
