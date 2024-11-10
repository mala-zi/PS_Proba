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
    private String naziv;

    public Kupac() {
    }

    public Kupac(int idKupac, int pibKupac, String telefon, String email, Mesto mesto,String naziv) {
        this.idKupac = idKupac;
        this.pibKupac = pibKupac;
        this.telefon = telefon;
        this.email = email;
        this.mesto = mesto;
        this.naziv=naziv;
    }
     public Kupac( int pibKupac, String telefon, String email, Mesto mesto,String naziv) {
        
        this.pibKupac = pibKupac;
        this.telefon = telefon;
        this.email = email;
        this.mesto = mesto;
        this.naziv=naziv;
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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
        return naziv;
    }

   
}
