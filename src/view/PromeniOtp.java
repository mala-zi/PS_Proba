/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cvecar;
import model.Kupac;
import model.Otpremnica;

/**
 *
 * @author Saki
 */
public class PromeniOtp extends javax.swing.JDialog {

    private Otpremnica novaOtp;
    private PromeniForma pf;
    /**
     * Creates new form PromeniOtp
     */
    public PromeniOtp(java.awt.Dialog parent, boolean modal, Otpremnica otp) {
        super(parent, modal);
        this.pf=(PromeniForma)parent;
        initComponents();
        setTitle("Promeni otpremnicu");
        setResizable(false);
        setLocationRelativeTo(null);
        popuniCvecareIzBaze();
        popuniKupceIzBaze(); 
        popuni(otp);
        novaOtp=otp;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxKupac = new javax.swing.JComboBox<>();
        btnOdustani = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDatumIzdavanja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUkupnaCena = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxCvecar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboBoxKupac.setSelectedItem(comboBoxKupac);

        btnOdustani.setText("odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        btnIzmeni.setText("izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        jLabel1.setText("Datum izdavanja:");

        jLabel2.setText("Ukupna Cena:");

        jLabel3.setText("Cvecar");

        jLabel4.setText("Kupac");

        comboBoxCvecar.setSelectedItem(comboBoxCvecar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDatumIzdavanja)
                            .addComponent(txtUkupnaCena, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxCvecar, 0, 152, Short.MAX_VALUE)
                            .addComponent(comboBoxKupac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIzmeni, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDatumIzdavanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxCvecar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOdustani)
                    .addComponent(btnIzmeni))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        Date datumIzdavanja = new Date();
        double ukupnaCena =0;
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (txtDatumIzdavanja.getText().isEmpty() || txtUkupnaCena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nisu sva polja popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            datumIzdavanja = dateFormat.parse(txtDatumIzdavanja.getText());
            try {
                ukupnaCena = Double.parseDouble(txtUkupnaCena.getText());
                if (ukupnaCena < 0) {
                    JOptionPane.showMessageDialog(this, "Nevalidan unos", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ukupna cena mora biti broj!", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cvecar c = (Cvecar) comboBoxCvecar.getSelectedItem();
            Kupac k = (Kupac) comboBoxKupac.getSelectedItem();
            int idO=novaOtp.getIdOtpremnica();
            Otpremnica otpremnica = new Otpremnica(idO,datumIzdavanja, ukupnaCena, c, k);
            Controller.getInstance().promeniOtpremnicu(otpremnica);

        } catch (ParseException ex) {
            //Logger.getLogger(KreirajOtp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Pogresan format datuma!", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        pf.mto = new ModelTableOtpremnica(Controller.getInstance().ucitajOtpremniceIzBaze());
        JOptionPane.showMessageDialog(this, "Otpremnica je promenjena", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();

    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
     /*    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PromeniOtp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PromeniOtp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PromeniOtp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PromeniOtp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
     /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PromeniOtp dialog = new PromeniOtp(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JComboBox<Cvecar> comboBoxCvecar;
    private javax.swing.JComboBox<Kupac> comboBoxKupac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDatumIzdavanja;
    private javax.swing.JTextField txtUkupnaCena;
    // End of variables declaration//GEN-END:variables

    private void popuni(Otpremnica otp) {
        txtDatumIzdavanja.setText(String.valueOf(otp.getDatumIzdavanja()));
        txtUkupnaCena.setText(String.valueOf(otp.getUkupnaCena()));
        comboBoxCvecar.setSelectedItem(otp.getCvecar());
        comboBoxKupac.setSelectedItem(otp.getKupac());
 }
    
     private void popuniCvecareIzBaze() {
        comboBoxKupac.removeAllItems();
        List<Cvecar> cvecari=Controller.getInstance().popuniCvecareIzBaze();
        for(Cvecar c: cvecari){
            comboBoxCvecar.addItem(c);
        }
    }

    private void popuniKupceIzBaze() {
        comboBoxKupac.removeAllItems();
        List<Kupac> kupci=Controller.getInstance().popuniKupceIzBaze();
        for(Kupac k: kupci){
            comboBoxKupac.addItem(k);
        }
    }
}
