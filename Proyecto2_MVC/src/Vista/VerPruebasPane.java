package Vista;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.Cursor;

public class VerPruebasPane extends JPanel {

	public JTable table;
	public JTextField codigoElimianrTF;
	public JButton btnEliminar;
	public JButton btnRefrescar;
	public JScrollPane scrollPane;
	
	public VerPruebasPane() {
		setBackground(new Color(0, 191, 255));
		setBounds(0,0,575,501);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PRUEBAS CREADAS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(10, 134, 555, 356);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		
		JSeparator separadorTitulo = new JSeparator();
		separadorTitulo.setForeground(new Color(0, 0, 0));
		separadorTitulo.setBackground(new Color(0, 0, 0));
		separadorTitulo.setBounds(0, 39, 691, 2);
		add(separadorTitulo);
		
		JLabel TituloLbl = new JLabel("VER TEST");
		TituloLbl.setBackground(new Color(30, 144, 255));
		TituloLbl.setOpaque(true);
		TituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TituloLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		TituloLbl.setBounds(0, 0, 575, 41);
		add(TituloLbl);
		
		btnRefrescar = new JButton("REFRESCAR");
		btnRefrescar.setToolTipText("Refrescar tabla de datos.");
		btnRefrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefrescar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		btnRefrescar.setIcon(new ImageIcon(VerPruebasPane.class.getResource("/imagenes/refreshIcono.png")));
		btnRefrescar.setBounds(380, 68, 185, 55);
		add(btnRefrescar);
		
		codigoElimianrTF = new JTextField();
		codigoElimianrTF.setToolTipText("Introduzca el codigo de una prueba para que sea eliminada.");
		codigoElimianrTF.setBounds(10, 80, 209, 34);
		add(codigoElimianrTF);
		codigoElimianrTF.setColumns(10);
		
		JLabel lblMensajeEliminar = new JLabel("Codigo Prueba:");
		lblMensajeEliminar.setFont(new Font("Arial", Font.BOLD, 15));
		lblMensajeEliminar.setBounds(10, 52, 230, 28);
		add(lblMensajeEliminar);
		
		btnEliminar = new JButton();
		btnEliminar.setToolTipText("Eliminar prueba.");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setIcon(new ImageIcon(VerPruebasPane.class.getResource("/imagenes/deleteIcon.png")));
		btnEliminar.setBounds(221, 75, 37, 40);
		add(btnEliminar);
	}
	
}
