package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ConectarSQL {

	private Connection conexion;
	
	public static void main(String[] args) {
		ConectarSQL xD = new ConectarSQL();
		/*String[] columnas = {"codigo","nombreprofe","nombreprueba","duracionprueba","cantidadpreguntas"};
		String[] valores = {"123","mauro","mate2","500","10"};
		String[] tipoValores = {"string","string","string","string","string"};
		xD.agregar("pruebas", columnas, valores, tipoValores);*/
	}
	
	public ConectarSQL() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + "proyecto2" + "?user="+ "Felipe&password=1234&useSSL=false");
            if(this.conexion.isValid(0)) {
            	//System.out.println("Conectado exitosamente.");
            }else {
            	Icon icono = new ImageIcon(getClass().getResource("/imagenes/error-icono.png"));
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al conectar a la base de datos","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
            }
        } catch (ClassNotFoundException e) {
        	Icon icono = new ImageIcon(getClass().getResource("/imagenes/error-icono.png"));
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al conectar a la base de datos","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
            System.out.println("Error al cargar controlador.");
            e.printStackTrace();
        } catch (SQLException e) {
        	Icon icono = new ImageIcon(getClass().getResource("/imagenes/error-icono.png"));
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al conectar a la base de datos","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
            System.out.println("No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
	}
	
	public boolean agregar(String tabla,String columnas[],String valores[],String tipoValores[]) {
		if(valores.length == tipoValores.length && columnas.length == valores.length && comprobarStringValores(tipoValores)) {
			try {
				String columnaPet = crearStringPeticion(columnas);
				PreparedStatement peticion = conexion.prepareStatement("INSERT INTO "+tabla+columnaPet);
				for(int i = 0;i<valores.length;i++) {
					if(tipoValores[i].toLowerCase().equals("string")) {
						peticion.setString(i+1,valores[i]);
					}
					if(tipoValores[i].toLowerCase().equals("int")){
						peticion.setInt(i+1,Integer.parseInt(valores[i]));
					}
				}
				int respuesta = peticion.executeUpdate();
				if(respuesta>0) {
					//Icon icono = new ImageIcon(getClass().getResource("/imagenes/success-icon.png"));
					//JOptionPane.showMessageDialog(null, "Se ha guardado con exito","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
					return true;
				} else {
					//Icon icono = new ImageIcon(getClass().getResource("/imagenes/error-icono.png"));
					//JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar","Mensaje",JOptionPane.PLAIN_MESSAGE,icono);
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Error al agregar: Uno o mas parametros erroneos, revisar parametros");
		}
		return false;
	}
	
	public boolean eliminarFila(String tabla,String nombreColumna,int numeroColumna,String datoFila) {
		try {
			PreparedStatement peticion = conexion.prepareStatement("DELETE FROM "+tabla+" WHERE "+nombreColumna+"=?");
			peticion.setString(numeroColumna,datoFila);
			int respuesta = peticion.executeUpdate();
			if(respuesta>0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean eliminarTablaPreguntas(String codigo) {
		try {
			PreparedStatement peticion = conexion.prepareStatement("DROP TABLE preguntas_"+codigo);
			peticion.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean eliminarTablaResultados(String codigo) {
		try {
			PreparedStatement peticion = conexion.prepareStatement("DROP TABLE resultados_"+codigo);
			peticion.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean eliminarTest(String nombreProfe,String codigo) {
		try {
			PreparedStatement peticion = conexion.prepareStatement("DELETE FROM pruebas WHERE nombreprofe=? AND codigo=?");
			peticion.setString(1,nombreProfe);
			peticion.setString(2, codigo);
			int respuesta = peticion.executeUpdate();
			if(respuesta>0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultadosVerf verificarVerResultados(String codigo,String nombreprofe) {
		PreparedStatement ps = null;
		ResultSet rs = 	null;
		String sql = "SELECT * FROM pruebas WHERE codigo=? AND nombreprofe=?";
		try {
			ps = conexion.prepareStatement(sql);
			ps.setString(1, codigo);
			ps.setString(2, nombreprofe);
			rs = ps.executeQuery();
			if(rs.next()) {
				return new ResultadosVerf(true,rs.getString("nombreprueba"));
			}else {
				return new ResultadosVerf(false," ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResultadosVerf(false," ");
	}
	
	public boolean Buscar(String tabla,String nombreColumna,String aBuscar){
		PreparedStatement ps = null;
		ResultSet rs = 	null;
		String sql = "SELECT * FROM "+tabla+" WHERE "+nombreColumna+"=?";
		try {
			ps = this.conexion.prepareStatement(sql);
			ps.setString(1, aBuscar);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public String getDatoString(String tabla,String nombreColumna,String aBuscar,String nombreColumnaDato) {
		PreparedStatement ps = null;
		ResultSet rs = 	null;
		String sql = "SELECT * FROM "+tabla+" WHERE "+nombreColumna+"=?";
		try {
			ps = this.conexion.prepareStatement(sql);
			ps.setString(1, aBuscar);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(nombreColumnaDato);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int getDatoInt(String tabla,String nombreColumna,String aBuscar,String nombreColumnaDato) {
		PreparedStatement ps = null;
		ResultSet rs = 	null;
		String sql = "SELECT * FROM "+tabla+" WHERE "+nombreColumna+"=?";
		try {
			ps = this.conexion.prepareStatement(sql);
			ps.setString(1, aBuscar);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(nombreColumnaDato);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public datosPregunta getDatosPregunta(String tabla,int aBuscar) {
		datosPregunta paquete = new datosPregunta();
		PreparedStatement ps = null;
		ResultSet rs = 	null;
		String sql = "SELECT * FROM "+tabla+" WHERE "+"numeroPregunta"+"=?";
		try {
			ps = this.conexion.prepareStatement(sql);
			ps.setInt(1, aBuscar);
			rs = ps.executeQuery();
			if(rs.next()) {
				paquete.nPreg = rs.getInt("numeroPregunta");
				paquete.tipoPreg = rs.getString("tipoPregunta").toLowerCase();
				paquete.enunciado = rs.getString("enunciado").toLowerCase();
				paquete.respCorrecta = rs.getString("respCorrecta").toLowerCase();
				paquete.alternativa1 = rs.getString("alternativa1").toLowerCase();
				paquete.alternativa2 = rs.getString("alternativa2").toLowerCase();
				paquete.alternativa3 = rs.getString("alternativa3").toLowerCase();
				paquete.alternativa4 = rs.getString("alternativa4").toLowerCase();
				paquete.puntaje = rs.getInt("puntaje");
				return paquete;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean verificarLogIn(String usuario, String password) {
		PreparedStatement ps = null;
		ResultSet rs = 	null;
		String sql = "SELECT * FROM usuarios WHERE nombreusuario =? AND passwordusuario =?";
		try {
			ps = this.conexion.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private String crearStringPeticion(String columnas[]) {
		String columnaPet = " (";
		for(int i = 0;i<columnas.length;i++) {
			if(i!=columnas.length-1) {
				columnaPet = columnaPet+columnas[i]+",";
			}else {
				columnaPet = columnaPet+columnas[i]+") ";
			}
		}
		columnaPet = columnaPet+"VALUES (";
		for(int j = 0;j<columnas.length;j++) {
			if(j!=columnas.length-1) {
				columnaPet = columnaPet+"?,";
			}else {
				columnaPet = columnaPet+"?)";
			}
		}
		return columnaPet;
	}
	
	private boolean comprobarStringValores(String valores[]) {
		for(int i = 0;i<valores.length;i++) {
			if(!valores[i].equalsIgnoreCase("string") && !valores[i].equalsIgnoreCase("int")) {
				return false;
			}
		}
		return true;
	}
	
	public boolean crearTablaPruebaNueva(String codigo) {
		Statement stm = null;
		try {
			String query = crearStringPrueba(codigo);	
			stm = conexion.createStatement();
			stm.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean crearTablaResultados(String codigo, int cantidadPreguntas) {
		Statement stm = null;
		try {
			String query = crearStringResultados(codigo,cantidadPreguntas);	
			stm = conexion.createStatement();
			stm.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public ArrayList<Object[]> ObtenerTablaPruebas(String nombreProfe){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ArrayList<Object[]> tabla = new ArrayList<>();
			String sql = "SELECT * FROM pruebas WHERE nombreprofe=?";
			ps = conexion.prepareStatement(sql);
			ps.setString(1, nombreProfe);
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMD = rs.getMetaData();
			int cantidadColumnas = rsMD.getColumnCount();
			
			while(rs.next()) {
				Object[] filas = new Object[cantidadColumnas];
				for(int i = 0; i< cantidadColumnas; i++) {
					filas[i] = rs.getObject(i+1);
				}
				tabla.add(filas);
			}
			return tabla;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Object[]> ObtenerTablaResultados(String codigo){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ArrayList<Object[]> tabla = new ArrayList<>();
			String sql = "SELECT * FROM resultados_"+codigo;
			ps = conexion.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsMD = rs.getMetaData();
			int cantidadColumnas = rsMD.getColumnCount();
			while(rs.next()) {
				Object[] filas = new Object[cantidadColumnas];
				for(int i = 0; i< cantidadColumnas; i++) {
					filas[i] = rs.getObject(i+1);
				}
				tabla.add(filas);
			}
			return tabla;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String crearStringResultados(String codigo,int cantidadPreguntas) {
		String query = "CREATE TABLE resultados_"+codigo+" ( "
				+ "rut VARCHAR(20) NOT NULL, ";
		for(int i = 1;i<=cantidadPreguntas;i++) {
			query = query+"resultadoP"+i+" VARCHAR(10) NOT NULL, ";
		}
		query = query +"puntajeObtenido INT NOT NULL,"
				+ " porcentajeObtenido INT NOT NULL,"
				+ " PRIMARY KEY (rut) )";
		return query;
	}
	
	private String crearStringPrueba(String codigo) {
		String query = "CREATE TABLE preguntas_"+codigo+" ( "
				+ "numeroPregunta INT NOT NULL, "
				+ "tipoPregunta VARCHAR(50) NOT NULL, "
				+ "enunciado VARCHAR(500) NOT NULL, "
				+ "respCorrecta VARCHAR(100) NOT NULL, "
				+ "alternativa1 VARCHAR(100), "
				+ "alternativa2 VARCHAR(100), "
				+ "alternativa3 VARCHAR(100), "
				+ "alternativa4 VARCHAR(100), "
				+ "puntaje INT NOT NULL ,"
				+ "PRIMARY KEY (numeroPregunta) )";
		return query;
	}

}
