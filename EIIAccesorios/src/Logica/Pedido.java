package Logica;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private List<Articulo> articulosPedido = null;
	private List<Articulo> articulosRegaloPedido = null;
	private float precioTotal=0;
	private float descuento=0;
	
	
	public Pedido(){
		articulosPedido = new ArrayList<Articulo>();
		articulosRegaloPedido = new ArrayList<Articulo>();
	}
	
	public void add(Articulo articulo, int unidades){
		Articulo articuloEnPedido = null;
	
		for (Articulo a : articulosPedido){
			if (a.getCodigo().equals(articulo.getCodigo()))
				articuloEnPedido = a;
		}
		
		if (articuloEnPedido == null){
			articulo.setUnidadesPedido(unidades);
			articulosPedido.add(articulo);
		}
		else{
			int totalUnidades = articuloEnPedido.getUnidadesPedido() + unidades;
			articuloEnPedido.setUnidadesPedido(totalUnidades);
		}
	}
	
	public void addRegalo(Articulo articulo){
			articulo.setUnidadesPedido(1);
			articulosRegaloPedido.add(articulo);
	
	}
	
	public float calcularTotalSinIva(){
		float total = 0.0f;
		
		for (Articulo a : articulosPedido){
			total += a.getPrecio()* a.getUnidadesPedido();
		}
		precioTotal=total;
		return total;
	}
	
	
	
	public float calcularPrecioDescuento(float puntos){
		if(puntos<calcularTotalSinIva()){
			descuento=puntos;
		}else{
			descuento=calcularTotalSinIva();
		}
		 
		System.out.println(descuento);
		return descuento;
	}
	
	
	public float total(){
		return calcularTotalSinIva()-descuento;
	}
	
	public void grabarPedido(String nombreFichero,StringBuffer buffer){
		try {
		        BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFichero + ".dat"));
		        fichero.write(buffer.toString());
		        fichero.close();
			}

		catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha podido guardar");
		    }
		catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}
	  }

	public void inicializar(){
		articulosPedido.clear();
	}
	
	public void remove(Articulo articuloParaEliminar, int unidades){
		for(Articulo articulo:articulosPedido){
			if(articulo.getCodigo().equals(articuloParaEliminar.getCodigo())){
				int nuevasUnidades = articulo.getUnidadesPedido() - unidades;
				if(nuevasUnidades <=0){
					articulo.setUnidadesPedido(0);
					articulosPedido.remove(articulo);
				}else{
					articulo.setUnidadesPedido(nuevasUnidades);
				}
				return;
			}
		}
	}
	
	public List<Articulo> getArticulos(){
		return articulosPedido;
	}
	
	public String[] getArrayArticulos(){
		Articulo[] articulos = articulosPedido.toArray(new Articulo[articulosPedido.size()]);
		String[] str= new String[articulos.length];
		for(int i=0;i<articulos.length;i++){
			str[i]=articulos[i].toString();
		}
		
		
		return str;	
	}

	
	public float getDescuento() {
		return descuento;
	}

	public List<Articulo> getArticulosRegalo(){
		return articulosRegaloPedido;
	}
	
}