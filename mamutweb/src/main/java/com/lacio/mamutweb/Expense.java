package com.lacio.mamutweb;

public class Expense {
    private int id;
    private String kategoria;
    private double koszt;
    private String kto;

    public Expense(int id, String kategoria, double koszt, String kto) {
        this.id = id;
        this.kategoria = kategoria;
        this.koszt = koszt;
        this.kto = kto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    public String getKto() {
        return kto;
    }

    public void setKto(String kto) {
        this.kto = kto;
    }
}
