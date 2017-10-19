package logica;

public class Casilla {
	
	private int valor;
	
	public enum TipoObstaculo {NINGUNO,ARBOL,AGUJERO,PREMIO}
	
	private TipoObstaculo tipo;
	
	public Casilla() {
		setValor (50);
		tipo = TipoObstaculo.NINGUNO;
	}

	public boolean isVacia(){
		return this.tipo == TipoObstaculo.NINGUNO;
	}

	public boolean tieneObstaculo(TipoObstaculo obstaculo){
		return this.tipo == obstaculo;
	}
	
	public void ponerObstaculo(TipoObstaculo obstaculo){
		 this.tipo = obstaculo;
	}

	public int getValor() {
		return valor;
	}
	private void setValor(int valor) {
		this.valor = valor;
	}
}
