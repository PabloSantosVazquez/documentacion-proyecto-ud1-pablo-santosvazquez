package es.centro.incidencias;

import java.util.List;

/**
 * Gestiona una colección de objetos {@link Incidencia}.
 *
 * <p>Permite listar todas las incidencias, consultar las que siguen abiertas
 * y buscarlas por identificador o por texto.</p>
 *
 * @author Pablo Santos Vázquez
 * @version 1.0
 * @since 1.0
 */
public final class GestorIncidencias {

    private final List<Incidencia> incidencias;

    /**
     * Crea un gestor con un conjunto inicial de incidencias.
     */
    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }

    /**
     * Devuelve todas las incidencias.
     *
     * @return lista con todas las incidencias
     */
    public List<Incidencia> listar() {
        return incidencias;
    }

    /**
     * Obtiene las incidencias que siguen abiertas.
     *
     * @return lista que contiene únicamente incidencias abiertas
     * @see Incidencia#isAbierta()
     */
    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }

    /**
     * Busca las incidencias que coinciden con un texto.
     *
     * @param texto texto que se desea buscar
     * @return lista no modificable con las incidencias coincidentes; vacía si no hay ninguna
     * @see Incidencia#coincideCon(String)
     */
    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }

    /**
     * Busca una incidencia por su identificador, sin distinguir entre
     * mayúsculas y minúsculas.
     *
     * @param id identificador buscado
     * @return incidencia encontrada
     * @throws IncidenciaNoEncontradaException si no existe ninguna incidencia con ese identificador
     * @see Incidencia#getId()
     */
    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }

    /**
     * Busca una incidencia por su identificador.
     *
     * @param id identificador buscado
     * @return incidencia encontrada o {@code null} si no existe
     * @deprecated desde la versión 1.0.0; usar {@link #buscarPorId(String)},
     *             que lanza una excepción en lugar de devolver {@code null}
     */
    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}