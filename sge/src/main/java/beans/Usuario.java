package beans;

public abstract class Usuario {
	private String nombre; // Nombre completo --> Agregar al diagrama
	private String nombre_de_usuario;
	private String contrasena;
	private Long id;

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String nombre_de_usuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.nombre_de_usuario = nombre_de_usuario;
		this.contrasena = contrasena;
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_de_usuario() {
		return nombre_de_usuario;
	}

	public void setNombre_de_usuario(String nombre_de_usuario) {
		this.nombre_de_usuario = nombre_de_usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
