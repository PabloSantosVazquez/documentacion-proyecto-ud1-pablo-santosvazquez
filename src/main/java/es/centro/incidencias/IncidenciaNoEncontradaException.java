package es.centro.incidencias;
/**
 * Excepción comprobada que indica que no existe ninguna incidencia
 * con el identificador buscado.
 *
 * <p>Se lanza desde {@link GestorIncidencias#buscarPorId(String)}.</p>
 *
 * @author Pablo Santos Vázquez
 * @version 1.0
 * @since 1.0
 */

public class IncidenciaNoEncontradaException extends Exception {
    /**
     * Crea la excepción con un mensaje que incluye el identificador buscado.
     *
     * @param id identificador de la incidencia que no se ha encontrado
     */

    public IncidenciaNoEncontradaException(String id) {
        super("No existe ninguna incidencia con el identificador " + id + ".");
    }
}
