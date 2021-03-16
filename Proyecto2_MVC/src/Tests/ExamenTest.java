package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Controlador.controladorPreguntaRespCortP;
import Controlador.preguntasPrueba;

public class ExamenTest {
	
	private preguntasPrueba[] preguntas;
	
	@Test
	public void testCrearStrings() {
		String[] resultados = CrearStrings(2);
		String[] esperados = {"Pregunta 1","Pregunta 2"};
		for(int i = 0;i<resultados.length;i++) {
			assertEquals(esperados[i],resultados[i]);
		}
	}
	
	@Test
	public void testPuntajeTotal() {
		preguntas = new preguntasPrueba[3];
		preguntas[0] = new controladorPreguntaRespCortP("Enunciadotxt", 1, "respCorrecta", 3);
		preguntas[1] = new controladorPreguntaRespCortP("Enunciadotxt",2,"respCorrecta", 2);
		preguntas[2] = new controladorPreguntaRespCortP("Enunciadotxt",3,"respCorrecta", 1);
		int resultado = puntajeTotal();
		int esperado = 6;
		assertEquals(esperado,resultado);
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
}
