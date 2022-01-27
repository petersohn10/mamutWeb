package com.lacio.mamutweb;

public class Settlement {

    private String who;
    private String whom;
    private float howMuch;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Settlement that = (Settlement) o;

        if (Float.compare(that.howMuch, howMuch) != 0) return false;
        if (!who.equals(that.who)) return false;
        return whom.equals(that.whom);
    }

    @Override
    public int hashCode() {
        int result = who.hashCode();
        result = 31 * result + whom.hashCode();
        result = 31 * result + (howMuch != +0.0f ? Float.floatToIntBits(howMuch) : 0);
        return result;
    }

    public Settlement(String nameWho, String nameWhom, float howMuch){

        this.who=nameWho;
        this.whom=nameWhom;
        this.howMuch=howMuch;
    }

    public String getWho(){
        return who;
    }
    public String getWhom(){
        return whom;
    }
    public float getHowMuch(){
        return howMuch;
    }

    @Override
    public String toString() {
        return "Rozliczenie:" +
                "Dłużnik'" + who + '\'' +
                ", wieżyciel'" + whom + '\'' +
                ", kwota" + howMuch +
                '.';
    }
}
