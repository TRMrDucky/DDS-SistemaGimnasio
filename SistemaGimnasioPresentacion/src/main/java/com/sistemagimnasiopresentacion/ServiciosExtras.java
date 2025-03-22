/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemagimnasiopresentacion;

/**
 *
 * @author Ramón Zamudio
 */
import dtos.ServicioExtraDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServiciosExtras extends JFrame {
    private List<JCheckBox> checkBoxes;
    private List<ServicioExtraDTO> servicios;

    public ServiciosExtras(List<ServicioExtraDTO> servicios) {
        this.servicios = servicios;
        setTitle("Servicios Extras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(100, 149, 237));
        panel.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Servicios Extras", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.MAGENTA);
        panel.add(lblTitulo, BorderLayout.NORTH);

        JPanel serviciosPanel = new JPanel();
        serviciosPanel.setLayout(new GridLayout(0, 1, 10, 10));
        serviciosPanel.setBackground(new Color(100, 149, 237));

        checkBoxes = new ArrayList<>();
        for (ServicioExtraDTO servicio : servicios) {
            JCheckBox checkBox = new JCheckBox(servicio.getNombreServicio() + " - Costo $" + servicio.getPrecio());
            checkBoxes.add(checkBox);
            serviciosPanel.add(checkBox);
        }

        JScrollPane scrollPane = new JScrollPane(serviciosPanel);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(100, 149, 237));
        centerPanel.add(scrollPane);

        panel.add(centerPanel, BorderLayout.CENTER);

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new FlowLayout());
        botonesPanel.setBackground(new Color(100, 149, 237));

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnContinuar = new JButton("Continuar");

        botonesPanel.add(btnCancelar);
        botonesPanel.add(btnLimpiar);
        botonesPanel.add(btnContinuar);

        panel.add(botonesPanel, BorderLayout.SOUTH);
        add(panel);

        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ServicioExtraDTO> seleccionados = getServiciosSeleccionados();
                mostrarSeleccionados(seleccionados);
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarSeleccion();
            }
        });
    
    }

    public List<ServicioExtraDTO> getServiciosSeleccionados() {
        List<ServicioExtraDTO> seleccionados = new ArrayList<>();
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isSelected()) {
                seleccionados.add(servicios.get(i));
            }
        }
        return seleccionados;
    }

    private void mostrarSeleccionados(List<ServicioExtraDTO> seleccionados) {
        StringBuilder mensaje = new StringBuilder("Servicios seleccionados:\n");
        for (ServicioExtraDTO servicio : seleccionados) {
            mensaje.append(servicio.getNombreServicio()).append(" - Costo $").append(servicio.getPrecio()).append("\n");
        }
        JOptionPane.showMessageDialog(this, mensaje.toString(), "Selección de Servicios", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void limpiarSeleccion() {
        for (JCheckBox checkBox : checkBoxes) {
            checkBox.setSelected(false);
        }
    }
}