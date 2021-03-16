package Vista;

import java.awt.EventQueue;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Toolkit;


public class LobbyProfesorFRM extends JFrame {

	private JPanel contentPane;
	private LoginPane panelDeLogin = new LoginPane(this);
	public JButton btnVolver;
	public JLayeredPane layeredPane;
	public JButton btnIngresar;
	public JButton btnRegistrarse;

	public LobbyProfesorFRM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LobbyProfesorFRM.class.getResource("/imagenes/AppIcono.png")));
		setTitle("TestApp/Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		 
		JPanel panelOpciones = new JPanel();
		panelOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelOpciones.setBackground(new Color(72, 209, 204));
		panelOpciones.setBounds(0, 0, 360, 501);
		contentPane.add(panelOpciones);
		panelOpciones.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(359, 0, 575, 501);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 39, 360, 3);
		panelOpciones.add(separator);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.ITALIC, 15));
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setIcon(new ImageIcon(LobbyProfesorFRM.class.getResource("/imagenes/RetrocederIcono.png")));
		btnVolver.setBounds(10, 442, 120, 48);
		panelOpciones.add(btnVolver);
		
		btnIngresar = new JButton("INGRESAR  ");
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnIngresar.setIcon(new ImageIcon(LobbyProfesorFRM.class.getResource("/imagenes/LoginIcono.png")));
		btnIngresar.setBounds(39, 70, 264, 81);
		panelOpciones.add(btnIngresar);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(357, -29, 21, 530);
		panelOpciones.add(separador);
		separador.setBackground(new Color(0, 0, 0));
		separador.setForeground(new Color(0, 0, 0));
		separador.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblOpciones = new JLabel("OPCIONES");
		lblOpciones.setIcon(new ImageIcon(LobbyProfesorFRM.class.getResource("/imagenes/opcionesicono.png")));
		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones.setBackground(new Color(0, 139, 139));
		lblOpciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblOpciones.setOpaque(true);
		lblOpciones.setBounds(0, 0, 360, 41);
		panelOpciones.add(lblOpciones);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setBounds(39, 181, 264, 81);
		panelOpciones.add(btnRegistrarse);
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarse.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnRegistrarse.setIcon(new ImageIcon(LobbyProfesorFRM.class.getResource("/imagenes/RegistrarseIcono.png")));
		
		setVisible(true);
	}
}
