package vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglosClientes.ClienteArreglosDatos;
import arreglosClientes.ProductosArreglo;
import arreglosClientes.VentasArreglo;
import identidades.Cliente;
import identidades.Producto;
import identidades.Ventas;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Reportes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tblReportes;
    
    ClienteArreglosDatos ac = new ClienteArreglosDatos();
    ProductosArreglo ap = new ProductosArreglo();
    VentasArreglo av =new VentasArreglo(ac,ap);
	private DefaultTableModel modelo3;
	private DefaultTableModel modelo0;
	private DefaultTableModel modelo1;
	private DefaultTableModel modelo2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Reportes frame = new Reportes();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Reportes() {
        modelo0 = new DefaultTableModel();
        modelo1 = new DefaultTableModel();
        modelo2 = new DefaultTableModel();
        modelo3 = new DefaultTableModel();
        setTitle("Reportes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 876, 614);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> cboListados = new JComboBox<>();
        cboListados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int listarOperaciones = cboListados.getSelectedIndex();
                //modelo.setRowCount(0); //palabara reservada para borrar los datos de la tabla y empezar nueva tabla

                switch (listarOperaciones) {
                    case 0:
                        lista0();
                        break;
                    case 1:
                        lista1();
                        break;
                    case 2:
                        lista2();
                        break;
                    case 3:
                        lista3();
                        break;
                    default:
                        break;
                }
                //tblReportes.setModel(modelo); // actualizar o llamar a la tabla
            }
        });

        cboListados.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cboListados.setModel(new DefaultComboBoxModel<>(new String[]{
                "Listado General de Ventas mostrando cada paso.",
                "Listado de Productos cuyo Stock se encuentre menor al Stock Mínimo.",
                "Listado de productos por unidades vendidas acumuladas",
                "Listado de Productos por importe total acumulado por cada Producto."
        }));
        cboListados.setBounds(51, 96, 471, 31);
        contentPane.add(cboListados);

        JLabel lblNewLabel = new JLabel("REPORTES");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(339, 25, 151, 31);
        contentPane.add(lblNewLabel);
        
        JButton btnCerrar = new JButton("CERRAR");
        btnCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaPrincipal secondWindow = new VentanaPrincipal();
                secondWindow.setVisible(true);
                dispose(); // Cierra la ventana principal
        	}
        });
        btnCerrar.setBounds(656, 103, 151, 24);
        contentPane.add(btnCerrar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 160, 842, 393);
        contentPane.add(scrollPane);
        
        tblReportes = new JTable();
        scrollPane.setViewportView(tblReportes);
    }

    private void lista0() {
        // Limpia y reinicia el modelo para la opción 0
        modelo0.setRowCount(0);
        
        // Inicializa las columnas solo si están vacías
        if (modelo0.getColumnCount() == 0) {
            modelo0.addColumn("Cód Venta");
            modelo0.addColumn("Cód Cliente");
            modelo0.addColumn("Cód Producto");
            modelo0.addColumn("Fecha");
            modelo0.addColumn("Importe subTotal");
            modelo0.addColumn("IGV");
            modelo0.addColumn("importe total");
        }

        tblReportes.setModel(modelo0);

        for (int i = 0; i < av.tamanio(); i++) {
            Ventas vent = av.obtener(i);
            modelo0.addRow(new Object[]{
                vent.getCod_ventas(),
                vent.getCod_cliente(),
                vent.getCod_producto(),
                vent.getFecha(),
                vent.calcularSubtotal(ap),
                vent.calcularIGV(ap),
                vent.calcularTotalPagar(ap)
                
                //vent,//pendiente sub total método de la clase venta 
                //0.18,//pendiente igv o un método en clase ventas
                //vent//pendiente importe total a pagar general
            });
        }
    }

    private void lista1() {
        modelo1.setRowCount(0); 
        if (modelo1.getColumnCount() == 0) {
            modelo1.addColumn("Código");
            modelo1.addColumn("Nombre");
            modelo1.addColumn("Stock Actual");
            modelo1.addColumn("Stock Mínimo");
        }
        tblReportes.setModel(modelo1);

        for (int i = 0; i < ap.tamanio(); i++) {
            Producto prod = ap.obtener(i);
            if (prod.getStock_actual() < prod.getStock_min()) {
                modelo1.addRow(new Object[]{
                    prod.getCod_producto(),
                    prod.getNombre(),
                    prod.getStock_actual(),
                    prod.getStock_min()
                });
            }
        }
    }

    private void lista2() {
    	//listado de productos por unidades vendidas acumuladas mostrando por cada:
    	//codigo de producto,||  nombre de producto, || cantidad de unidades vendidas
        modelo2.setRowCount(0); // limpiar el modelo

        if (modelo2.getColumnCount() == 0) {
            modelo2.addColumn("Código producto");
            modelo2.addColumn("Nombre producto");
            modelo2.addColumn("Cantidad total por producto");
        }
        tblReportes.setModel(modelo2);

	    for (int i = 0; i < ap.tamanio(); i++) {//Iterar sobre los productos
	        Producto prod = ap.obtener(i);
	        int cantidadAcumulada = 0; // Reiniciar cantidad para cada producto

	        // Iterar sobre las ventas 
	        for (int j = 0; j < av.tamanio(); j++) {
	            Ventas x = av.obtener(j); 

	            if (prod.getCod_producto() == x.getCod_producto()) {//Buscar codigo prod  en venta
	                cantidadAcumulada += x.getCantidad();
	            }
	        }

	        // Solo agregar si hay unidades vendidas
	        if (cantidadAcumulada > 0) { //muestra solo las ventas si no se vendio ningun producto no aparece en la tabla
	            modelo2.addRow(new Object[]{
	                prod.getCod_producto(),
	                prod.getNombre(),
	                cantidadAcumulada
	            });
	        }
	    }
    }

    private void lista3() {
        modelo3.setRowCount(0); // Limpia las filas
        if (modelo3.getColumnCount() == 0) {
            modelo3.addColumn("Código");
            modelo3.addColumn("Nombre");
            modelo3.addColumn("Importe Total");
        }
        tblReportes.setModel(modelo3);
        
        for (int i = 0; i < ap.tamanio(); i++) {//Iterar sobre los productos
	        Producto prod = ap.obtener(i);
	        double importetotalacumulado = 0.0; // Reiniciar cantidad para cada producto

	        // Iterar sobre las ventas
	        for (int j = 0; j < av.tamanio(); j++) {
	            Ventas x = av.obtener(j); // Asegúrate de obtener el elemento correcto

	            if (prod.getCod_producto() == x.getCod_producto()) {
	            	double totalpag = x.calcularTotalPagar(ap);
	            	importetotalacumulado += totalpag;
	            }
	        }

	        // Solo agregar si hay unidades vendidas sino hay omite
	        if (importetotalacumulado > 0) { //muestra solo las ventas si no se vendio ningun producto no aparece en la tabla
	            modelo3.addRow(new Object[]{
	                prod.getCod_producto(),
	                prod.getNombre(),
	                importetotalacumulado
	            });
	        }
	    }
    }

}
