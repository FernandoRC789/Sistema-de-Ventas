package menu_principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Ventana_Ventas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Ventas frame = new Ventana_Ventas();
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
	public Ventana_Ventas() {
		setTitle("Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Cliente:");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		lblNewLabel.setBounds(24, 72, 142, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombresYApellidos = new JLabel("Apellidos de Cliente:");
		lblNombresYApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombresYApellidos.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		lblNombresYApellidos.setBounds(24, 114, 142, 35);
		contentPane.add(lblNombresYApellidos);
		
		textField = new JTextField();
		textField.setBounds(233, 72, 153, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(233, 114, 153, 27);
		contentPane.add(textField_1);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del Producto:");
		lblNombreDelProducto.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDelProducto.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		lblNombreDelProducto.setBounds(24, 172, 142, 35);
		contentPane.add(lblNombreDelProducto);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(233, 172, 153, 27);
		contentPane.add(textField_2);
		
		JLabel lblCantidadDeUnidades = new JLabel("Cantidad de Unidades:");
		lblCantidadDeUnidades.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeUnidades.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		lblCantidadDeUnidades.setBounds(24, 229, 142, 35);
		contentPane.add(lblCantidadDeUnidades);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(233, 229, 153, 27);
		contentPane.add(textField_3);
	}
}
