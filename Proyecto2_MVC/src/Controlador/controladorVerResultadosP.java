package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ConectarSQL;
import Modelo.TablaExcel;
import Vista.VerResultadosPruebasPane;

public class controladorVerResultadosP {
	public static VerResultadosPruebasPane panel;
	private ConectarSQL conexion = new ConectarSQL();
	private String nombrePrueba;
	private ArrayList<Object[]> datosTabla;
	
	public controladorVerResultadosP(String nombreprofe) {
		panel = new VerResultadosPruebasPane();
		
		panel.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificar(nombreprofe)) {
					crearTabla();
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/success-icon.png"));
					JOptionPane.showMessageDialog(null, "Prueba encontrada","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}else {
					panel.btnExcel.setVisible(false);
					panel.scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
					panel.table.setModel(new DefaultTableModel());
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/Exclamation-mark-icon.png"));
					JOptionPane.showMessageDialog(null, "Prueba no encontrada","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}
			}
		});
		
		panel.btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablaExcel TE = new TablaExcel();
				try {
					TE.exportarExcel(panel.table);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void crearTabla() {
		panel.scrollPane.setBorder(new TitledBorder(null, "Resultados Prueba "+nombrePrueba, TitledBorder.CENTER, TitledBorder.TOP, null, null));
		datosTabla = conexion.ObtenerTablaResultados(panel.BuscarCodigoTF.getText());
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		if(datosTabla.isEmpty()) {
			panel.scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.table.setModel(new DefaultTableModel());
			panel.btnExcel.setVisible(false);
			panel.lblSinResultados.setVisible(true);
		}else {
			panel.btnExcel.setVisible(true);
			panel.lblSinResultados.setVisible(false);
			modelo.addColumn("rut");
			for(int i = 0;i<(datosTabla.get(0).length)-3;i++) {
				modelo.addColumn("RP"+(i+1));
			}
			modelo.addColumn("Puntaje Obtenido");
			modelo.addColumn("Porcentaje Obtenido");
			for(int i = 0;i<datosTabla.size();i++) {
				modelo.addRow(datosTabla.get(i));
			}
			panel.table.setModel(modelo);
		}
	}
	
	private boolean verificar(String nombreprofe) {
		panel.datosPrueba = conexion.verificarVerResultados(panel.BuscarCodigoTF.getText(), nombreprofe);
		if(panel.datosPrueba.resultado == true) {
			nombrePrueba = panel.datosPrueba.nombrePrueba;
			return true;
		}
		return false;
	}
}
