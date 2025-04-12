/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dtos.ClienteRegConMembDTO;
import dtos.ClienteRegistradoDTO;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class OpcionesMemb extends javax.swing.JFrame {
    private ControlNavegacionCompraMembresia control;
    private ClienteRegistradoDTO cliente;


    /**
     * Creates new form OpcionesMemb
     */
    public OpcionesMemb(ControlNavegacionCompraMembresia control, ClienteRegistradoDTO cliente) {
        initComponents();
        this.control= control;
        this.cliente= cliente;
        cargarMembresias();
        
    }
    
    public void cargarMembresias(){
        System.out.println("cargando");
       // JPanel panelMembresias = new JPanel();
       panelMemb.removeAll();
        panelMemb.setPreferredSize(new Dimension(500,500));
        panelMemb.setLayout(new GridLayout(0,1));
        List<TipoMembresiaDTO> listaMembresias= control.obtenerListaMembresiasDTO();
        if(listaMembresias==null || listaMembresias.isEmpty()){
            System.out.println("error no hay memb");
            return;
        }else{
            System.out.println(listaMembresias.size());
    
            
        for(TipoMembresiaDTO membresia: listaMembresias){
            String nombresServicios = membresia.getServiciosExtras().stream()
                    .map(ServicioExtraDTO::getNombreServicio)
                    .collect(Collectors.joining(", "));
            String texto= (membresia.getTipoMembresia()+"\n precio $" +membresia.getPrecio());
            if(!nombresServicios.isEmpty()){
                texto+= "\nServicios: " + nombresServicios;
            }
            JButton boton= new JButton(texto);
            boton.setPreferredSize(new Dimension(500, 100));
            
            boton.addActionListener(e-> seleccionarMembresia(membresia));
            panelMemb.add(boton);
            
            
        }
        
        
        }
       // getContentPane().removeAll();
        //getContentPane().setLayout(new BorderLayout());
        
        //JScrollPane scroll = new JScrollPane(panelMemb);
        //scroll.setPreferredSize(new Dimension(200, 300));
        
//        
//        JScrollPane scrollPane = new JScrollPane(panelMemb);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setPreferredSize(new Dimension(400, 500));
//        panelMemb.revalidate();
//        panelMemb.repaint();
    }
        
        private void seleccionarMembresia(TipoMembresiaDTO membresia){
            System.out.println("llega");
          ClienteRegConMembDTO clienteConMemb= new ClienteRegConMembDTO(
             membresia.getTipoMembresia(),
             membresia.getPrecio(),
             membresia.getServiciosExtras(),
             cliente.getId()
          );
            System.out.println(clienteConMemb);
          control.openFormServiciosExtra(clienteConMemb);
          dispose();
                  
          

}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelMemb = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Devanagari MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("SELECCION DE MEMBRESIA");

        panelMemb.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMembLayout = new javax.swing.GroupLayout(panelMemb);
        panelMemb.setLayout(panelMembLayout);
        panelMembLayout.setHorizontalGroup(
            panelMembLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );
        panelMembLayout.setVerticalGroup(
            panelMembLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panelMemb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMemb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(OpcionesMemb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcionesMemb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcionesMemb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcionesMemb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ControlNavegacionCompraMembresia control = new ControlNavegacionCompraMembresia(null);
                ClienteRegistradoDTO cliente= new ClienteRegistradoDTO();
                new OpcionesMemb(control, cliente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelMemb;
    // End of variables declaration//GEN-END:variables
}
