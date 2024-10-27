package vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglosClientes.ProductosArreglo;
import identidades.Producto;

public class MantenimientoProductos extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JTextField txtCodProducto;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMinimo;
	private JButton btnBuscar;
	private JButton btnOK;
	private JButton btnOpciones;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblPersona;
	private DefaultTableModel modelo;

	//  Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;
	
	//  Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;

	
	 // Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoProductos dialog = new MantenimientoProductos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	  //Create the dialog.
	 
	public MantenimientoProductos() {
		setResizable(false);
		setTitle("Mantenimiento | Productos");
		setBounds(100, 100, 810, 610);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo Producto");
		lblCodigo.setBounds(21, 10, 97, 23);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 35, 97, 23);
		getContentPane().add(lblNombre);
	
		lblApellidos = new JLabel("Precio");
		lblApellidos.setBounds(21, 60, 97, 23);
		getContentPane().add(lblApellidos);
		
		lblDni = new JLabel("Stock Actual");
		lblDni.setBounds(21, 85, 97, 23);
		getContentPane().add(lblDni);
		
		lblDireccion = new JLabel("Stock M\u00EDnimo");
		lblDireccion.setBounds(21, 110, 97, 23);
		getContentPane().add(lblDireccion);
		
		lblTelefono = new JLabel("Stock M\u00E1ximo");
		lblTelefono.setBounds(21, 135, 97, 23);
		getContentPane().add(lblTelefono);
		
		txtCodProducto = new JTextField();
		txtCodProducto.setBounds(128, 10, 86, 23);
		getContentPane().add(txtCodProducto);
		txtCodProducto.setEditable(false);
		txtCodProducto.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(128, 35, 109, 23);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(128, 60, 109, 23);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStockActual = new JTextField();
		txtStockActual.setBounds(128, 85, 109, 23);
		getContentPane().add(txtStockActual);
		txtStockActual.setColumns(10);

		txtStockMinimo = new JTextField();
		txtStockMinimo.setBounds(128, 110, 109, 23);
		getContentPane().add(txtStockMinimo);
		txtStockMinimo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(271, 10, 101, 23);
		getContentPane().add(btnBuscar);

		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		btnOK.setBounds(429, 135, 100, 23);
		getContentPane().add(btnOK);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setBounds(555, 10, 100, 98);
		getContentPane().add(btnOpciones);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(664, 10, 120, 23);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(664, 35, 120, 23);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(664, 60, 120, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(664, 85, 120, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 775, 390);
		getContentPane().add(scrollPane);
		
		tblPersona = new JTable();
		tblPersona.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPersona);

		modelo = new DefaultTableModel();
		modelo.addColumn("COD.PRODUCTO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("PRECIO");
		modelo.addColumn("STOCK ACTUAL");
		modelo.addColumn("STOCK MÍNIMO");
		modelo.addColumn("STOCK MÁXIMO");
		tblPersona.setModel(modelo);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setEditable(false);
		txtStockMaximo.setColumns(10);
		txtStockMaximo.setBounds(128, 135, 109, 23);
		getContentPane().add(txtStockMaximo);
		
		btnNewButton = new JButton("CERRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal secondWindow = new VentanaPrincipal();
                secondWindow.setVisible(true);
                dispose(); // Cierra la ventana principal
			}
		});
		btnNewButton.setBounds(654, 136, 130, 23);
		getContentPane().add(btnNewButton);
		
		ajustarAnchoColumnas();
		listar();
		
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	
	//  Declaración global
	ProductosArreglo ap = new ProductosArreglo();
	private JTextField txtStockMaximo;
	private JButton btnNewButton;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(arg0);
		}
		if (arg0.getSource() == btnOK) {
			actionPerformedBtnOK(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarProducto();
	}
	protected void actionPerformedBtnOK(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarProducto();
				break;
			case CONSULTAR:
				consultarProducto();
				break;
			case MODIFICAR:
				modificarProducto();
				break;
			case ELIMINAR:
				eliminarProducto();
		}
	}
	protected void actionPerformedBtnOpciones(ActionEvent arg0) {
		txtCodProducto.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMinimo.setText("");
		txtStockMaximo.setText("");
		txtCodProducto.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		txtCodProducto.setText("" + ap.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		txtCodProducto.setEditable(true);
		habilitarBotones(false);
		txtCodProducto.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		txtCodProducto.setEditable(true);
		habilitarBotones(false);
		txtCodProducto.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		txtCodProducto.setEditable(true);
		habilitarBotones(false);
		txtCodProducto.requestFocus();
	}
	//  Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblPersona.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  // APELLIDO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // peso DNI
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));  // estatura DIRECCION
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12));  // estadoCivil TELEFONO
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
	void adicionarProducto() {
        try {
            int codigoCorrelativo = ap.codigoCorrelativo();
            String nombre = leerNombre();
            double precio = leerPrecio();
            int StockActual = leerStockActual();
            int stockMin = leerStockMinimo();
            int stockMax = leerStockMaximo();

           /* if (nombre.length()>0 || precio.length()>0 || StockActual.length()>0 || stockMin.length()>0 || stockMax.length>0) {
                mensaje("Complete todos los campos...");
                return;
            }*/

            Producto x = ap.buscar(codigoCorrelativo);
            if (x == null) {
            	Producto nuevoProducto = new Producto(codigoCorrelativo, nombre, precio, StockActual, stockMin, stockMax);
                ap.adicionar(nuevoProducto);
                listar();
                limpiarEntradas();
                mensaje("Ingreso exitoso");
                //txtCodigo.setText(String.valueOf(ac.codigoCorrelativo()));
            } else {
                mensaje("Elcodigo ya existe");//mejorar codigo/eliminar
            }
        } catch (Exception e2) {
            mensaje("Error al completar todos los campos.");
        }
	}
		
	void consultarProducto() {
		try {
			int codigo = leerCodigoProducto();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				txtNombre.setText(x.getNombre());
				txtPrecio.setText(String.valueOf(x.getPrecio())); // Asegúrate de convertir a String
				txtStockActual.setText(String.valueOf(x.getStock_actual()));
				txtStockMinimo.setText(String.valueOf(x.getStock_min()));
				txtStockMaximo.setText(String.valueOf(x.getStock_max()));

				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodProducto.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
					txtNombre.requestFocus();
				}
				if (tipoOperacion == ELIMINAR) {
					txtCodProducto.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodProducto);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodProducto);
		}
	}
	void modificarProducto() {
		try {
			int codigo = leerCodigoProducto();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				String nombre = leerNombre();
				double precio = leerPrecio();
				int stockActual=leerStockActual();
				int stockMin = leerStockMinimo();
				int stockMax = leerStockMaximo();
				if (nombre.length() > 0)
					try {
						x.setNombre(nombre);
						x.setPrecio(precio);
						x.setStock_actual(stockActual);;
						x.setStock_min(stockMin);
						x.setStock_max(stockMax);
						ap.actualizarArchivo();
						listar();
						mensaje("Se Modifico registro con el codigo: " + codigo);
						txtNombre.requestFocus();
					}
					catch (Exception e) {
						error("Ingrese stock actual correcto", txtStockActual);
					}
				else
					error("Ingrese NOMBRE correcto", txtNombre);
			}
			else
				error("El código " + codigo + " no existe", txtCodProducto);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodProducto);
		}
	}
	void eliminarProducto() {
		try {
			int codigo = leerCodigoProducto();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					ap.eliminar(x);
					listar();
					mensaje("Se Elimino registro con el codigo: " + codigo);
					btnOK.setEnabled(false);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodProducto);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodProducto);
		}	
	}
	//  Métodos tipo void (con parámetros)
	void habilitarEntradas(boolean sino) {
		txtNombre.setEditable(sino);
		txtPrecio.setEditable(sino);
		txtStockActual.setEditable(sino);
		txtStockMinimo.setEditable(sino);
		txtStockMaximo.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		if (tipoOperacion == ADICIONAR)
			btnOK.setEnabled(!sino);
		else {
			btnBuscar.setEnabled(!sino);
			btnOK.setEnabled(false);
		}	
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);		
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigoProducto() {
		return Integer.parseInt(txtCodProducto.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	
	int leerStockActual() {
		return Integer.parseInt(txtStockActual.getText().trim());
	}

	int leerStockMinimo() {
		return Integer.parseInt(txtStockMinimo.getText().trim());

	}
	
	int leerStockMaximo() {
		return Integer.parseInt(txtStockMaximo.getText().trim());
	}

	//  Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	double ajustar(double numero) {
		return (int)(numero * 10) / 10.0;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
    private void limpiarEntradas() {
        txtCodProducto.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStockActual.setText("");
        txtStockMinimo.setText("");
        txtStockMaximo.setText("");
        txtCodProducto.requestFocus();
        habilitarEntradas(false);
        habilitarBotones(true);
    }
	
}