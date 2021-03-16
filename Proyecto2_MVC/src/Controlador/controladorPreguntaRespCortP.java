package Controlador;

import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

import Vista.PreguntaRespCortPane;

public class controladorPreguntaRespCortP extends preguntasPrueba{
	
	public controladorPreguntaRespCortP(String Enunciadotxt,int numeroPregunta,String respCorrecta,int puntaje) {
		super(Enunciadotxt,numeroPregunta,respCorrecta,puntaje);
		this.rscP = new PreguntaRespCortPane(Enunciadotxt,numeroPregunta);
		rscP.setName("activo");
		rscP.RespuestaTextField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                rscP.RespuestaTextField.setForeground(SystemColor.black);
                source.removeFocusListener(this);
            }
        });
	}
	
	public void setRespUsuario() {
		if(rscP.RespuestaTextField.getText() != null) {
			setRespUsuario(rscP.RespuestaTextField.getText());
		}else {
			setRespUsuario("");
		}
	}

}
