package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class LoggedFRM extends JFrame {

	public JPanel contentPane;
	public String nombreUsuario;
	public JButton btnDesconectar;
	public JLayeredPane layeredPane;
	public JButton btnNuevoTest;
	public JButton btnVerPruebas;
	public JButton btnVerResultados;

	public LoggedFRM(String nombreusuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoggedFRM.class.getResource("/imagenes/AppIcono.png")));
		setResizable(false);
		this.nombreUsuario = nombreusuario;
		
		setTitle("TestApp/Login/Profesor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,950, 540);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelOpciones.setBackground(new Color(72, 209, 204));
		panelOpciones.setBounds(0, 0, 360, 501);
		contentPane.add(panelOpciones);
		panelOpciones.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(LoggedFRM.class.getResource("/imagenes/userRegistroIcono.png")));
		lblNewLabel.setBounds(-11, 0, 54, 40);
		panelOpciones.add(lblNewLabel);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(357, -29, 21, 530);
		panelOpciones.add(separador);
		separador.setBackground(new Color(0, 0, 0));
		separador.setForeground(new Color(0, 0, 0));
		separador.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 39, 360, 3);
		panelOpciones.add(separator);
		
		JLabel lblBienvenida = new JLabel("Bienvenido "+nombreUsuario);
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBackground(new Color(0, 139, 139));
		lblBienvenida.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblBienvenida.setOpaque(true);
		lblBienvenida.setBounds(0, 0, 360, 40);
		panelOpciones.add(lblBienvenida);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(359, 0, 575, 501);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setFont(new Font("Arial", Font.ITALIC, 15));
		btnDesconectar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDesconectar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDesconectar.setIcon(new ImageIcon(LoggedFRM.class.getResource("/imagenes/logOutIcono.png")));
		btnDesconectar.setBounds(10, 442, 179, 48);
		panelOpciones.add(btnDesconectar);
		setVisible(true);
		
		btnNuevoTest = new JButton("NUEVO TEST");
		btnNuevoTest.setIcon(new ImageIcon(LoggedFRM.class.getResource("/imagenes/crearTest.png")));
		btnNuevoTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoTest.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNuevoTest.setBounds(39, 70, 264, 81);
		panelOpciones.add(btnNuevoTest);
		
		btnVerPruebas = new JButton("VER PRUEBAS");
		btnVerPruebas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerPruebas.setIcon(new ImageIcon(LoggedFRM.class.getResource("/imagenes/verTestsIcono.png")));
		btnVerPruebas.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnVerPruebas.setBounds(39, 179, 264, 81);
		panelOpciones.add(btnVerPruebas);
		
		btnVerResultados = new JButton("RESULTADOS");
		btnVerResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerResultados.setIcon(new ImageIcon(LoggedFRM.class.getResource("/imagenes/verResultadosIcono.png")));
		btnVerResultados.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnVerResultados.setBounds(39, 288, 264, 81);
		panelOpciones.add(btnVerResultados);
	}
}
