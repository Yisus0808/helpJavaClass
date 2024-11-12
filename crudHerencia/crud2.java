package crudHerencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class crud2 {

	private static List<Alumno> alumnos = new ArrayList<>();
	private static List<Profesor> profesores = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean menu = true;

        while (menu) {
            mostrarMenu();
            String opcion = lector.readLine();

            switch (opcion) {
                case "1":
                    registrarAlumno(lector);
                    break;
                case "2":
                    eliminarAlumno(lector);
                    break;
                case "3":
                    mostrarListaAlumnos();
                    break;
                case "4":
                    mostrarListaProfesores();
                    break;
                case "5":
                    registrarProfesor(lector);
                    break;
                case "6":
                    seleccionarAlumno(lector);
                    break;
                case "7":
                    seleccionarProfesor(lector);
                    break;
                case "8":
                    menu = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("+---------------------------------------------+");
        System.out.println("|                  MENÚ                       |");
        System.out.println("+---------------------------------------------+");
        System.out.println("| 1. Registrar alumno                         |");
        System.out.println("| 2. Eliminar alumno                          |");
        System.out.println("| 3. Mostrar lista de alumnos                 |");
        System.out.println("| 4. Mostrar lista de profesores              |");
        System.out.println("| 5. Registrar profesor                       |");
        System.out.println("| 6. Seleccionar alumno                       |");
        System.out.println("| 7. Seleccionar profesor                     |");
        System.out.println("| 8. Salir                                    |");
        System.out.println("+---------------------------------------------+");
        System.out.print("Seleccione una opción: ");
    }

    public static void registrarAlumno(BufferedReader lector) throws IOException {
        System.out.print("Ingrese nombre del alumno: ");
        String nombre = lector.readLine();
        System.out.print("Ingrese apellido del alumno: ");
        String apellido = lector.readLine();
        System.out.print("Ingrese RUT del alumno: ");
        String rut = lector.readLine();
        System.out.print("Ingrese matrícula: ");
        String matricula = lector.readLine();
        System.out.print("Ingrese carrera: ");
        String carrera = lector.readLine();
        System.out.print("Ingrese año de ingreso: ");
        int añoIngreso = Integer.parseInt(lector.readLine());
        System.out.print("Ingrese calificación: ");
        double calificacion = Double.parseDouble(lector.readLine());

        Alumno alumno = new Alumno(nombre, apellido, rut, "", "", matricula, carrera, añoIngreso, calificacion);
        alumnos.add(alumno);
        System.out.println("Alumno registrado con éxito.");
    }

    public static void registrarProfesor(BufferedReader lector) throws IOException {
        System.out.print("Ingrese nombre del profesor: ");
        String nombre = lector.readLine();
        System.out.print("Ingrese apellido del profesor: ");
        String apellido = lector.readLine();
        System.out.print("Ingrese RUT del profesor: ");
        String rut = lector.readLine();
        System.out.print("Ingrese código de empleado: ");
        String codigoEmpleado = lector.readLine();
        System.out.print("Ingrese departamento: ");
        String departamento = lector.readLine();
        System.out.print("Ingrese años de experiencia: ");
        int añosExperiencia = Integer.parseInt(lector.readLine());
        System.out.print("Ingrese cantidad de clases: ");
        int cantidadClases = Integer.parseInt(lector.readLine());

        Profesor profesor = new Profesor(nombre, apellido, rut, "", "", codigoEmpleado, departamento, añosExperiencia, cantidadClases);
        profesores.add(profesor);
        System.out.println("Profesor registrado con éxito.");
    }

    public static void eliminarAlumno(BufferedReader lector) throws IOException {
        System.out.print("Ingrese RUT del alumno a eliminar: ");
        String rut = lector.readLine();
        alumnos.removeIf(alumno -> alumno.getRut().equals(rut));
        System.out.println("Alumno eliminado.");
    }

    public static void mostrarListaAlumnos() {
        System.out.println("\nLista de Alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
            System.out.println(alumno.aprobado() ? "Estado: Aprobado" : "Estado: Reprobado");
        }
    }

    public static void mostrarListaProfesores() {
        System.out.println("\nLista de Profesores:");
        for (Profesor profesor : profesores) {
            System.out.println(profesor);
            System.out.println(profesor.verificarCantidadClases() ? "Tiene suficiente cantidad de clases." : "Cantidad de clases insuficiente.");
        }
    }

    public static void editarAlumno(BufferedReader lector) throws IOException {
        System.out.print("Ingrese RUT del alumno a editar: ");
        String rut = lector.readLine();
        for (Alumno alumno : alumnos) {
            if (alumno.getRut().equals(rut)) {
                System.out.print("Ingrese nueva dirección: ");
                alumno.setDireccion(lector.readLine());
                System.out.print("Ingrese nuevo teléfono: ");
                alumno.setTelefono(lector.readLine());
                System.out.print("Ingrese nueva calificación: ");
                alumno.setCalificacion(Double.parseDouble(lector.readLine()));
                System.out.println("Alumno actualizado.");
                return;
            }
        }
        System.out.println("Alumno no encontrado.");
    }

    public static void editarProfesor(BufferedReader lector) throws IOException {
        System.out.print("Ingrese RUT del profesor a editar: ");
        String rut = lector.readLine();
        for (Profesor profesor : profesores) {
            if (profesor.getRut().equals(rut)) {
                System.out.print("Ingrese nuevo departamento: ");
                profesor.setDepartamento(lector.readLine());
                System.out.print("Ingrese nueva cantidad de clases: ");
                profesor.setCantidadClases(Integer.parseInt(lector.readLine()));
                System.out.println("Profesor actualizado.");
                return;
            }
        }
        System.out.println("Profesor no encontrado.");
    }
    
    public static void seleccionarAlumno(BufferedReader lector) throws IOException {
        System.out.println("+---------------------------------------------+");
        System.out.println("|    Ingrese RUT del alumno a seleccionar     |");
        System.out.println("+---------------------------------------------+");
        String rut = lector.readLine();
        for (Alumno alumno : alumnos) {
            if (alumno.getRut().equals(rut)) {
            	
                System.out.println("+---------------------------------------------+");
                System.out.println("|                  MENÚ                       |");
                System.out.println("+---------------------------------------------+");
                System.out.println("| 1. Editar alumno                            |");
                System.out.println("| 2. Mostrar si está aprobado                 |");
                System.out.println("+---------------------------------------------+");

                String opcion = lector.readLine();
                switch (opcion) {
                    case "1":
                        editarAlumno(lector, alumno);
                        break;
                    case "2":
                        System.out.println(alumno.mostrarEstadoAprobacion());
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                return;
            }
        }
        System.out.println("Alumno no encontrado.");
    }

    public static void seleccionarProfesor(BufferedReader lector) throws IOException {
        System.out.println("+---------------------------------------------+");
        System.out.println("|    Ingrese RUT del profesor a seleccionar   |");
        System.out.println("+---------------------------------------------+");
        String rut = lector.readLine();
        for (Profesor profesor : profesores) {
            if (profesor.getRut().equals(rut)) {
            	
                System.out.println("+---------------------------------------------+");
                System.out.println("|                  MENÚ                       |");
                System.out.println("+---------------------------------------------+");
                System.out.println("| 1. Editar profesor                          |");
                System.out.println("| 2. Verificar si tiene más de 3 clases       |");
                System.out.println("+---------------------------------------------+");

                String opcion = lector.readLine();
                switch (opcion) {
                    case "1":
                        editarProfesor(lector, profesor);
                        break;
                    case "2":
                        System.out.println(profesor.mostrarCantidadClases());
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                return;
            }
        }
        System.out.println("Profesor no encontrado.");
    }

    public static void editarAlumno(BufferedReader lector, Alumno alumno) throws IOException {
        System.out.print("Ingrese nueva dirección: ");
        alumno.setDireccion(lector.readLine());
        System.out.print("Ingrese nuevo teléfono: ");
        alumno.setTelefono(lector.readLine());
        System.out.print("Ingrese nueva calificación: ");
        alumno.setCalificacion(Double.parseDouble(lector.readLine()));
        System.out.println("Alumno actualizado.");
    }

    public static void editarProfesor(BufferedReader lector, Profesor profesor) throws IOException {
        System.out.print("Ingrese nuevo departamento: ");
        profesor.setDepartamento(lector.readLine());
        System.out.print("Ingrese nueva cantidad de clases: ");
        profesor.setCantidadClases(Integer.parseInt(lector.readLine()));
        System.out.println("Profesor actualizado.");
    }
}
