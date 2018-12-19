package org.geek.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ton on 2017/5/23.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/world")
    public   String index(){
        return "Hello  world";
    }

}