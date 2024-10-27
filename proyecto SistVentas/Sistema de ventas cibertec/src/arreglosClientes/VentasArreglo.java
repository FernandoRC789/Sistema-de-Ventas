package arreglosClientes;

import java.util.ArrayList;
import java.io.*;
import identidades.Ventas;
import identidades.Cliente;
import identidades.Producto;

public class VentasArreglo {
    private ArrayList<Ventas> ventas;
    private ClienteArreglosDatos clientes; // Arreglo de clientes
    private ProductosArreglo productos; // Arreglo de productos

    // Constructor con arreglos de clientes y productos
    public VentasArreglo(ClienteArreglosDatos clientes, ProductosArreglo productos) {
        ventas = new ArrayList<>();
        this.clientes = clientes;
        this.productos = productos;
        cargarVentas();
    }

    private void grabarVentas() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("ventas.txt"))) {
            for (Ventas x : ventas) {
                Cliente cliente = clientes.buscar(x.getCod_cliente());
                Producto producto = productos.buscar(x.getCod_producto());

                String nombreCliente = cliente != null ? cliente.getNombres() : "Desconocido";
                String apellidoCliente = cliente != null ? cliente.getApellidos() : "Desconocido";
                String nombreProducto = producto != null ? producto.getNombre() : "Desconocido";

                double importe = x.calcularSubtotal(productos);
                double igv = x.calcularIGV(productos); // 18% IGV
                double totalPagar = x.calcularTotalPagar(productos);

                String linea = x.getCod_ventas() + ";" +
                        x.getCod_cliente() + ";" + 
                        nombreCliente + ";" +
                        apellidoCliente + ";" +
                        x.getCod_producto() + ";" +
                        nombreProducto + ";" +
                        x.getCantidad() + ";" +
                        x.getPrecio() + ";" +
                        x.getFecha() + ";" +
                        importe + ";" + // Importe total
                        igv + ";" + // IGV
                        totalPagar; // Total a pagar

                pw.println(linea);
            }	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void cargarVentas() {
        File archivo = new File("ventas.txt");
        if (!archivo.exists()) {
            System.out.println("El archivo 'ventas.txt' no se encuentra. Asegúrate de que el archivo exista.");
            return; // Sale del método si no existe el archivo
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] s = linea.split(";");
                int codVenta = Integer.parseInt(s[0].trim());
                int codCliente = Integer.parseInt(s[1].trim());
                int codProducto = Integer.parseInt(s[4].trim());
                int cantidad = Integer.parseInt(s[6].trim());
                double precio = Double.parseDouble(s[7].trim());
                String fecha = s[8].trim();

                // Adicionar la venta usando los códigos
                adicionar(new Ventas(codVenta, codCliente, codProducto, cantidad, precio, fecha));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int tamanio() {
        return ventas.size();
    }

    public Ventas obtener(int x) {
        return ventas.get(x);
    }
        
    public Ventas buscar(int codigo) {
        for (Ventas v : ventas) {
            if (v.getCod_producto() == codigo) {
                return v;
            }
        }
        return null;
    }
    
	public Ventas buscarcod(int codigoventa) {
		//Cliente x;
		for(int i=0; i<tamanio(); i++) {
			//x = obtener(i);
			if(codigoventa==obtener(i).getCod_ventas())
				return obtener(i);
		}
		return null;
	}
    
    public Ventas buscarVenta(int codVenta) {
        for (Ventas v : ventas) {
            if (v.getCod_ventas() == codVenta) {
                return v;
            }
        }
        return null; // Retorna null si no encuentra la venta
    }
    
    public void eliminar(Ventas x) {
        ventas.remove(x);
        grabarVentas();
    }
    
    public void actualizarArchivo() {
        grabarVentas();
    }
    
    public void adicionar(Ventas x) {
        ventas.add(x);
        grabarVentas();
    }

    public int codigoCorrelativo() {
        if (tamanio() == 0)
            return 3001;
        else 
            return obtener(tamanio() - 1).getCod_ventas() + 1; // Corregido a getCod_ventas
    }
    
    public void modificarVenta(Ventas venta) {
        // Aquí podrías agregar lógica para modificar una venta existente
    }

    public void eliminarVenta(Ventas venta) {
        ventas.remove(venta);
        grabarVentas();
    }

    public ArrayList<Ventas> listarVentas() {
        return new ArrayList<>(ventas); // Retorna una copia de la lista de ventas
    }
}
