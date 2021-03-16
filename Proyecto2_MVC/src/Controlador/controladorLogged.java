package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.CrearTestPane;
import Vista.LobbyProfesorFRM;
import Vista.LoggedFRM;
import Vista.VerPruebasPane;
import Vista.VerResultadosPruebasPane;

public class controladorLogged {
	String nombreUsuario;
	LoggedFRM ventana;
	controladorCrearTestP panelTest;
	controladorVerPruebasPane panelVerPruebas;
	controladorVerResultadosP panelVerResultados;

	public controladorLogged(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
		ventana = new LoggedFRM(nombreUsuario);
		panelTest = new controladorCrearTestP(nombreUsuario);
		panelVerPruebas = new controladorVerPruebasPane(nombreUsuario);
		panelVerResultados = new controladorVerResultadosP(nombreUsuario);
		ventana.layeredPane.add(panelTest.panel);
		
		ventana.btnNuevoTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.layeredPane.removeAll();
				ventana.layeredPane.add(panelTest.panel);
				ventana.layeredPane.repaint();
				ventana.layeredPane.revalidate();
			}
		});
		
		ventana.btnVerPruebas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.layeredPane.removeAll();
				ventana.layeredPane.add(panelVerPruebas.panel);
				ventana.layeredPane.repaint();
				ventana.layeredPane.revalidate();
			}
		});
		
		ventana.btnVerResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.layeredPane.removeAll();
				ventana.layeredPane.add(panelVerResultados.panel);
				ventana.layeredPane.repaint();
				ventana.layeredPane.revalidate();
			}
		});
		
		ventana.btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.setVisible(false);
				controladorLobbyProfesor NuevaVentana = new controladorLobbyProfesor();
			}
		});
	}
	
}
