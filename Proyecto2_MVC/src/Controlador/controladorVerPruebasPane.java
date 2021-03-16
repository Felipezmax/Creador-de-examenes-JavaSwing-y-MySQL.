package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.ConectarSQL;
import Vista.VerPruebasPane;

public class controladorVerPruebasPane {
	public static VerPruebasPane panel;
	private ConectarSQL conexion = new ConectarSQL();
	private ArrayList<Object[]> datosTabla;
	
	public controladorVerPruebasPane(String nombreProfe) {
		panel = new VerPruebasPane();
		crearTabla(nombreProfe);
		
		panel.btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearTabla(nombreProfe);
			}
		});
		
		panel.btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(eliminarDatosPrueba(nombreProfe)) {
					crearTabla(nombreProfe);
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/success-icon.png"));
					JOptionPane.showMessageDialog(null, "Prueba eliminada","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}else {
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/Exclamation-mark-icon.png"));
					JOptionPane.showMessageDialog(null, "Esa prueba no existe","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}
			}
		});
	}
	
	void crearTabla(String nombreProfe) {
		datosTabla = conexion.ObtenerTablaPruebas(nombreProfe);
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modelo.addColumn("Codigo");
		modelo.addColumn("Dueño");
		modelo.addColumn("Nombre Prueba");
		modelo.addColumn("Duracion (s)");
		modelo.addColumn("Cantidad Preguntas");
		for(int i = 0;i<datosTabla.size();i++) {
			modelo.addRow(datosTabla.get(i));
		}
		panel.table.setModel(modelo);
	}
	
	private boolean eliminarDatosPrueba(String nombreProfe) {
		if(!conexion.eliminarTest(nombreProfe, panel.codigoElimianrTF.getText())) {
			return false;
		}
		if(!conexion.eliminarTablaPreguntas(panel.codigoElimianrTF.getText())) {
			return false;
		}
		if(!conexion.eliminarTablaResultados(panel.codigoElimianrTF.getText())) {
			return false;
		}
		return true;
	}
}
