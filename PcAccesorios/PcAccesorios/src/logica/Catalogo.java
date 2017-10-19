package logica;
import java.io.*;
import java.util.*;

public class Catalogo {
	
	private static final String FICHERO_CATALOGO = "files/articulos.dat";
	private List<Articulo> articulosCatalogo = null;
	
	public Catalogo(){
		articulosCatalogo = new ArrayList<Articulo>();
		cargarArticulos();
	}

	private void cargarArticulos(){
	    String linea = "";
	    String[] datosArticulo= null;
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(FICHERO_CATALOGO));
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        datosArticulo = linea.split("@");
	        articulosCatalogo.add(new Articulo(datosArticulo[0],datosArticulo[1],Float.parseFloat(datosArticulo[2]),0));
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe) {
	      System.out.println("El archivo no se ha encontrado.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("Error de entrada/salida.");
	    } 
	  }

	public Articulo[] getArticulos(){
		Articulo[] articulos = articulosCatalogo.toArray(new Articulo[articulosCatalogo.size()]);
		return articulos;	
	}
	
	public void inicializar(){
		for(Articulo a:articulosCatalogo){
			a.setUnidades(0);
		}
	}
	
}
