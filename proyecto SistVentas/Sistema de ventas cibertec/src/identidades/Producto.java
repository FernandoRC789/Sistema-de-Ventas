package identidades;

public class Producto {
	public int cod_producto,stock_actual, stock_min, stock_max;
	public double precio;
	public String nombre;

	public Producto(int cod_producto, String nombre,double precio, int stock_actual, int stock_min, int stock_max) {
		this.cod_producto = cod_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock_actual = stock_actual;
		this.stock_min = stock_min;
		this.stock_max = stock_max;
	}

	public int getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}

	public int getStock_min() {
		return stock_min;
	}

	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}

	public int getStock_max() {
		return stock_max;
	}

	public void setStock_max(int stock_max) {
		this.stock_max = stock_max;
	}

	public int getStock_actual() {
		return stock_actual;
	}

	public void setStock_actual(int stock_actual) {
		this.stock_actual = stock_actual;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
