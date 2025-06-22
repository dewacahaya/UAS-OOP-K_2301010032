/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pos_coffeeshop;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public class frameMain extends javax.swing.JFrame {
   
    private String mode = "awal";

    public frameMain() {
        initComponents();
        aturMode("awal");
        
        cbKategori.removeAllItems();
        cbKategori.addItem("Kopi");
        cbKategori.addItem("Makanan");
        cbKategori.addItem("NonKopi");
        
        this.tampilDataProduk();
        
        fieldInputEnabled(false);
    }
    
    private void aturMode(String kondisi) {
        mode = kondisi;

        switch(kondisi) {
            case "awal":
                fieldInputEnabled(false);
                resetForm();

                btnTambah.setText("Tambah");
                btnTutup.setText("Tutup");
                btnEdit.setText("Edit");

                btnTambah.setEnabled(true);
                btnEdit.setEnabled(false);
                btnHapus.setEnabled(false);
                btnTutup.setEnabled(true);
                break;

            case "tambah":
                fieldInputEnabled(true);
                resetForm();

                btnTambah.setText("Simpan");
                btnTutup.setText("Batal");

                btnTambah.setEnabled(true);
                btnEdit.setEnabled(false);
                btnHapus.setEnabled(false);
                btnTutup.setEnabled(true);
                break;

            case "pilih":
                fieldInputEnabled(false);

                btnTambah.setEnabled(false);
                btnEdit.setEnabled(true);
                btnHapus.setEnabled(true);
                btnTutup.setText("Batal");
                break;

            case "edit":
                fieldInputEnabled(true);

                btnEdit.setText("Simpan");
                btnTutup.setText("Batal");

                btnEdit.setEnabled(true);
                btnTambah.setEnabled(false);
                btnHapus.setEnabled(false);
                btnTutup.setEnabled(true);
                break;
        }
    }
    
    private int idProdukTerpilih = -1;
    
    private void fieldInputEnabled(boolean status) {
        txtNamaProduk.setEditable(status);
        txtHarga.setEditable(status);
        cbKategori.setEnabled(status);
    }
    
     private void resetForm() {
        txtNamaProduk.setText("");
        txtHarga.setText("");
        cbKategori.setSelectedIndex(0);
    }
     
    private void storeData() throws SQLException{
        String nama = txtNamaProduk.getText();
        String hargaText = txtHarga.getText();
        String tipe = cbKategori.getSelectedItem().toString();

        double harga = Double.parseDouble(hargaText);

        Connection conn = Koneksi.getConnection();
        PreparedStatement PS = conn.prepareStatement(
            "INSERT INTO produk(nama_produk, harga, tipe) VALUES (?, ?, ?);");
        PS.setString(1, nama);
        PS.setDouble(2, harga);
        PS.setString(3, tipe);
        PS.executeUpdate();
    }
    
    private void updateData() throws SQLException {
        String nama = txtNamaProduk.getText();
        String hargaText = txtHarga.getText();
        String tipe = cbKategori.getSelectedItem().toString();

        double harga = Double.parseDouble(hargaText);

        Connection conn = Koneksi.getConnection();
        PreparedStatement PS = conn.prepareStatement("UPDATE produk SET nama_produk=?, harga=?, tipe=? WHERE id_produk=?");
        PS.setString(1, nama);
        PS.setDouble(2, harga);
        PS.setString(3, tipe);
        PS.setInt(4, idProdukTerpilih);
        PS.executeUpdate();
    }
    
    private void destroyData() throws SQLException {
        String nama = txtNamaProduk.getText();
        Connection cnn = Koneksi.getConnection();
        PreparedStatement PS = cnn.prepareStatement("DELETE FROM produk WHERE id_produk=?;");
        PS.setInt(1, idProdukTerpilih);
        PS.executeUpdate();
    }
    
    private void tampilDataProduk(){
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("ID Produk");
        tabel.addColumn("No");
        tabel.addColumn("Nama Produk");
        tabel.addColumn("Harga");
        tabel.addColumn("Kategori");
        
        try {
            int no = 1;
            String sql = "SELECT * FROM produk";
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                tabel.addRow(new Object[]{
                    rs.getInt("id_produk"),
                    no++,
                    rs.getString("nama_produk"),
                    rs.getDouble("harga"),
                    rs.getString("tipe")
                });
            }
            TABEL.setModel(tabel);
            
            TABEL.getColumnModel().getColumn(0).setMinWidth(0);
            TABEL.getColumnModel().getColumn(0).setMaxWidth(0);
            TABEL.getColumnModel().getColumn(0).setWidth(0);
        } catch (Exception e) {
            System.out.println("Gagal mengambil data produk"+ e.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNamaProduk = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        cbKategori = new javax.swing.JComboBox<>();
        menuKasir = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("POS Coffee Shop");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data Produk");

        TABEL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Nama Produk", "Harga", "Kategori"
            }
        ));
        TABEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABELMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABEL);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Produk");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Harga");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kategori");

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKategori.setSelectedItem(TABEL);
        cbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaProduk)
                            .addComponent(txtHarga)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 163, Short.MAX_VALUE))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        menuKasir.setText("Menu Kasir");
        menuKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKasirActionPerformed(evt);
            }
        });

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(83, 83, 83)
                        .addComponent(btnEdit)
                        .addGap(91, 91, 91)
                        .addComponent(btnHapus)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuKasir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTutup)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTutup)
                    .addComponent(menuKasir))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (btnTambah.getText().equals("Tambah")) {
            aturMode("tambah");
        } else {
            try {
                String nama = txtNamaProduk.getText();
                double harga = Double.parseDouble(txtHarga.getText());
                String kategori = cbKategori.getSelectedItem().toString();

                Connection conn = Koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO produk(nama_produk, harga, tipe) VALUES (?, ?, ?)"
                );
                ps.setString(1, nama);
                ps.setDouble(2, harga);
                ps.setString(3, kategori);
                ps.executeUpdate();

                // Refresh tabel
                tampilDataProduk();
                JOptionPane.showMessageDialog(this, "Produk berhasil ditambahkan!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan produk: " + e.getMessage());
            }

            aturMode("awal");
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (idProdukTerpilih == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit terlebih dahulu.");
            return;
        }
        
        if (btnEdit.getText().equals("Edit")) {
            aturMode("edit");
        } else {
            try {
                String nama = txtNamaProduk.getText();
                double harga = Double.parseDouble(txtHarga.getText());
                String kategori = cbKategori.getSelectedItem().toString();

                Connection conn = Koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                    "UPDATE produk SET nama_produk=?, harga=?, tipe=? WHERE id_produk=?"
                );
                ps.setString(1, nama);
                ps.setDouble(2, harga);
                ps.setString(3, kategori);
                ps.setInt(4, idProdukTerpilih);
                
                ps.executeUpdate();

                tampilDataProduk();
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal mengupdate data: " + e.getMessage());
            }
            aturMode("awal");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void TABELMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELMouseClicked
        int baris = TABEL.getSelectedRow();
        if (baris >= 0) {
            idProdukTerpilih = Integer.parseInt(TABEL.getValueAt(baris, 0).toString());
            txtNamaProduk.setText(TABEL.getValueAt(baris, 2).toString());
            txtHarga.setText(TABEL.getValueAt(baris, 3).toString());
            cbKategori.setSelectedItem(TABEL.getValueAt(baris, 4).toString());

            aturMode("pilih");
        }
    }//GEN-LAST:event_TABELMouseClicked

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        if (btnTutup.getText().equals("Tutup")) {
            int pilihan = JOptionPane.showConfirmDialog(this, "Tutup aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else {
            aturMode("awal");
            
        }
    }//GEN-LAST:event_btnTutupActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (idProdukTerpilih == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus.");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this,
            "Yakin ingin menghapus produk ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION
        );

        if (konfirmasi == JOptionPane.YES_OPTION) {
            try {
                Connection conn = Koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM produk WHERE id_produk=?"
                );
                ps.setInt(1, idProdukTerpilih);
                ps.executeUpdate();

                tampilDataProduk();
                JOptionPane.showMessageDialog(this, "Produk berhasil dihapus!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus produk: " + e.getMessage());
            }

            aturMode("awal");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKategoriActionPerformed

    private void menuKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKasirActionPerformed
        this.setVisible(false);
        new frameKasir().setVisible(true);
    }//GEN-LAST:event_menuKasirActionPerformed

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
            java.util.logging.Logger.getLogger(frameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABEL;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menuKasir;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNamaProduk;
    // End of variables declaration//GEN-END:variables
}
