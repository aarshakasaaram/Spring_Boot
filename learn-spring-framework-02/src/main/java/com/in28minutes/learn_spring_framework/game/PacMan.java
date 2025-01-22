package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacMan implements GamingConsole{
    public void up(){

        System.out.println("Aarsha");
    }
    public void down(){
        System.out.println("Kasaram");

    }
    public void left(){
        System.out.println("PremSai");
    }
    public void right(){
        System.out.println("Kanamarlapudi");
    }
}
