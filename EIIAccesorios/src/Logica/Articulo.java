package Logica;

public class Articulo {

	private String codigo;
	private String categoria;
	private String subcategoria;
	private String denominacion;
	private String descripcion;
	private float precio;
	private int puntos;
	private int unidadesStock;
	private int unidadesPedido;
	private int valor;
	private boolean oferta=false;




	public Articulo(String codigo, String categoria,String subcategoria,
			String denominacion, String descripcion, float precio, int puntos,
			int unidades) {
		
		setCodigo(codigo);
		setCategoria(categoria);
		setSubcategoria(subcategoria);
		setDenominacion(denominacion);
		setDescripcion(descripcion);
		setPrecio(precio);
		setPuntos(puntos);
		setUnidadesStock(unidades);

	}
	
	public Articulo(String codigo, String categoria, String denominacion,
			int valor) {

		setCodigo(codigo);
		setCategoria(categoria);
		setDenominacion(denominacion);
		setValor(valor);

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

	public int getUnidadesStock() {
		return unidadesStock;
	}

	public void setUnidadesStock(int unidades) {
		this.unidadesStock = unidades;
	}

	private void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	private void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void setUnidadesPedido(int unidadesPedido) {
		this.unidadesPedido = unidadesPedido;
	}

	public int getUnidadesPedido() {
		return unidadesPedido;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getPuntos() {
		return puntos;
	}
	
	private void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.denominacion);
//		buffer.append(" - ");
//		buffer.append(this.precio);
		return buffer.toString();
	}
	
	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
}
