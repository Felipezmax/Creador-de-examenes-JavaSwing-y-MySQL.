package Vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class PreguntaVofPane extends JPanel {
	public ButtonGroup alternativas;
	
	public PreguntaVofPane(String Enunciadotxt,int numeroPregunta) {
		setBorder(new LineBorder(new Color(139, 69, 19), 5));
		this.setBounds(0, 0, 671, 235);
		this.setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel PreguntaLbl = new JLabel("Pregunta "+numeroPregunta);
		PreguntaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		PreguntaLbl.setFont(new Font("Arial Black", Font.BOLD, 20));
		PreguntaLbl.setBounds(195, 11, 282, 36);
		add(PreguntaLbl);
		
		JTextArea Enunciado = new JTextArea(Enunciadotxt);
		Enunciado.setBorder(new LineBorder(new Color(0, 0, 0)));
		Enunciado.setLineWrap(true);
		Enunciado.setBackground(SystemColor.activeCaptionBorder);
		Enunciado.setFont(new Font("Monospaced", Font.BOLD, 15));
		Enunciado.setOpaque(false);
		Enunciado.setFocusable(false);
		Enunciado.setEditable(false);
		Enunciado.setBounds(10, 53, 651, 77);
		add(Enunciado);
		
		JPanel panelFocusAlternativas = new JPanel();
		panelFocusAlternativas.setBorder(null);
		panelFocusAlternativas.setOpaque(false);
		panelFocusAlternativas.setBounds(61, 141, 546, 43);
		add(panelFocusAlternativas);
		panelFocusAlternativas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		alternativas = new ButtonGroup();
		
		JRadioButton alternativa1 = new JRadioButton("Verdadero");
		alternativa1.setOpaque(false);
		alternativa1.setBackground(SystemColor.activeCaptionBorder);
		alternativa1.setFont(new Font("Arial", Font.BOLD, 12));
		alternativas.add(alternativa1);
		panelFocusAlternativas.add(alternativa1);
		
		JRadioButton alternativa2 = new JRadioButton("Falso");
		alternativa2.setOpaque(false);
		alternativa2.setBackground(SystemColor.activeCaptionBorder);
		alternativa2.setFont(new Font("Arial", Font.BOLD, 12));
		alternativas.add(alternativa2);
		panelFocusAlternativas.add(alternativa2);
		
	}
	
}
