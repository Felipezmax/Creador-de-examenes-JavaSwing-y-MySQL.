package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.LobbyProfesorFRM;

public class controladorLobbyProfesor {
	
	LobbyProfesorFRM ventana;
	controladorLoginP panelLog;
	controladorRegistroP panelReg;
	
	public controladorLobbyProfesor() {
		ventana = new LobbyProfesorFRM();
		panelLog = new controladorLoginP(ventana);
		panelReg = new controladorRegistroP();
		
		ventana.layeredPane.add(panelLog.panel);
		ventana.layeredPane.setName("panelDeLogin");
		
		ventana.btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.setVisible(false);
				controladorSeleccion NuevaVentana = new controladorSeleccion();
			}
		});
		
		ventana.btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ventana.layeredPane.getName().equalsIgnoreCase("panelDeLogin")) {
					ventana.layeredPane.removeAll();
					ventana.layeredPane.add(panelLog.panel);
					ventana.layeredPane.repaint();
					ventana.layeredPane.revalidate();
					ventana.layeredPane.setName("panelDeLogin");
				}
			}
		});
		
		ventana.btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ventana.layeredPane.getName().equalsIgnoreCase("panelDeRegistro")) {
					ventana.layeredPane.removeAll();
					ventana.layeredPane.add(panelReg.RegistroP);
					ventana.layeredPane.repaint();
					ventana.layeredPane.revalidate();
					ventana.layeredPane.setName("panelDeRegistro");
				}
			}
		});
	}
	
}
