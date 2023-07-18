package com.springdasar.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		var metalSlugGame = new MetalSlugGame();
		var gameRunner = new GameRunner(metalSlugGame);
		gameRunner.run();
		System.out.println("");
		var marioGame = new MarioGame();
		gameRunner = new GameRunner(marioGame);
		gameRunner.run();

		
	}

}
