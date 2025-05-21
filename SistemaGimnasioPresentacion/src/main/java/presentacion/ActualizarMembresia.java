/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dtos.MembresiaDTO;
import dtos.ServicioExtraDTO;
import excepciones.SubsistemaMembresiaException;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ActualizarMembresia extends javax.swing.JFrame {

     private ControlNavegacionCompraMembresia control;
     private MembresiaDTO membresia;
    /**
     * Creates new form ActualizarMembresia
     */
    public ActualizarMembresia(ControlNavegacionCompraMembresia control, MembresiaDTO membresia) {
        initComponents();
        this.control= control;
        this.membresia= membresia;
        cargarServiciosExtras();
        serviciosSeleccionados();
        llenarCampos();
    }
    
    private void cargarServiciosExtras(){
        panelServicios.setLayout(new GridLayout(0, 1));
        panelServicios.removeAll();
        List<ServicioExtraDTO> servicios= control.obtenerServiciosExtrasDTO();
//        List<String> serviciosActuales = membresia.getServiciosExtra().stream()
//                .map(ServicioExtraDTO::getNombreServicio)
//                .toList();
        
        for(ServicioExtraDTO servicio: servicios){
            JCheckBox serv= new JCheckBox(servicio.getNombreServicio());
          ///  serv.setSelected(serviciosActuales.contains(servicio.getNombreServicio()));
            
            panelServicios.add(serv);
//            listaCheckBoxes.add(serv);
           // System.out.println(serv);
        }
        panelServicios.revalidate();
        panelServicios.repaint();
//        panelEscribirNombre.setVisible(false);
//         panelEscribirCosto.setVisible(false);
//         panelEscribirDuracion.setVisible(false);
         
    }
    
    private void cargarMembresia(){
        panelEscribirNombre.add(new JTextField(membresia.getNombre()));
        
        
    }
    
    
    private void serviciosSeleccionados(){
       List<String> serviciosMemb = membresia.getServiciosExtra().stream()
                                          .map(ServicioExtraDTO::getNombreServicio)
                                          .toList();
       for (Component comp : panelServicios.getComponents()) {
           
           if (comp instanceof JCheckBox checkBox) {
                checkBox.setSelected(serviciosMemb.contains(checkBox.getText()));
           }
           

        }
        
    }
    
    private void actualizarMembresia(){
         try {
             String nuevoNombre = campoNuevoNombre.getText().trim();
             String nuevaDuracion = campoEditarDuracion.getText().trim();
             String nuevoCosto = campoEscribirCosto.getText().trim();
             
//         Map<String, Object> cambios = new HashMap<>();
//         if (!nuevoNombre.isBlank()&& !nuevoNombre.isEmpty() && !nuevoNombre.equals("Escribir nombre...") ) {
//             membresia.setNombre(nuevoNombre);
//             cambios.put("nombre", nuevoNombre);
//         }
//         if (!nuevaDuracion.isBlank() && !nuevaDuracion.equals("Escribir duracion..." )) {
//             long nuevaDuracionMilisegundos = Long.parseLong(nuevaDuracion) * 86400000L;
//             membresia.setDuracion(nuevaDuracionMilisegundos);
//             cambios.put("duracion", nuevaDuracionMilisegundos);
//             
//         }
//         
//         if (!nuevoCosto.isBlank() && !nuevoCosto.equals("Escribir costo...")) {
//             double nuevoPrecio = Double.parseDouble(nuevoCosto);
//              membresia.setPrecio(nuevoPrecio);
//              cambios.put("precio", nuevoPrecio);
//              
//         }

// MembresiaDTO nuevaMembresia= new MembresiaDTO(nuevoNombre, ERROR, serviciosExtra, nuevaDuracion);
    List<ServicioExtraDTO> nuevosServicios = new ArrayList<>();
    List<ServicioExtraDTO> serviciosDisponibles = control.obtenerServiciosExtrasDTO();

    for (Component comp : panelServicios.getComponents()) {
        if (comp instanceof JCheckBox checkBox && checkBox.isSelected()) {
            for (ServicioExtraDTO servicio : serviciosDisponibles) {
                if (servicio.getNombreServicio().equals(checkBox.getText())) {
                    servicio.setId(membresia.getServiciosExtra().stream()
                            .filter(s -> s.getNombreServicio().equals(servicio.getNombreServicio()))
                            .map(ServicioExtraDTO::getId)
                            .findFirst()
                            .orElse(servicio.getId()));
                    nuevosServicios.add(servicio);
                    break;

                }
            }

        }
    }
    MembresiaDTO nuevaMembresia= new MembresiaDTO(nuevoNombre, membresia.getId(), Double.parseDouble(nuevoCosto), nuevosServicios, membresia.getEstado(), Long.valueOf(nuevaDuracion));
    control.actualizarMembresia(nuevaMembresia);
//              membresia.setServiciosExtra(nuevosServicios);
//              cambios.put("serviciosExtra", nuevosServicios);



//         if (!cambios.isEmpty()) {
//             try{
//                  control.actualizarMembresia(membresia.getId(), cambios);
//                  labelNombreOriginal.setText(nuevoNombre);
//                   labelDuracionOriginal.setText(nuevaDuracion);
//                   labelCostoOriginal.setText(nuevoCosto);
//                   JOptionPane.showMessageDialog(this, "membresía actualizada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//            } catch(SubsistemaMembresiaException e){
//                JOptionPane.showMessageDialog(this, "error al actualizar membresia" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//
//
//                  
//             }
//         }
         } catch (SubsistemaMembresiaException ex) {
             Logger.getLogger(ActualizarMembresia.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         }
        
    

    
    private void llenarCampos(){
        campoNuevoNombre.setText(membresia.getNombre());
        campoEditarDuracion.setText(String.valueOf(membresia.getDuracion() / 86400000L));
        campoEscribirCosto.setText(String.valueOf(membresia.getPrecio()));
        
    }
    
//    private void rellenarNombre(){
//        panelEscribirNombre.setVisible(true);
//       // String nombre= campoNuevoNombre.getText();
//    }
//    
//    private void rellenarCosto(){
//        panelEscribirCosto.setVisible(true);
//      //  String costo= campoEscribirCosto.getText();
//    }
//    
//    private void rellenarDuracion(){
//        panelEscribirDuracion.setVisible(true);
//      //  String duracion= campoEditarDuracion.getText();
//    }
//            
            
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        botonNombre1 = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelServicios = new javax.swing.JPanel();
        botonActualizar = new javax.swing.JButton();
        labelDias = new javax.swing.JLabel();
        labelCosto = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        panelEscribirNombre = new javax.swing.JPanel();
        campoNuevoNombre = new javax.swing.JTextField();
        panelEscribirCosto = new javax.swing.JPanel();
        campoEscribirCosto = new javax.swing.JTextField();
        campoEditarDuracion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        labelTiulo = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();

        botonNombre1.setText("EDITAR ");
        botonNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNombre1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(102, 0, 102));

        panelInfo.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 217, 255));

        panelServicios.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelServiciosLayout = new javax.swing.GroupLayout(panelServicios);
        panelServicios.setLayout(panelServiciosLayout);
        panelServiciosLayout.setHorizontalGroup(
            panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        panelServiciosLayout.setVerticalGroup(
            panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );

        botonActualizar.setBackground(new java.awt.Color(204, 0, 204));
        botonActualizar.setForeground(new java.awt.Color(204, 204, 204));
        botonActualizar.setText("ACTUALIZAR");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        labelDias.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        labelDias.setForeground(new java.awt.Color(51, 51, 51));
        labelDias.setText(" DURACION");

        labelCosto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        labelCosto.setForeground(new java.awt.Color(51, 51, 51));
        labelCosto.setText(" COSTO");

        labelNombre.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(51, 51, 51));
        labelNombre.setText("NOMBRE DE LA MEMBRESIA");

        panelEscribirNombre.setBackground(new java.awt.Color(255, 255, 255));

        campoNuevoNombre.setBackground(new java.awt.Color(255, 255, 255));
        campoNuevoNombre.setForeground(new java.awt.Color(102, 102, 102));
        campoNuevoNombre.setText("Escribir nombre...");
        campoNuevoNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNuevoNombreMouseClicked(evt);
            }
        });
        campoNuevoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNuevoNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEscribirNombreLayout = new javax.swing.GroupLayout(panelEscribirNombre);
        panelEscribirNombre.setLayout(panelEscribirNombreLayout);
        panelEscribirNombreLayout.setHorizontalGroup(
            panelEscribirNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEscribirNombreLayout.createSequentialGroup()
                .addComponent(campoNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        panelEscribirNombreLayout.setVerticalGroup(
            panelEscribirNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEscribirNombreLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(campoNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelEscribirCosto.setBackground(new java.awt.Color(255, 255, 255));

        campoEscribirCosto.setBackground(new java.awt.Color(255, 255, 255));
        campoEscribirCosto.setForeground(new java.awt.Color(102, 102, 102));
        campoEscribirCosto.setText("Escribir costo...");
        campoEscribirCosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoEscribirCostoMouseClicked(evt);
            }
        });
        campoEscribirCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEscribirCostoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEscribirCostoLayout = new javax.swing.GroupLayout(panelEscribirCosto);
        panelEscribirCosto.setLayout(panelEscribirCostoLayout);
        panelEscribirCostoLayout.setHorizontalGroup(
            panelEscribirCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEscribirCostoLayout.createSequentialGroup()
                .addComponent(campoEscribirCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelEscribirCostoLayout.setVerticalGroup(
            panelEscribirCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEscribirCostoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoEscribirCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        campoEditarDuracion.setBackground(new java.awt.Color(255, 255, 255));
        campoEditarDuracion.setForeground(new java.awt.Color(102, 102, 102));
        campoEditarDuracion.setText("Escribir duracion...");
        campoEditarDuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoEditarDuracionMouseClicked(evt);
            }
        });
        campoEditarDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEditarDuracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(406, 406, 406))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoEditarDuracion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelEscribirNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelEscribirCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(panelServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 63, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(labelNombre)
                        .addGap(18, 18, 18)
                        .addComponent(panelEscribirNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelDias, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoEditarDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelCosto)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEscribirCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        labelTiulo.setFont(new java.awt.Font("Bradley Hand", 1, 18)); // NOI18N
        labelTiulo.setForeground(new java.awt.Color(102, 0, 102));
        labelTiulo.setText("actualizar membresia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(labelTiulo))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTiulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAtras.setBackground(new java.awt.Color(204, 204, 255));
        botonAtras.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        botonAtras.setForeground(new java.awt.Color(0, 0, 0));
        botonAtras.setText("<");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }//GEN-END:initComponents

    private void botonNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNombre1ActionPerformed

    private void campoNuevoNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNuevoNombreMouseClicked
       // campoNuevoNombre.setText("");
    }//GEN-LAST:event_campoNuevoNombreMouseClicked

    private void campoEscribirCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEscribirCostoActionPerformed
      
    }//GEN-LAST:event_campoEscribirCostoActionPerformed

    private void campoEscribirCostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoEscribirCostoMouseClicked
       // campoEscribirCosto.setText("");
    }//GEN-LAST:event_campoEscribirCostoMouseClicked

    private void campoEditarDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEditarDuracionActionPerformed
       
    }//GEN-LAST:event_campoEditarDuracionActionPerformed

    private void campoEditarDuracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoEditarDuracionMouseClicked
     //   campoEditarDuracion.setText("");
    }//GEN-LAST:event_campoEditarDuracionMouseClicked

    private void campoNuevoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNuevoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNuevoNombreActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
       actualizarMembresia();
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        control.openFormOpcionesModuloMembresia();
    }//GEN-LAST:event_botonAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonNombre1;
    private javax.swing.JTextField campoEditarDuracion;
    private javax.swing.JTextField campoEscribirCosto;
    private javax.swing.JTextField campoNuevoNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelCosto;
    private javax.swing.JLabel labelDias;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTiulo;
    private javax.swing.JPanel panelEscribirCosto;
    private javax.swing.JPanel panelEscribirNombre;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelServicios;
    // End of variables declaration//GEN-END:variables
}
