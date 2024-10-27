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

import arreglosClientes.ClienteArreglosDatos;
import identidades.Cliente;

public class MantenimientoClientesVERSION3 extends JDialog implements ActionListener {
	
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
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtDireccion;
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
					MantenimientoClientesVERSION3 dialog = new MantenimientoClientesVERSION3();
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
	 
	public MantenimientoClientesVERSION3() {
		setResizable(false);
		setTitle("Mantenimiento | Persona");
		setBounds(100, 100, 810, 610);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 10, 110, 23);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 35, 70, 23);
		getContentPane().add(lblNombre);
	
		lblApellidos = new JLabel("Apellido");
		lblApellidos.setBounds(10, 60, 70, 23);
		getContentPane().add(lblApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 85, 70, 23);
		getContentPane().add(lblDni);
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(10, 110, 70, 23);
		getContentPane().add(lblDireccion);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 135, 86, 23);
		getContentPane().add(lblTelefono);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(90, 10, 86, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(90, 35, 138, 23);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(90, 60, 138, 23);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(90, 85, 138, 23);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(90, 110, 318, 23);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(240, 10, 101, 23);
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
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DNI");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		tblPersona.setModel(modelo);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(90, 135, 138, 23);
		getContentPane().add(txtTelefono);
		
		JButton btnNewButton = new JButton("CERRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal secondWindow = new VentanaPrincipal();
                secondWindow.setVisible(true);
                dispose(); // Cierra la ventana principal
			}
		});
		btnNewButton.setBounds(654, 135, 130, 23);
		getContentPane().add(btnNewButton);
		
		ajustarAnchoColumnas();
		listar();
		
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	
	//  Declaración global
	ClienteArreglosDatos ac = new ClienteArreglosDatos();
	private JTextField txtTelefono;
	
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
		consultarPersona();
	}
	protected void actionPerformedBtnOK(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarPersona();
				break;
			case CONSULTAR:
				consultarPersona();
				break;
			case MODIFICAR:
				modificarPersona();
				break;
			case ELIMINAR:
				eliminarPersona();
		}
	}
	protected void actionPerformedBtnOpciones(ActionEvent arg0) {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		txtCodigo.setText("" + ac.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	//  Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblPersona.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  // APELLIDO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // peso DNI
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));  // estatura DIRECCION
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12));  // estadoCivil TELEFONO
	}
	void listar() {
		Cliente x;
		modelo.setRowCount(0);
		for (int i=0; i<ac.tamanio(); i++) {
			x = ac.obtener(i);
			Object[] fila = { x.getCodigoCliente(),
					          x.getNombres(),
					          x.getApellidos(),
					          x.getDni(),
					          x.getDireccion(),
					          x.getTelefono() };
			modelo.addRow(fila);
		}
	}
	void adicionarPersona() {
        try {
            int codigoCorrelativo = ac.codigoCorrelativo();
            String nombre = leerNombre();
            String apellido = leerApellido();
            String direccion = leerDireccion();
            String telefono = leerTelefono();
            String dni = leerDni();

            if (nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || dni.isEmpty()) {
                mensaje("Complete todos los campos...");
                return;
            }
            
            if (telefono.charAt(0) != '9') {
                mensaje("El número de celular debe empezar con 9");
                return;
            }
            
            if (dni.length() != 8 || telefono.length() != 9) {
                mensaje("DNI debe tener 8 dígitos y teléfono 9 dígitos");
                return;
            }

            Cliente x = ac.buscar(dni);
            if (x == null) {
            	Cliente nuevocliente = new Cliente(codigoCorrelativo, nombre, apellido, direccion, telefono, dni);
                ac.adicionar(nuevocliente);
                listar();
                limpiarEntradas();
                mensaje("Ingreso exitoso");
                //txtCodigo.setText(String.valueOf(ac.codigoCorrelativo()));
            } else {
                mensaje("El DNI de la persona ya existe.");
            }
        } catch (Exception e2) {
            mensaje("Error al completar todos los campos.");
        }
	}
		

	void consultarPersona() {
		try {
			int codigo = leerCodigo();
			Cliente x = ac.buscar(codigo);
			if (x != null) {
				txtNombre.setText(x.getNombres());
				txtApellido.setText(x.getApellidos());
				txtDNI.setText(x.getDni());
				txtDireccion.setText(x.getDireccion());
				txtTelefono.setText(x.getTelefono());

				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
					txtNombre.requestFocus();
				}
				if (tipoOperacion == ELIMINAR) {
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodigo);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}
	void modificarPersona() {
		try {
			int codigo = leerCodigo();
			Cliente x = ac.buscar(codigo);
			if (x != null) {
				String nombre = leerNombre();
				String apellido = leerApellido();
				String dni=leerDni();
				String direccion = leerDireccion();
				String telefono = leerTelefono();
				if (nombre.length() > 0)
					try {
						x.setNombres(nombre);
						x.setApellidos(apellido);
						x.setDni(dni);
						x.setDireccion(direccion);
						x.setTelefono(telefono);
						ac.actualizarArchivo();
						listar();
						mensaje("Se Modifico los datos del cliente con codigo: " + codigo);
						txtNombre.requestFocus();
					}
					catch (Exception e) {
						error("Ingrese DNI correcto", txtDNI);
					}
				else
					error("Ingrese NOMBRE correcto", txtNombre);
			}
			else
				error("El código " + codigo + " no existe", txtCodigo);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}
	void eliminarPersona() {
		try {
			int codigo = leerCodigo();
			Cliente x = ac.buscar(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					ac.eliminar(x);
					listar();
					mensaje("Se elimino el registro con código: " + codigo);
					btnOK.setEnabled(false);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodigo);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}	
	}
	//  Métodos tipo void (con parámetros)
	void habilitarEntradas(boolean sino) {
		txtNombre.setEditable(sino);
		txtApellido.setEditable(sino);
		txtDNI.setEditable(sino);
		txtDireccion.setEditable(sino);
		txtTelefono.setEditable(sino);
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
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	
	String leerApellido() {
		return txtApellido.getText().trim();
	}
	
	String leerDni() {
		return txtDNI.getText().trim();
	}

	String leerDireccion() {
		return txtDireccion.getText().trim();
	}
	
	String leerTelefono() {
		return txtTelefono.getText().trim();
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
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDNI.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCodigo.requestFocus();
        habilitarEntradas(false);
        habilitarBotones(true);
    }
}