/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Saki
 */
public class Kupac {
    private int idKupac;
    private int pibKupac;
    private String telefon;
    private String email;
    private Mesto mesto;

    public Kupac() {
    }

    public Kupac(int idKupac, int pibKupac, String telefon, String email, Mesto mesto) {
        this.idKupac = idKupac;
        this.pibKupac = pibKupac;
        this.telefon = telefon;
        this.email = email;
        this.mesto = mesto;
    }


    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public int getIdKupac() {
        return idKupac;
    }

    public void setIdKupac(int idKupac) {
        this.idKupac = idKupac;
    }

    public int getPibKupac() {
        return pibKupac;
    }

    public void setPibKupac(int pibKupac) {
        this.pibKupac = pibKupac;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "pib:"+pibKupac;
    }

   
}
