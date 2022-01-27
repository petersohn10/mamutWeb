package com.lacio.mamutweb;



import com.lacio.mamutweb.entities.SettlementRow;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class MamutCalculations {

    private Map<String, Float> amountByName;



    public MamutCalculations() {
        this.amountByName = new HashMap<>();
    }
    public float getTotal(){
        float sum=0;
        for (Map.Entry<String,Float> row:this.amountByName.entrySet()){
            sum=sum+row.getValue();
        }
        return sum;
    }
    public void addInvestor(String name, float amount){
        if (name==null){
            throw new IllegalArgumentException("Null ni ma kasy wiec ma spierdalac");
        }
        if (amountByName.containsKey(name)){
            throw new IllegalArgumentException("Inwestor już przejebał tu swoją kase.");
        }

        amountByName.put(name,amount);

    }
    public void addCashToInvestor(String name, float investment){
        if (name==null) {
            throw new IllegalArgumentException("Null ni ma kasy wiec ma spierdalac");
        }
        if(amountByName.containsKey(name)){
            amountByName.put(name,amountByName.get(name)+investment);
        }
        else amountByName.put(name,investment);
    }
    public void addCashToInvestor(SettlementRow row){
        if (row==null) {
            throw new IllegalArgumentException("Null ni ma kasy wiec ma spierdalac");
        }
        this.addCashToInvestor(String.valueOf(row.getKto()), (float)row.getKoszt());
    }


    public float getCashForInvestor(String name) {
       return amountByName.getOrDefault(name,0f);
    }

    public Settlement settle() {

        Map.Entry<String, Float> minEntry = Collections.min(amountByName.entrySet(), Map.Entry.comparingByValue());
        String who=minEntry.getKey();

        Map.Entry<String, Float> maxEntry = Collections.max(amountByName.entrySet(), Map.Entry.comparingByValue());
        String whom=maxEntry.getKey();

        float howMuch= (maxEntry.getValue() - minEntry.getValue())/2;

        return new Settlement(who, whom, howMuch);
    }


}
