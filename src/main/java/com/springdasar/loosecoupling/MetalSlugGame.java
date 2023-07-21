package com.springdasar.loosecoupling;

import org.springframework.stereotype.Component;

@Component
public class MetalSlugGame implements GamingConsole {

    @Override
    public void startGame() {
        // TODO Auto-generated method stub
        System.out.println("Metal Slug Start!");
    }

}
