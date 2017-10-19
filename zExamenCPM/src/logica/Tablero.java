package logica;

public class Tablero {
	
	public static int DIM=9;
	
	private Casilla[] casillas;
	
	public Tablero(){
	 	this.casillas=new Casilla[DIM];
	 	System.out.println("Generando tablero");
	 	for(int i=0;i<DIM;i++){
	 		casillas[i]=new Casilla();
	 		System.out.println("Generando casilla "+i);
	 	}
        }

}
