package Vista;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class PreguntaAltrPane extends JPanel {
	private String[] respuestas = new String[4];
	public  ButtonGroup alternativas;
	private JTextArea Enunciado;
	private JRadioButton alternativa1;
	private JRadioButton alternativa2;
	private JRadioButton alternativa3;
	private JRadioButton alternativa4;
	public JComboBox RespuestaCorrecta;
	
	public PreguntaAltrPane(String Enunciadotxt,int numeroPregunta,String[] respuestas) {
		setBorder(new LineBorder(new Color(139, 69, 19), 5));
		this.setBounds(0, 0, 671, 235);
		this.setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel PreguntaLbl = new JLabel("Pregunta "+numeroPregunta);
		PreguntaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		PreguntaLbl.setFont(new Font("Arial Black", Font.BOLD, 20));
		PreguntaLbl.setBounds(195, 11, 282, 36);
		add(PreguntaLbl);
		
		Enunciado = new JTextArea(Enunciadotxt);
		Enunciado.setBorder(new LineBorder(new Color(0, 0, 0)));
		Enunciado.setLineWrap(true);
		Enunciado.setFont(new Font("Monospaced", Font.BOLD, 15));
		Enunciado.setForeground(SystemColor.desktop);
		Enunciado.setOpaque(false);
		Enunciado.setFocusable(false);
		Enunciado.setEditable(false);
		Enunciado.setBounds(10, 53, 651, 77);
		add(Enunciado);
		
		JPanel panelFocusAlternativas = new JPanel();
		panelFocusAlternativas.setBorder(null);
		panelFocusAlternativas.setOpaque(false);
		panelFocusAlternativas.setBackground(SystemColor.window);
		panelFocusAlternativas.setBounds(61, 141, 546, 43);
		add(panelFocusAlternativas);
		panelFocusAlternativas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		alternativas = new ButtonGroup();
		
		alternativa1 = new JRadioButton(respuestas[0]);
		alternativa1.setOpaque(false);
		alternativa1.setBackground(SystemColor.activeCaptionBorder);
		alternativa1.setFont(new Font("Arial", Font.BOLD, 12));
		alternativas.add(alternativa1);
		panelFocusAlternativas.add(alternativa1);
		
		alternativa2 = new JRadioButton(respuestas[1]);
		alternativa2.setOpaque(false);
		alternativa2.setBackground(SystemColor.activeCaptionBorder);
		alternativa2.setFont(new Font("Arial", Font.BOLD, 12));
		alternativas.add(alternativa2);
		panelFocusAlternativas.add(alternativa2);
		
		alternativa3 = new JRadioButton(respuestas[2]);
		alternativa3.setOpaque(false);
		alternativa3.setBackground(SystemColor.activeCaptionBorder);
		alternativa3.setFont(new Font("Arial", Font.BOLD, 12));
		alternativas.add(alternativa3);
		panelFocusAlternativas.add(alternativa3);
		
		alternativa4 = new JRadioButton(respuestas[3]);
		alternativa4.setOpaque(false);
		alternativa4.setBackground(SystemColor.activeCaptionBorder);
		alternativa4.setFont(new Font("Arial", Font.BOLD, 12));
		alternativas.add(alternativa4);
		panelFocusAlternativas.add(alternativa4);
	}
	
}
