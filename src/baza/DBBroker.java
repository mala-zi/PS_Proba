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
            String upit = "SELECT korisnickoIme,lozinka FROM cvecar "
                    + "WHERE korisnickoIme=? AND BINARY lozinka=?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                return true;

            } else {
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
                String naziv=rs.getString("k.naziv");
                
                int idM=rs.getInt("m.idMesto");
                String grad=rs.getString("m.grad");
                int pB=rs.getInt("m.postanskiBroj");
                String ulica=rs.getString("m.ulica");
                
                Mesto mesto=new Mesto(idM, grad, pB, ulica);
                Kupac kupac=new Kupac(idK, pibK, tel, email, mesto,naziv);
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
                int id=rs.getInt("id");
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
                String naziv=rs.getString("k.naziv");
                
                int idM=rs.getInt("m.idMesto");
                String grad=rs.getString("m.grad");
                int pB=rs.getInt("m.postanskiBroj");
                String ulica=rs.getString("m.ulica");
                
                Mesto mesto=new Mesto(idM, grad, pB, ulica);
                Kupac k=new Kupac(idK, pibK, tel, email, mesto,naziv);
                kupci.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kupci;
    }

    public void dodajOtpremnicu(Otpremnica otp) {
        try {
            String upit="INSERT INTO otpremnica (idOtpremnica,datumIzdavanja,ukupnaCena,idCvecar,idKupac)"
                    + " VALUES (?,?,?,?,?) ";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            java.sql.Date sqlDate=new java.sql.Date(otp.getDatumIzdavanja().getTime());
            ps.setInt(1,otp.getIdOtpremnica());
            ps.setDate(2,  sqlDate);
            ps.setDouble(3, otp.getUkupnaCena());
            ps.setInt(4,otp.getCvecar().getIdCvecar());
            ps.setInt(5,otp.getKupac().getIdKupac());
            ps.executeUpdate(); 
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    public void promeniOtpremnicu(Otpremnica otp) {

        try {
            String upit="UPDATE otpremnica SET datumIzdavanja=? "
                    + ", ukupnaCena=? , idCvecar=?, idKupac=? WHERE idOtpremnica=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            java.sql.Date sqlDate= new java.sql.Date(otp.getDatumIzdavanja().getTime());
            ps.setDate(1,sqlDate);
            ps.setDouble(2,otp.getUkupnaCena());
            ps.setInt(3,otp.getCvecar().getIdCvecar());
            ps.setInt(4,otp.getKupac().getIdKupac());
            ps.setInt(5, otp.getIdOtpremnica());
            System.out.println(upit);
            System.out.println(otp);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Kupac> ucitajKupceIzBaze() {
        List<Kupac> kupci=new ArrayList<>();
        try {
            String upit="SELECT * FROM kupac k JOIN mesto m ON k.idMesto=m.idMesto";
            Statement s=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                int id=rs.getInt("k.idKupac");
                String naziv=rs.getString("k.naziv");
                int pib=rs.getInt("k.pibKupac");
                String email=rs.getString("k.email");
                String tel=rs.getString("k.telefon");
                
                int idMesto=rs.getInt("m.idMesto");
                String grad=rs.getString("m.grad");
                int pBroj=rs.getInt("m.postanskiBroj");
                String ulica=rs.getString("m.ulica");
                
                Mesto mesto=new Mesto(idMesto, grad, pBroj, ulica);
                Kupac kupac=new Kupac(id, pib, tel, email, mesto, naziv);
                
                kupci.add(kupac);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kupci;
    }

    public List<Mesto> ucitajMestaIzBaze() {
        List<Mesto> mesta=new ArrayList<>();
        try {
            String upit="SELECT * FROM mesto";
            Statement s=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                
                
                int idMesto=rs.getInt("idMesto");
                String grad=rs.getString("grad");
                int pBroj=rs.getInt("postanskiBroj");
                String ulica=rs.getString("ulica");
                
                Mesto mesto=new Mesto(idMesto, grad, pBroj, ulica);
                
                mesta.add(mesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesta;
    }

    public void dodajKupca(Kupac k) {
        try {
            String upit="INSERT INTO kupac (idKupac,pibKupac,telefon,email,idMesto,naziv) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, k.getIdKupac());
            ps.setInt(2,k.getPibKupac());
            ps.setString(3,k.getTelefon());
            ps.setString(4, k.getEmail());
            ps.setInt(5, k.getMesto().getIdMesto());
            ps.setString(6, k.getNaziv());
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void izmeniKupca(Kupac k) {
        try {
            String upit = "UPDATE kupac SET naziv=?,email=?,pibKupac=?,telefon=?,idMesto=? WHERE idKupac=" + k.getIdKupac();
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, k.getNaziv());
            ps.setString(2, k.getEmail());
            ps.setInt(3, k.getPibKupac());
            ps.setString(4, k.getTelefon());

            ps.setObject(5, k.getMesto().getIdMesto());
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obrisiKupca(Kupac kupac) {
        try {
            String upit="DELETE FROM kupac WHERE idKupac="+kupac.getIdKupac();
            Statement s=Konekcija.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    public List<Cvecar> ucitajCvecareIzBaze() {
        List<Cvecar> cvecari=new ArrayList<>();
        try {
            String upit="SELECT * FROM cvecar";
            Statement s=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                int id=rs.getInt("id");
                String ime=rs.getString("ime");
                String prezime=rs.getString("prezime");
                String kor=rs.getString("korisnickoIme");
                String lozinka=rs.getString("lozinka");
                
                Cvecar c=new Cvecar(id, ime, prezime, kor, lozinka);
                
              cvecari.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cvecari;
    }

    public void obrisiCvecara(Cvecar c) {
        try {
            String upit="DELETE FROM cvecar WHERE id="+c.getIdCvecar();
            Statement s=Konekcija.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dodajCvecara(Cvecar c) {
        try {
            String upit="INSERT INTO cvecar (ime,prezime,korisnickoIme,lozinka) VALUES(?,?,?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1,c.getIme());
            ps.setString(2,c.getPrezime());
            ps.setString(3, c.getKorisnickoIme());
            ps.setString(4, c.getLozinka());
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void promeniCvecara(Cvecar c) {
        try {
            String upit = "UPDATE cvecar SET ime=?,prezime=?, korisnickoIme=?,lozinka=? WHERE id=" +c.getIdCvecar();
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, c.getIme());
            ps.setString(2, c.getPrezime());
            ps.setString(3, c.getKorisnickoIme());
            ps.setString(4, c.getLozinka());

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
