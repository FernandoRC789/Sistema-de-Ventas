package menu_principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaModificarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9207473190932602353L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarCliente frame = new VentanaModificarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaModificarCliente() {
		setTitle("MODIFICAR DATOS CLIENTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(187, 101, 156, 33);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 111, 90, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblApellido.setBounds(27, 169, 90, 23);
		contentPane.add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(187, 159, 156, 33);
		contentPane.add(textField_1);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblCdigo.setBounds(27, 57, 90, 23);
		contentPane.add(lblCdigo);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		textField_2.setBounds(187, 52, 156, 33);
		contentPane.add(textField_2);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblDireccin.setBounds(27, 228, 107, 23);
		contentPane.add(lblDireccin);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		textField_3.setBounds(187, 223, 156, 33);
		contentPane.add(textField_3);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblTelefono.setBounds(27, 288, 107, 23);
		contentPane.add(lblTelefono);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setColumns(10);
		textField_4.setBounds(187, 283, 156, 33);
		contentPane.add(textField_4);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblDni.setBounds(27, 343, 107, 23);
		contentPane.add(lblDni);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setColumns(10);
		textField_5.setBounds(187, 338, 156, 33);
		contentPane.add(textField_5);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(27, 450, 221, 47);
		contentPane.add(btnBorrar);
		
		JButton btnCerrar_1 = new JButton("CERRAR");
		btnCerrar_1.setBounds(567, 58, 221, 47);
		contentPane.add(btnCerrar_1);
		
		JButton btnIngresarAceptar = new JButton("INGRESAR / ACEPTAR");
		btnIngresarAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
			//metodos
		});
		btnIngresarAceptar.setBounds(313, 450, 221, 47);
		contentPane.add(btnIngresarAceptar);
		
		TextArea txtS = new TextArea();
		txtS.setBounds(398, 111, 371, 311);
		contentPane.add(txtS);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(707, 367, 2, 2);
		contentPane.add(scrollPane);
	}
}
