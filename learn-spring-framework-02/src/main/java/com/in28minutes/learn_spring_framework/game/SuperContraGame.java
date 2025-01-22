package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("supercontragamequalifier")

public class SuperContraGame  implements GamingConsole{
    public void up(){
        System.out.println("sydabee");
    }
    public void down(){
        System.out.println("raghu");

    }
    public void left(){
        System.out.println("ammamma");
    }
    public void right(){
        System.out.println("thathaya");
    }
}
