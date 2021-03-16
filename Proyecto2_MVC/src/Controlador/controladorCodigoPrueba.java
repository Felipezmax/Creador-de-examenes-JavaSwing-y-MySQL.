package Controlador;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Modelo.ConectarSQL;
import Modelo.datosPregunta;
import Vista.CodigoPruebaFRM;

public class controladorCodigoPrueba {
	
	private ConectarSQL conexion;
	CodigoPruebaFRM ventana;
	
	public controladorCodigoPrueba() {
		conexion = new ConectarSQL();
		
		ventana = new CodigoPruebaFRM();
		
        ventana.rutTF.getVerifyInputWhenFocusTarget();
		ventana.rutTF.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                ventana.rutTF.setText("");
                ventana.rutTF.setForeground(SystemColor.black);
                source.removeFocusListener(this);
            }
        });
		
		AbstractAction onEnter_codigo = new AbstractAction() {
            private static final long serialVersionUID = 1L;
            @Override
            public void actionPerformed(ActionEvent e) {
            	ventana.btnBuscar.doClick();
            }
        };
        ventana.codigoTextField.addActionListener(onEnter_codigo);
        
        ventana.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarRut()) {
					if(conexion.Buscar("pruebas","codigo",ventana.codigoTextField.getText())) {
						Icon icono = new ImageIcon(getClass().getResource("/imagenes/success-icon.png"));
						JOptionPane.showMessageDialog(null, "Examen encontrado","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
						crearPreguntas();
					}else {
						Icon icono = new ImageIcon(getClass().getResource("/imagenes/Exclamation-mark-icon.png"));
						JOptionPane.showMessageDialog(null, "Examen no encontrado","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
					}
				}else {
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/Exclamation-mark-icon.png"));
					JOptionPane.showMessageDialog(null, "Rut invalido","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}
			}
		});
        ventana.btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.setVisible(false);
				controladorSeleccion nuevaVentana = new controladorSeleccion();
			}
		});
	}
	
	private boolean verificarRut() {
		if(ventana.rutTF.getText().charAt(0) == '0') {
			return false;
		}
		if(ventana.rutTF.getText().matches("[0-9]{1,2}[.][1-9][0-9]{2}[.][1-9][0-9]{2}[-]([1-9]|(k|K))")) {
			return true;
		}
		return false;
	}
	
	private void crearPreguntas() {
		String codigo = ventana.codigoTextField.getText();
		preguntasPrueba[] preguntas = new preguntasPrueba[conexion.getDatoInt("pruebas","codigo",codigo,"cantidadPreguntas")];
		for(int i = 0;i<preguntas.length;i++) {
			datosPregunta paquete = conexion.getDatosPregunta("preguntas_"+codigo,i+1);
			if(paquete.tipoPreg.equalsIgnoreCase("alternativas")) {
				String[] respuestas = new String[4];
				respuestas[0] = paquete.alternativa1;respuestas[1] = paquete.alternativa2;
				respuestas[2] = paquete.alternativa3;respuestas[3] = paquete.alternativa4;
				preguntas[i] = new controladorPreguntaAltrP(paquete.enunciado,paquete.nPreg,paquete.respCorrecta,respuestas,paquete.puntaje);
				preguntas[i].tipoPregunta = "alternativas";
			}
			if(paquete.tipoPreg.equalsIgnoreCase("respcorta")) {
				preguntas[i] = new controladorPreguntaRespCortP(paquete.enunciado,paquete.nPreg,paquete.respCorrecta,paquete.puntaje);
				preguntas[i].tipoPregunta = "respcorta";
			}
			if(paquete.tipoPreg.equalsIgnoreCase("vof")) {
				preguntas[i] = new controladorPreguntaVoFP(paquete.enunciado,paquete.nPreg,paquete.respCorrecta,paquete.puntaje);
				preguntas[i].tipoPregunta = "vof";
			}
		}
		controladorExamen nuevaVentana = new controladorExamen(preguntas,conexion.getDatoInt("pruebas","codigo", codigo,"duracionprueba"),codigo,ventana.rutTF.getText());
		ventana.setVisible(false);
	}
}
