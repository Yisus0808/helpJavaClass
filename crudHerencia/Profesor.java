package crudHerencia;

//Clase Profesor que hereda de Persona
class Profesor extends Persona {
	private String codigoEmpleado;
	private String departamento;
	private int añosExperiencia;
    private int cantidadClases;

	// Constructor vacío
	public Profesor() {
	}

	// Constructor completo
	public Profesor(String nombre, String apellido, String rut, String direccion, String telefono,
			String codigoEmpleado, String departamento, int añosExperiencia, int cantidadClases) {
		super(nombre, apellido, rut, direccion, telefono);
		this.codigoEmpleado = codigoEmpleado;
		this.departamento = departamento;
		this.añosExperiencia = añosExperiencia;
        this.cantidadClases = cantidadClases;
	}

	// Constructor especializado (con datos esenciales)
	public Profesor(String nombre, String apellido, String rut, String codigoEmpleado) {
		super(nombre, apellido, rut);
		this.codigoEmpleado = codigoEmpleado;
	}

	// Métodos get y set para encapsulamiento
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getAñosExperiencia() {
		return añosExperiencia;
	}

	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}
	
    public int getCantidadClases() {
		return cantidadClases;
	}

	public void setCantidadClases(int cantidadClases) {
		this.cantidadClases = cantidadClases;
	}

	public boolean verificarCantidadClases() {
        return cantidadClases > 5;
    }

	public String mostrarCantidadClases() {
        return verificarCantidadClases() ? "El profesor tiene más de 3 clases." : "El profesor tiene 3 o menos clases.";
    }
	// Método toString para mostrar la información del profesor
	@Override
	public String toString() {
		return super.toString() + ", Código de Empleado: " + codigoEmpleado + ", Departamento: " + departamento
				+ ", Años de Experiencia: " + añosExperiencia;
	}
}