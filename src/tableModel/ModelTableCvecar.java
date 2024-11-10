/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cvecar;

/**
 *
 * @author Saki
 */
public class ModelTableCvecar extends AbstractTableModel {
    private List<Cvecar> listaCvecara;
    private String[] kolone={"Ime","Prezime","Korisnicko ime"};

    public ModelTableCvecar(List<Cvecar> listaCvecara) {
        this.listaCvecara = listaCvecara;
    }

    @Override
    public int getRowCount() {
        return listaCvecara.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cvecar c=listaCvecara.get(rowIndex);
        switch(columnIndex){
            case 0:
                return c.getIme();
            case 1:
                return c.getPrezime();
            case 2:
                return c.getKorisnickoIme();
            default:
                return null;
                        
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
}
