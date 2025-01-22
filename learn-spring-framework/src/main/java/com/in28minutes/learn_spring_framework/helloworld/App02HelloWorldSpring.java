package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        ){
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean("address3"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("person4Parameters"));
            System.out.println(context.getBean("person5qualifier"));

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


        }




    }
}
