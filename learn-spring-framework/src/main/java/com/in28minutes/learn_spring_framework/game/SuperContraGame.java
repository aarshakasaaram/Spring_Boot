package com.in28minutes.learn_spring_framework.game;

public class SuperContraGame  implements GamingConsole{
    public void up(){
        System.out.println("jump");
    }
    public void down(){
        System.out.println("Go into a hole");

    }
    public void left(){
        System.out.println("Go Back");
    }
    public void right(){
        System.out.println("Accelerate");
    }
}
