package crud_estudiantes;
import java.io.*;

public class crud {

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean menu = true;
        int MAX_ALUMNOS = 60;
        String[] Alumnos = new String[MAX_ALUMNOS];
        int[][] Fechas = new int[MAX_ALUMNOS][3];
        int cantidadAlumnos = 0;

        while (menu) {

        	try {
	            mostrarMenu();
	            int opcion = Integer.parseInt(lector.readLine());

	            switch (opcion) {
	                case 1:
	                    cantidadAlumnos = registrarAlumno(lector, Alumnos, Fechas, cantidadAlumnos, MAX_ALUMNOS);
	                    break;
	                case 2:
	                    eliminarAlumno(lector, Alumnos, Fechas, cantidadAlumnos);
	                    break;
	                case 3:
	                    mostrarLista(Alumnos, Fechas, cantidadAlumnos);
	                    break;
	                case 4:
	                    ordenarLista(Alumnos, Fechas, cantidadAlumnos);
	                    break;
	                case 5:
	                    mostrarInformacion();
	                    menu = false;
	                    break;
	                default:
	                    System.out.println("Opción no válida! Vuelve a intentarlo.");
	            }
            } catch (NumberFormatException e) {
            	System.out.println("Error: " + e.getMessage());
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }
    }

    public static void mostrarMenu() {

    	System.out.println("+---------------------------------------------+");
        System.out.println("|                  MENÚ                       |");
        System.out.println("+---------------------------------------------+");
        System.out.println("| 1. Registrar alumno y fecha de nacimiento   |");
        System.out.println("| 2. Eliminar alumno                          |");
        System.out.println("| 3. Mostrar la lista del curso               |");
        System.out.println("| 4. Ordenar la lista (joven a viejo)         |");
        System.out.println("| 5. Salir                                    |");
        System.out.println("+---------------------------------------------+");
        System.out.print("Seleccione una opción: ");
    }

    // Función para registrar un alumno
    public static int registrarAlumno(BufferedReader lector, String[] Alumnos, int[][] Fechas, int cantidadAlumnos, int MAX_ALUMNOS) throws IOException {

    	if (cantidadAlumnos >= MAX_ALUMNOS) {
            System.out.println("No se pueden registrar más alumnos.");
        } else {
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = lector.readLine();
            
         // Validación del día
            int dia = 0;
            do {
                System.out.print("Ingrese el día de nacimiento (1-31): ");
                dia = Integer.parseInt(lector.readLine());
                if (dia < 1 || dia > 31) {
                    System.out.println("Error: El día debe estar entre 1 y 31.");
                }
            } while (dia < 1 || dia > 31);

            // Validación del mes
            int mes = 0;
            do {
                System.out.print("Ingrese el mes de nacimiento (1-12): ");
                mes = Integer.parseInt(lector.readLine());
                if (mes < 1 || mes > 12) {
                    System.out.println("Error: El mes debe estar entre 1 y 12.");
                }
            } while (mes < 1 || mes > 12);

            // Validación del año
            int anio = 0;
            do {
                System.out.print("Ingrese el año de nacimiento (YYYY): ");
                anio = Integer.parseInt(lector.readLine());
                if (anio < 1900 || anio > 2024) {  // Se puede ajustar el rango de años según sea necesario
                    System.out.println("Error: El año debe estar entre 1900 y 2024.");
                }
            } while (anio < 1900 || anio > 2024);
            
            Alumnos[cantidadAlumnos] = nombre;
            Fechas[cantidadAlumnos][0] = dia;
            Fechas[cantidadAlumnos][1] = mes;
            Fechas[cantidadAlumnos][2] = anio;
            cantidadAlumnos++;
            System.out.println("Alumno registrado exitosamente.");
        }
        return cantidadAlumnos;
    }

