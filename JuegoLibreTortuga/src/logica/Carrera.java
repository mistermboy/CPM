package logica;

import java.util.Random;

import logica.Casilla.TipoObstaculo;


public class Carrera {

	private Corredor liebre;
	private Corredor tortuga;
	private Corredor corredorActivo;
	private int numeroDado;
	private int numeroArboles = 2;
	private int nCasillas=11;

	public Carrera() {
		inicializarJuego();
	}

	public int getnCasillas() {
		return nCasillas;
	}

	public void setnCasillas(int nCasillas) {
		this.nCasillas = nCasillas;
	}

	public int getNumeroArboles() {
		return numeroArboles;
	}

	public void setNumeroArboles(int numeroArboles) {
		this.numeroArboles = numeroArboles;
	}

	public void inicializarJuego() {
		Random r = new Random();
		boolean agujero= r.nextBoolean();	//Genera un boolean aleatorio para colocar el agujero en un panel o en otro
		boolean premio= r.nextBoolean();	//Lo mismo pero para el premio
		liebre = new Corredor(new Calle(nCasillas, agujero,numeroArboles,premio),"liebre","liebre.jpg",4);
		tortuga = new Corredor(new Calle(nCasillas,!agujero,0,!premio),"tortuga","tortuga.jpg",2);
		numeroDado = 0;
		// Establecemos el corredor activo apuntando a la tortuga ya que sale la primera
		this.setCorredorActivo(tortuga);
	}

	public boolean lanzarDado() {
		boolean isPosible = false;
		numeroDado = Dado.lanzar(getCorredorActivo());
		if (corredorActivo.getPosicion() + numeroDado < Calle.DIM){
			isPosible = true;
		}
		else {
			cambiarTurnos();
		}
		return isPosible;
	}

	
	private boolean isJugadaCorrecta(int i) {
		return (corredorActivo.getPosicion() + numeroDado >= i) && corredorActivo.getPosicion()<i ;
	}

	public boolean resolverJugada(int i) {
		boolean resuelta = false;
		// Comprobamos que se trata de avanzar a la casilla correcta
		if (isJugadaCorrecta (i)){
			corredorActivo.setPosicion(i);
			//Si tenemos un arbol en la casilla, ponemos a dormir al corredor
			if(corredorActivo.getCalleAsignada().getCasilla(corredorActivo.getPosicion()).tieneObstaculo(TipoObstaculo.ARBOL)){
				corredorActivo.dormir();
			}
			// Incrementamos la puntuación del corredor
			corredorActivo.incrementaPuntuacion(corredorActivo.getCalleAsignada().puntosCasilla(corredorActivo.getPosicion()));
			//Duplicamos la puntuación del jugador en caso de caer en el premio
			if(corredorActivo.getCalleAsignada().getCasilla(corredorActivo.getPosicion()).tieneObstaculo(Casilla.TipoObstaculo.PREMIO)){
				corredorActivo.duplicarPuntuacion();
			}		
			// Intercambiamos los turnos
			cambiarTurnos();
			resuelta = true;
		}
		return resuelta;
	}

	public Corredor getCorredorActivo() {
		return corredorActivo;
	}

	public Corredor getCorredorNoActivo() {
		if (corredorActivo == liebre) {
			return tortuga;
		}
		return liebre;
	}

	private void cambiarTurnos() {
		//Si el corredor no activo está durmiendo lo despierta pero no cambiamos el turno
		if(getCorredorNoActivo().isDurmiendo()){
			getCorredorNoActivo().despertar();
		}else{
		// Cambiamos el turno
		corredorActivo = getCorredorNoActivo();
		}
	}

	public boolean isPartidaFinalizada() {
		boolean liebreEnAgujero = (liebre.getCalleAsignada().getCasilla(liebre.getPosicion()).tieneObstaculo(Casilla.TipoObstaculo.AGUJERO));
		boolean tortugaEnAgujero = (tortuga.getCalleAsignada().getCasilla(tortuga.getPosicion()).tieneObstaculo(Casilla.TipoObstaculo.AGUJERO));
		return (liebre.getPosicion() == Calle.POSICION_META || tortuga.getPosicion() ==  Calle.POSICION_META || liebreEnAgujero || tortugaEnAgujero);
	}
	public boolean isPremio(){
		return (getCorredorNoActivo().getCalleAsignada().getCasilla(getCorredorNoActivo().getPosicion()).tieneObstaculo(Casilla.TipoObstaculo.PREMIO));
	}
	public int getNumeroDado() {
		return numeroDado;
	}

	public Corredor getLiebre() {
		return liebre;
	}

	public Corredor getTortuga() {
		return tortuga;
	}

	private void setCorredorActivo(Corredor corredorActivo) {
		this.corredorActivo = corredorActivo;
	}
}