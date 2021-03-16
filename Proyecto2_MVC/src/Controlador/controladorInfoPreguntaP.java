package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import Vista.InfoPreguntaPane;

public class controladorInfoPreguntaP {
	public InfoPreguntaPane panel;
	public int puntaje = 1;
	public String respCorrecta = "",enunciado = "",tipoPregunta = "Alternativas";
	public String[] alternativas = {"","","",""};
	
	public controladorInfoPreguntaP() {
		panel = new InfoPreguntaPane();
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				guardarDatos();
			}
		});
		
		panel.tipoPreguntaCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarDiseño();
			}
		});
	}
	
	public void guardarDatos() {
		enunciado = panel.EnunciadoTextArea.getText();
		puntaje = getValorSpinner();
		switch(panel.tipoPreguntaCB.getSelectedIndex()) {
		case 0:
			tipoPregunta = "Alternativas";
			alternativas[0] = panel.alternativa1TF.getText();
			alternativas[1] = panel.alternativa2TF.getText();
			alternativas[2] = panel.alternativa3TF.getText();
			alternativas[3] = panel.alternativa4TF.getText();
			switch(panel.RespCorrectaAlternativasCB.getSelectedIndex()) {
				case 0: respCorrecta = panel.alternativa1TF.getText();break;
				case 1: respCorrecta = panel.alternativa2TF.getText();break;
				case 2: respCorrecta = panel.alternativa3TF.getText();break;
				case 3: respCorrecta = panel.alternativa4TF.getText();break;
			}
			break;
		case 1:
			tipoPregunta = "RespCorta";
			respCorrecta = panel.respuestaCorrectaTF.getText();
			limpiarAlternativas();
			break;
		case 2:
			tipoPregunta = "VoF";
			limpiarAlternativas();
			switch(panel.RespCorrectaVoFCB.getSelectedIndex()) {
				case 0: respCorrecta = "Verdadero";break;
				case 1: respCorrecta = "Falso";break;
			}
			break;
		}
	}
	
	private int getValorSpinner() {
		try {
			panel.puntosPreguntaSpinner.commitEdit();
			if((int)panel.puntosPreguntaSpinner.getValue()<1) {
				panel.puntosPreguntaSpinner.setValue(Integer.valueOf(1));
				return 1;
			}
			return (int)panel.puntosPreguntaSpinner.getValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	private void limpiarAlternativas() {
		for(int i = 0;i<4;i++) {
			alternativas[i] = "";
		}
	}
	
	void cambiarDiseño() {
		switch (panel.tipoPreguntaCB.getSelectedIndex()) {
		case 0:
			panel.RespCorrectaVoFCB.setVisible(false);
			panel.RespCorrectaLbl.setVisible(false);
			panel.respuestaCorrectaTF.setVisible(false);
			panel.RespCorrectaAlternativasCB.setVisible(true);
			panel.lblAlternativa1.setForeground(Color.black);panel.alternativa1TF.setEditable(true);panel.alternativa1TF.setForeground(Color.black);
			panel.lblAlternativa2.setForeground(Color.black);panel.alternativa2TF.setEditable(true);panel.alternativa2TF.setForeground(Color.black);
			panel.lblAlternativa3.setForeground(Color.black);panel.alternativa3TF.setEditable(true);panel.alternativa3TF.setForeground(Color.black);
			panel.lblAlternativa4.setForeground(Color.black);panel.alternativa4TF.setEditable(true);panel.alternativa4TF.setForeground(Color.black);
			break;
		case 1:
			panel.lblAlternativa1.setForeground(Color.gray);panel.alternativa1TF.setEditable(false);panel.alternativa1TF.setForeground(Color.gray);
			panel.lblAlternativa2.setForeground(Color.gray);panel.alternativa2TF.setEditable(false);panel.alternativa2TF.setForeground(Color.gray);
			panel.lblAlternativa3.setForeground(Color.gray);panel.alternativa3TF.setEditable(false);panel.alternativa3TF.setForeground(Color.gray);
			panel.lblAlternativa4.setForeground(Color.gray);panel.alternativa4TF.setEditable(false);panel.alternativa4TF.setForeground(Color.gray);
			panel.RespCorrectaAlternativasCB.setVisible(false);
			panel.RespCorrectaVoFCB.setVisible(false);
			panel.respuestaCorrectaTF.setVisible(true);
			panel.RespCorrectaLbl.setVisible(true);
			break;
		case 2:
			panel.lblAlternativa1.setForeground(Color.gray);panel.alternativa1TF.setEditable(false);panel.alternativa1TF.setForeground(Color.gray);
			panel.lblAlternativa2.setForeground(Color.gray);panel.alternativa2TF.setEditable(false);panel.alternativa2TF.setForeground(Color.gray);
			panel.lblAlternativa3.setForeground(Color.gray);panel.alternativa3TF.setEditable(false);panel.alternativa3TF.setForeground(Color.gray);
			panel.lblAlternativa4.setForeground(Color.gray);panel.alternativa4TF.setEditable(false);panel.alternativa4TF.setForeground(Color.gray);
			panel.RespCorrectaAlternativasCB.setVisible(false);
			panel.respuestaCorrectaTF.setVisible(false);
			panel.RespCorrectaLbl.setVisible(false);
			panel.RespCorrectaVoFCB.setVisible(true);
			break;
		}
	}
}
