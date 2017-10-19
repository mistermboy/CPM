package logica;

public class Corredor {

	private int puntuacion;
	private int posicion;
	public final static int POSICION_SALIDA=0;
	
	
	public Corredor(){
		System.out.println("Generando corredor");
		setPosicion(POSICION_SALIDA);
		setPuntuacion(0);
	}


	private void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}


	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}


	public int getPuntuacion() {
		return puntuacion;
	}


	public int getPosicion() {
		return posicion;
	}
	
	public void incrementarPuntuacion(){
		this.puntuacion+=100;
	}
}
