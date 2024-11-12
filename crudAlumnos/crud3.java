package crudAlumnos;
import java.io.*;

public class crud3 {

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean menu = true;
        int MAX_ALUMNOS = 60;
        Alumno[] alumnos = new Alumno[MAX_ALUMNOS];

        int cantidadAlumnos = 0;

        while (menu) {
            try {
                mostrarMenu();
                int opcion = Integer.parseInt(lector.readLine());

                switch (opcion) {
                    case 1:
                        cantidadAlumnos = registrarAlumno(lector, alumnos, cantidadAlumnos, MAX_ALUMNOS);
                        break;
                    case 2:
                        eliminarAlumno(lector, alumnos, cantidadAlumnos);
                        break;
                    case 3:
                        mostrarLista(alumnos, cantidadAlumnos);
                        break;
                    case 4:
                        ordenarLista(alumnos, cantidadAlumnos);
                        break;
                    case 5:
                        mostrarInformacion();
                        menu = false;
                        break;
                    default:
                        System.out.println("Opción no válida! Vuelve a intentarlo.");
                }
            } catch (NumberFormatException e) {
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

    public static int registrarAlumno(BufferedReader lector, Alumno[] alumnos, int cantidadAlumnos, int MAX_ALUMNOS) throws IOException {
        if (cantidadAlumnos >= MAX_ALUMNOS) {
            System.out.println("No se pueden registrar más alumnos.");
        } else {
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = lector.readLine();

            int dia, mes, anio;
            dia = obtenerNumeroValido(lector, "día", 1, 31);
            mes = obtenerNumeroValido(lector, "mes", 1, 12);
            anio = obtenerNumeroValido(lector, "año", 1900, 2024);

            alumnos[cantidadAlumnos] = new Alumno(nombre, dia, mes, anio);
            cantidadAlumnos++;
            System.out.println("Alumno registrado exitosamente.");
        }
        return cantidadAlumnos;
    }

    private static int obtenerNumeroValido(BufferedReader lector, String tipo, int min, int max) throws IOException {
        int numero;
        do {
            System.out.printf("Ingrese el %s de nacimiento (%d-%d): ", tipo, min, max);
            numero = Integer.parseInt(lector.readLine());
            if (numero < min || numero > max) {
                System.out.printf("Error: El %s debe estar entre %d y %d.\n", tipo, min, max);
            }
        } while (numero < min || numero > max);
        return numero;
    }

    public static void eliminarAlumno(BufferedReader lector, Alumno[] alumnos, int cantidadAlumnos) throws IOException {
        if (cantidadAlumnos == 0) {
            System.out.println("No hay alumnos registrados para eliminar.");
        } else {
            System.out.print("Ingrese el nombre del alumno a eliminar: ");
            String nombre = lector.readLine();
            boolean encontrado = false;

            for (int i = 0; i < cantidadAlumnos; i++) {
                if (alumnos[i] != null && alumnos[i].getNombre().equalsIgnoreCase(nombre)) {
                    alumnos[i] = null;
                    for (int j = i; j < cantidadAlumnos - 1; j++) {
                        alumnos[j] = alumnos[j + 1];
                    }
                    alumnos[cantidadAlumnos - 1] = null;
                    cantidadAlumnos--;
                    encontrado = true;
                    System.out.println("Alumno eliminado exitosamente.");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Alumno no encontrado.");
            }
        }
    }

    public static void mostrarLista(Alumno[] alumnos, int cantidadAlumnos) {
        if (cantidadAlumnos == 0) {
            System.out.println("No hay alumnos registrados.");
        } else {
            System.out.println("+---------------------------------------------+");
            System.out.println("|          Lista de alumnos registrados       |");
            System.out.println("+---------------------------------------------+");
            for (int i = 0; i < cantidadAlumnos; i++) {
                if (alumnos[i] != null) {
                    System.out.println("| " + alumnos[i].toString() + " |");
                }
            }
            System.out.println("+---------------------------------------------+");
        }
    }

    public static void ordenarLista(Alumno[] alumnos, int cantidadAlumnos) {
        if (cantidadAlumnos < 2) {
            System.out.println("No hay suficientes alumnos para ordenar.");
        } else {
            for (int i = 0; i < cantidadAlumnos - 1; i++) {
                for (int j = i + 1; j < cantidadAlumnos; j++) {
                    if (alumnos[i].esMayorQue(alumnos[j])) {
                        Alumno temp = alumnos[i];
                        alumnos[i] = alumnos[j];
                        alumnos[j] = temp;
                    }
                }
            }
            System.out.println("Lista ordenada de joven a viejo.");
        }
    }

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
