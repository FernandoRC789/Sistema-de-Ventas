package identidades;

import arreglosClientes.ProductosArreglo;

public class Ventas {
	public int cod_ventas, cod_cliente, cod_producto, cantidad;
	public double precio;
	public String fecha;

	public Ventas(int cod_ventas, int cod_cliente,
            int cod_producto, int cantidad, double precio, String fecha) {
		this.cod_ventas = cod_ventas;
		this.cod_cliente = cod_cliente;
		this.cod_producto = cod_producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
}
	
	public Ventas() {
		
	}

	
	
	public int getCod_ventas() {
		return cod_ventas;
	}
	public void setCod_ventas(int cod_ventas) {
		this.cod_ventas = cod_ventas;
	}
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public int getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
    public double calcularSubtotal(ProductosArreglo productos) {
        Producto producto = productos.buscar(cod_producto); // Busca el producto por su código
        if (producto != null) {
            return cantidad * producto.getPrecio(); // Calcula el subtotal
        }
        return 0.0; // Si el producto no se encuentra, retorna 0
    }

    public double calcularIGV(ProductosArreglo productos) {
        return calcularSubtotal(productos) * 0.18; // Calcula el IGV
    }

    public double calcularTotalPagar(ProductosArreglo productos) {
        return calcularSubtotal(productos) + calcularIGV(productos); // Total a pagar
    }
	
}
