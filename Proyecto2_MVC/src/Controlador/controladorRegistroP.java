package Controlador;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Modelo.ConectarSQL;
import Vista.RegistroPane;

public class controladorRegistroP {
	
	public static RegistroPane RegistroP;
	private ConectarSQL conexion = new ConectarSQL();
	
	public controladorRegistroP() {
		RegistroP = new RegistroPane();
		
		RegistroP.txtUsuario.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                RegistroP.txtUsuario.setForeground(SystemColor.black);
                source.removeFocusListener(this);
            }
        });
		
		RegistroP.btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarDatos()) {
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/success-icon.png"));
					JOptionPane.showMessageDialog(null, "Se ha registrado con exito","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}
			}
		});
	}
	
	private boolean verificarDatos() {
		boolean usuario = verificarUsuario();
		boolean contraseña1 = verificarContraseña1();
		boolean contraseña2 = verificarContraseña2();
		if(usuario && contraseña1 && contraseña2) {
			String[] columnas = {"nombreusuario","passwordusuario"};
			String[] valores = {RegistroPane.txtUsuario.getText(),RegistroPane.campoContraseña1.getText()};
			String[] tipoValores = {"string","string"};
			if(conexion.agregar("usuarios", columnas, valores, tipoValores)){
				return true;
			}else {
				Icon icono = new ImageIcon(getClass().getResource("Exclamation-mark-icon.png"));
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrarse","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
			}
		}
		return false;
	}
	
	private boolean verificarContraseña2() {
		if(!RegistroPane.campoContraseña2.getText().equals(RegistroPane.campoContraseña1.getText())) {
			RegistroPane.lblAlertaC2.setToolTipText("Las contraseñas no son iguales");
			RegistroPane.lblAlertaC2.setVisible(true);
			return false;
		}
		RegistroPane.lblAlertaC2.setToolTipText("");
		RegistroPane.lblAlertaC2.setVisible(false);
		return true;
	}
	
	private boolean verificarContraseña1() {
		if(RegistroPane.campoContraseña1.getText().length()>20) {
			RegistroPane.lblAlertaC1.setToolTipText("Se excede la cantidad de caracteres maxima");
			RegistroPane.lblAlertaC1.setVisible(true);
			return false;
		}
		if(RegistroPane.campoContraseña1.getText().equals("")) {
			RegistroPane.lblAlertaC1.setToolTipText("No ha escrito nada");
			RegistroPane.lblAlertaC1.setVisible(true);
			return false;
		}
		RegistroPane.lblAlertaC1.setToolTipText("");
		RegistroPane.lblAlertaC1.setVisible(false);
		return true;
	}
	
	private boolean verificarUsuario() {
		if(RegistroPane.txtUsuario.getText().length()>15) {
			RegistroPane.lblAlertaUsuario.setToolTipText("Se excede cantidad de caracteres maxima");
			RegistroPane.lblAlertaUsuario.setVisible(true);
			return false;
		}
		if(RegistroPane.txtUsuario.getText().equals("")) {
			RegistroPane.lblAlertaUsuario.setToolTipText("No ha escrito nada");
			RegistroPane.lblAlertaUsuario.setVisible(true);
			return false;
		}
		if(!RegistroPane.txtUsuario.getText().matches("[a-zA-Z0-9ñ]{1,15}")) {
			RegistroPane.lblAlertaUsuario.setToolTipText("Hay caracteres invalidos");
			RegistroPane.lblAlertaUsuario.setVisible(true);
			return false;
		}
		if(conexion.Buscar("usuarios","nombreusuario",RegistroPane.txtUsuario.getText())) {
			RegistroPane.lblAlertaUsuario.setToolTipText("Este usuario ya existe, elija otro nombre");
			RegistroPane.lblAlertaUsuario.setVisible(true);
			return false;
		}
		RegistroPane.lblAlertaUsuario.setToolTipText("");
		RegistroPane.lblAlertaUsuario.setVisible(false);
		return true;
	}
}
