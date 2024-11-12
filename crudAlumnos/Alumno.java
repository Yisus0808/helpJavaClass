package crudAlumnos;

public class Alumno {
    private String nombre;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;

    public Alumno(String nombre, int diaNacimiento, int mesNacimiento, int anioNacimiento) {
        this.nombre = nombre;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anioNacimiento = anioNacimiento;
    }

    public Alumno() {

    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDiaNacimiento() {
		return diaNacimiento;
	}

	public void setDiaNacimiento(int diaNacimiento) {
		this.diaNacimiento = diaNacimiento;
	}

	public int getMesNacimiento() {
		return mesNacimiento;
	}

	public void setMesNacimiento(int mesNacimiento) {
		this.mesNacimiento = mesNacimiento;
	}

	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	// Método para representar la información del alumno
    @Override
    public String toString() {
        return String.format("%-20s | %02d/%02d/%04d", nombre, diaNacimiento, mesNacimiento, anioNacimiento);
//        el alumno tanto tiene tal edad
    }

    // Método para comparar fechas de nacimiento
    public boolean esMayorQue(Alumno otro) {
        if (this.anioNacimiento != otro.anioNacimiento) {
            return this.anioNacimiento > otro.anioNacimiento;
        } else if (this.mesNacimiento != otro.mesNacimiento) {
            return this.mesNacimiento > otro.mesNacimiento;
        } else {
            return this.diaNacimiento > otro.diaNacimiento;
        }
    }
}
