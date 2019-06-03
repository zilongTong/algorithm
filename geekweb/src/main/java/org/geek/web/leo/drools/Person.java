package org.geek.web.leo.drools;

import lombok.Data;

/**
 * @ClassName Person
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/20 11:30
 **/
@Data
public class Person {

    private Integer age;
    private String name;

    public Person(String name, Integer age) {
        this.age = age;
        this.name = name;
    }
}