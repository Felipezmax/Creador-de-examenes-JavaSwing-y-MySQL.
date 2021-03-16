package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class CodigoPruebaTest {
	
	@Test
	public void testVerificarRut() {
		boolean[] resultados = new boolean[10];
		boolean[] esperados = new boolean[10];
		resultados[0] = verificarRutString("20.211.828-3");  esperados[0] = true;
		resultados[1] = verificarRutString("20.211.828--3"); esperados[1] = false;
		resultados[2] = verificarRutString("20.211.828-3k"); esperados[2] = false;
		resultados[3] = verificarRutString("2.211.828-3");   esperados[3] = true;
		resultados[4] = verificarRutString("0.211.828-3");   esperados[4] = false;
		resultados[5] = verificarRutString("2011.828-3");    esperados[5] = false;
		resultados[6] = verificarRutString("20.21128-3");    esperados[6] = false;
		resultados[7] = verificarRutString("20211828-3");    esperados[7] = false;
		resultados[8] = verificarRutString("20.11.828-3");   esperados[8] = false;
		resultados[9] = verificarRutString("20.111.28-3");   esperados[9] = false;
		for(int i = 0;i<resultados.length;i++) {
			assertEquals(esperados[i],resultados[i]);
		}
	}
	
	private boolean verificarRutString(String aVerificar) {
		if(aVerificar.charAt(0) == '0') {
			return false;
		}
		if(aVerificar.matches("[0-9]{1,2}[.][0-9]{3}[.][0-9]{3}[-]([1-9]|(k|K))")) {
			return true;
		}
		return false;
	}

}
