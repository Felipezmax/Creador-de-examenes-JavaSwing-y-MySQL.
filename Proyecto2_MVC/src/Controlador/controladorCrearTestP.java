package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Modelo.ConectarSQL;
import Vista.CrearTestPane;
import Vista.InfoPreguntaPane;

public class controladorCrearTestP {
	public static CrearTestPane panel;
	private ConectarSQL conexion = new ConectarSQL();
	private ArrayList<controladorInfoPreguntaP> preguntas = new ArrayList<>();
	private String nombreProf;
	
	public controladorCrearTestP(String nombreProfe) {
		panel = new CrearTestPane();
		
		preguntas.add(new controladorInfoPreguntaP());
		panel.layeredPane.add(preguntas.get(0).panel);
		panel.PreguntaActualCB.setModel(new DefaultComboBoxModel(crearStrings()));
		
		nombreProf = nombreProfe;
		
		panel.btnAddPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(preguntas.isEmpty() || verificar()) {
					preguntas.add(new controladorInfoPreguntaP());
					panel.PreguntaActualCB.setModel(new DefaultComboBoxModel(crearStrings()));
					panel.layeredPane.removeAll();
					panel.layeredPane.add(preguntas.get(preguntas.size()-1).panel);
					panel.layeredPane.repaint();
					panel.layeredPane.revalidate();
					panel.PreguntaActualCB.setSelectedIndex(preguntas.size()-1);
				}else {
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/Exclamation-mark-icon.png"));
					JOptionPane.showMessageDialog(null, "Hay campos vacios","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}
			}
		});
		
		panel.btnQuitarPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(preguntas.size()>1) {
					panel.layeredPane.removeAll();
					if(panel.PreguntaActualCB.getSelectedIndex() != 0) {
						panel.layeredPane.add(preguntas.get(preguntas.size()-2).panel);
					}else {
						panel.layeredPane.add(preguntas.get(1).panel);
					}
					panel.layeredPane.repaint();
					panel.layeredPane.revalidate();
					preguntas.remove(panel.PreguntaActualCB.getSelectedIndex());
					panel.PreguntaActualCB.setModel(new DefaultComboBoxModel(crearStrings()));
					panel.PreguntaActualCB.setSelectedIndex(preguntas.size()-1);
				}else {
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/Exclamation-mark-icon.png"));
					JOptionPane.showMessageDialog(null, "No se pueden borrar mas preguntas","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}
			}
		});
		
		panel.PreguntaActualCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.layeredPane.removeAll();
				panel.layeredPane.add(preguntas.get(panel.PreguntaActualCB.getSelectedIndex()).panel);
				panel.layeredPane.repaint();
				panel.layeredPane.revalidate();
			}
		});
		
		panel.btnCrearTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(crearPrueba()) {
					resetear();
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/success-icon.png"));
					JOptionPane.showMessageDialog(null,"Se ha creado la prueba con exito","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}else {
					Icon icono = new ImageIcon(getClass().getResource("/imagenes/Exclamation-mark-icon.png"));
					JOptionPane.showMessageDialog(null,"No se cumplen los requisitos","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
				}
			}
		});
		
		panel.spinner.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
					try {
						panel.spinner.commitEdit();
						if((int)panel.spinner.getValue()<1) {
							panel.spinner.setValue(Integer.valueOf(1));
						}
					} catch (ParseException a) {
						a.printStackTrace();
					}
			}
		});
	}
	
	private boolean verificar() {
		for(int i = 0; i<preguntas.size();i++) {
			if(preguntas.get(i).enunciado.equals("") || preguntas.get(i).respCorrecta.equals("") || preguntas.get(i).puntaje<1) {
				return false;
			}
			if(preguntas.get(i).panel.tipoPreguntaCB.getSelectedIndex() == 0) {
				for(int j = 0;j<4;j++) {
					if(preguntas.get(i).alternativas[j].equals("")) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private boolean verificarPrueba() {
		if(verificar() && !panel.nombrePruebaTF.getText().equals("") && (int)panel.spinner.getValue()>0 ) {
			return true;
		}
		return false;
	}
	
	private String[] crearStrings() {
		String[] strings = new String[preguntas.size()];
		for(int i = 0;i<strings.length;i++) {
			strings[i] = "Pregunta "+ (i+1);
		}
		return strings;
	}
	
	private String crearCodigo() {
		char[] caracteres = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','t','u','v','x','y','z',
				'0','1','2','3','4','5','6','7','8','9'};
		String codigo = "";
		for(int i = 0;i<15;i++) {
			int numero = ThreadLocalRandom.current().nextInt(0, caracteres.length);
			codigo = codigo+ caracteres[numero];
		}
		return codigo;
	}
	
	private boolean crearPrueba() {
		if(verificarPrueba()) {
			String codigo = "";
			while(true) {
				codigo = crearCodigo();
				if(!conexion.Buscar("pruebas","codigo",codigo)) {
					break;
				}
			}
			String[] columnas = {"codigo","nombreprofe","nombreprueba","duracionprueba","cantidadpreguntas"};
			String[] valores = {codigo,nombreProf.toLowerCase(),panel.nombrePruebaTF.getText(),String.valueOf(panel.spinner.getValue()),String.valueOf(preguntas.size())};
			String[] tipoValores = {"string","string","string","int","int"};
			if(conexion.agregar("pruebas", columnas, valores,tipoValores)) {
				if(!conexion.crearTablaPruebaNueva(codigo) || !conexion.crearTablaResultados(codigo, preguntas.size())) {
					return false;
				}
				String[] columnas2 = {"numeroPregunta","tipoPregunta","enunciado","respCorrecta","alternativa1","alternativa2","alternativa3","alternativa4","puntaje"};
				String[] tipoValores2 = {"int","string","string","string","string","string","string","string","int"};
				String[] valores2 = new String[columnas2.length];
				for(int i = 0; i<preguntas.size();i++) {
					valores2[0] = Integer.toString(i+1);valores2[1] = preguntas.get(i).tipoPregunta;valores2[2] = preguntas.get(i).enunciado;
					valores2[3] = preguntas.get(i).respCorrecta;valores2[4] = preguntas.get(i).alternativas[0];valores2[5] =  preguntas.get(i).alternativas[1];
					valores2[6] =  preguntas.get(i).alternativas[2] ;valores2[7] =  preguntas.get(i).alternativas[3] ;valores2[8] = Integer.toString(preguntas.get(i).puntaje);
					if(!conexion.agregar("preguntas_"+codigo.toLowerCase(),columnas2,valores2,tipoValores2)) {
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	private void resetear() {
		panel.nombrePruebaTF.setText("");
		panel.spinner.setValue(Integer.valueOf(1));
		for(int i = 0;i<preguntas.size();i++) {
			preguntas.remove(i);
			i--;
		}
		preguntas.add(new controladorInfoPreguntaP());
		panel.PreguntaActualCB.setModel(new DefaultComboBoxModel(crearStrings()));
		panel.layeredPane.removeAll();
		panel.layeredPane.add(preguntas.get(0).panel);
		panel.layeredPane.repaint();
		panel.layeredPane.revalidate();
	}
}
