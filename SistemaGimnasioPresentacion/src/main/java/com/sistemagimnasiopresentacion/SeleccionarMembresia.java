/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sistemagimnasiopresentacion;

import com.sistemagimnasiopresentacion.ServiciosExtras;
import com.subsistemacompramembresia.IManejadorComprasMembresias;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import implementaciones.ManejadorComprasMembresias;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class SeleccionarMembresia extends javax.swing.JFrame {

    private final IManejadorComprasMembresias subsistema;

    /**
     * Creates new form SeleccionarMembresia
     */
    public SeleccionarMembresia(IManejadorComprasMembresias subsistema) {
        this.subsistema = subsistema;
        initComponents();
    }

    public SeleccionarMembresia() {
        this.subsistema = new ManejadorComprasMembresias();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        MEMB1 = new javax.swing.JButton();
        MEMB4on2 = new javax.swing.JButton();
        MEMB5 = new javax.swing.JButton();
        MEMB3 = new javax.swing.JButton();
        MEMB6 = new javax.swing.JButton();
        MEMB2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("TIPOS DE MEMBRESIAS ");
        jScrollPane1.setViewportView(jTextArea1);

        MEMB1.setText("DAY PASS. COSTO $15.");
        MEMB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MEMB1ActionPerformed(evt);
            }
        });

        MEMB4on2.setText("15 DIAS.COSTO $225. INCLUYE ENTRENADOR");
        MEMB4on2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MEMB4ActionPerformed(evt);
            }
        });

        MEMB5.setText("MENSUAL.COSTO $300");
        MEMB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MEMB5ActionPerformed(evt);
            }
        });

        MEMB3.setText("10 DIAS. COSTO $150. INCLUYE ENTRENADOR");
        MEMB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MEMB3ActionPerformed(evt);
            }
        });

        MEMB6.setText("POR VISITA. COSTO $13");
        MEMB6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MEMB6ActionPerformed(evt);
            }
        });

        MEMB2.setText("7 DIAS. COSTO $105. INCLUYE ENTRENADOR");
        MEMB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memb2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MEMB4on2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MEMB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MEMB5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MEMB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MEMB6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MEMB3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(MEMB3, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(MEMB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MEMB2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MEMB6, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(MEMB5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MEMB4on2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MEMB6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MEMB6ActionPerformed
        TipoMembresiaDTO tipoMembresia = subsistema.getTiposMembresia().get(6);
        List<ServicioExtraDTO> serviciosExtras = tipoMembresia.getServiciosExtras();

        if (serviciosExtras == null) {
            serviciosExtras = new ArrayList<>();
        }

        ServiciosExtras se = new ServiciosExtras(serviciosExtras);
        se.setVisible(true);

    }//GEN-LAST:event_MEMB6ActionPerformed

    private void MEMB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MEMB5ActionPerformed
        TipoMembresiaDTO tipoMembresia = subsistema.getTiposMembresia().get(5);
        List<ServicioExtraDTO> serviciosExtras = tipoMembresia.getServiciosExtras();

        if (serviciosExtras == null) {
            serviciosExtras = new ArrayList<>();
        }

        ServiciosExtras se = new ServiciosExtras(serviciosExtras);
        se.setVisible(true);

    }//GEN-LAST:event_MEMB5ActionPerformed

    private void MEMB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MEMB4ActionPerformed
        TipoMembresiaDTO tipoMembresia = subsistema.getTiposMembresia().get(4);
        List<ServicioExtraDTO> serviciosExtras = tipoMembresia.getServiciosExtras();

        if (serviciosExtras == null) {
            serviciosExtras = new ArrayList<>();
        }

        ServiciosExtras se = new ServiciosExtras(serviciosExtras);
        se.setVisible(true);

    }//GEN-LAST:event_MEMB4ActionPerformed

    private void MEMB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MEMB3ActionPerformed
        TipoMembresiaDTO tipoMembresia = subsistema.getTiposMembresia().get(3);
        List<ServicioExtraDTO> serviciosExtras = tipoMembresia.getServiciosExtras();

        if (serviciosExtras == null) {
            serviciosExtras = new ArrayList<>();
        }

        ServiciosExtras se = new ServiciosExtras(serviciosExtras);
        se.setVisible(true);

    }//GEN-LAST:event_MEMB3ActionPerformed

    private void memb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memb2ActionPerformed
        TipoMembresiaDTO tipoMembresia = subsistema.getTiposMembresia().get(2);
        List<ServicioExtraDTO> serviciosExtras = tipoMembresia.getServiciosExtras();

        if (serviciosExtras == null) {
            serviciosExtras = new ArrayList<>();
        }

        ServiciosExtras se = new ServiciosExtras(serviciosExtras);
        se.setVisible(true);

    }//GEN-LAST:event_memb2ActionPerformed

    private void MEMB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MEMB1ActionPerformed
        TipoMembresiaDTO tipoMembresia = subsistema.getTiposMembresia().get(1);
        List<ServicioExtraDTO> serviciosExtras = tipoMembresia.getServiciosExtras();

        if (serviciosExtras == null) {
            serviciosExtras = new ArrayList<>();
        }

        ServiciosExtras se = new ServiciosExtras(serviciosExtras);
        se.setVisible(true);
    }//GEN-LAST:event_MEMB1ActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionarMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionarMembresia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MEMB1;
    private javax.swing.JButton MEMB2;
    private javax.swing.JButton MEMB3;
    private javax.swing.JButton MEMB4on2;
    private javax.swing.JButton MEMB5;
    private javax.swing.JButton MEMB6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
