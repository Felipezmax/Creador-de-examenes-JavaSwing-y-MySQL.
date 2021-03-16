package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Modelo.ConectarSQL;
import Vista.Examen;

public class controladorExamen {
	private Examen ventana;
	private preguntasPrueba[] preguntas;
	public int correctas = 0;
	private String rut,codigo;
	private int puntajeObtenido = 0;
	private String[] estadosRespuesta,respCorrectas,respUsuario;
	private ConectarSQL conexion = new ConectarSQL();
	
	public controladorExamen(preguntasPrueba[] preguntas,int tiempoPrueba,String codigo,String rut) {
		this.rut=rut;
		this.codigo = codigo;
		this.estadosRespuesta = new String[preguntas.length];
		this.preguntas = new preguntasPrueba[preguntas.length];
		System.arraycopy(preguntas,0,this.preguntas,0,preguntas.length);
		
		ventana = new Examen(tiempoPrueba);
		agregarPanel(0);
		ventana.comboBox.setModel(new DefaultComboBoxModel(CrearStrings(preguntas.length)));
		ventana.comboBox.setSelectedIndex(0);
		
		iniciarTiempo(ventana.TiempoLbl);
		
		ventana.comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cambiarPanel) {
				ventana.layeredPane.removeAll();
				agregarPanel(ventana.comboBox.getSelectedIndex());;
				ventana.layeredPane.repaint();
				ventana.layeredPane.revalidate();
			}
		});
		
		ventana.finalizarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent fi) {
				finalizarExam();
			}
		});
		
		ventana.btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ventana.comboBox.getSelectedIndex()+1 <preguntas.length) {
					ventana.layeredPane.removeAll();
					agregarPanel(ventana.comboBox.getSelectedIndex()+1);
					ventana.layeredPane.repaint();
					ventana.layeredPane.revalidate();
					ventana.comboBox.setSelectedIndex(ventana.comboBox.getSelectedIndex()+1);
				}	
			}
		});
		
		ventana.btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ventana.comboBox.getSelectedIndex()-1 >-1) {
					ventana.layeredPane.removeAll();
					agregarPanel(ventana.comboBox.getSelectedIndex()-1);
					ventana.layeredPane.repaint();
					ventana.layeredPane.revalidate();
					ventana.comboBox.setSelectedIndex(ventana.comboBox.getSelectedIndex()-1);
				}	
			}
		});
	}
	
	void agregarPanel(int index) {
		if(preguntas[index].tipoPregunta.equals("alternativas")) {
			ventana.layeredPane.add(preguntas[index].altP);
		}
		if(preguntas[index].tipoPregunta.equals("respcorta")) {
			ventana.layeredPane.add(preguntas[index].rscP);
		}
		if(preguntas[index].tipoPregunta.equals("vof")) {
			ventana.layeredPane.add(preguntas[index].vofP);
		}
	}
	
	private void finalizarExam() {
		for(int i = 0;i<preguntas.length;i++) {
			preguntas[i].setRespUsuario();
			if(preguntas[i].getRespUsuario().equalsIgnoreCase(preguntas[i].getRespCorrecta())) {
				estadosRespuesta[i] = "correcta";
				puntajeObtenido = puntajeObtenido + preguntas[i].puntaje;
				correctas++;
			}else {
				estadosRespuesta[i] = "incorrecta";
			}
		}
		ventana.t.stop();
		System.out.println("Obtuvo un total de "+correctas+" preguntas correctas");
		guardarResultados();
		ventana.frame.setVisible(false);
	}
	
	private void guardarResultados() {
		String[] columnas = new String[preguntas.length+3];
		String[] valores = new String[preguntas.length+3];
		String[] tipoValores = new String[preguntas.length+3];
		
		columnas[0] = "rut";columnas[preguntas.length+1] = "puntajeObtenido";columnas[preguntas.length+2] = "porcentajeObtenido";
		valores[0] = rut;valores[preguntas.length+1] = String.valueOf(puntajeObtenido);valores[preguntas.length+2] = String.valueOf((puntajeObtenido*100)/puntajeTotal());
		tipoValores[0] = "string";tipoValores[preguntas.length+1] ="int";tipoValores[preguntas.length+2] = "int";
		for(int i = 0;i<preguntas.length;i++) {
			columnas[i+1] = "resultadoP"+(i+1);
			valores[i+1] = estadosRespuesta[i];
			tipoValores[i+1] = "string";
		}
		conexion.agregar("resultados_"+codigo, columnas, valores, tipoValores);
		rellenarRespuestas();
		controladorResultados nuevaVentana = new controladorResultados((puntajeObtenido*100)/puntajeTotal(),estadosRespuesta,respCorrectas,respUsuario);
	}
	
	private void rellenarRespuestas() {
		respCorrectas = new String[preguntas.length];
		respUsuario = new String[preguntas.length];
		for(int i = 0;i<preguntas.length;i++) {
			respCorrectas[i] = preguntas[i].respCorrecta.toLowerCase();
			respUsuario[i] = preguntas[i].respUsuario.toLowerCase();
		}
	}
	
	private String[] CrearStrings(int numero) {
		String[] cadena = new String[numero];
		for(int i = 0;i<numero;i++) {
			cadena[i] = "Pregunta "+(i+1);
		}
		return cadena;
	}
	
	private int puntajeTotal() {
		int puntajeTotal = 0;
		for(int i = 0;i<preguntas.length;i++) {
			puntajeTotal = puntajeTotal+preguntas[i].puntaje;
		}
		return puntajeTotal;
	}
	
	private void iniciarTiempo(JLabel TiempoLbl) {
		ventana.t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TiempoLbl.setText("Tiempo restante: "+(ventana.tiempoPrueba-ventana.tiempo)+" segundos");
				if(ventana.tiempoPrueba-ventana.tiempo <= ventana.tiempoPrueba/5) {
					TiempoLbl.setForeground(Color.red);
				}
				if(ventana.tiempoPrueba-ventana.tiempo <= 0) {
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/Exclamation-mark-icon.png"));
					JOptionPane.showMessageDialog(null, "TE HAS QUEDADO SIN TIEMPO","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
					finalizarExam();
				}
				ventana.tiempo++;
			}
		});
		ventana.t.start();
	}
}
