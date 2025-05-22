/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import Enumeradores.EnumEstadoMembresia;
import static Enumeradores.EnumEstadoMembresia.ACTIVA;
import dtos.ClienteRegConMembDTO;
import dtos.ClienteRegistradoDTO;
import dtos.MembresiaDTO;
import dtos.ServicioExtraDTO;
import excepciones.SubsistemaMembresiaException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ConsultarMembresias extends javax.swing.JFrame {
    
    private ControlNavegacionCompraMembresia control;
    private String accionSeleccionada;
    private ClienteRegistradoDTO cliente;
    /**
     * Creates new form ConsultarMembresias
     */
    public ConsultarMembresias(ControlNavegacionCompraMembresia control, String accion,  ClienteRegistradoDTO cliente) {
        initComponents();
        this.control= control;
        this.accionSeleccionada= accion;
        this.cliente= cliente;
        cargarMembresias();
        setLocationRelativeTo(null);
    }
    
    private List<JCheckBox> listaCheckBoxes = new ArrayList<>();
    
    public void cargarMembresias(){
        try{
        List<MembresiaDTO> membresias= control.consultarMembresias();
        switch (accionSeleccionada) {
            case "Activar":
                membresias = control.consultarMembresiasPorEstado(EnumEstadoMembresia.INACTIVA);
                break;
             case "Desactivar":
                 membresias = control.consultarMembresiasPorEstado(EnumEstadoMembresia.ACTIVA);
                 break;
             default:
                 membresias = control.consultarMembresias();
                 break;
                 
             
                 
        }
      //  System.out.println(membresias);
      panelMembresias.removeAll();;
        panelMembresias.setLayout(new GridLayout(0, 1));
        panelMembresias.removeAll();
        listaCheckBoxes.clear();
        
        
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        for (MembresiaDTO membresia: membresias){
            JPanel panel= new JPanel();
            panel.setBackground(new Color(255,204,255));
            panel.setLayout(new GridLayout(4, 1));
            panel.setPreferredSize(new Dimension(250, 150));
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            JCheckBox checkBox = new JCheckBox(membresia.getNombre());
            listaCheckBoxes.add(checkBox);
            JLabel costoLabel = new JLabel("COSTO: $" + membresia.getPrecio());
            
            String servicios= "Servicios: ";
            for(ServicioExtraDTO servicio: membresia.getServiciosExtra()){
               servicios+= servicio.getNombreServicio()+", ";
              
            }
            if(membresia.getServiciosExtra().isEmpty()){
                servicios= "Sin servicios incluidos";
            }
           
            JLabel serviciosLabel= new JLabel(servicios);
            JLabel estadoLabel = new JLabel("Estado: " + membresia.getEstado());
            
            
            panel.add(checkBox);
            panel.add(costoLabel);
            panel.add(serviciosLabel);
            panel.add(estadoLabel);
            panelMembresias.add(panel);
            
        }
        JScrollPane scrollPane = new JScrollPane(panelMembresias);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
       // panelPrincipal.removeAll();
   
       panelPrincipal.setLayout(new BorderLayout());
       panelPrincipal.add(labelTitulo, BorderLayout.NORTH);
       panelPrincipal.add(scrollPane, BorderLayout.CENTER); 
       panelPrincipal.add(botonSiguiente, BorderLayout.SOUTH);

       panelPrincipal.revalidate();
       panelPrincipal.repaint();
    } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error al consultar membresías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }
    
    private List<MembresiaDTO> membresiasSeleccionadas(){
        List<MembresiaDTO> membresiasDisponibles= control.consultarMembresias();
        return listaCheckBoxes.stream()
                .filter(JCheckBox::isSelected)
                .map(check -> membresiasDisponibles.stream()
                        .filter(m -> m.getNombre().equals(check.getText()))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                 .collect(Collectors.toList());
       
           
    }
    private void accion(String accion, String idMembresia, MembresiaDTO membresia) throws SubsistemaMembresiaException{
        try{
        boolean resultado= false;
        switch(accion){
            case "Eliminar":
            
               
                    resultado= control.eliminarMembresia(idMembresia);
                    if(resultado){
                        JOptionPane.showMessageDialog(null, "Membresía eliminada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar la membresía.", "Error", JOptionPane.ERROR_MESSAGE);
                       // dispose();
                    }
                    break;
                    
            
            case "Actualizar":
                if (membresia != null){
                    
                MembresiaDTO membresiaActualizada= control.actualizarMembresia(membresia);
                if(membresiaActualizada!= null){
                    JOptionPane.showMessageDialog(null, "Membresía actualizada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
               else{
                     JOptionPane.showMessageDialog(null, "No se pudo actualizar la membresía.", "Error", JOptionPane.ERROR_MESSAGE);
                    // dispose();
                }
                }
                    
            case "Compra" :
                ClienteRegConMembDTO clienteConMemb = new ClienteRegConMembDTO(cliente, membresia);
                control.openFormServiciosExtra(clienteConMemb);
                dispose();
                
                break;
//                
            case "Activar":
                  membresia.setEstado(EnumEstadoMembresia.ACTIVA);
                
//                cambios.put("estado", EnumEstadoMembresia.ACTIVA);
                MembresiaDTO membresiaActivada= control.actualizarMembresia(membresia);
                if(membresiaActivada.getEstado()==EnumEstadoMembresia.ACTIVA){
                    JOptionPane.showMessageDialog(null, "Membresía activada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else{
                    JOptionPane.showMessageDialog(null, "Error al activar membresia", "Error", JOptionPane.INFORMATION_MESSAGE);
                   // dispose();
                }
//                
//                if(membresiaActualizada!=null){
//                    JOptionPane.showMessageDialog(null, "Membresía activada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//                }else{
//                    System.out.println(membresiaActualizada);
//                    JOptionPane.showMessageDialog(null, "Error al activar membresia", "Error", JOptionPane.INFORMATION_MESSAGE);
//                   
//                }
                break;
//                
                case "Desactivar":
                    membresia.setEstado(EnumEstadoMembresia.INACTIVA);
                    MembresiaDTO membresiaDesactivada= control.actualizarMembresia(membresia);
//                cambios.put("estado", EnumEstadoMembresia.INACTIVA);
//                    System.out.println(idMembresia);
//                    System.out.println(accion);
//                    System.out.println(cambios);
//                    try{
                     if(membresiaDesactivada.getEstado()==EnumEstadoMembresia.INACTIVA){
                    JOptionPane.showMessageDialog(null, "Membresía desactivada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    } else{
                    JOptionPane.showMessageDialog(null, "Error al desactivar membresia", "Error", JOptionPane.INFORMATION_MESSAGE);
                   // dispose();
                }
                     
                     
//                //if(membresiaDesactualizada!=null){
//                    JOptionPane.showMessageDialog(null, "Membresía desacactivada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//                } catch(SubsistemaMembresiaException e){
//                    
//                
//                 //   System.out.println(membresiaDesactualizada);
//                    JOptionPane.showMessageDialog(null, "Error al desactivar membresía: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//    
//                }
//                break;
                

        }
        } catch(SubsistemaMembresiaException e){
            JOptionPane.showMessageDialog(null, "Error en el sistema de membresías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
            
        }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        panelPrincipal = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelTexto = new javax.swing.JLabel();
        panelMembresias = new javax.swing.JPanel();
        botonSiguiente = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        labelTitulo.setBackground(new java.awt.Color(51, 51, 51));
        labelTitulo.setFont(new java.awt.Font("Snell Roundhand", 1, 36)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(51, 51, 51));
        labelTitulo.setText("membresias");

        labelTexto.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        labelTexto.setForeground(new java.awt.Color(0, 0, 0));
        labelTexto.setText("Seleccione una membresia");

        panelMembresias.setBackground(new java.awt.Color(255, 204, 255));

        javax.swing.GroupLayout panelMembresiasLayout = new javax.swing.GroupLayout(panelMembresias);
        panelMembresias.setLayout(panelMembresiasLayout);
        panelMembresiasLayout.setHorizontalGroup(
            panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );
        panelMembresiasLayout.setVerticalGroup(
            panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );

        botonSiguiente.setText("SIGUIENTE");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonAtras.setBackground(new java.awt.Color(204, 204, 255));
        botonAtras.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        botonAtras.setForeground(new java.awt.Color(0, 0, 0));
        botonAtras.setText("<");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(panelMembresias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAtras)
                .addGap(3, 3, 3)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelMembresias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSiguiente)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }//GEN-END:initComponents

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
       List<MembresiaDTO> seleccionadas= membresiasSeleccionadas();
       MembresiaDTO membresiaSeleccionada = seleccionadas.get(0);
       //ahorita lo borro
       for(MembresiaDTO membresia: seleccionadas){
           System.out.println(membresia.getNombre());
           System.out.println(membresia.getId());
       
           try {
              // if (accionSeleccionada.equals("Actualizar")) {
//                  
           //        MembresiaDTO membresia= control.
//               }
              if(accionSeleccionada.equals("Eliminar")){
                   boolean eliminada = control.eliminarMembresia(membresia.getId());
                   if(eliminada){
                       JOptionPane.showMessageDialog(null, "Membresía eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                       dispose();
                   } else{
                       JOptionPane.showMessageDialog(null, "No se pudo eliminar la membresía con ID: " + membresia.getId(), "Error", JOptionPane.ERROR_MESSAGE);
                    //   dispose();
                   }
              } if(accionSeleccionada.equals("Compra")){
                  ClienteRegConMembDTO clienteConMemb = new ClienteRegConMembDTO(cliente, membresiaSeleccionada);
                   control.openFormServiciosExtra(clienteConMemb);
                   dispose();
                  
              } if(accionSeleccionada.equals("Actualizar")){
                  
                  
                  control.openFormActualizarMembresia(membresiaSeleccionada);
                  dispose();
//                  Map<String, Object> cambios = new HashMap<>();
//                  cambios.put("estado", EnumEstadoMembresia.ACTIVA);
//                   accion(accionSeleccionada, membresia.getId(), membresia, cambios);
//                  
//              } if(accionSeleccionada.equals("Desactivar")){
//                  Map<String, Object> cambios = new HashMap<>();
//                  cambios.put("estado", EnumEstadoMembresia.INACTIVA);
//                   accion(accionSeleccionada, membresia.getId(), membresia, cambios);
//                  
//              }
//            
              } if(accionSeleccionada.equals("Activar")){
                  membresiaSeleccionada.setEstado(EnumEstadoMembresia.ACTIVA);
                  MembresiaDTO membresiaActualizada = control.actualizarMembresia(membresiaSeleccionada);
                  if(membresiaActualizada != null && membresiaActualizada.getEstado() == EnumEstadoMembresia.ACTIVA) { 
                      JOptionPane.showMessageDialog(null, "membresía activada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                      dispose();
                  }
                  else{
                      JOptionPane.showMessageDialog(null, "error al activar la membresía", "Error", JOptionPane.ERROR_MESSAGE);
                     // dispose();
                  }
              }
              
              if(accionSeleccionada.equals("Desactivar")){
                  membresiaSeleccionada.setEstado(EnumEstadoMembresia.INACTIVA);
                  MembresiaDTO membresiaActualizada = control.actualizarMembresia(membresiaSeleccionada);
                  if(membresiaActualizada != null && membresiaActualizada.getEstado() == EnumEstadoMembresia.INACTIVA) { 
                      JOptionPane.showMessageDialog(null, "membresía desactivada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                      dispose();
                  }
                  else{
                      JOptionPane.showMessageDialog(null, "error al desactivar la membresía", "Error", JOptionPane.ERROR_MESSAGE);
                     // dispose();
                  }
              }
              
              
               
           } catch (SubsistemaMembresiaException ex) {
               Logger.getLogger(ConsultarMembresias.class.getName()).log(Level.SEVERE, null, ex);
           }
               
       }  
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
         control.openFormOpcionesModuloMembresia();
         dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ConsultarMembresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsultarMembresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsultarMembresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsultarMembresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultarMembresias().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelMembresias;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
