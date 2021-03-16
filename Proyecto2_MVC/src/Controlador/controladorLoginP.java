package Controlador;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Modelo.ConectarSQL;
import Vista.LoggedFRM;
import Vista.LoginPane;

public class controladorLoginP {
	
	public static LoginPane panel;
	private ConectarSQL conexion = new ConectarSQL();
	
	public controladorLoginP(JFrame ventanaMain) {
		panel = new LoginPane(ventanaMain);
		
		panel.campoContraseña.getVerifyInputWhenFocusTarget();
		AbstractAction onEnter_contraseña = new AbstractAction() {
            private static final long serialVersionUID = 1L;
            @Override
            public void actionPerformed(ActionEvent e) {
               panel.botonLogin.doClick();
            }
        };
        panel.campoContraseña.addActionListener(onEnter_contraseña);
        
        panel.campoContraseña.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        
        AbstractAction onEnter_txtUsuario = new AbstractAction() {
            private static final long serialVersionUID = 1L;
            @Override
            public void actionPerformed(ActionEvent e) {
            	panel.campoContraseña.requestFocusInWindow();
            }
        };
        panel.txtUsuario.addActionListener(onEnter_txtUsuario);
        
        panel.txtUsuario.getVerifyInputWhenFocusTarget();
		panel.txtUsuario.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                panel.txtUsuario.setText("");
                panel.txtUsuario.setForeground(SystemColor.black);
                source.removeFocusListener(this);
            }
        });
		
		panel.botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkDatos()) {
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/success-icon.png"));
					JOptionPane.showMessageDialog(null, "Bienvenido "+panel.txtUsuario.getText(),"Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
					ventanaMain.setVisible(false);
					controladorLogged nuevaVentana = new controladorLogged(panel.txtUsuario.getText());
				}
			}
		});
	}
	
	private boolean checkDatos() {
		boolean usuario = checkUsuario();
		if(usuario) {
			boolean password = checkPassword();
			if(password) {
				panel.lblAlertaContra.setToolTipText("");
				panel.lblAlertaContra.setVisible(false);				
				return true;
			}else {
				panel.lblAlertaContra.setToolTipText("Contraseña incorrecta");
				panel.lblAlertaContra.setVisible(true);
				return false;
			}
		}
		return false;
	}
	
	private boolean checkUsuario() {
		if(conexion.Buscar("usuarios","nombreusuario",panel.txtUsuario.getText())) {
			panel.lblAlertaUsuario.setToolTipText("");
			panel.lblAlertaUsuario.setVisible(false);
			return true;
		}else {
			panel.lblAlertaUsuario.setToolTipText("El usuario no existe");
			panel.lblAlertaUsuario.setVisible(true);
			panel.lblAlertaContra.setToolTipText("");
			panel.lblAlertaContra.setVisible(false);				
			return false;
		}
	}
	
	private boolean checkPassword(){
		if(conexion.verificarLogIn(panel.txtUsuario.getText(), panel.campoContraseña.getText())) {
			return true;
		}
		return false;
	}
	
}
