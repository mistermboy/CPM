package logica;


public class Articulo {
	
	private String codigo;
	private String denominacion;
	private float precio;
	private int unidades;
	private boolean descontado;
	
	public Articulo(String codigo, String denominacion, float precio, int unidades){
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.precio = precio;
		this.unidades = unidades;
		this.descontado=false;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.denominacion);
		buffer.append(" - ");
		buffer.append(this.precio);
		return buffer.toString();
	   }
	public void setDescontado(Boolean descontado){
		this.descontado=descontado;
	}
	public boolean getDescontado(){
		return descontado;
	}
}
