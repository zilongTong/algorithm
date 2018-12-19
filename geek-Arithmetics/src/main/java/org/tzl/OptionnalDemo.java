/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: OptionnalDemo.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-10-31 05 : 14:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-10-31 05 : 14:13> <version>   <desc>
 */

package org.tzl;

import java.util.Optional;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OptionnalDemo {


    public static void main(String[] args) {
        User u=new User();
         u=null;
        Optional<User> user = Optional.of(u);
        System.out.println(user.isPresent());
        user.get().getAge();
    }

    static class  User{
        private String name;
        private int age;
        private  Man man;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Man getMan() {
            return man;
        }

        public void setMan(Man man) {
            this.man = man;
        }
    }
    class Man{
        private  String gen;

        public String getGen() {
            return gen;
        }

        public void setGen(String gen) {
            this.gen = gen;
        }
    }
}
