/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package presentacion;
import dtos.EquipoDTO;
import enums.ModoUso;
import excepciones.IdEquipoVacioException;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;



 
public class PantallaBuscadorEquipos extends JDialog{
   private final ControlNavegacionCompraMembresia control;
    private JTextField campoBusqueda;
    private  JTable tablaResultados;
    private  JButton btnSeleccionar;
    private ModoUso modoUso;
    private DefaultTableModel modeloTabla;


    public PantallaBuscadorEquipos(ModoUso modoUso, ControlNavegacionCompraMembresia control) {
        this.modoUso = modoUso;
        this.control = control;
        initComponents();
        cargarEquiposIniciales();
    }

    private void initComponents() {
        setTitle("Buscar Equipo - " + modoUso.toString().replace("_", " "));
        setSize(800, 600);
        setLocationRelativeTo(null);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Modelo de tabla
        String[] columnas = {"ID", "Nombre", "Número de Serie", "Marca", "Modelo","Fecha Adquisicion"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Componentes
        campoBusqueda = new JTextField(30);
        JButton btnBuscar = new JButton("Buscar");
        btnSeleccionar = new JButton("Seleccionar");
        tablaResultados = new JTable(modeloTabla);
        tablaResultados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Configurar eventos
        btnBuscar.addActionListener(e -> buscarEquipos());
        btnSeleccionar.addActionListener(e -> seleccionarEquipo());
        campoBusqueda.addActionListener(e -> buscarEquipos());
        
        // Configurar interfaz
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.add(new JLabel("Buscar:"));
        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(btnBuscar);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnSeleccionar);

        add(panelBusqueda, BorderLayout.NORTH);
        add(new JScrollPane(tablaResultados), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarEquiposIniciales() {
        // Cargar todos los equipos al iniciar
        List<EquipoDTO> equipos = control.obtenerTodosEquipos();
        actualizarTabla(equipos);
    }

    private void buscarEquipos() {
        String filtro = campoBusqueda.getText().trim();
        List<EquipoDTO> equipos = control.buscarEquiposPorFiltro(filtro);
        actualizarTabla(equipos);
    }

    private void actualizarTabla(List<EquipoDTO> equipos) {
        modeloTabla.setRowCount(0);
        for (EquipoDTO equipo : equipos) {
            modeloTabla.addRow(new Object[]{
                equipo.getId(),
                equipo.getNombre(),
                equipo.getNumeroSerie(),
                equipo.getMarca(),
                equipo.getModelo(),
                equipo.getFechaAdquisicion()
            });
        }
    }

    private void seleccionarEquipo() {
    int filaSeleccionada = tablaResultados.getSelectedRow();
    if (filaSeleccionada < 0) {
        JOptionPane.showMessageDialog(this, "Seleccione un equipo de la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String idEquipo = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
    EquipoDTO equipo = control.obtenerEquipoPorId(idEquipo);
        switch (modoUso) {
            case REGISTRO_MANTENIMIENTO:
                abrirRegistroMantenimiento(equipo);
                break;
            case CONSULTA_HISTORIAL:
                abrirHistorialMantenimiento(equipo);
                break;
            case ELIMINAR_EQUIPO:
                confirmarEliminacion(equipo);
                break;
        }
    }

    private void abrirRegistroMantenimiento(EquipoDTO equipo) {
       new PantallaRegistroMantenimiento(control, equipo).setVisible(true);
       dispose();
   }

    private void abrirHistorialMantenimiento(EquipoDTO equipo) {
        new PantallaHistorialMantenimiento(control, equipo).setVisible(true);
        dispose();
    }

    private void confirmarEliminacion(EquipoDTO equipo) {
        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de eliminar el equipo " + equipo.getNombre() + "?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = control.eliminarEquipoYAsociados(equipo.getId());
            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Equipo eliminado exitosamente");
                buscarEquipos(); // Refrescar la lista
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el equipo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


   


    

