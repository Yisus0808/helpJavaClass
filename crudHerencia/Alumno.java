package crudHerencia;

/**
 * Clase que representa a un Alumno y hereda de la clase Persona.
 */
//Clase Alumno que hereda de Persona
class Alumno extends Persona {
	private String matricula;
	private String carrera;
	private int añoIngreso;
    private double calificacion;
    

	// Constructor vacío
	public Alumno() {
	}

	// Constructor completo
	public Alumno(String nombre, String apellido, String rut, String direccion, String telefono, String matricula,
			String carrera, int añoIngreso, double calificacion) {
		super(nombre, apellido, rut, direccion, telefono);
		this.matricula = matricula;
		this.carrera = carrera;
		this.añoIngreso = añoIngreso;
        this.calificacion = calificacion;
	}
	
	// Constructor especializado (con datos esenciales)
	public Alumno(String nombre, String apellido, String rut, String matricula) {
		super(nombre, apellido, rut);
		this.matricula = matricula;
	}

	// Métodos get y set para encapsulamiento
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public int getAñoIngreso() {
		return añoIngreso;
	}

	public void setAñoIngreso(int añoIngreso) {
		this.añoIngreso = añoIngreso;
	}

    public boolean aprobado() {
        return calificacion >= 4.0;
    }
    
    public String mostrarEstadoAprobacion() {
    	
    	if (aprobado() == true) {
    		return "El alumno está aprobado." ;
    	}else {
    		return "El alumno no está aprobado." ;
    	}
    	
    	
//        return aprobado() ? "El alumno está aprobado." : "El alumno no está aprobado.";
    }
    
	// Método toString para mostrar la información del alumno
	@Override
	public String toString() {
		return super.toString() + ", Matrícula: " + matricula + ", Carrera: " + carrera + ", Año de Ingreso: "
				+ añoIngreso;
	}
}
