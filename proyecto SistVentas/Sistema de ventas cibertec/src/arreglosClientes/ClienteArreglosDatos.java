package arreglosClientes;

import java.io.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import identidades.Cliente;

public class ClienteArreglosDatos {
	//atributo privado
	private ArrayList <Cliente> cli;
	//constructor
	public ClienteArreglosDatos(){
		cli = new ArrayList <Cliente> ();
		cargarClientes();
	}
	
	//operaciones basicas: adicionar
	public void adicionar(Cliente x) {
		cli.add(x);
		grabarClientes();
	}
	
	public int tamanio() {
		return cli.size();
	}
	
	public Cliente obtener(int x) {
		return cli.get(x);
	}
	
	public Cliente buscar(int codigoCliente) {
		//Cliente x;
		for(int i=0; i<tamanio(); i++) {
			//x = obtener(i);
			if(codigoCliente==obtener(i).getCodigoCliente())
				return obtener(i);
		}
		return null;
	}
	
	public Cliente buscar(String dni) {
		Cliente x;
		for(int i=0; i<tamanio(); i++) {
			x=obtener(i);
			if(x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	
	public void eliminar(Cliente x) {
		cli.remove(x);
		grabarClientes();
	}
	
	public void actualizarArchivo(){
		grabarClientes();
	}
	
	
	private void grabarClientes(){
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for(int i=0; i<tamanio(); i++){
				x=obtener(i);
				linea = x.getCodigoCliente() + ";" +
						x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDni() + ";"+
						x.getDireccion() + ";" +
						x.getTelefono();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	private void cargarClientes() {
		try {
			BufferedReader br;
			String linea,nombre,apellido,dni,direccion,telefono;
			String s[];
			int codigoCliente;
			br =new BufferedReader(new FileReader("clientes.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoCliente = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				apellido = s[2].trim();
				dni = s[3].trim();
				direccion = s[4].trim();
				telefono = s[5].trim();
				adicionar(new Cliente(codigoCliente,nombre,apellido,dni,direccion,telefono));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
	
	public int codigoCorrelativo() {
		if(tamanio() == 0)
			return 1001;
		else 
			return obtener(tamanio()-1).getCodigoCliente()+1;
	}
	public ArrayList<Cliente> getClientes() {
	    return cli; // Asegúrate de que 'cli' no sea null
	}

	

}
