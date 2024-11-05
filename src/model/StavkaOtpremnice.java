/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Saki
 */
public class StavkaOtpremnice {
    private int rb;
    private int kolicina;
    private double cena;
    private double iznos;
    private String napomena;
    private Aranzman aranzman;
    private Otpremnica otpremnica;

    public StavkaOtpremnice() {
    }

    public StavkaOtpremnice(int rb, int kolicina, double cena, double iznos, String napomena, Aranzman aranzman, Otpremnica otpremnica) {
        this.rb = rb;
        this.kolicina = kolicina;
        this.cena = cena;
        this.iznos = iznos;
        this.napomena = napomena;
        this.aranzman = aranzman;
        this.otpremnica = otpremnica;
    }

    public Otpremnica getOtpremnica() {
        return otpremnica;
    }

    public void setOtpremnica(Otpremnica otpremnica) {
        this.otpremnica = otpremnica;
    }

    

    public Aranzman getAranzman() {
        return aranzman;
    }

    public void setAranzman(Aranzman aranzman) {
        this.aranzman = aranzman;
    }

   
    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String toString() {
        return "StavkaOtpremnice{" + "rb=" + rb + ", kolicina=" + kolicina + ", cena=" + cena + ", iznos=" + iznos + ", napomena=" + napomena + ", aranzman=" + aranzman + ", otpremnica=" + otpremnica + '}';
    }

    
    
    
    
}
