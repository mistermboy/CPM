package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Regalos {
	private static final String FICHERO_REGALOS = "files/regalos.dat";
	private List<Articulo> regalos = null;

	public Regalos() {
		regalos = new ArrayList<Articulo>();
		cargarRegalos();
	}

	private void cargarRegalos() {
		String linea = "";
		String[] datosRegalo = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					FICHERO_REGALOS));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosRegalo = linea.split(";");
				regalos.add(new Articulo(datosRegalo[0], datosRegalo[1],
						datosRegalo[2], Integer.parseInt(datosRegalo[3])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public Articulo[] getArticulos() {
		Articulo[] reg = regalos.toArray(new Articulo[regalos.size()]);
		return reg;
	}

	public String[] getArrayArticulos(){
		Articulo[] articulos = regalos.toArray(new Articulo[regalos.size()]);
		String[] str= new String[articulos.length];
		for(int i=0;i<articulos.length;i++){
			str[i]=articulos[i].toString();
		}
		
		
		return str;	
	}
	
	
	public Articulo getArticulo(String articulo){
		Articulo art= null;
		for(Articulo a:regalos){
			if(a.getDenominacion().equals(articulo)){
				art=a;
			}
		}
		System.out.println(art);
		return art;
	}
}
