package Logica;

public class Usuario {
	private String nombre;
	private String apellidos;
	private String NIF;
	private String usuario;
	private String contraseña;
	private String telefono;
	private String numeroTarjeta;
	private int puntos;
	
	public Usuario(String nombre,String apellidos,String NIF,String usuario, String contraseña,String telefono,String numeroTarjeta,int puntos){
		setNombre(nombre);
		setApellidos(apellidos);
		setNIF(NIF);
		setUsuario(usuario);
		setContraseña(contraseña);
		setTelefono(telefono);
		setNumeroTarjeta(numeroTarjeta);
		setPuntos(puntos);
	}
	
	public Usuario(String nombre,String apellidos,String NIF,String usuario, String contraseña,String telefono){
		setNombre(nombre);
		setApellidos(apellidos);
		setNIF(NIF);
		setUsuario(usuario);
		setContraseña(contraseña);
		setTelefono(telefono);
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	private void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	private void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getNIF() {
		return NIF;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public int getPuntos() {
		return puntos;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.nombre);
		buffer.append(";");
		buffer.append(this.apellidos);
		buffer.append(";");
		buffer.append(this.NIF);
		buffer.append(";");
		buffer.append(this.usuario);
		buffer.append(";");
		buffer.append(this.contraseña);
		buffer.append(";");
		buffer.append(this.telefono);
		buffer.append(";");
		buffer.append(this.numeroTarjeta);
		buffer.append(";");
		buffer.append(this.puntos);
		buffer.append("\n");
		return buffer.toString();
	   

	}
	
}
