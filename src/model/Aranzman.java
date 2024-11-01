/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Saki
 */
public class Aranzman {
    private int idAranzman;
    private String nazivAranzmana;
    private double cenaAranzmana;
    private String opisAranzmana;

    public Aranzman() {
    }

    public Aranzman(int idAranzman, String nazivAranzmana, double cenaAranzmana, String opisAranzmana) {
        this.idAranzman = idAranzman;
        this.nazivAranzmana = nazivAranzmana;
        this.cenaAranzmana = cenaAranzmana;
        this.opisAranzmana = opisAranzmana;
    }

    public int getIdAranzman() {
        return idAranzman;
    }

    public void setIdAranzman(int idAranzman) {
        this.idAranzman = idAranzman;
    }

    public String getNazivAranzmana() {
        return nazivAranzmana;
    }

    public void setNazivAranzmana(String nazivAranzmana) {
        this.nazivAranzmana = nazivAranzmana;
    }

    public double getCenaAranzmana() {
        return cenaAranzmana;
    }

    public void setCenaAranzmana(double cenaAranzmana) {
        this.cenaAranzmana = cenaAranzmana;
    }

    public String getOpisAranzmana() {
        return opisAranzmana;
    }

    public void setOpisAranzmana(String opisAranzmana) {
        this.opisAranzmana = opisAranzmana;
    }

    @Override
    public String toString() {
        return "Aranzman{" + "idAranzman=" + idAranzman + ", nazivAranzmana=" + nazivAranzmana + ", cenaAranzmana=" + cenaAranzmana + ", opisAranzmana=" + opisAranzmana + '}';
    }
    
}
