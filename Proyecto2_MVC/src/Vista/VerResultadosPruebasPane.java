package Vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import Modelo.ResultadosVerf;

import java.awt.Cursor;



public class VerResultadosPruebasPane extends JPanel {
	public JTable table;
	public JLabel lblSinResultados;
	public ResultadosVerf datosPrueba;
	public JTextField BuscarCodigoTF;
	public JScrollPane scrollPane;
	public JButton btnBuscar;
	public JButton btnExcel;
	
	public VerResultadosPruebasPane() {
		setBounds(0,0,575,501);
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		lblSinResultados = new JLabel("");
		lblSinResultados.setVisible(false);
		lblSinResultados.setIcon(new ImageIcon(VerResultadosPruebasPane.class.getResource("/imagenes/mensajeSinResultadosIcono-removebg-preview.png")));
		lblSinResultados.setBounds(30, 127, 575, 387);
		add(lblSinResultados);
		
		JSeparator separadorTitulo = new JSeparator();
		separadorTitulo.setForeground(new Color(0, 0, 0));
		separadorTitulo.setBackground(new Color(0, 0, 0));
		separadorTitulo.setBounds(0, 39, 691, 2);
		add(separadorTitulo);
		
		JLabel TituloLbl = new JLabel("VER RESULTADOS");
		TituloLbl.setBackground(new Color(30, 144, 255));
		TituloLbl.setOpaque(true);
		TituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TituloLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		TituloLbl.setBounds(0, 0, 575, 41);
		add(TituloLbl);
		
		JLabel lblCodigoPrueba = new JLabel("Codigo prueba:\r\n");
		lblCodigoPrueba.setFont(new Font("Arial", Font.BOLD, 18));
		lblCodigoPrueba.setBounds(10, 47, 209, 30);
		add(lblCodigoPrueba);
		
		BuscarCodigoTF = new JTextField();
		BuscarCodigoTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BuscarCodigoTF.setToolTipText("Introduzca el codigo de la prueba que desea ver los resultados.");
		BuscarCodigoTF.setBounds(10, 75, 209, 39);
		add(BuscarCodigoTF);
		BuscarCodigoTF.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setToolTipText("Buscar resultados de la prueba, puede ocupar este mismo boton para refrescar la tabla.");
		btnBuscar.setIcon(new ImageIcon(VerResultadosPruebasPane.class.getResource("/imagenes/buscarPruebaIcono2.png")));
		btnBuscar.setBounds(229, 73, 42, 41);
		add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Resultados Prueba", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 139, 555, 351);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnExcel = new JButton("Crear Excel");
		btnExcel.setVisible(false);
		btnExcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExcel.setIcon(new ImageIcon(VerResultadosPruebasPane.class.getResource("/imagenes/excelIconoo.png")));
		btnExcel.setBounds(400, 87, 165, 41);
		add(btnExcel);
	}
}
