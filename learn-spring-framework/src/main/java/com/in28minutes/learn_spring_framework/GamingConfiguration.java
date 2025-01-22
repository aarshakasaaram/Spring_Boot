package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import com.in28minutes.learn_spring_framework.game.PacMan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
    @Bean
            public GamingConsole game(){
        var game  =  new PacMan();
        return game;

    }
    @Bean
    public GameRunner  gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

//        var game = new PacMan();
//        //var game = new MarioGame();
//        //var game = new SuperContraGame();
//
//        var gameRunner = new GameRunner(game);
//        gameRunner.run();
}
