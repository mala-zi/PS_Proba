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
public class CvSS {
    private Cvecar cvecar;
    private StrucnaSprema strucnaSprema;
    private Date datumObuke;

    public CvSS() {
    }

    public CvSS(Cvecar cvecar, StrucnaSprema strucnaSprema, Date datumObuke) {
        this.cvecar = cvecar;
        this.strucnaSprema = strucnaSprema;
        this.datumObuke = datumObuke;
    }

    public Cvecar getCvecar() {
        return cvecar;
    }

    public void setCvecar(Cvecar cvecar) {
        this.cvecar = cvecar;
    }

    public StrucnaSprema getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    public Date getDatumObuke() {
        return datumObuke;
    }

    public void setDatumObuke(Date datumObuke) {
        this.datumObuke = datumObuke;
    }

    @Override
    public String toString() {
        return "CvSS{" + "cvecar=" + cvecar + ", strucnaSprema=" + strucnaSprema + ", datumObuke=" + datumObuke + '}';
    }
    
}
