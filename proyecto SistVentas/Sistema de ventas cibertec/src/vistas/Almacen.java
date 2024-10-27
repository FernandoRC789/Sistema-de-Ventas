package vistas;
//pendiente por mejorar codigo /eliminar codigo que no sirve
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglosClientes.ProductosArreglo;
import identidades.Producto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Almacen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoProducto;
	private JTextField txtCantidadIngresar;
	private JTextField txtStockMinimo;
	private JTextField txtStockMaximo;
	private JTextField txtStockActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen frame = new Almacen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * creando arraylist
	 */
	ProductosArreglo ap=new ProductosArreglo();
	private JTable tblAlmacen;
	private DefaultTableModel modelo;
	public Almacen() {
		setTitle("Almac\u00E9n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setBounds(158, 87, 149, 30);
		contentPane.add(txtCodigoProducto);
		txtCodigoProducto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo de Producto:");
		lblNewLabel.setBounds(38, 92, 125, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblCantidadAIngresar = new JLabel("Cantidad a Ingresar:");
		lblCantidadAIngresar.setBounds(38, 144, 125, 13);
		contentPane.add(lblCantidadAIngresar);
		
		txtCantidadIngresar = new JTextField();
		txtCantidadIngresar.setColumns(10);
		txtCantidadIngresar.setBounds(158, 139, 149, 30);
		contentPane.add(txtCantidadIngresar);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarProducto();
			}
			
			
		});
		btnIngresar.setBounds(38, 454, 162, 35);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel_1 = new JLabel("Almac\u00E9n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(323, 33, 92, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarProducto();
			}
		});
		btnBuscar.setBounds(314, 91, 101, 26);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_2 = new JLabel("Stock M\u00EDnimo");
		lblNewLabel_2.setBounds(495, 95, 77, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Stock M\u00E1ximo");
		lblNewLabel_2_1.setBounds(495, 139, 77, 13);
		contentPane.add(lblNewLabel_2_1);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setEditable(false);
		txtStockMinimo.setColumns(10);
		txtStockMinimo.setBounds(582, 87, 149, 30);
		contentPane.add(txtStockMinimo);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setEditable(false);
		txtStockMaximo.setColumns(10);
		txtStockMaximo.setBounds(582, 127, 149, 30);
		contentPane.add(txtStockMaximo);
		
		JLabel lblNewLabel_2_2 = new JLabel("Stock Actual");
		lblNewLabel_2_2.setBounds(74, 187, 77, 13);
		contentPane.add(lblNewLabel_2_2);
		
		txtStockActual = new JTextField();
		txtStockActual.setEditable(false);
		txtStockActual.setColumns(10);
		txtStockActual.setBounds(158, 179, 149, 30);
		contentPane.add(txtStockActual);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 775, 221);
		contentPane.add(scrollPane);
		
		tblAlmacen = new JTable();
		tblAlmacen.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlmacen);
	
	//
	modelo = new DefaultTableModel();
	modelo.addColumn("COD.PRODUCTO");
	modelo.addColumn("NOMBRE");
	modelo.addColumn("PRECIO");
	modelo.addColumn("STOCK ACTUAL(MODIFICADO)");
	modelo.addColumn("STOCK MÍNIMO");
	modelo.addColumn("STOCK MÁXIMO");
	tblAlmacen.setModel(modelo);
	
	JButton btnNewButton = new JButton("CERRAR");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaPrincipal secondWindow = new VentanaPrincipal();
            secondWindow.setVisible(true);
            dispose(); // Cierra la ventana principal
		}
	});
	btnNewButton.setBounds(655, 472, 130, 23);
	contentPane.add(btnNewButton);
	listar();
	}
	//
	void modificarProducto() {
		try {
			int codigo = leerCodigo();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				int cant = leerCant();
				int stockActual=leerStockActual();
				int stockMin = leerStockMinimo();
				int stockMax = leerStockMaximo();
				if (cant > stockMax ) {
					mensaje("El nuevo stock a ingresar no debe superar el Stock MÁXIMO");
					return;
				}
					try {
						stockActual=cant;
						x.setStock_actual(stockActual);
						x.setStock_min(stockMin);
						x.setStock_max(stockMax);
						ap.actualizarArchivo();
						listar();
						txtCodigoProducto.requestFocus();
					}
					catch (Exception e) {
						error("Ingrese stock actual correcto", txtStockActual);
					}
			}
			else
				error("El código " + codigo + " no existe", txtCodigoProducto);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigoProducto);
		}
	}
	
	int leerCodigo() {
		return Integer.parseInt(txtCodigoProducto.getText().trim());
	}
	private int leerCant() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtCantidadIngresar.getText().trim());
	}

	private int leerStockMaximo() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtStockMaximo.getText().trim());
	}

	private int leerStockMinimo() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtStockMinimo.getText().trim());
	}

	int leerStockActual() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtStockActual.getText().trim());
	}


	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void listar() {
		Producto x;
		modelo.setRowCount(0);
		for (int i=0; i<ap.tamanio(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCod_producto(),
					          x.getNombre(),
					          x.getPrecio(),
					          x.getStock_actual(),
					          x.getStock_min(),
					          x.getStock_max() };
			modelo.addRow(fila);
		}
	}
	
	void consultarProducto() {
		try {
			int codigo = leerCodigo();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				txtStockActual.setText(String.valueOf(x.getStock_actual()));
				txtStockMinimo.setText(String.valueOf(x.getStock_min()));
				txtStockMaximo.setText(String.valueOf(x.getStock_max()));

			}
			else
				error("El código " + codigo + " no existe", txtCodigoProducto);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigoProducto);
		}
	}
}
//pendiente por mejorar codigo /eliminar codigo que no sirve