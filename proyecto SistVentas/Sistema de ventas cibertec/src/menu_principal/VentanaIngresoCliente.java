package menu_principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente_datos.Cliente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import java.awt.TextArea;

public class VentanaIngresoCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JLabel lblDireccin;
	private JTextField txtDireccion;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblDni;
	private JTextField txtDNI;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresoCliente frame = new VentanaIngresoCliente();
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
	public VentanaIngresoCliente() {
		setTitle("ingreso clientes");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(139, 29, 141, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 81, 141, 30);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 135, 141, 30);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(139, 183, 141, 30);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(139, 234, 141, 30);
		getContentPane().add(textField_4);
		setTitle("Ingreso Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("");
		txtNombre.setBounds(228, 125, 156, 33);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblNewLabel.setBounds(68, 135, 90, 23);
		contentPane.add(lblNewLabel);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblApellido.setBounds(68, 193, 90, 23);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setToolTipText("");
		txtApellido.setColumns(10);
		txtApellido.setBounds(228, 183, 156, 33);
		contentPane.add(txtApellido);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblCdigo.setBounds(68, 81, 90, 23);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setToolTipText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(228, 76, 156, 33);
		contentPane.add(txtCodigo);
		
		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblDireccin.setBounds(68, 252, 107, 23);
		contentPane.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setToolTipText("");
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(228, 247, 156, 33);
		contentPane.add(txtDireccion);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblTelefono.setBounds(68, 312, 107, 23);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setToolTipText("");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(228, 307, 156, 33);
		contentPane.add(txtTelefono);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblDni.setBounds(68, 367, 107, 23);
		contentPane.add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setToolTipText("");
		txtDNI.setColumns(10);
		txtDNI.setBounds(228, 362, 156, 33);
		contentPane.add(txtDNI);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(68, 474, 221, 47);
		contentPane.add(btnBorrar);
		
		JButton btnCerrar_1 = new JButton("CERRAR");
		btnCerrar_1.setBounds(608, 82, 221, 47);
		contentPane.add(btnCerrar_1);
		
		JButton btnIngresarAceptar = new JButton("INGRESAR / ACEPTAR");
		btnIngresarAceptar.setBounds(354, 474, 221, 47);
		contentPane.add(btnIngresarAceptar);
		
		TextArea txtS = new TextArea();
		txtS.setBounds(439, 135, 371, 311);
		contentPane.add(txtS);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(748, 391, 2, 2);
		contentPane.add(scrollPane);
		
		btnBorrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        txtNombre.setText("");
		        txtApellido.setText("");
		        txtCodigo.setText("");
		        txtDireccion.setText("");
		        txtTelefono.setText("");
		        txtDNI.setText("");
				txtCodigo.requestFocus();
		    }
		});

		btnIngresarAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo = leerCodigo();
				String name = leerNombre();
				String lastname = leerApellido();
				String direccion = leerDireccion();
				String telefono = leerTelefono();
				String dni = leerDNI();
				Cliente c= new Cliente(codigo,name,lastname,direccion,telefono,dni);
				
				listado (c);
										
			}

			//  Métodos que retornan valor (sin parámetros)
			int leerCodigo() {
				return Integer.parseInt(txtCodigo.getText().trim());
			}
			String leerNombre() {
				return txtNombre.getText();
			}
			String leerApellido() {
				return txtApellido.getText();
			}
			String leerDireccion(){
				return txtDireccion.getText();
			}
			String leerTelefono(){
				return txtTelefono.getText().trim();
			}
			String leerDNI(){
				
				return txtDNI.getText().trim();
			}
			
			void listado (Cliente x){

				imprimir ("DirMem : "+x);

				imprimir ("Codigo : "+x.getCodigoCliente());

				imprimir ("Nombres : "+x.getNombres());

				imprimir ("Apellidos : "+x.getApellidos());

				imprimir ("Direccion : "+x.getDireccion());

				imprimir ("Telefono : "+x.getTelefono());
				imprimir ("DNI : "+x.getDni()+"\n");

				}
			
			void imprimir(String s) {
				txtS.append(s + "\n");
			}

		});
		
		}
}
