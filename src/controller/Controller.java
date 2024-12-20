/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.List;
import model.Cvecar;
import model.Kupac;
import model.Mesto;
import model.Otpremnica;

/**
 *
 * @author Saki
 */
public class Controller {

    private DBBroker dbb;
    private static Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {
         dbb=new DBBroker();
    }

    public boolean login(String user, String password) {
        return dbb.login(user,password);
    }

    public List<Otpremnica> ucitajOtpremniceIzBaze() {
        return dbb.ucitajOtpremniceIzBaze();
    }

    public List<Cvecar> popuniCvecareIzBaze() {
        return dbb.popuniCvecareIzBaze();
    }

    public List<Kupac> popuniKupceIzBaze() {
        return dbb.popuniKupceIzBaze();
    }

    public void dodajOtpremnicu(Otpremnica otp) {
        dbb.dodajOtpremnicu(otp);
    }

    public void promeniOtpremnicu(Otpremnica otp) {
        dbb.promeniOtpremnicu(otp);
    }

    public List<Kupac> ucitajKupceIzBaze() {
        return dbb.ucitajKupceIzBaze();
    }

    public List<Mesto> ucitajMestaIzBaze() {
        return dbb.ucitajMestaIzBaze();
    }

    public void dodajKupca(Kupac k) {
        dbb.dodajKupca(k);
    }

    public void izmeniKupca(Kupac k) {
        dbb.izmeniKupca(k);
    }

    public void obrisiKupca(Kupac kupac) {
        dbb.obrisiKupca(kupac);
    }

    public List<Cvecar> ucitajCvecareIzBaze() {
        return dbb.ucitajCvecareIzBaze();
    }

    public void obrisiCvecara(Cvecar c) {
        dbb.obrisiCvecara(c);
    }

    public void dodajCvecara(Cvecar c) {
        dbb.dodajCvecara(c);
    }

    public void promeniCvecara(Cvecar c) {
        dbb.promeniCvecara(c);
    }

    
    
    

}
