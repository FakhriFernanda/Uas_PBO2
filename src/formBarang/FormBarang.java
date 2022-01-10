
package formBarang;

import db.Koneksi;
import Model.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class FormBarang extends javax.swing.JFrame {
    Barang barang;
    int status;
    
    private final int SEDANG_TAMBAH = 101;
        
    public FormBarang() {
        initComponents();
        setLocationRelativeTo(null);
        resetTable("");
    }

    public ArrayList<Barang> getBarangList(String keyword){
    ArrayList<Barang> penerbitList = new ArrayList<Barang>();
    Koneksi Koneksi = new Koneksi();
    Connection connetion = Koneksi.getConnection();
    
    String query = "SELECT * FROM tb_barang "+keyword;
    Statement statement;
    ResultSet resultSet;
    
    try {
        statement = connetion.createStatement();
        resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            barang = new Barang(resultSet.getString("kode_barang"),
                    resultSet.getString("nama_barang"),
                    resultSet.getInt("jumlah_barang"),
                    resultSet.getInt("harga_sewa"));
            penerbitList.add(barang);
        }
    } catch (SQLException | NullPointerException ex){
        System.err.println("Koneksi Null Gagal");
    }
    return penerbitList;
} 
    
    public final void selectBarang(String keyword){
    ArrayList<Barang> list = getBarangList(keyword);
    DefaultTableModel model = (DefaultTableModel)tBarang.getModel();
    Object[] row = new Object[2];
    
    for (int i = 0; i < list.size(); i++){
        row[0] = list.get(i).getKode_barang();
        row[1] = list.get(i).getNama_barang();
        row[2] = list.get(i).getJumlah_barang();
        row[3] = list.get(i).getHarga_sewa();
        model.addRow(row);
    }
}
    
        public final void resetTable(String keyword){
        DefaultTableModel model = (DefaultTableModel)tBarang.getModel();
        model.setRowCount(0);
        selectBarang(keyword);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textKodeBarang = new javax.swing.JTextField();
        textNamaBarang = new javax.swing.JTextField();
        textJumlahBarang = new javax.swing.JTextField();
        textHargaSewa = new javax.swing.JTextField();
        tSimpan = new javax.swing.JButton();
        tEdit = new javax.swing.JButton();
        tHapus = new javax.swing.JButton();
        tClear = new javax.swing.JButton();
        tKeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Input Barang");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel2.setText("Kode Barang");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel3.setText("Nama Barang");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setText("Jumlah Barang");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel5.setText("Harga Sewa");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        textKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKodeBarangActionPerformed(evt);
            }
        });
        getContentPane().add(textKodeBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 220, -1));
        getContentPane().add(textNamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 220, -1));
        getContentPane().add(textJumlahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 220, -1));
        getContentPane().add(textHargaSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 220, -1));

        tSimpan.setText("Simpan");
        tSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(tSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        tEdit.setText("Edit");
        tEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tEditActionPerformed(evt);
            }
        });
        getContentPane().add(tEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        tHapus.setText("Hapus");
        tHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tHapusActionPerformed(evt);
            }
        });
        getContentPane().add(tHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        tClear.setText("Clear");
        tClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tClearActionPerformed(evt);
            }
        });
        getContentPane().add(tClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        tKeluar.setText("Keluar");
        tKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKeluarActionPerformed(evt);
            }
        });
        getContentPane().add(tKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        tBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jumlah Barang", "Harga Sewa"
            }
        ));
        jScrollPane2.setViewportView(tBarang);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 340, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSimpanActionPerformed
       Barang barang =new Barang ();
       barang.setKode_barang(textKodeBarang.getText());
       barang.setNama_barang(textNamaBarang.getText());
       barang.setJumlah_barang(textJumlahBarang.getColumns());
       barang.setHarga_sewa(textHargaSewa.getColumns());

       
       if (barang.getKode_barang().equalsIgnoreCase("")||
           barang.getNama_barang().equalsIgnoreCase("")||   
           barang.getJumlah_barang().equals("")||
           barang.getHarga_sewa().equals("")){
               JOptionPane.showMessageDialog(null,"Lengkapi Data !!");
               
       }else{
           
           Koneksi Koneksi = new Koneksi();
           Connection con = Koneksi.getConnection();
           PreparedStatement ps;
                try {
                    if (status==SEDANG_TAMBAH) {
                        String executeQuery ="insert into tb_barang values (?,?,?,?)";
                        ps = con.prepareStatement(executeQuery);
                        ps.setString(1, barang.getKode_barang());
                        ps.setString(2, barang.getNama_barang());
                        ps.setInt(3, barang.getJumlah_barang());
                        ps.setInt(4, barang.getHarga_sewa());
                        ps.executeUpdate();
                    } else {
                        String executeQuery = "update tb_barang set nama_barang=?, jumlah_barang=?,"
                                +"harga_sewa=? WHERE kode_barang=?";
                        ps = con.prepareStatement(executeQuery);
                        ps.setString(1, barang.getKode_barang());
                        ps.setString(2, barang.getNama_barang());
                        ps.setInt(3, barang.getJumlah_barang());
                        ps.setInt(4, barang.getHarga_sewa());
                        ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println("Error Insert/Update : "+ex);
        }
        dispose();
       }// TODO add your handling code here:
    }//GEN-LAST:event_tSimpanActionPerformed

    private void textKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKodeBarangActionPerformed

    private void tKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKeluarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_tKeluarActionPerformed

    private void tHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHapusActionPerformed
        int i = tBarang.getSelectedRow();
            int pilihan = JOptionPane.showConfirmDialog(null,
                    "Yakin mau hapus ?",
                    "Konfirmasi hapus",
                    JOptionPane.YES_NO_OPTION);
            if(pilihan==0){
                if(i>=0){
                    try {
                        TableModel model = tBarang.getModel();
                        Koneksi Koneksi = new Koneksi();
                        Connection con = Koneksi.getConnection();
                        String executeQuery = "delete from tb_barang where kode_barang=?";
                        PreparedStatement ps = con.prepareStatement(executeQuery);
                        ps.setString(1, model.getValueAt(i, 0).toString());
                        ps.executeUpdate();
                    }catch (SQLException ex){
                        System.err.println(ex);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus");
                }
            } resetTable("");// TODO add your handling code here:
    }//GEN-LAST:event_tHapusActionPerformed

    private void tEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tEditActionPerformed
        int i = tBarang.getSelectedRow();
        if(i>=0){
            TableModel model = tBarang.getModel();
            barang= new Barang();
            barang.setKode_barang(model.getValueAt(i, 0).toString());
            barang.setNama_barang(model.getValueAt(i, 1).toString());
            barang.setJumlah_barang((Integer) model.getValueAt(i, 2));
            barang.setHarga_sewa((Integer) model.getValueAt(i, 3));

            
        }else{
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin diubah");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tEditActionPerformed

    private void tClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tClearActionPerformed
        resetTable("");// TODO add your handling code here:
    }//GEN-LAST:event_tClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tBarang;
    private javax.swing.JButton tClear;
    private javax.swing.JButton tEdit;
    private javax.swing.JButton tHapus;
    private javax.swing.JButton tKeluar;
    private javax.swing.JButton tSimpan;
    private javax.swing.JTextField textHargaSewa;
    private javax.swing.JTextField textJumlahBarang;
    private javax.swing.JTextField textKodeBarang;
    private javax.swing.JTextField textNamaBarang;
    // End of variables declaration//GEN-END:variables
}
