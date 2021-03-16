package Vista;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class CodigoPruebaFRM extends JFrame {

	private JPanel contentPane;
	public JTextField codigoTextField;
	public JButton btnBuscar;
	public JButton btnVolver;
	public JTextField rutTF;

	public CodigoPruebaFRM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CodigoPruebaFRM.class.getResource("/imagenes/AppIcono.png")));
		setTitle("TestApp/Estudiantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 433, 351);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton fakeButton = new JButton("fake");
        fakeButton.requestFocusInWindow();
        panel.add(fakeButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CodigoPruebaFRM.class.getResource("/imagenes/Users-Student-icon.png")));
		lblNewLabel_1.setBounds(24, -17, 48, 88);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CodigoPruebaFRM.class.getResource("/imagenes/testIconopeque\u00F1o.png")));
		lblNewLabel.setBounds(366, 0, 32, 48);
		panel.add(lblNewLabel);
		
		JLabel lblTItulo = new JLabel("BUSCAR EXAMEN");
		lblTItulo.setBackground(new Color(70, 130, 180));
		lblTItulo.setOpaque(true);
		lblTItulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 25));
		lblTItulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTItulo.setBounds(0, 0, 433, 48);
		panel.add(lblTItulo);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 47, 433, 16);
		panel.add(separator);
		
		JLabel lblCodigo = new JLabel("CODIGO EXAMEN");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 20));
		lblCodigo.setBounds(82, 139, 297, 58);
		panel.add(lblCodigo);
		
		codigoTextField = new JTextField();
		codigoTextField.setToolTipText("Aqui debe ingresar el codigo de la prueba entregado por su profesor.");
		codigoTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		codigoTextField.setBounds(82, 185, 297, 48);
		panel.add(codigoTextField);
		codigoTextField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setIcon(new ImageIcon(CodigoPruebaFRM.class.getResource("/imagenes/buscarIcono.png")));
		btnBuscar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 20));
		btnBuscar.setBounds(131, 250, 176, 54);
		panel.add(btnBuscar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnVolver.setIcon(new ImageIcon(CodigoPruebaFRM.class.getResource("/imagenes/RetrocederIcono.png")));
		btnVolver.setBounds(0, 310, 127, 41);
		panel.add(btnVolver);
		
		JLabel lblKeyIcono = new JLabel("");
		lblKeyIcono.setIcon(new ImageIcon(CodigoPruebaFRM.class.getResource("/imagenes/keyIcono.png")));
		lblKeyIcono.setBounds(20, 183, 66, 50);
		panel.add(lblKeyIcono);
		
		rutTF = new JTextField("EJ: 20.542.124-6");
		rutTF.setForeground(SystemColor.textInactiveText);
		rutTF.setToolTipText("Aqui debe ingresar su rut con todos los puntos y el guion.");
		rutTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rutTF.setColumns(10);
		rutTF.setBounds(82, 108, 297, 48);
		panel.add(rutTF);
		
		JLabel lblRut = new JLabel("RUT ALUMNO");
		lblRut.setHorizontalAlignment(SwingConstants.CENTER);
		lblRut.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 20));
		lblRut.setBounds(82, 62, 297, 58);
		panel.add(lblRut);
		
		JLabel lblKeyIcono_1 = new JLabel("");
		lblKeyIcono_1.setIcon(new ImageIcon(CodigoPruebaFRM.class.getResource("/imagenes/rutIcono.png")));
		lblKeyIcono_1.setBounds(13, 106, 66, 50);
		panel.add(lblKeyIcono_1);
		setVisible(true);
	}
}
