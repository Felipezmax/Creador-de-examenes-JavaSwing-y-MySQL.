package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.ConectarSQL;

public class ConectarSQLTest {
	ConectarSQL conexion = new ConectarSQL();
	
	@Test
	public void testAgregar() {
		System.out.println("agregar");
		String[] columnas = {"nombreusuario","passwordusuario"};
		String[] valores = {"xelipe","algo"};
		String[] tipoValores = {"string","string"};
		boolean resultado = conexion.agregar("usuarios", columnas, valores, tipoValores);
		boolean esperado = true;
		assertEquals(esperado,resultado);
	}

	@Test
	public void testGetDato() {
		System.out.println("getDato");
		String resultado = conexion.getDatoString("usuarios", "nombreusuario", "xelipe", "passwordusuario");
		String esperado = "algo";
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void testEliminar() {
		System.out.println("eliminar");
		boolean resultado = conexion.eliminarFila("usuarios","nombreusuario", 1, "xelipe");
		boolean esperado = true;
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void testBuscar() {
		System.out.println("Buscar");
		boolean resultado = conexion.Buscar("usuarios","nombreusuario","xelipe");
		boolean esperado = false;
		assertEquals(esperado,resultado);
	}

}
