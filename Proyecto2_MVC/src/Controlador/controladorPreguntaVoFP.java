package Controlador;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import Vista.PreguntaVofPane;

public class controladorPreguntaVoFP extends preguntasPrueba{
	
	public controladorPreguntaVoFP(String Enunciadotxt,int numeroPregunta,String respCorrecta,int puntaje) {
		super(Enunciadotxt,numeroPregunta,respCorrecta,puntaje);
		vofP = new PreguntaVofPane(Enunciadotxt,numeroPregunta);
		vofP.setName("activo");
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
		if(getSelectedButtonText(vofP.alternativas) != null) {
			setRespUsuario(getSelectedButtonText(vofP.alternativas));
		}else {
			setRespUsuario("");
		}
	}
}
