package Vista;

import java.awt.Color;

import java.awt.Font;



import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Examen {
	public Timer t;
	public JFrame frame;
	public JComboBox comboBox;
	public JButton finalizarBtn;
	public JLayeredPane layeredPane;
	public JLabel TiempoLbl;
	
	public int tiempo = 0;
	public final int tiempoPrueba;
	public JButton btnAnterior;
	public JButton btnSiguiente;

	public Examen(int tiempoPrueba) {
		this.tiempoPrueba = tiempoPrueba;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Examen.class.getResource("/imagenes/AppIcono.png")));
		frame.setTitle("TestApp/Estudiantes/Examen");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(0, 100, 0));
		frame.setBounds(100, 100, 707, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(null);
		layeredPane.setBounds(10, 90, 671, 235);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);	
		
		
		comboBox = new JComboBox();
		comboBox.setBorder(new TitledBorder(null, "Escoger pregunta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(20, 336, 155, 46);
		frame.getContentPane().add(comboBox);
		
		finalizarBtn = new JButton("FINALIZAR");
		finalizarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		finalizarBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		finalizarBtn.setForeground(Color.RED);
		finalizarBtn.setBounds(553, 342, 128, 41);
		frame.getContentPane().add(finalizarBtn);

		TiempoLbl = new JLabel();
		TiempoLbl.setForeground(new Color(0, 0, 0));
		TiempoLbl.setFont(new Font("Agency FB", Font.BOLD, 22));
		TiempoLbl.setBounds(66, 32, 274, 35);
		frame.getContentPane().add(TiempoLbl);
		
		JLabel IconoReloj = new JLabel();
		IconoReloj.setIcon(new ImageIcon(Examen.class.getResource("/imagenes/Time-And-Date-Clock-icon.png")));
		IconoReloj.setBounds(10, 11, 70, 68);
		frame.getContentPane().add(IconoReloj);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setIcon(new ImageIcon(Examen.class.getResource("/imagenes/atrasIcono.png")));
		btnAnterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnterior.setBounds(219, 336, 141, 35);
		frame.getContentPane().add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setHorizontalTextPosition(SwingConstants.LEADING);
		btnSiguiente.setHorizontalAlignment(SwingConstants.LEFT);
		btnSiguiente.setIcon(new ImageIcon(Examen.class.getResource("/imagenes/adelanteIcono.png")));
		btnSiguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSiguiente.setBounds(370, 336, 141, 35);
		frame.getContentPane().add(btnSiguiente);
		frame.setVisible(true);
	}
}
