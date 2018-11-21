package com.nealhartley.pokerbuddy;

/**
 * Created by Dev on 21/11/2018.
 */

public class AdvicePacket {

    private String advice;
    private int strength;

    public AdvicePacket(String advice, int strength){
        this.advice = advice;
        this.strength = strength;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
