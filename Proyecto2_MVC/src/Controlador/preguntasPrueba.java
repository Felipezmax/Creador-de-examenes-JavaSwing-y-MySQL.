package Controlador;

import java.awt.Component;

import javax.swing.JPanel;

import Vista.PreguntaAltrPane;
import Vista.PreguntaRespCortPane;
import Vista.PreguntaVofPane;

public abstract class preguntasPrueba{
	
	public String Enunciadotxt;
	public int numeroPregunta;
	public String respCorrecta;
	public String respUsuario;
	public String tipoPregunta;
	public int puntaje;
	public PreguntaAltrPane altP;
	public PreguntaRespCortPane rscP;
	public PreguntaVofPane vofP;
	
	
	public preguntasPrueba(String Enunciadotxt,int numeroPregunta,String respCorrecta,int puntaje) {
		this.Enunciadotxt = Enunciadotxt;
		this.numeroPregunta = numeroPregunta;
		this.respCorrecta = respCorrecta;
		this.respUsuario = "";
		this.puntaje = puntaje;
	}
	
	public abstract void setRespUsuario();
	
	public void setRespCorrecta(String respCorrecta) {
		this.respCorrecta = respCorrecta;
	}
	
	public String getRespCorrecta() {
		return this.respCorrecta;
	}
	
	public int getNumeroPreg() {
		return this.numeroPregunta;
	}
	
	public String getEnunciado() {
		return this.Enunciadotxt;
	}
	
	public String getRespUsuario() {
		return this.respUsuario;
	}
	
	public void setRespUsuario(String respUsuario) {
		this.respUsuario = respUsuario;
	}
	
}
