package Controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import Vista.SeleccionFRM;

public class controladorSeleccion {
	SeleccionFRM ventana;
	
	public controladorSeleccion() {
		ventana = new SeleccionFRM();
		
		ventana.btnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.setVisible(false);
				controladorLobbyProfesor nuevaVentana = new controladorLobbyProfesor();
			}
		});
		
		ventana.btnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.setVisible(false);
				controladorCodigoPrueba ventanax = new controladorCodigoPrueba();
			}
		});
	}
}