    // Función para eliminar un alumno
    public static void eliminarAlumno(BufferedReader lector, String[] Alumnos, int[][] Fechas, int cantidadAlumnos) throws IOException {

    	if (cantidadAlumnos == 0) {
            System.out.println("No hay alumnos registrados para eliminar.");
        } else {
        	 System.out.print("Ingrese el nombre del alumno a eliminar: ");
             String nombre = lector.readLine();
             boolean encontrado = false;

             for (int i = 0; i < cantidadAlumnos; i++) {
                 if (Alumnos[i].equalsIgnoreCase(nombre)) {
                	 
                	 System.out.println("Alumno encontrado." + nombre);
                	 
                     encontrado = true;

                     Alumnos[i] = null;
                     Fechas[cantidadAlumnos - 1][0] = 0;
                     Fechas[cantidadAlumnos - 1][1] = 0;
                     Fechas[cantidadAlumnos - 1][2] = 0;

                     // Reducir la cantidad de alumnos registrados
                     cantidadAlumnos--;

                     System.out.println("Alumno eliminado exitosamente.");
                     break;
                 }
             }

             if (!encontrado) {
                 System.out.println("Alumno no encontrado.");
             }
        }
    }

    // Función para mostrar la lista de alumnos
    public static void mostrarLista(String[] Alumnos, int[][] Fechas, int cantidadAlumnos) {

    	if (cantidadAlumnos == 0) {
            System.out.println("No hay alumnos registrados.");
        } else {
            System.out.println("+---------------------------------------------+");
            System.out.println("|          Lista de alumnos registrados       |");
            System.out.println("+---------------------------------------------+");
            for (int i = 0; i < cantidadAlumnos; i++) {
                System.out.printf("| %-20s | %02d/%02d/%04d |\n", Alumnos[i], Fechas[i][0], Fechas[i][1], Fechas[i][2]);
            }
            System.out.println("+---------------------------------------------+");
        }
    }

    // Función para ordenar la lista de alumnos por fecha de nacimiento (joven a viejo)
    public static void ordenarLista(String[] Alumnos, int[][] Fechas, int cantidadAlumnos) {

        if (cantidadAlumnos < 2) {
            System.out.println("No hay suficientes alumnos para ordenar.");
        } else {
            for (int i = 0; i < cantidadAlumnos - 1; i++) {
                for (int j = i + 1; j < cantidadAlumnos; j++) {
                    if (esMayor(Fechas[i], Fechas[j])) {  // Cambiar si el alumno i es mayor (más viejo) que j
                        // Intercambiar alumnos y fechas
                        String tempAlumno = Alumnos[i];
                        Alumnos[i] = Alumnos[j];
                        Alumnos[j] = tempAlumno;

                        int[] tempFecha = Fechas[i];
                        Fechas[i] = Fechas[j];
                        Fechas[j] = tempFecha;
                    }
                }
            }
            System.out.println("Lista ordenada de joven a viejo.");
        }
    }

    // Función auxiliar para comparar dos fechas
    public static boolean esMayor(int[] fecha1, int[] fecha2) {
        // Devuelve true si fecha1 es más antigua (más vieja) que fecha2
        if (fecha1[2] < fecha2[2]) return false;  // fecha1 es de un año más reciente (más joven)
        if (fecha1[2] > fecha2[2]) return true;   // fecha1 es de un año más antiguo (más viejo)

        if (fecha1[1] < fecha2[1]) return false;  // Mismo año, pero mes más reciente
        if (fecha1[1] > fecha2[1]) return true;   // Mismo año, pero mes más antiguo

        if (fecha1[0] < fecha2[0]) return false;  // Mismo año y mes, pero día más reciente
        if (fecha1[0] > fecha2[0]) return true;   // Mismo año y mes, pero día más antiguo

        return false;  // Las fechas son iguales
    }
   
    // Función para mostrar la información del desarrollador
    public static void mostrarInformacion() {

        System.out.println("+---------------------------------------------+");
        System.out.println("|            Información del Proyecto         |");
        System.out.println("+---------------------------------------------+");
        System.out.println("| Nombre: Fernando Zapata Rut: 21.938.224-3   |");
        System.out.println("| Nombre: Nicolas Urbina Rut: 22.025.606-5    |");
        System.out.println("+---------------------------------------------+");
        System.out.println("Saliendo...");
    }
    
}
