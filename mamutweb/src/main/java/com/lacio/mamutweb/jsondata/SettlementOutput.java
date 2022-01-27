package com.lacio.mamutweb.jsondata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SettlementOutput {
    private String who;
    private String whom;
    private float howMuch;


    public SettlementOutput(String who, String whom, float howMuch) {
        this.who = who;
        this.whom = whom;
        this.howMuch = howMuch;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhom() {
        return whom;
    }

    public void setWhom(String whom) {
        this.whom = whom;
    }

    public float getHowMuch() {
        return howMuch;
    }

    @JsonProperty("how_much_to_return")
    public void setHowMuch(float howMuch) {
        this.howMuch = howMuch;
    }

}
