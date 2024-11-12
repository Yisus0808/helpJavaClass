package crudHerencia;

/**
 * Clase base que representa una persona con atributos básicos.
 */
//Clase base Persona
public class Persona {
	// Atributos generales
	private String nombre;
	private String apellido;
	private String rut;
	private String direccion;
	private String telefono;

	// Constructor vacío
	public Persona() {
	}

	// Constructor completo
	public Persona(String nombre, String apellido, String rut, String direccion, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	// Constructor especializado (nombre, apellido y rut)
	public Persona(String nombre, String apellido, String rut) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
	}

	// Métodos get y set para encapsulamiento
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// Método toString para mostrar la información
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Apellido: " + apellido + ", RUT: " + rut + ", Dirección: " + direccion
				+ ", Teléfono: " + telefono;
	}
}
