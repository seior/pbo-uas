/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.uas.modules.transaksi;

import com.uas.model.StatusPemesanan;
import com.uas.model.TransaksiToko;
import com.uas.repository.StatusPemesananRepository;
import com.uas.repository.TransaksiRepository;
import com.uas.repository.impl.StatusPemesananRepositoryImpl;
import com.uas.repository.impl.TransaksiRepositoryimpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Objects;

/**
 * @author seior
 */
public class LihatTransaksiToko extends javax.swing.JFrame {

    private String username;
    private final TransaksiRepository transaksiRepository;
    private final StatusPemesananRepository statusPemesananRepository;
    private DefaultTableModel tableModel;


    /**
     * Creates new form LihatTransaksiToko
     */
    public LihatTransaksiToko(String username) {
        this.username = username;
        this.transaksiRepository = new TransaksiRepositoryimpl();
        this.statusPemesananRepository = new StatusPemesananRepositoryImpl();

        initComponents();
        showTables();
        showDataTables();
    }

    public void showTables() {
        Object[] tableNames = {
                "id",
                "id laptop",
                "pembayaran",
                "total bayar",
                "jasa pengiriman",
                "alamat",
                "pembeli"
        };

        tableModel = new DefaultTableModel(null, tableNames);

        orderTable.setModel(tableModel);
    }

    public void showDataTables() {
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        List<TransaksiToko> result = transaksiRepository.findAllTransaksiToko(username);

        result.forEach(transaksiToko -> {
            Object[] data = {
                    transaksiToko.getId(),
                    transaksiToko.getIdLaptop(),
                    transaksiToko.getPembayaran(),
                    transaksiToko.getTotalBayar(),
                    transaksiToko.getJasaPengiriman(),
                    transaksiToko.getAlamat(),
                    transaksiToko.getPembeli()
            };

            tableModel.addRow(data);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        pemesananBTN = new javax.swing.JButton();
        kembaliBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("List Order"));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(orderTable);

        pemesananBTN.setText("Proses Pemesanan");
        pemesananBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemesananBTNActionPerformed(evt);
            }
        });

        kembaliBTN.setText("Kembali");
        kembaliBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pemesananBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kembaliBTN)
                                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pemesananBTN)
                                        .addComponent(kembaliBTN))
                                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliBTNActionPerformed
        this.dispose();
    }//GEN-LAST:event_kembaliBTNActionPerformed

    private void pemesananBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemesananBTNActionPerformed
        StatusPemesanan statusPemesanan = new StatusPemesanan();

        statusPemesanan.setIdTransaksi(orderTable.getValueAt(orderTable.getSelectedRow(), 0).toString());
        statusPemesanan.setStatusPemesanan("Diproses");

        statusPemesananRepository.update(statusPemesanan);

        JOptionPane.showMessageDialog(null, "Pesanan Berhasil Diproses");
    }//GEN-LAST:event_pemesananBTNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembaliBTN;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton pemesananBTN;
    // End of variables declaration//GEN-END:variables
}
