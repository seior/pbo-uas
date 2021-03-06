/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.uas.modules.belilaptop;

import com.uas.model.LaptopToko;
import com.uas.model.StatusPemesanan;
import com.uas.model.Transaksi;
import com.uas.repository.StatusPemesananRepository;
import com.uas.repository.TransaksiRepository;
import com.uas.repository.impl.StatusPemesananRepositoryImpl;
import com.uas.repository.impl.TransaksiRepositoryimpl;

import javax.swing.*;
import java.util.Objects;

/**
 * @author seior
 */
public class TransaksiBaru extends javax.swing.JFrame {

    LaptopToko laptopToko;
    TransaksiRepository transaksiRepository;
    StatusPemesananRepository statusPemesananRepository;

    /**
     * Creates new form TransaksiBaru
     */
    public TransaksiBaru(LaptopToko laptopToko) {
        this.statusPemesananRepository = new StatusPemesananRepositoryImpl();
        this.transaksiRepository = new TransaksiRepositoryimpl();
        this.laptopToko = laptopToko;

        initComponents();

        this.totalLabel.setText(laptopToko.getHarga());
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
        kurirCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        pembayranCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatTA = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        beliBTN = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        batalBTN = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opsi Pembelian"));

        jLabel1.setText("Pilih jasa pengiriman");

        kurirCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"SiCepat", "JNE", "JNT", "AnterAja"}));

        jLabel2.setText("Metode Pembayaran");

        pembayranCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ovo", "GoPay", "Dana", "Mandiri Virutal", "Visa"}));

        jLabel4.setText("Alamat");

        alamatTA.setColumns(20);
        alamatTA.setRows(5);
        jScrollPane1.setViewportView(alamatTA);

        jLabel5.setText("Total bayar");

        beliBTN.setText("Beli");
        beliBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliBTNActionPerformed(evt);
            }
        });

        totalLabel.setText("kosong");

        batalBTN.setText("Batal");
        batalBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pembayranCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(kurirCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(beliBTN)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(batalBTN)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(kurirCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(pembayranCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(beliBTN)
                                        .addComponent(totalLabel)
                                        .addComponent(batalBTN))
                                .addContainerGap())
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

    private void batalBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBTNActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalBTNActionPerformed

    private void beliBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliBTNActionPerformed
        Transaksi transaksi = new Transaksi();
        transaksi.setIdLaptop(laptopToko.getId());
        transaksi.setUsername(laptopToko.getUsername());

        transaksi.setJasaPengiriman(Objects.requireNonNull(kurirCB.getSelectedItem()).toString());
        transaksi.setAlamat(alamatTA.getText());
        transaksi.setPembayaran(Objects.requireNonNull(pembayranCB.getSelectedItem()).toString());
        transaksi.setTotalBayar(totalLabel.getText());

        Transaksi result = transaksiRepository.buy(transaksi);

        StatusPemesanan statusPemesanan = new StatusPemesanan();

        statusPemesanan.setIdTransaksi(result.getId());
        statusPemesanan.setStatusPembayaran("Pembayaran Berhasil");
        statusPemesanan.setStatusPemesanan("Belum diproses");

        statusPemesananRepository.save(statusPemesanan);

        JOptionPane.showMessageDialog(null, "Pembelian Berhasil");
        this.dispose();
    }//GEN-LAST:event_beliBTNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatTA;
    private javax.swing.JButton batalBTN;
    private javax.swing.JButton beliBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kurirCB;
    private javax.swing.JComboBox<String> pembayranCB;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
