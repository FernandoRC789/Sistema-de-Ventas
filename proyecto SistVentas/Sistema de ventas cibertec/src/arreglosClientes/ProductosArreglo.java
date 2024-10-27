package arreglosClientes;

import java.util.ArrayList;
import java.io.*;

import identidades.Producto;

public class ProductosArreglo {
	//atribut privado de arreglo
	private ArrayList<Producto> prod;


	public ProductosArreglo() {
		prod = new ArrayList<Producto>();
		cargarProductos();
	}
	public void adicionar(Producto x) {
		prod.add(x);
		grabarProductos();
	}
		
	public int tamanio() {
		return prod.size();
	}
		
	public Producto obtener(int x) {
		return prod.get(x);
	}
		
	public Producto buscar(int codigo) {
		for(int i=0; i<tamanio(); i++) {
			if(codigo==obtener(i).getCod_producto())
				return obtener(i);
		}
		return null;
	}
		
		
		public void eliminar(Producto x) {
			prod.remove(x);
			grabarProductos();
		}
		
		public void actualizarArchivo(){
			grabarProductos();
		}
		
		
		private void grabarProductos(){
			try {
				PrintWriter pw;
				String linea;
				Producto x;
				
				pw = new PrintWriter(new FileWriter("productos.txt"));
				for(int i=0; i<tamanio(); i++){
					x=obtener(i);
					linea = x.getCod_producto() + ";" +
							x.getNombre() + ";" +
							x.getPrecio() + ";" +
							x.getStock_actual() + ";" +
							x.getStock_min() + ";"+
							x.getStock_max();
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {
			}
		}
		
		private void cargarProductos() {
			try {
				BufferedReader br;
				String linea,nombre;
				String s[];
				int codigo,stockActual,stockMin,stockMax;
				double precio;
				br =new BufferedReader(new FileReader("productos.txt"));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					codigo = Integer.parseInt(s[0].trim());
					nombre = s[1].trim();
					precio = Double.parseDouble(s[2].trim());
					stockActual = Integer.parseInt(s[3].trim());
					stockMin = Integer.parseInt(s[4].trim());
					stockMax= Integer.parseInt(s[5].trim());
					adicionar(new Producto(codigo,nombre,precio,stockActual,stockMin,stockMax));
				}
				br.close();	
			}
			catch (Exception e) {
			}
		}
		
		public int codigoCorrelativo() {
			if(tamanio() == 0)
				return 2001;
			else 
				return obtener(tamanio()-1).getCod_producto()+1;
		}
		
		public ArrayList<Producto> getProductos() {
		    return prod; // Asegúrate de que 'cli' no sea null
		}
}