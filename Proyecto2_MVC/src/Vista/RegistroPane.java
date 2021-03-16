package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class RegistroPane extends JPanel {
	public static JTextField txtUsuario;
	public static JPasswordField campoContrase�a1;
	public static JPasswordField campoContrase�a2;
	public static JLabel lblAlertaUsuario;
	public static JLabel lblAlertaC2;
	public static JLabel lblAlertaC1;
	public JButton btnRegistrarse;

	public RegistroPane() {
		setBackground(new Color(0, 191, 255));
		setBounds(0,0,575,501);
		setLayout(null);
		
		JButton fakeButton = new JButton("fake");
        add(fakeButton);
        fakeButton.requestFocusInWindow();
		
		JSeparator separadorTitulo = new JSeparator();
		separadorTitulo.setForeground(new Color(0, 0, 0));
		separadorTitulo.setBackground(new Color(0, 0, 0));
		separadorTitulo.setBounds(0, 39, 575, 2);
		add(separadorTitulo);
		
		JLabel TituloLbl = new JLabel("REGISTRO");
		TituloLbl.setBackground(new Color(30, 144, 255));
		TituloLbl.setOpaque(true);
		TituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TituloLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		TituloLbl.setBounds(0, 0, 575, 41);
		add(TituloLbl);
		this.setVisible(true);
		
		JSeparator separadorUsuario = new JSeparator();
		separadorUsuario.setBackground(new Color(0, 0, 0));
		separadorUsuario.setForeground(new Color(0, 0, 0));
		separadorUsuario.setBounds(86, 162, 406, 9);
		add(separadorUsuario);
		
		txtUsuario = new JTextField("Ingrese su usuario...");
		txtUsuario.setToolTipText("\r\nSolo se admiten letras dentro de [a-z] [A-Z] [0-1] o �, maximo 15 letras.");
		txtUsuario.setBorder(null);
		setForeground(SystemColor.textText);
		txtUsuario.setForeground(SystemColor.textInactiveText);
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtUsuario.setOpaque(false);
		txtUsuario.setBounds(86, 130, 406, 41);
		txtUsuario.getVerifyInputWhenFocusTarget();
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		campoContrase�a1 = new JPasswordField();
		campoContrase�a1.setToolTipText("Cantidad maxima de caracteres 20.");
		campoContrase�a1.setBorder(null);
		campoContrase�a1.setOpaque(false);
		campoContrase�a1.setBounds(86, 215, 406, 41);
		add(campoContrase�a1);
		
		campoContrase�a2 = new JPasswordField();
		campoContrase�a2.setToolTipText("Las contrase\u00F1as deben ser iguales.");
		campoContrase�a2.setBorder(null);
		campoContrase�a2.setOpaque(false);
		campoContrase�a2.setBounds(86, 306, 406, 41);
		add(campoContrase�a2);
		
		JLabel usuarioLbl = new JLabel("Nombre Usuario:");
		usuarioLbl.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		usuarioLbl.setBounds(86, 92, 229, 41);
		add(usuarioLbl);
		
		JLabel lblContrasea1 = new JLabel("Contrase\u00F1a:");
		lblContrasea1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblContrasea1.setBounds(86, 182, 173, 41);
		add(lblContrasea1);
		
		JLabel lblContrasea2 = new JLabel("Repetir Contrase\u00F1a:");
		lblContrasea2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblContrasea2.setBounds(86, 272, 229, 41);
		add(lblContrasea2);
		
		JSeparator separadorContrase�a_1 = new JSeparator();
		separadorContrase�a_1.setForeground(Color.BLACK);
		separadorContrase�a_1.setBackground(Color.BLACK);
		separadorContrase�a_1.setBounds(86, 245, 406, 9);
		add(separadorContrase�a_1);
		
		JSeparator separadorContrase�a_2 = new JSeparator();
		separadorContrase�a_2.setForeground(Color.BLACK);
		separadorContrase�a_2.setBackground(Color.BLACK);
		separadorContrase�a_2.setBounds(86, 336, 406, 9);
		add(separadorContrase�a_2);
		
		lblAlertaUsuario = new JLabel("");
		lblAlertaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaUsuario.setIcon(new ImageIcon(RegistroPane.class.getResource("/imagenes/warningIcono.png")));
		lblAlertaUsuario.setBounds(500, 130, 46, 41);
		lblAlertaUsuario.setVisible(false);
		add(lblAlertaUsuario);
		
		lblAlertaC1 = new JLabel("");
		lblAlertaC1.setIcon(new ImageIcon(RegistroPane.class.getResource("/imagenes/warningIcono.png")));
		lblAlertaC1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaC1.setBounds(500, 215, 46, 41);
		lblAlertaC1.setVisible(false);
		add(lblAlertaC1);
		
		lblAlertaC2 = new JLabel("");
		lblAlertaC2.setIcon(new ImageIcon(RegistroPane.class.getResource("/imagenes/warningIcono.png")));
		lblAlertaC2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaC2.setBounds(500, 288, 46, 41);
		lblAlertaC2.setVisible(false);
		add(lblAlertaC2);
		
		JLabel lblIconoUsuario = new JLabel("");
		lblIconoUsuario.setIcon(new ImageIcon(RegistroPane.class.getResource("/imagenes/userRegistroIcono.png")));
		lblIconoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoUsuario.setBounds(30, 130, 46, 41);
		add(lblIconoUsuario);
		
		JLabel lblIconoC1 = new JLabel("");
		lblIconoC1.setIcon(new ImageIcon(RegistroPane.class.getResource("/imagenes/passwordRegistro.png")));
		lblIconoC1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoC1.setBounds(30, 206, 46, 48);
		add(lblIconoC1);
		
		JLabel lblIconoC2 = new JLabel("");
		lblIconoC2.setIcon(new ImageIcon(RegistroPane.class.getResource("/imagenes/passwordRegistro.png")));
		lblIconoC2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoC2.setBounds(30, 306, 46, 41);
		add(lblIconoC2);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarse.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
		btnRegistrarse.setIcon(new ImageIcon(RegistroPane.class.getResource("/imagenes/registrarseConfirmacionIcono.png")));
		btnRegistrarse.setBounds(167, 396, 253, 66);
		add(btnRegistrarse);
	}
	
}
