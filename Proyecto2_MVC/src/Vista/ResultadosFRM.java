package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

public class ResultadosFRM extends JFrame {

	private JPanel contentPane;
	private String prueba;
	public JTextArea txtrHolaSi;

	public ResultadosFRM(int porcentajeObtenido) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ResultadosFRM.class.getResource("/imagenes/AppIcono.png")));
		setTitle("TestApp/Estudiantes/Examen/Resultados");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 0, 504, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAlumnoIcono = new JLabel("");
		lblAlumnoIcono.setIcon(new ImageIcon(ResultadosFRM.class.getResource("/imagenes/estudiante2Icono.png")));
		lblAlumnoIcono.setBounds(446, 0, 58, 59);
		panel.add(lblAlumnoIcono);
		
		JLabel lblResultadosIcono = new JLabel("");
		lblResultadosIcono.setIcon(new ImageIcon(ResultadosFRM.class.getResource("/imagenes/resultadosIcono.png")));
		lblResultadosIcono.setBounds(0, 0, 48, 59);
		panel.add(lblResultadosIcono);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 57, 504, 2);
		panel.add(separator);
		
		JLabel lblTitulo = new JLabel("RESULTADOS");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBackground(new Color(0, 139, 139));
		lblTitulo.setOpaque(true);
		lblTitulo.setBounds(0, 0, 504, 59);
		panel.add(lblTitulo);
		
		JLabel lblResultadoFinal = new JLabel("Porcentaje correctas:");
		lblResultadoFinal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblResultadoFinal.setBounds(10, 89, 262, 48);
		panel.add(lblResultadoFinal);
		
		JLabel lblPorcentaje = new JLabel(porcentajeObtenido+"%");
		if(porcentajeObtenido>=60) {
			lblPorcentaje.setForeground(new Color(0, 128, 0));
		}else {
			lblPorcentaje.setForeground(Color.red);
		}
		lblPorcentaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblPorcentaje.setBounds(282, 70, 212, 80);
		panel.add(lblPorcentaje);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "INFORME RESPUESTAS", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 184, 484, 188);
		panel.add(scrollPane);
		
		txtrHolaSi = new JTextArea();
		txtrHolaSi.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		scrollPane.setViewportView(txtrHolaSi);
		setVisible(true);
	}
}
