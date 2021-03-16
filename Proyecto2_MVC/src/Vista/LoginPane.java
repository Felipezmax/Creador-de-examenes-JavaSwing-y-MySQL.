package Vista;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;



public class LoginPane extends JPanel {
	public JTextField txtUsuario;
	public JPasswordField campoContrase�a;
	public JLabel lblAlertaContra;
	public JLabel lblAlertaUsuario;
	public JButton botonLogin;

	public LoginPane(JFrame ventanaMain) {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
		
		JSeparator separadorContrase�a = new JSeparator();
		separadorContrase�a.setForeground(Color.BLACK);
		separadorContrase�a.setBackground(Color.BLACK);
		separadorContrase�a.setBounds(86, 289, 421, 9);
		add(separadorContrase�a);
		
		JLabel usuarioLbl = new JLabel("USUARIO:");
		usuarioLbl.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		usuarioLbl.setBounds(86, 79, 229, 41);
		add(usuarioLbl);
		
		campoContrase�a = new JPasswordField();
		campoContrase�a.setFont(new Font("Tahoma", Font.BOLD, 18));
		campoContrase�a.setForeground(SystemColor.black);
		campoContrase�a.setBorder(null);
		campoContrase�a.setOpaque(false);
		campoContrase�a.setText("textoDeEjemplo");
		campoContrase�a.setBounds(86, 259, 421, 41);
		add(campoContrase�a);
        
		txtUsuario = new JTextField("Ingrese su usuario...");
		txtUsuario.setBorder(null);
		setForeground(SystemColor.textText);
		txtUsuario.setForeground(SystemColor.textInactiveText);
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtUsuario.setOpaque(false);
		txtUsuario.setBounds(86, 130, 421, 41);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JSeparator separadorUsuario = new JSeparator();
		separadorUsuario.setBackground(new Color(0, 0, 0));
		separadorUsuario.setForeground(new Color(0, 0, 0));
		separadorUsuario.setBounds(86, 162, 421, 9);
		add(separadorUsuario);
		
		JLabel iconoUsuario = new JLabel("");
		iconoUsuario.setIcon(new ImageIcon(LoginPane.class.getResource("/imagenes/UserIcono.png")));
		iconoUsuario.setBounds(21, 109, 67, 62);
		add(iconoUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:");
		lblContrasea.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblContrasea.setBounds(86, 208, 229, 41);
		add(lblContrasea);
		
		JLabel contrase�aIcono = new JLabel("");
		contrase�aIcono.setIcon(new ImageIcon(LoginPane.class.getResource("/imagenes/Contrase\u00F1aIcono.png")));
		contrase�aIcono.setBounds(21, 238, 67, 62);
		add(contrase�aIcono);
		
		botonLogin = new JButton("INGRESAR");
		botonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		botonLogin.setHorizontalAlignment(SwingConstants.LEFT);
		botonLogin.setIcon(new ImageIcon(LoginPane.class.getResource("/imagenes/Login64x64Icono.png")));
		botonLogin.setBounds(181, 364, 215, 73);
		add(botonLogin);
		
		JLabel TituloLbl = new JLabel("LOGIN");
		TituloLbl.setBackground(new Color(30, 144, 255));
		TituloLbl.setOpaque(true);
		TituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TituloLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		TituloLbl.setBounds(0, 0, 575, 41);
		add(TituloLbl);
		
		lblAlertaUsuario = new JLabel("");
		lblAlertaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaUsuario.setIcon(new ImageIcon(LoginPane.class.getResource("/imagenes/warnin32X32Icono.png")));
		lblAlertaUsuario.setBounds(517, 109, 46, 48);
		lblAlertaUsuario.setVisible(false);
		add(lblAlertaUsuario);
		
		lblAlertaContra = new JLabel("");
		lblAlertaContra.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaContra.setIcon(new ImageIcon(LoginPane.class.getResource("/imagenes/warnin32X32Icono.png")));
		lblAlertaContra.setBounds(517, 238, 46, 48);
		lblAlertaContra.setVisible(false);
		add(lblAlertaContra);
		this.setVisible(true);
	}

}
