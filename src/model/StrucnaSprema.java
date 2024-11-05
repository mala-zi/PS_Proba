/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Saki
 */
public class StrucnaSprema {
    private int idStrucnaSprema;
    private String nazivStrucnaSprema;
    private String nivoStrucnaSprema;
    private boolean sertifikat;

    public StrucnaSprema() {
    }

    public StrucnaSprema(int idStrucnaSprema, String nazivStrucnaSprema, String nivoStrucnaSprema, boolean sertifikat) {
        this.idStrucnaSprema = idStrucnaSprema;
        this.nazivStrucnaSprema = nazivStrucnaSprema;
        this.nivoStrucnaSprema = nivoStrucnaSprema;
        this.sertifikat = sertifikat;
    }

    public int getIdStrucnaSprema() {
        return idStrucnaSprema;
    }

    public void setIdStrucnaSprema(int idStrucnaSprema) {
        this.idStrucnaSprema = idStrucnaSprema;
    }

    public String getNazivStrucnaSprema() {
        return nazivStrucnaSprema;
    }

    public void setNazivStrucnaSprema(String nazivStrucnaSprema) {
        this.nazivStrucnaSprema = nazivStrucnaSprema;
    }

    public String getNivoStrucnaSprema() {
        return nivoStrucnaSprema;
    }

    public void setNivoStrucnaSprema(String nivoStrucnaSprema) {
        this.nivoStrucnaSprema = nivoStrucnaSprema;
    }

    public boolean isSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(boolean sertifikat) {
        this.sertifikat = sertifikat;
    }

    @Override
    public String toString() {
        return nazivStrucnaSprema ;
    }

    
}
