package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import org.junit.Test;

import Controlador.controladorInfoPreguntaP;

public class CrearTestTest {
	
	private ArrayList<controladorInfoPreguntaP> preguntas = new ArrayList<>();
	private controladorInfoPreguntaP pregunta1 = new controladorInfoPreguntaP();
	
	
	
	@Test
	public void testVerificar() {
		pregunta1.enunciado = "testeo";
		pregunta1.alternativas[0] = "a";pregunta1.alternativas[1] = "b";pregunta1.alternativas[2] = "c";pregunta1.alternativas[3] = "d";
		pregunta1.respCorrecta = "algo";
		pregunta1.puntaje = 2;
		pregunta1.panel.tipoPreguntaCB.setModel(new DefaultComboBoxModel(new String[] {"Algo", "OtroAlgo"}));
		pregunta1.panel.tipoPreguntaCB.setSelectedIndex(0);
		preguntas.add(pregunta1);
		boolean resultado = verificar();
		boolean esperado = true;
		assertEquals(esperado,resultado);
		pregunta1.enunciado = "";
		esperado = false;
		resultado = verificar();
		assertEquals(esperado,resultado);
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
}
