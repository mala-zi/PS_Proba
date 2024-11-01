/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Cvecar;
import model.Kupac;
import model.Mesto;
import model.Otpremnica;

/**
 *
 * @author Saki
 */
public class DBBroker {

    public boolean login(String user, String password) {
        try {
            String upit="SELECT korisnickoIme,lozinka FROM cvecar "
                    + "WHERE korisnickoIme=? AND BINARY lozinka=?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
               //String korisnickoIme=rs.getString("korisnickoIme");
               // String lozinka=rs.getString("lozinka");
              //  if(korisnickoIme.equals(user) && lozinka.equals(password)){
                    return true;
               // }
                 
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Otpremnica> ucitajOtpremniceIzBaze() {
        List<Otpremnica> listaOtpremnica=new ArrayList<>();
        try {
            
            
            String upit="SELECT * FROM otpremnica o "
                    + "JOIN cvecar c ON  o.idCvecar=c.id "
                    + "JOIN kupac k ON o.idKupac=k.idKupac "
                    + "JOIN mesto m ON k.idMesto=m.idMesto";
            Statement s = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {
                int idO = rs.getInt("o.idOtpremnica");
                Date datum = rs.getDate("o.datumIzdavanja");
                double ukupno = rs.getDouble("o.ukupnaCena");

                int idC = rs.getInt("c.id");
                String imeC = rs.getString("c.ime");
                String prezimeC = rs.getString("c.prezime");
                String user = rs.getString("c.korisnickoIme");
                String pass = rs.getString("c.lozinka");

                int idK = rs.getInt("k.idKupac");
                int pibK = rs.getInt("k.pibKupac");
                String tel = rs.getString("k.telefon");
                String email = rs.getString("k.email");
                
                int idM=rs.getInt("m.idMesto");
                String grad=rs.getString("m.grad");
                int pB=rs.getInt("m.postanskiBroj");
                String ulica=rs.getString("m.ulica");
                
                Mesto mesto=new Mesto(idM, grad, pB, ulica);
                Kupac kupac=new Kupac(idK, pibK, tel, email, mesto);
                Cvecar cvecar=new Cvecar(idC, imeC, prezimeC, user, pass);
                
                Otpremnica otp=new Otpremnica(idO, datum, ukupno, cvecar, kupac);
                listaOtpremnica.add(otp);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaOtpremnica;
    }

    public List<Cvecar> popuniCvecareIzBaze() {
        List<Cvecar> cvecari=new ArrayList<>();
        try {
            
            String upit="SELECT * FROM cvecar";
            Statement s=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                int id=rs.getInt("idCvecar");
                String ime=rs.getString("ime");
                String prezime=rs.getString("prezime");
                String korisnickoIme=rs.getString("korisnickoIme");
                String lozinka=rs.getString("lozinka");
                
                Cvecar c=new Cvecar(id, ime, prezime, korisnickoIme, lozinka);
                cvecari.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cvecari;
    }

    public List<Kupac> popuniKupceIzBaze() {
        List<Kupac> kupci=new ArrayList<>();
        try {
            String upit="SELECT * FROM  kupac k JOIN "
                    + "mesto m ON k.idMesto=m.idMesto";
            Statement s=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                int idK=rs.getInt("k.idKupac");
                int pibK=rs.getInt("k.pibKupac");
                String tel=rs.getString("k.telefon");
                String email=rs.getString("k.email");
                
                int idM=rs.getInt("m.idMesto");
                String grad=rs.getString("m.grad");
                int pB=rs.getInt("m.postanskiBroj");
                String ulica=rs.getString("m.ulica");
                
                Mesto mesto=new Mesto(idM, grad, pB, ulica);
                Kupac k=new Kupac(idK, pibK, tel, email, mesto);
                kupci.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kupci;
    }
}
