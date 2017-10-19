package logica;

public class Carrera {
	
	private Corredor caballo;
	private Tablero tablero;
	
	public Carrera(){
		inicializarJuego();
	}
	
	public void inicializarJuego(){
		System.out.println("Generando carrera");
		caballo = new Corredor();
		tablero = new Tablero();
		
	}
	
	public void resolverGalope(){
		if(isGalopeCorrecto()){
			caballo.setPosicion(caballo.getPosicion()+1);
			caballo.incrementarPuntuacion();
		}
	}

	private boolean isGalopeCorrecto() {
		if((int) caballo.getPosicion() ==2 || (int) caballo.getPosicion() ==8){
			return false;
		}else{
			return true;
		}
	}
	
	public void resolverSalto(){
		if(isSaltoCorrecto()){
			caballo.setPosicion(caballo.getPosicion()+2);
			caballo.incrementarPuntuacion();
		}
	}

	private boolean isSaltoCorrecto() {
		if((int) caballo.getPosicion() ==2){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isPartidaFinalizada(){
		if((int) caballo.getPosicion() ==8){
			return true;
		}else{
			return false;
		}
	}
	
	public Corredor getCaballo(){
		return caballo;
	}
}
