package logica;

import logica.Casilla.TipoObstaculo;

public class Calle {

	public static int DIM = 11;
	public static final int POSICION_META = DIM -1;
	private Casilla[] casillas;;


	public Calle (int nCasillas, boolean agujero,int arboles,boolean premio) {
		DIM = nCasillas;
		this.casillas = new Casilla[DIM]; 
		
		for (int i = 0; i < DIM; i++) {
			casillas[i] = new Casilla();
			System.out.println("Creando casilla "+i);
		}
		
		if(agujero){
			colocarObstaculo(Casilla.TipoObstaculo.AGUJERO);
		}
		for(int i=0;i<arboles;i++){
			colocarObstaculo(Casilla.TipoObstaculo.ARBOL);
		}
		if(premio){
			colocarObstaculo(Casilla.TipoObstaculo.PREMIO);
		}
	}

	private void colocarObstaculo(TipoObstaculo obstaculo) {
		int posCasilla;
		//Ponemos -2 para que no caiga ni en la primera casilla ni en la última
		int semilla = DIM - 2;
		do{
			posCasilla = ((int) (Math.random() * semilla)) +1;
		}while(!casillas[posCasilla].isVacia());
		casillas[posCasilla].ponerObstaculo(obstaculo);
		System.out.println("Colocado "+obstaculo+" en casilla "+posCasilla);
	}

	public int puntosCasilla(int posicion) {
		return casillas[posicion].getValor();
	}
	
	public Casilla getCasilla(int posicion) {
		return casillas[posicion];
	}
	
}
