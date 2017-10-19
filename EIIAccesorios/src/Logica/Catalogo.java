package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;



public class Catalogo {
	private static final String FICHERO_CATALOGO = "files/articulos.dat";
	private List<Articulo> articulosCatalogo = null;


	public Catalogo() {
		articulosCatalogo = new ArrayList<Articulo>();
		cargarArticulos();
		aplicarOferta();
	}

	private void cargarArticulos() {
		String linea = "";
		String[] datosArticulo = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					FICHERO_CATALOGO));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosArticulo = linea.split(";");
				articulosCatalogo.add(new Articulo(datosArticulo[0],
						datosArticulo[1], datosArticulo[2],datosArticulo[3],
						datosArticulo[4], Float.parseFloat(datosArticulo[5]),
						Integer.parseInt(datosArticulo[6]), Integer
								.parseInt(datosArticulo[7])));
			}
			fichero.close(); 
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public Articulo[] getArticulos() {
		Articulo[] articulos = articulosCatalogo
				.toArray(new Articulo[articulosCatalogo.size()]);
		return articulos;
	}

	
	
	public ArrayList<Articulo> cargarArticulos(String categoria) {
		ArrayList<Articulo> Articulos = new ArrayList<Articulo>();
		for (Articulo a : getArticulos()) {
			if (a.getSubcategoria().equals(categoria)) {
				Articulos.add(a);
			}
		}
		return Articulos;
	
	}
	

	
	public Articulo getArticulo(String articulo){
		Articulo art= null;
		for(Articulo a:articulosCatalogo){
			if(a.getDenominacion().equals(articulo)){
				art=a;
			}
		}
		return art;
	}
	
	
	public ArrayList<Articulo> filtrar(String categoria, boolean menor50,
			boolean entre50y99, boolean entre100y499, boolean mas500,
			boolean todos) {	
		
		ArrayList<Articulo> filtrados = new ArrayList<Articulo>();
		for (Articulo a : cargarArticulos(categoria)) {
			if (a.getPrecio() < 50 && menor50) {
				filtrados.add(a);
				System.out.println(a);
			}
			if ((a.getPrecio() >= 50 && a.getPrecio() <= 99) && entre50y99) {
				filtrados.add(a);
			}
			if ((a.getPrecio() >= 100 && a.getPrecio() <= 499) && entre100y499) {
				filtrados.add(a);
			}
			if (a.getPrecio() >= 500 && mas500) {
				filtrados.add(a);
			}
			if (todos) {
				filtrados.add(a);
			}
			System.out.println(filtrados);
		}
		return filtrados;
	}
	
	public String generarCategoriaEnOferta() {
		String[] str = new String[5];
		str[0] = "Consolas y Videojuegos";
		str[1] = "Fotografía y Vídeo";
		str[2] = "Telefonía Móvil";
		str[3] = "Ordenadores y Tablets";
		str[4] = "Videovigilancia";

		int valorEntero = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		asignarOfertaArticulos(str[valorEntero]);
		return str[valorEntero];
	}
	
	
	public void asignarOfertaArticulos(String categoria){
		for(Articulo a:articulosCatalogo){
			if(categoria.equals(a.getCategoria())){
				a.setOferta(true);
			}
		}
	}

	public void aplicarOferta() {
		String categoria = generarCategoriaEnOferta();
//		System.out.println(categoria);
//		for (Articulo a : articulosCatalogo) {
//			if (a.getCategoria().equals(categoria)) {
//				System.out.println(a.getPrecio());
//			}
//		}
		
		for (Articulo a : articulosCatalogo) {
			if (a.getCategoria().equals(categoria)) {
				float descontar = (float) (a.getPrecio() * 0.1);
				float descontado = a.getPrecio() - descontar;
				a.setPrecio(descontado);
			}
		}

//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");
//		System.out.println("-----------------------------");

//		for (Articulo a : articulosCatalogo) {
//			if (a.getCategoria().equals(categoria)) {
//				System.out.println(a.getPrecio());
//			}
//		}
	}
	
	public void grabarArticulos() {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(
					"files/articulos.dat"));
			String linea = articulosCatalogo.toString();
//			// Sirve para quitar corchetes y comas que no queremos
//			String remplazado = linea.replace(",", "");
//			String reremplazado = remplazado.replace("[", "");
//			linea = reremplazado.replace("]", "");
			fichero.write(linea);
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	
	
}
