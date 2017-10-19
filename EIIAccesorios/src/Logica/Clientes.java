package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clientes {
	private static final String FICHERO_CLIENTES = "files/clientes.dat";
	private List<Usuario> clientes = null;
	private Usuario usuarioActivo=new Usuario("Anonimo", "Anonimo", "Anonimo", "Anonimo", "Anonimo", "1000101");
	
	public Clientes(){
		clientes = new ArrayList<Usuario>();
		cargarClientes();
	}
	
	
	private void cargarClientes() {
		String linea = "";
		String[] datosCliente = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					FICHERO_CLIENTES));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosCliente = linea.split(";");
				clientes.add(new Usuario(datosCliente[0], datosCliente[1],
						datosCliente[2], datosCliente[3], datosCliente[4],
						datosCliente[5], datosCliente[6],
						Integer.parseInt(datosCliente[7])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	
	
	public Usuario[] getClientes() {
		Usuario[] usuarios = clientes.toArray(new Usuario[clientes.size()]);
		return usuarios;
	}
	
	
	
	public boolean registrarCliente(String nombre, String apellidos,
			String NIF, String usuario, String contraseña, String telefono) {
			boolean aux = false;
			aux = coincideNIF(NIF); //Comprobamos que no coincidan los nifs
			if (!aux) {
				clientes.add(new Usuario(nombre, apellidos, NIF, usuario,
						contraseña, telefono));
				grabarClientes();
				return true;
			}
			return false;
	}
	
	public void grabarClientes() {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(
					"files/clientes.dat"));
			String linea = clientes.toString();
			// Sirve para quitar corchetes y comas que no queremos
			String remplazado = linea.replace(",", "");
			String reremplazado = remplazado.replace("[", "");
			linea = reremplazado.replace("]", "");
			fichero.write(linea);
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
	
	
	public boolean iniciarSesion(String usuario, String contraseña) {
		for (Usuario u : getClientes()) {
			if (usuario.equals(u.getUsuario()) && contraseña.equals(u.getContraseña())) {
				usuarioActivo=u;
				return true;
			}

		}
		return false;
	}
	
	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}


	public boolean coincideNIF(String NIF){
		boolean coincide = false;
		for (Usuario u : getClientes()) {
			if (u.getNIF().equals(NIF)) {
				coincide = true;
			}
		}
		return coincide;
	}


	public void inicializar(){
		usuarioActivo = new Usuario("Anonimo", "Pablo", "Anonimo", "Anonimo", "Anonimo", "1000101");
	}
	
	public void añadirPuntos(int puntos){
		usuarioActivo.setPuntos(puntos);
	}
	
	public void descontarPuntos(){
		usuarioActivo.setPuntos(0);
	}
}


