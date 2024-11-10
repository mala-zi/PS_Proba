/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kupac;

/**
 *
 * @author Saki
 */
public class ModelTableKupac  extends AbstractTableModel{
    private List<Kupac> listaKupaca;
    private String[] kolone={"ID","Naziv","PIB","Telefon","Email","Mesto"};

    public ModelTableKupac(List<Kupac> listaKupaca) {
        this.listaKupaca = listaKupaca;
    }

    
    @Override
    public int getRowCount() {
        return listaKupaca.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac k=listaKupaca.get(rowIndex);
        switch(columnIndex){
            case 0:
                return k.getIdKupac();
            case 1:
                return k.getNaziv();
            case 2:
                return k.getPibKupac();
            case 3:
                return k.getTelefon();
            case 4:
                return k.getEmail();
            case 5:
                return k.getMesto().getGrad();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
}
