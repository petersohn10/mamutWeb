package com.lacio.mamutweb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MamutCalculationsTest {

    @Test
    public void getTotal() {
        MamutCalculations sut = new MamutCalculations();
        sut.addInvestor("Brajan", 2000);
        sut.addInvestor("Andrzej",1000);
        sut.addInvestor("Jessica",1000);
        assertEquals(4000,sut.getTotal());
    }
    @Test
    public void getTotal_duplicateName() {
        MamutCalculations sut = new MamutCalculations();
        sut.addInvestor("Brajan", 2000);
        assertThrows(
                IllegalArgumentException.class,
                () -> sut.addInvestor("Brajan", 0)
        );
    }
    @Test
    public void getTotal_nullName() {
        MamutCalculations sut = new MamutCalculations();

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.addInvestor(null, 0)
        );
    }
    @Test
    public void addCashToInvestor() {
        MamutCalculations sut = new MamutCalculations();
        sut.addCashToInvestor("Brajan", 2000);
        sut.addCashToInvestor("Andrzej",1000);
        sut.addCashToInvestor("Jessica",1000);
        sut.addCashToInvestor("Jessica",5000);
        assertEquals(0,sut.getCashForInvestor("Jurek"));
        assertEquals(6000,sut.getCashForInvestor("Jessica"));
    }

    @Test
    public void SettlementTwoMembers() {
        MamutCalculations sut = new MamutCalculations();
        sut.addCashToInvestor("Brajan", 2000);
        sut.addCashToInvestor("Andrzej", 1000);
        Settlement expected = new Settlement("Andrzej","Brajan",500);
        Settlement got =sut.settle();
        assertEquals(expected,got);
    }
}