package com.lacio.mamutweb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "costs")
public class SettlementRow {


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "`ID`")
    private int id;
    @Column(name = "`Koszt`")
    private double koszt;
    @Column(name = "`Kto`")
    private char kto;
    @Column(name = "`Kategoria`")
    private String kategoria;


    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public SettlementRow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    public char getKto() {
        return kto;
    }

    public void setKto(char kto) {
        this.kto = kto;
    }


    @Override
    public String toString() {
        return "SettlementRow{" +
                "id=" + id +
                ", koszt=" + koszt +
                ", kto=" + kto +
                ", kategoria='" + kategoria + '\'' +
                '}';
    }
}
