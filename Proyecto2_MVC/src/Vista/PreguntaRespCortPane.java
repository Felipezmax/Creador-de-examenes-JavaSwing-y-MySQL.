package Vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PreguntaRespCortPane extends JPanel {
	public JTextField RespuestaTextField;

	public PreguntaRespCortPane(String Enunciadotxt,int numeroPregunta) {
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
		Enunciado.setFont(new Font("Monospaced", Font.BOLD, 15));
		Enunciado.setBorder(new LineBorder(new Color(0, 0, 0)));
		Enunciado.setLineWrap(true);
		Enunciado.setOpaque(false);
		Enunciado.setFocusable(false);
		Enunciado.setEditable(false);
		Enunciado.setBounds(10, 53, 651, 77);
		add(Enunciado);
		
		RespuestaTextField = new JTextField("Respuesta");
		RespuestaTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		RespuestaTextField.setBounds(159, 141, 380, 36);
		RespuestaTextField.setColumns(10);
		RespuestaTextField.setForeground(SystemColor.textInactiveText);
		RespuestaTextField.setText("Respuesta");
		RespuestaTextField.getVerifyInputWhenFocusTarget();
		add(RespuestaTextField);
	
	}
}
