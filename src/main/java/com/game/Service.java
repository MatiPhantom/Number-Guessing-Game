package com.game;

import java.util.Random;

public class Service {

    private static byte DIFFICULTY;
    private static byte RANDOM_NUMBER;

    public void setDificulty(byte difficulty) {
        this.DIFFICULTY = difficulty;
    }

    public void setRandomNumber() {
        switch (DIFFICULTY) {
            case 1:
                RANDOM_NUMBER=(byte) (new Random().nextInt(30)+1);
            break;
            case 2:
                RANDOM_NUMBER = (byte) (new Random().nextInt(60)+1);
            break;
            case 3:
                RANDOM_NUMBER = (byte) (new Random().nextInt(100)+1);
            break;
        }
    }

    public byte getRandomNumber(){
        return this.RANDOM_NUMBER;
    }

    public int checkGuess(int guess){
        int rest=RANDOM_NUMBER-guess;
        if(rest>0){
            return 1;
        }else if(rest<0){
            return -1;
        }else{
            return 0;
        }
    }



    



}
