/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Saki
 */
public class Otpremnica {
    private int idOtpremnica;
    private Date datumIzdavanja;
    private double ukupnaCena;
    private Cvecar cvecar;
    private Kupac kupac;

    public Otpremnica() {
    }

    public Otpremnica(int idOtpremnica, Date datumIzdavanja, double ukupnaCena, Cvecar cvecar, Kupac kupac) {
        this.idOtpremnica = idOtpremnica;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupnaCena = ukupnaCena;
        this.cvecar = cvecar;
        this.kupac =kupac;
    }

    public Cvecar getCvecar() {
        return cvecar;
    }

    public void setCvecar(Cvecar cvecar) {
        this.cvecar = cvecar;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    
   

    public int getIdOtpremnica() {
        return idOtpremnica;
    }

    public void setIdOtpremnica(int idOtpremnica) {
        this.idOtpremnica = idOtpremnica;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    @Override
    public String toString() {
        return "Otpremnica{" + "idOtpremnica=" + idOtpremnica + ", datumIzdavanja=" + datumIzdavanja + ", ukupnaCena=" + ukupnaCena + ", cvecar=" + cvecar + ", kupac=" + kupac + '}';
    }

   
}
