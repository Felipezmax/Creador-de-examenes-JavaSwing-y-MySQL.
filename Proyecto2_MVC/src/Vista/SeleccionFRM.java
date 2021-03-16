package Vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;

public class SeleccionFRM extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngresarComo;
	public JButton btnEstudiante;
	public JButton btnProfesor;

	public SeleccionFRM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeleccionFRM.class.getResource("/imagenes/AppIcono.png")));
		setResizable(false);
		setTitle("TestApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 433, 351);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtIngresarComo = new JTextField();
		txtIngresarComo.setBorder(null);
		txtIngresarComo.setEditable(false);
		txtIngresarComo.setBackground(Color.WHITE);
		txtIngresarComo.setOpaque(false);
		txtIngresarComo.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 35));
		txtIngresarComo.setHorizontalAlignment(SwingConstants.CENTER);
		txtIngresarComo.setText("INGRESAR COMO...");
		txtIngresarComo.setBounds(74, 11, 292, 52);
		panel.add(txtIngresarComo);
		txtIngresarComo.setColumns(10);
		
		btnProfesor = new JButton("PROFESOR");
		btnProfesor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProfesor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnProfesor.setIcon(new ImageIcon(SeleccionFRM.class.getResource("/imagenes/profeIcono.png")));
		btnProfesor.setBounds(84, 84, 272, 98);
		panel.add(btnProfesor);
		
		btnEstudiante = new JButton("ESTUDIANTE");
		btnEstudiante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEstudiante.setIcon(new ImageIcon(SeleccionFRM.class.getResource("/imagenes/alumnoIcono.png")));
		btnEstudiante.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnEstudiante.setBounds(84, 199, 272, 98);
		panel.add(btnEstudiante);
		setVisible(true);
	}
}
