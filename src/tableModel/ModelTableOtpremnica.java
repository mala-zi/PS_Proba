/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Otpremnica;

/**
 *
 * @author Saki
 */
public class ModelTableOtpremnica extends AbstractTableModel{

    private List<Otpremnica> listaOtpremnica;
    private final String[] kolone={"id","datum izdavanja","ukupna cena","cvecar","kupac"};

    public ModelTableOtpremnica(List<Otpremnica> listaOtpremnica) {
        this.listaOtpremnica = listaOtpremnica;
    }
    
    
    @Override
    public int getRowCount() {
        return listaOtpremnica.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Otpremnica otp=listaOtpremnica.get(rowIndex);
        switch(columnIndex){
            case 0:
                return otp.getIdOtpremnica();
            case 1:
                return otp.getDatumIzdavanja();
            case 2:
                return otp.getUkupnaCena();
            case 3:
                return otp.getCvecar();
            case 4:
                return otp.getKupac();
            default:
                return null;
                
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
