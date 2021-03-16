package Vista;

import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class InfoPreguntaPane extends JPanel {
	public JTextField alternativa1TF,alternativa2TF,alternativa3TF,alternativa4TF,respuestaCorrectaTF;
	public JLabel lblAlternativa1,lblAlternativa2,lblAlternativa3,lblAlternativa4,RespCorrectaLbl;
	public JComboBox tipoPreguntaCB,RespCorrectaAlternativasCB,RespCorrectaVoFCB;
	public JTextArea EnunciadoTextArea;
	private JLabel puntajeLbl;
	public JSpinner puntosPreguntaSpinner;
	
	public InfoPreguntaPane() {
		
		setBounds(0,0,555,233);
		setLayout(null);
		setVisible(true);
		
		EnunciadoTextArea = new JTextArea();
		EnunciadoTextArea.setLineWrap(true);
		EnunciadoTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		EnunciadoTextArea.setBounds(10, 26, 535, 80);
		add(EnunciadoTextArea);
		
		JLabel EnunciadoLbl = new JLabel("Enunciado");
		EnunciadoLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		EnunciadoLbl.setBounds(10, 0, 90, 26);
		add(EnunciadoLbl);
		
		RespCorrectaLbl = new JLabel("Respuesta Correcta");
		RespCorrectaLbl.setVisible(false);
		RespCorrectaLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		RespCorrectaLbl.setBounds(10, 174, 147, 26);
		add(RespCorrectaLbl);
		
		respuestaCorrectaTF = new JTextField();
		respuestaCorrectaTF.setVisible(false);
		respuestaCorrectaTF.setBounds(10, 202, 147, 20);
		add(respuestaCorrectaTF);
		respuestaCorrectaTF.setColumns(10);
		
		lblAlternativa1 = new JLabel("Alternativa 1\r\n");
		lblAlternativa1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternativa1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlternativa1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAlternativa1.setBounds(10, 114, 118, 26);
		add(lblAlternativa1);
		
		lblAlternativa2 = new JLabel("Alternativa 2");
		lblAlternativa2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternativa2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlternativa2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAlternativa2.setBounds(149, 114, 118, 26);
		add(lblAlternativa2);
		
		lblAlternativa3 = new JLabel("Alternativa 3");
		lblAlternativa3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternativa3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlternativa3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAlternativa3.setBounds(288, 114, 118, 26);
		add(lblAlternativa3);
		
		lblAlternativa4 = new JLabel("Alternativa 4");
		lblAlternativa4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternativa4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlternativa4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAlternativa4.setBounds(427, 112, 118, 26);
		add(lblAlternativa4);
		
		alternativa1TF = new JTextField();
		alternativa1TF.setColumns(10);
		alternativa1TF.setBounds(10, 136, 118, 20);
		add(alternativa1TF);
		
		alternativa2TF = new JTextField();
		alternativa2TF.setColumns(10);
		alternativa2TF.setBounds(149, 136, 118, 20);
		add(alternativa2TF);
		
		alternativa3TF = new JTextField();
		alternativa3TF.setColumns(10);
		alternativa3TF.setBounds(288, 136, 118, 20);
		add(alternativa3TF);
		
		alternativa4TF = new JTextField();
		alternativa4TF.setColumns(10);
		alternativa4TF.setBounds(427, 136, 118, 20);
		add(alternativa4TF);
		
		RespCorrectaVoFCB = new JComboBox();
		RespCorrectaVoFCB.setVisible(false);
		RespCorrectaVoFCB.setBorder(new TitledBorder(null, "Respuesta Correcta", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		RespCorrectaVoFCB.setModel(new DefaultComboBoxModel(new String[] {"Verdadero", "Falso"}));
		RespCorrectaVoFCB.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		RespCorrectaVoFCB.setBounds(10, 174, 153, 59);
		add(RespCorrectaVoFCB);
		
		RespCorrectaAlternativasCB = new JComboBox();
		RespCorrectaAlternativasCB.setBorder(new TitledBorder(null, "Respuesta Correcta", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		RespCorrectaAlternativasCB.setModel(new DefaultComboBoxModel(new String[] {"Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4"}));
		RespCorrectaAlternativasCB.setBounds(10, 174, 153, 59);
		add(RespCorrectaAlternativasCB);
		
		tipoPreguntaCB = new JComboBox();
		tipoPreguntaCB.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		tipoPreguntaCB.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de pregunta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tipoPreguntaCB.setModel(new DefaultComboBoxModel(new String[] {"Alternativas", "Respuestas Cortas", "Verdadero o falso"}));
		tipoPreguntaCB.setBounds(180, 174, 161, 59);
		add(tipoPreguntaCB);
		
		puntosPreguntaSpinner = new JSpinner();
		puntosPreguntaSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		puntosPreguntaSpinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntosPreguntaSpinner.setBounds(373, 186, 172, 36);
		add(puntosPreguntaSpinner);
		
		puntajeLbl = new JLabel("Puntos de la pregunta");
		puntajeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		puntajeLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		puntajeLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		puntajeLbl.setBounds(363, 159, 182, 26);
		add(puntajeLbl);
	}

}
