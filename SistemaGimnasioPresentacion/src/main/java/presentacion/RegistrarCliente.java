/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dtos.ClienteRegistradoDTO;
import dtos.ClienteDTO;
import implementaciones.ManejadorComprasMembresias;

/**
 *
 * @author 52644
 */
public class RegistrarCliente extends javax.swing.JFrame {

    private final ControlNavegacionCompraMembresia control;

    /**
     * Creates new form RegistrarUsuario
     */
    public RegistrarCliente(ControlNavegacionCompraMembresia control) {
        this.control = control;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public RegistrarCliente() {
        this(new ControlNavegacionCompraMembresia(new ManejadorComprasMembresias()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EtiquetaSuperior = new javax.swing.JLabel();
        jOptionPane1 = new javax.swing.JOptionPane();
        campoNombres3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        campoNumeroTelefono = new javax.swing.JTextField();
        campoNombres = new javax.swing.JTextField();
        campoApellidos = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        etiquetaPantalla = new javax.swing.JLabel();
        etiquetaEmail = new javax.swing.JLabel();
        etiquetaNombres = new javax.swing.JLabel();
        etiquetaApellidos = new javax.swing.JLabel();
        etiquetaCelular = new javax.swing.JLabel();

        EtiquetaSuperior.setText("jLabel1");

        campoNombres3.setText("Nombre(s)");
        campoNombres3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombres3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        campoNumeroTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumeroTelefonoActionPerformed(evt);
            }
        });

        campoNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombresActionPerformed(evt);
            }
        });

        campoApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoApellidosActionPerformed(evt);
            }
        });

        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        etiquetaPantalla.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        etiquetaPantalla.setText("Registrar Cliente");

        etiquetaEmail.setText("Correo Electrónico");

        etiquetaNombres.setText("Nombre(s)");

        etiquetaApellidos.setText("Apellido(s)");

        etiquetaCelular.setText("Número de Teléfono");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoNombres, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoApellidos)
                            .addComponent(campoNumeroTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(campoEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(111, 111, 111))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaPantalla)
                            .addComponent(etiquetaNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(etiquetaApellidos))
                            .addComponent(etiquetaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(etiquetaPantalla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaNombres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaApellidos)
                .addGap(2, 2, 2)
                .addComponent(campoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaEmail)
                .addGap(8, 8, 8)
                .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombres3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombres3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombres3ActionPerformed

    private void campoNumeroTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumeroTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumeroTelefonoActionPerformed

    private void campoNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombresActionPerformed

    private void campoApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoApellidosActionPerformed

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed
    /**
     * Registra un cliente con base a los parámetros recogidos desde los campos
     * de texto.
     *
     * @param evt
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        String nombres = campoNombres.getText();
        String apellidos = campoApellidos.getText();
        String email = campoEmail.getText();
        String numeroTelefono = campoNumeroTelefono.getText();

        ClienteDTO registrarClienteDTO = new ClienteDTO(nombres, apellidos,
                email, numeroTelefono);
        ClienteRegistradoDTO cliente = control.registrarCliente(registrarClienteDTO);
        if(!(cliente==null)){
            
        campoNombres.setText(null);
        campoApellidos.setText(null);
        campoEmail.setText(null);
        campoNumeroTelefono.setText(null);

        //Aqui se debe llamar a ControlNavegacionCompraMembresia y pasar como parametro 
        //ClienteRegistradoDTO y Subsistema
        //ControlNavegacionCompraMembresia control= new ControlNavegacionCompraMembresia();
        control.openFormSeleccionarMembresia(cliente);
        dispose();
        }

    }//GEN-LAST:event_btnAceptarActionPerformed
    /**
     * Cancela el llenado del formulario del registro de usuario y vuelve a la
     * pantalla anterior
     *
     * @param evt
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        control.openFormBuscarCliente();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EtiquetaSuperior;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombres;
    private javax.swing.JTextField campoNombres3;
    private javax.swing.JTextField campoNumeroTelefono;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaCelular;
    private javax.swing.JLabel etiquetaEmail;
    private javax.swing.JLabel etiquetaNombres;
    private javax.swing.JLabel etiquetaPantalla;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
