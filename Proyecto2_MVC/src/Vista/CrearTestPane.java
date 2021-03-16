package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

public class CrearTestPane extends JPanel {
	public JTextField nombrePruebaTF;
	public JComboBox PreguntaActualCB;
	public JButton btnQuitarPregunta;
	public JButton btnAddPregunta;
	public JButton btnCrearTest;
	public JLayeredPane layeredPane;
	public JSpinner spinner;
	
	public CrearTestPane() {

		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(new Color(0, 191, 255));
		setBounds(0,0,575,501);
		setLayout(null);
		
		JLabel requisitoslbl = new JLabel("");
		requisitoslbl.setToolTipText("<html><p width=\"500\">"
				+"Para que se pueda almacenar su prueba correctamente debe cumplir con los siguientes requisitos:"+"<BR/>" 
				+ "1) Ningun campo debe estar vacio"+"<BR/>" 
				+ "2) El tiempo debe estar entre 1 y 86400 segundos."+"<BR/>" 
				+"</p></html>");
		requisitoslbl.setIcon(new ImageIcon(CrearTestPane.class.getResource("/imagenes/preguntaIcono.png")));
		requisitoslbl.setBounds(527, 0, 38, 41);
		add(requisitoslbl);
		
		JButton fakeButton = new JButton("fake");
        add(fakeButton);
        fakeButton.requestFocusInWindow();
		
		JSeparator separadorTitulo = new JSeparator();
		separadorTitulo.setForeground(new Color(0, 0, 0));
		separadorTitulo.setBackground(new Color(0, 0, 0));
		separadorTitulo.setBounds(0, 39, 691, 2);
		add(separadorTitulo);
		
		JLabel TituloLbl = new JLabel("CREAR TEST");
		TituloLbl.setBackground(new Color(30, 144, 255));
		TituloLbl.setOpaque(true);
		TituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TituloLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		TituloLbl.setBounds(0, 0, 575, 41);
		add(TituloLbl);
		
		btnAddPregunta = new JButton("A\u00F1adir pregunta\r\n");
		btnAddPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddPregunta.setToolTipText("A\u00F1ade una pregunta al examen.");
		btnAddPregunta.setIcon(new ImageIcon(CrearTestPane.class.getResource("/imagenes/crearIcono.png")));
		btnAddPregunta.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnAddPregunta.setBounds(10, 369, 281, 57);
		add(btnAddPregunta);
		
		JLabel tiempoLbl = new JLabel("TIEMPO (SEGUNDOS)");
		tiempoLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		tiempoLbl.setBounds(261, 44, 179, 25);
		add(tiempoLbl);
		
		JLabel tiempoIcono = new JLabel("");
		tiempoIcono.setIcon(new ImageIcon(CrearTestPane.class.getResource("/imagenes/relojIcono.png")));
		tiempoIcono.setBounds(235, 44, 24, 25);
		add(tiempoIcono);
		
		JLabel nombrePruebalbl = new JLabel("NOMBRE PRUEBA");
		nombrePruebalbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		nombrePruebalbl.setBounds(36, 45, 153, 25);
		add(nombrePruebalbl);
		
		JLabel nombrePruebaIcono = new JLabel("");
		nombrePruebaIcono.setIcon(new ImageIcon(CrearTestPane.class.getResource("/imagenes/nombrePruebaIcono.png")));
		nombrePruebaIcono.setBounds(10, 45, 24, 25);
		add(nombrePruebaIcono);
		
		nombrePruebaTF = new JTextField();
		nombrePruebaTF.setFont(new Font("Arial", Font.PLAIN, 15));
		nombrePruebaTF.setToolTipText("Es el nombre de la prueba.");
		nombrePruebaTF.setColumns(10);
		nombrePruebaTF.setBounds(10, 70, 205, 34);
		add(nombrePruebaTF);
		
		layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBorder(new TitledBorder(null, "Datos Pregunta", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setBounds(10, 125, 555, 233);
		add(layeredPane);

		btnQuitarPregunta = new JButton("Quitar pregunta");
		btnQuitarPregunta.setIcon(new ImageIcon(CrearTestPane.class.getResource("/imagenes/eliminarIcono.png")));
		btnQuitarPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitarPregunta.setToolTipText("Elimina una pregunta de la prueba.");
		btnQuitarPregunta.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnQuitarPregunta.setBounds(10, 433, 281, 57);
		add(btnQuitarPregunta);
		
		PreguntaActualCB = new JComboBox();
		PreguntaActualCB.setBounds(327, 433, 238, 57);
		add(PreguntaActualCB);
		PreguntaActualCB.setToolTipText("Es la pregunta que se esta editando actualmente");
		PreguntaActualCB.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		PreguntaActualCB.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pregunta actual", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		btnCrearTest = new JButton("Crear Test");
		btnCrearTest.setToolTipText("Crea el examen y se guarda.");
		btnCrearTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearTest.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnCrearTest.setIcon(new ImageIcon(CrearTestPane.class.getResource("/imagenes/crearTest.png")));
		btnCrearTest.setBounds(327, 369, 238, 57);
		add(btnCrearTest);
		
		spinner = new JSpinner();
		spinner.setToolTipText("Es el tiempo que durara el examen, no puede ser menor que 1 ni mayor a 86400 (1 dia).");
		spinner.setModel(new SpinnerNumberModel(1, 1, 86400, 1));
		spinner.setFont(new Font("Arial", Font.PLAIN, 15));
		spinner.setBounds(235, 70, 205, 34);
		add(spinner);
		
	}
}
