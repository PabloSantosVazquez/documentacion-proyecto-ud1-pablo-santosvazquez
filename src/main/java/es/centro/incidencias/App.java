package es.centro.incidencias;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 *Punto de entrada de la aplicación
 *
 * @author Pablo Santos Vázquez
 * @version 1.0
 * @since 1.0
 */


public final class App {

    private App() {
    }
    /**
     * Inicia la aplicación.
     *
     * <p>Si no se recibe ningún argumento, se abre el menú.
     * En caso contrario, el primer argumento indica la operación:</p>
     * <ul>
     *   <li>{@code ayuda}: muestra la ayuda.</li>
     *   <li>{@code listar}: muestra todas las incidencias.</li>
     *   <li>{@code abiertas}: muestra las incidencias abiertas.</li>
     *   <li>{@code buscar <texto>}: busca incidencias por texto.</li>
     *   <li>{@code detalle <id>}: muestra una incidencia por su identificador.</li>
     * </ul>
     *
     * @param args argumentos de línea de comandos; no se utilizan
     */

    public static void main(String[] args) {
        GestorIncidencias gestor = new GestorIncidencias();

        if (args.length == 0) {
            ejecutarMenuInteractivo(gestor);
            return;
        }

        if ("ayuda".equalsIgnoreCase(args[0])) {
            mostrarAyuda();
            return;
        }

        String operacion = args[0].toLowerCase();
        switch (operacion) {
            case "listar" -> mostrar(gestor.listar());
            case "abiertas" -> mostrar(gestor.listarAbiertas());
            case "buscar" -> buscar(args, gestor);
            case "detalle" -> mostrarDetalle(args, gestor);
            default -> {
                System.out.println("Operación desconocida: " + args[0]);
                mostrarAyuda();
            }
        }
    }
    /**
     * Ejecuta el menú interactivo y repite el ciclo de lectura de opciones
     * hasta que el usuario elige salir.
     *
     * @param gestor gestor del que se obtienen las incidencias
     */
    private static void ejecutarMenuInteractivo(GestorIncidencias gestor) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("GESTOR DE INCIDENCIAS");
        System.out.println("Aplicación de consulta de avisos de soporte del centro.");

        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            if (!entrada.hasNextLine()) {
                return;
            }

            String opcion = entrada.nextLine().trim();
            System.out.println();

            switch (opcion) {
                case "1" -> mostrar(gestor.listar());
                case "2" -> mostrar(gestor.listarAbiertas());
                case "3" -> buscarDesdeMenu(entrada, gestor);
                case "4" -> mostrarDetalleDesdeMenu(entrada, gestor);
                case "0" -> {
                    continuar = false;
                    System.out.println("Aplicación finalizada.");
                }
                default -> System.out.println("La opción indicada no es válida.");
            }

            System.out.println();
        }
    }
    /**
     * Muestra por consola las opciones del menú interactivo.
     */

    private static void mostrarMenu() {
        System.out.println("----------------------------------------");
        System.out.println("1. Mostrar todas las incidencias");
        System.out.println("2. Mostrar las incidencias abiertas");
        System.out.println("3. Buscar incidencias");
        System.out.println("4. Consultar una incidencia por su ID");
        System.out.println("0. Salir");
        System.out.println("----------------------------------------");
    }
    /**
     * Pide un texto al usuario y muestra las incidencias que coinciden con él.
     * Si el texto está vacío, muestra un aviso y no realiza la búsqueda.
     *
     * @param entrada lector de la entrada estándar
     * @param gestor gestor en el que se realiza la búsqueda
     */

    private static void buscarDesdeMenu(Scanner entrada, GestorIncidencias gestor) {
        System.out.print("Texto que deseas buscar: ");
        String texto = entrada.hasNextLine() ? entrada.nextLine().trim() : "";

        if (texto.isBlank()) {
            System.out.println("Debes introducir algún texto.");
            return;
        }

        mostrar(gestor.buscar(texto));
    }
    /**
     * Pide un identificador al usuario y muestra la incidencia correspondiente.
     * Si el identificador está vacío, muestra un aviso y no realiza la consulta.
     *
     * @param entrada lector de la entrada estándar
     * @param gestor gestor en el que se consulta la incidencia
     */
    private static void mostrarDetalleDesdeMenu(Scanner entrada, GestorIncidencias gestor) {
        System.out.print("Identificador de la incidencia: ");
        String id = entrada.hasNextLine() ? entrada.nextLine().trim() : "";

        if (id.isBlank()) {
            System.out.println("Debes introducir un identificador.");
            return;
        }

        mostrarDetalle(id, gestor);
    }
    /**
     * Busca incidencias a partir de los argumentos de línea de comandos.
     * Todos los argumentos posteriores a la operación se unen con espacios
     * para formar el texto de búsqueda.
     *
     * @param args argumentos de línea de comandos, incluida la operación en la posición 0
     * @param gestor gestor en el que se realiza la búsqueda
     */

    private static void buscar(String[] args, GestorIncidencias gestor) {
        if (args.length < 2) {
            System.out.println("Debes indicar el texto que deseas buscar.");
            return;
        }

        String texto = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        mostrar(gestor.buscar(texto));
    }
    /**
     * Muestra el detalle de una incidencia usando el identificador recibido
     * por línea de comandos.
     *
     * @param args argumentos de línea de comandos; el identificador se espera en la posición 1
     * @param gestor gestor en el que se consulta la incidencia
     * @see #mostrarDetalle(String, GestorIncidencias)
     */

    private static void mostrarDetalle(String[] args, GestorIncidencias gestor) {
        if (args.length < 2) {
            System.out.println("Debes indicar el identificador de la incidencia.");
            return;
        }

        mostrarDetalle(args[1], gestor);
    }
    /**
     * Muestra el detalle de la incidencia con el identificador indicado.
     * Si no existe, muestra el mensaje de la excepción
     * {@link IncidenciaNoEncontradaException}.
     *
     * @param id identificador de la incidencia
     * @param gestor gestor en el que se consulta la incidencia
     * @see GestorIncidencias#buscarPorId(String)
     */

    private static void mostrarDetalle(String id, GestorIncidencias gestor) {
        try {
            System.out.println(gestor.buscarPorId(id));
        } catch (IncidenciaNoEncontradaException excepcion) {
            System.out.println(excepcion.getMessage());
        }
    }
    /**
     * Muestra por consola una lista de incidencias, una por línea.
     * Si la lista está vacía, muestra un aviso.
     *
     * @param incidencias incidencias que se desean mostrar
     */

    private static void mostrar(List<Incidencia> incidencias) {
        if (incidencias.isEmpty()) {
            System.out.println("No se han encontrado incidencias.");
            return;
        }
        incidencias.forEach(System.out::println);
    }
    /**
     * Muestra por consola la ayuda con las operaciones disponibles.
     */

    private static void mostrarAyuda() {
        System.out.println("Gestor de incidencias");
        System.out.println("  ayuda              Muestra esta ayuda");
        System.out.println("  listar              Muestra todas las incidencias");
        System.out.println("  abiertas            Muestra las incidencias abiertas");
        System.out.println("  buscar <texto>      Busca por identificador o título");
        System.out.println("  detalle <id>        Muestra una incidencia");
    }
}
