/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Saki
 */
public class Cvecar {
    private int idCvecar;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Cvecar() {
    }

    public Cvecar(int idCvecar, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.idCvecar = idCvecar;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getIdCvecar() {
        return idCvecar;
    }

    public void setIdCvecar(int idCvecar) {
        this.idCvecar = idCvecar;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return  ime + " " + prezime;
    }
    
}
