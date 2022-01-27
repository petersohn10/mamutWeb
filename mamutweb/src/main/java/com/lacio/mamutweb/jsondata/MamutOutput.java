package com.lacio.mamutweb.jsondata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MamutOutput {

    private float koszty;
    private float kosztyP;
    private float kosztyB;
    private SettlementOutput settlementOutput;


    public MamutOutput(float koszty, float kosztyP, float kosztyB, SettlementOutput settlementOutput) {
        this.koszty = koszty;
        this.kosztyP = kosztyP;
        this.kosztyB = kosztyB;
        this.settlementOutput = settlementOutput;
    }

    @JsonProperty("total_costs")
    public float getKoszty() {
        return koszty;
    }

    public void setKoszty(float koszty) {
        this.koszty = koszty;
    }

    @JsonProperty("P_costs")
    public float getKosztyP() {
        return kosztyP;
    }

    public void setKosztyP(float kosztyP) {
        this.kosztyP = kosztyP;
    }

    @JsonProperty("B_costs")
    public float getKosztyB() {
        return kosztyB;
    }

    public void setKosztyB(float kosztyB) {
        this.kosztyB = kosztyB;
    }

    public SettlementOutput getSettlement() {
        return settlementOutput;
    }

    public void setSettlement(SettlementOutput settlementOutput) {
        this.settlementOutput = settlementOutput;
    }
}
