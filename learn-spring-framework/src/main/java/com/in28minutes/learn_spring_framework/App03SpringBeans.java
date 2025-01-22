package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import com.in28minutes.learn_spring_framework.game.PacMan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03SpringBeans {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);
        context.getBean(GamingConsole.class).down();
        context.getBean(GameRunner.class).run();
    }



//    public static void main(String[] args) {
//        var game = new PacMan();
//        //var game = new MarioGame();
//        //var game = new SuperContraGame();
//
//        var gameRunner = new GameRunner(game);
//        gameRunner.run();


    }

