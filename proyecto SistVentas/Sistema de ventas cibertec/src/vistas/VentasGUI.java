package vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglosClientes.ClienteArreglosDatos;
import identidades.Cliente;

import arreglosClientes.ProductosArreglo;
import arreglosClientes.VentasArreglo;
import identidades.Producto;
import identidades.Ventas;

public class VentasGUI extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigoVenta;
	private JLabel lblNombre;
	private JLabel lblNomCli;
	private JLabel lblCodProd;
	private JLabel lblNombrep;
	private JLabel lblCantidad;
	private JTextField txtCodigoVenta;
	private JTextField txtCodCliente;
	private JTextField txtNombre;
	private JTextField txtCodigoProducto;
	private JTextField txtNombreProducto;
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
	private VentasArreglo av;
	private ClienteArreglosDatos ac;
	private ProductosArreglo ap;
	


	//  Tipo de operacion a procesar: Adicionar, Consultar, Modificar o Eliminar
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
					VentasGUI dialog = new VentasGUI();
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
	 
	public VentasGUI() {
		setResizable(false);
		setTitle("\tVentas");
		setBounds(100, 100, 810, 610);
		getContentPane().setLayout(null);

		
		lblCodigoVenta = new JLabel("C\u00F3digo Venta");
		lblCodigoVenta.setBounds(10, 10, 110, 23);
		getContentPane().add(lblCodigoVenta);
		
		lblNombre = new JLabel("C\u00F3digo Cliente");
		lblNombre.setBounds(10, 35, 86, 23);
		getContentPane().add(lblNombre);
	
		lblNomCli = new JLabel("Nombre");
		lblNomCli.setBounds(10, 60, 70, 23);
		getContentPane().add(lblNomCli);
		
		lblCodProd = new JLabel("C\u00F3d Producto");
		lblCodProd.setBounds(266, 60, 86, 23);
		getContentPane().add(lblCodProd);
		
		lblNombrep = new JLabel("Nombre");
		lblNombrep.setBounds(266, 85, 70, 23);
		getContentPane().add(lblNombrep);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 135, 86, 23);
		getContentPane().add(lblCantidad);
		
		txtCodigoVenta = new JTextField();
		txtCodigoVenta.setBounds(103, 10, 86, 23);
		getContentPane().add(txtCodigoVenta);
		txtCodigoVenta.setEditable(false);
		txtCodigoVenta.setColumns(10);

		txtCodCliente = new JTextField();
		txtCodCliente.setBounds(103, 35, 86, 23);
		getContentPane().add(txtCodCliente);
		txtCodCliente.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(103, 60, 137, 23);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setBounds(359, 60, 86, 23);
		getContentPane().add(txtCodigoProducto);
		txtCodigoProducto.setColumns(10);

		txtNombreProducto = new JTextField();
		txtNombreProducto.setEditable(false);
		txtNombreProducto.setBounds(359, 85, 156, 23);
		getContentPane().add(txtNombreProducto);
		txtNombreProducto.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(220, 10, 101, 23);
		getContentPane().add(btnBuscar);

		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		btnOK.setBounds(555, 135, 100, 23);
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
		//
		ac = new ClienteArreglosDatos();
        ap = new ProductosArreglo();
        av = new VentasArreglo(ac, ap);

		modelo = new DefaultTableModel();
		modelo.addColumn("#VENTA");
		modelo.addColumn("#CLIENTE");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("#PRODUCTO");
		modelo.addColumn("NOMBRE_PRODUCTO");
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("PRECIO");
		modelo.addColumn("IMPORTE");
		modelo.addColumn("IGV");
		modelo.addColumn("TOTAL PAGAR");
		tblPersona.setModel(modelo);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(103, 135, 86, 23);
		getContentPane().add(txtCantidad);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setEnabled(false);
		lblFecha.setBounds(373, 10, 39, 23);
		getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(422, 10, 86, 23);
		getContentPane().add(txtFecha);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(103, 93, 137, 23);
		getContentPane().add(txtApellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 93, 70, 23);
		getContentPane().add(lblApellido);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(266, 118, 70, 23);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(359, 120, 156, 23);
		getContentPane().add(txtPrecio);
		
		btnNewButton = new JButton("CERRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal secondWindow = new VentanaPrincipal();
                secondWindow.setVisible(true);
                dispose(); // Cierra la ventana principal
			}
		});
		btnNewButton.setBounds(698, 136, 86, 23);
		getContentPane().add(btnNewButton);
		
	    agregarDocumentListener();

		ajustarAnchoColumnas();
		listar();
		
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	
	private JTextField txtCantidad;
	private JTextField txtFecha;
	private JTextField txtApellido;
	private JTextField txtPrecio;
	private JButton btnNewButton;
	//private ClienteArreglosDatos ac;
	//private ClienteArreglosDatos ap;
	
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
		consultarVenta();
	}
	protected void actionPerformedBtnOK(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarVenta();
				break;
			case CONSULTAR:
				consultarVenta();
				break;
			case MODIFICAR:
				modificarVenta();
				break;
			case ELIMINAR:
				eliminarVenta();
		}
	}
	protected void actionPerformedBtnOpciones(ActionEvent arg0) {
		txtCodigoVenta.setText("");
		txtCodCliente.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtCodigoProducto.setText("");
		txtNombreProducto.setText("");
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtFecha.setText("");
		txtCodigoVenta.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		txtCodigoVenta.setText("" + av.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodCliente.requestFocus();
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		txtCodigoVenta.setEditable(true);
		habilitarBotones(false);
		txtCodigoVenta.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		txtCodigoVenta.setEditable(true);
		habilitarBotones(false);
		txtCodigoVenta.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		txtCodigoVenta.setEditable(true);
		habilitarBotones(false);
		txtCodigoVenta.requestFocus();
	}
	//  M�todos tipo void (sin par�metros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblPersona.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8));  // c venta
		tcm.getColumn(1).setPreferredWidth(anchoColumna(8));  // c cliente
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  // nombre
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // apellido
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10));  // codproducto
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12));  // nombre
		tcm.getColumn(6).setPreferredWidth(anchoColumna(6));
	}
	void listar() {
	    modelo.setRowCount(0); // Limpia la tabla antes de llenarla
	    for (int i = 0; i < av.tamanio(); i++) {
	        Ventas x = av.obtener(i);
	        Cliente cliente = ac.buscar(x.getCod_cliente());
	        Producto producto = ap.buscar(x.getCod_producto());

	        double subtotal = x.calcularSubtotal(ap);
	        double igv = x.calcularIGV(ap);
	        double totalPagar = x.calcularTotalPagar(ap);

	        Object[] fila = {
	            x.getCod_ventas(),
	            x.getCod_cliente(),
	            cliente != null ? cliente.getNombres() : "No encontrado",
	            cliente != null ? cliente.getApellidos() : "No encontrado",
	            x.getCod_producto(),
	            producto != null ? producto.getNombre() : "No encontrado",
	            x.getCantidad(),
	            producto != null ? producto.getPrecio() : 0.0,
	            subtotal,
	            igv,
	            totalPagar
	        };
	        modelo.addRow(fila);
	    }
	}

	void adicionarVenta() {
        try {
            int codCliente = Integer.parseInt(txtCodCliente.getText().trim());
            if (txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado. Verifica el código de cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codProducto = Integer.parseInt(txtCodigoProducto.getText().trim());
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());

            Producto producto = ap.buscar(codProducto);
            double precio = producto != null ? producto.getPrecio() : 0.0;
            if (precio == 0.0) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado o precio no disponible.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String fecha = txtFecha.getText().trim();
         // Validar formato de fecha
            if (!validarFecha(fecha)) {
                JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Debe ser mm/dd/aaaa.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Ventas nuevaVenta = new Ventas(av.codigoCorrelativo(), codCliente, codProducto, cantidad, precio, fecha);
            av.adicionar(nuevaVenta);

            listar(); // Este método actualiza la lista de ventas
            JOptionPane.showMessageDialog(this, "Venta adicionada con éxito");
            limpiarEntradas();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	private void agregarDocumentListener() {
	    txtCodCliente.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            buscarCliente();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            buscarCliente();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            // No lo usamos en este caso
	        }

			
	    });
	    
	    txtCodigoProducto.getDocument().addDocumentListener(new DocumentListener(){
	    	@Override
	    	public void insertUpdate(DocumentEvent e) {
	    		buscarProductos();
	    	}
	    	
	    	@Override
	    	public void removeUpdate(DocumentEvent e) {
	    		buscarProductos();
	    	}
	    	
	    	@Override
	    	public void changedUpdate(DocumentEvent e) {
	    		//no se usa
	    	}
	    });
	}

	// Método que busca un cliente en el arreglo por su código
	private void buscarCliente() {
	    try {
	        int codCliente = Integer.parseInt(txtCodCliente.getText().trim());
	        Cliente cliente = buscarClientePorCodigo(codCliente);

	        if (cliente != null) {
	            txtNombre.setText(cliente.getNombres());
	            txtApellido.setText(cliente.getApellidos()); // Si tienes un campo para apellidos
	        } else {
	            txtNombre.setText("");
	            txtApellido.setText(""); // Si tienes un campo para apellidos
	        }
	    } catch (NumberFormatException e) {
	        txtNombre.setText("");
	        txtApellido.setText(""); // Si tienes un campo para apellidos
	    }
	}
	// Método que busca un cliente en el arreglo por su código
	private void buscarProductos() {
	    try {
	        int codProducto = Integer.parseInt(txtCodigoProducto.getText().trim());
	        Producto prod = buscarProductoPorCodigo(codProducto);

	        if (prod != null) {
	        	txtNombreProducto.setText(prod.getNombre());
	        	txtPrecio.setText(String.valueOf(prod.getPrecio()));
	        } else {
	        	txtNombreProducto.setText("");
	        	txtPrecio.setText(String.valueOf(""));
	        }
	    } catch (NumberFormatException e) {
	    	txtNombreProducto.setText("");
	    	txtPrecio.setText(String.valueOf(""));
	    }
	}

	private Cliente buscarClientePorCodigo(int codigo) {
	    // Recorremos el arregloClientes para buscar el cliente con el código ingresado
	    for (Cliente cliente : ac.getClientes()) {
	        if (cliente.getCodigoCliente() == codigo) {
	            return cliente;
	        }
	    }
	    // Si no se encuentra ningún cliente con ese código, devolvemos null
	    return null;
	}
	
	private Producto buscarProductoPorCodigo(int codigo) {
	    // Recorremos el arregloClientes para buscar el cliente con el código ingresado
	    for (Producto prod : ap.getProductos()) {
	        if (prod.getCod_producto() == codigo) {
	            return prod;
	        }
	    }
	    // Si no se encuentra ningún cliente con ese código, devolvemos null
	    return null;
	}
	void consultarVenta() {
		try {
			int codigo = leerCodigoVenta();
			System.out.println(codigo);
			Ventas x = av.buscarVenta(codigo);
			System.out.println(x);
	        
			if (x != null) {
				Cliente cli = ac.buscar(x.getCod_cliente()); // Busca el cliente por su código
		        Producto prod = ap.buscar(x.getCod_producto()); // Busca el producto por su código
				txtCodCliente.setText(String.valueOf(x.getCod_cliente())); // Convertir a String
				txtNombre.setText(cli.getNombres());
				txtApellido.setText(cli.getApellidos());
				txtCodigoProducto.setText(String.valueOf(x.getCod_producto())); // Convertir a String
				txtNombreProducto.setText(prod.getNombre());
				txtCantidad.setText(String.valueOf(x.getCantidad()));
				txtPrecio.setText(String.valueOf(prod.getPrecio()));
				txtFecha.setText(x.getFecha());
				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodigoVenta.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
					txtCodCliente.requestFocus();
				}
				if (tipoOperacion == ELIMINAR) {
					txtCodigoVenta.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
				}
			}else
				error("El código " + codigo + " no existe", txtCodigoVenta);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigoVenta);
		}
	}
	void modificarVenta() {
		try {
			int codigo = leerCodigoVenta();
			Ventas x = av.buscarcod(codigo);
 
			if (x != null) {
				Producto prod = ap.buscar(x.getCod_producto());
				Cliente cli = ac.buscar(x.getCod_cliente());
				int codCliente = leerCodigoCliente();
				String nombrecliente = leerNombreCliente();
				String apellidoCliente = leerApellido();
				int codProducto = leerCodigoProducto();
				String nombreproducto = leerNombreProducto();
				int cant = leerCantidad();
	            String fecha = txtFecha.getText().trim();
	            Double precio = Double.parseDouble(txtPrecio.getText().trim());
	            if (!validarFecha(fecha)) {
	                JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Debe ser mm/dd/aaaa.", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            x.setCod_cliente(codCliente);
	            cli.setNombres(nombrecliente);
	            cli.setApellidos(apellidoCliente);
				x.setCod_producto(codProducto);
				prod.setNombre(nombreproducto);
				x.setCantidad(cant);
				prod.setPrecio(precio);
				x.setFecha(fecha);
				av.actualizarArchivo();
				listar();
				txtCodCliente.requestFocus();
				mensaje("Se modifico la venta # " + codigo);
				limpiarEntradas();

			}
			else
				error("El c�digo " + codigo + " no existe", txtCodigoVenta);
		}
		catch (Exception e) {
			error("Ingrese C�DIGO correcto", txtCodigoVenta);
		}
	}
	void eliminarVenta() {
		try {
			int codigo = leerCodigoVenta();
			Ventas x = av.buscarcod(codigo);
			if (x != null) {
				int ok = confirmar("� Desea eliminar el registro ?");
				if (ok == 0) {
					av.eliminar(x);
					listar();
					mensaje("Registro eliminado correctamente con codigo: " + codigo);
					btnOK.setEnabled(false);
				}
			}
			else
				error("El c�digo " + codigo + " no existe", txtCodigoVenta);
		}
		catch (Exception e) {
			error("Ingrese C�DIGO correcto", txtCodigoVenta);
		}	
	}
	//  M�todos tipo void (con par�metros)
	void habilitarEntradas(boolean sino) {
		txtCodCliente.setEditable(sino);
		txtFecha.setEditable(sino);
		//txtNombre.setEditable(sino);
		//txtApellido.setEditable(sino);
		txtCodigoProducto.setEditable(sino);
		//txtNombreProducto.setEditable(sino);
		txtCantidad.setEditable(sino);
		//txtPrecio.setEditable(sino);
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
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	//  M�todos que retornan valor (sin par�metros)
	int leerCodigoVenta() {
		return Integer.parseInt(txtCodigoVenta.getText().trim());
	}
	int leerCodigoCliente() {
		return Integer.parseInt(txtCodCliente.getText().trim());
	}
	
	String leerNombreCliente() {
		return txtNombre.getText().trim();
	}
	
	String leerApellido() {
		return txtApellido.getText().trim();
	}
	
	int leerCodigoProducto() {
		return Integer.parseInt(txtCodigoProducto.getText().trim());
	}

	String leerNombreProducto() {
		return txtNombreProducto.getText().trim();
	}
	
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText().trim());
	}

	//  M�todos que retornan valor (con par�metros)
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
        txtCodCliente.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCodigoProducto.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtFecha.setText("");
        txtCodCliente.requestFocus();
        habilitarEntradas(false);
        habilitarBotones(true);
    }  
    private boolean validarFecha(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false); // Para evitar que acepte fechas no válidas
        try {
            Date date = sdf.parse(fecha);
            return true; // La fecha es válida true comparacion
        } catch (ParseException e) {
            return false; // La fecha no es válida false 
        } 
    }
}