package Controlador;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import Vista.PreguntaAltrPane;

public class controladorPreguntaAltrP extends preguntasPrueba{
	
	
	public controladorPreguntaAltrP(String Enunciadotxt,int numeroPregunta,String respCorrecta,String[] respuestas,int puntaje) {
		super(Enunciadotxt,numeroPregunta,respCorrecta,puntaje);
		this.altP = new PreguntaAltrPane(Enunciadotxt,numeroPregunta,respuestas);
		altP.setName("activo");
	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
	
	public void setRespUsuario() {
		if(getSelectedButtonText(altP.alternativas) != null) {
			setRespUsuario(getSelectedButtonText(altP.alternativas));
		}else {
			setRespUsuario("");
		}
	}
}
