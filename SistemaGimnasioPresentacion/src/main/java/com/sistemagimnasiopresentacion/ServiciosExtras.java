/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemagimnasiopresentacion;

/**
 *
 * @author Ramón Zamudio
 */
import com.subsistemacompramembresia.IManejadorComprasMembresias;
import dtos.ServicioExtraDTO;
import implementaciones.ManejadorComprasMembresias;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ServiciosExtras extends JFrame {
    private IManejadorComprasMembresias subsistema;
    private List<JCheckBox> checkBoxes;
    private LinkedHashMap<Long, ServicioExtraDTO> serviciosExtras;
    private double costoTotal;
    private JLabel lblCostoTotal;
    

    public ServiciosExtras(List<ServicioExtraDTO> seleccionados) {
        subsistema = new ManejadorComprasMembresias();
        serviciosExtras = subsistema.obtenerServiciosExtrasDTO();
        this.costoTotal = 0.0;
        this.checkBoxes = new ArrayList<>();
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

        for (ServicioExtraDTO servicio : serviciosExtras.values()) {
            JCheckBox checkBox = new JCheckBox(servicio.getNombreServicio() + " - Costo $" + servicio.getPrecio());
            checkBox.setActionCommand(String.valueOf(servicio.getId()));

            // Verificar si el ID del servicio está en la lista de seleccionados
            if (seleccionados.stream().anyMatch(s -> s.getId() == servicio.getId())) {
                checkBox.setSelected(true);
                costoTotal += servicio.getPrecio();
            }

        checkBox.addActionListener(e -> actualizarCosto(checkBox, servicio.getPrecio()));
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

        lblCostoTotal = new JLabel("Costo Total: $" + costoTotal);
        lblCostoTotal.setFont(new Font("Arial", Font.BOLD, 16));
        botonesPanel.add(lblCostoTotal);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnContinuar = new JButton("Continuar");

        botonesPanel.add(btnCancelar);
        botonesPanel.add(btnLimpiar);
        botonesPanel.add(btnContinuar);

        panel.add(botonesPanel, BorderLayout.SOUTH);
        add(panel);

        btnContinuar.addActionListener(e -> {
            List<ServicioExtraDTO> seleccionadosList = getServiciosSeleccionados();
            mostrarSeleccionados(seleccionadosList);
        });

        btnLimpiar.addActionListener(e -> limpiarSeleccion());
    }

    public List<ServicioExtraDTO> getServiciosSeleccionados() {
        List<ServicioExtraDTO> seleccionados = new ArrayList<>();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                long id = Long.parseLong(checkBox.getActionCommand());
                seleccionados.add(serviciosExtras.get(id));
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

    private void actualizarCosto(JCheckBox checkBox, double precio) {
        if (checkBox.isSelected()) {
            costoTotal += precio;
        } else {
            costoTotal -= precio;
        }
        lblCostoTotal.setText("Costo Total: $" + costoTotal);
    }

    private void limpiarSeleccion() {
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                checkBox.setSelected(false);
            }
        }
        costoTotal = 0;
        lblCostoTotal.setText("Costo Total: $" + costoTotal);
    }
}