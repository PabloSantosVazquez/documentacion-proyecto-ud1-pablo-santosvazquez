package es.centro.incidencias;

import java.util.Locale;

/**
 * Representa una incidencia
 *
 * <p>Cada incidencia tiene un id, un titutlo, una prioridad y un estado</p>
 *
 * @author Pablo Santos Vázquez
 * @version 1.0
 * @since 1.0
 */

public final class Incidencia {

    private final String id;
    private final String titulo;
    private final String prioridad;
    private final boolean abierta;

    /**
     * Crea una nueva incidencia
     *
     * @param id identificador
     * @param titulo titulo de la incidencia
     * @param prioridad nivel de prioridad de la incidencia
     * @param abierta {@code true} si la incidencia está abierta; {@code false} si está cerrada
     */
    public Incidencia(String id, String titulo, String prioridad, boolean abierta) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.abierta = abierta;
    }

    /**
     * Devuelve el identificador de la incidencia
     *
     * @return identificador de la incidencia
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve el titulo de la incidencia
     *
     * @return titulo de la incidencia
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve la prioridad de la incidencia
     *
     * @return prioridad de la incidencia
     */

    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Indica si la incidencia esta abierta
     *
     * @return {@code true} si la incidencia esta abierta; {@code false} en caso contrario
     */

    public boolean isAbierta() {
        return abierta;
    }

    /**
     * Comprueba si un texto aparece en el identificador o en el título,
     * sin distinguir entre mayúsculas y minúsculas.
     *
     * @param texto texto que se desea buscar
     * @return {@code true} si el texto aparece en el título o en el identificador;
     *         {@code false} en caso contrario
     *@throws NullPointerException si {@code texto} es {@code null}
     */
    public boolean coincideCon(String texto) {
        String criterio = texto.toLowerCase(Locale.ROOT);
        return id.toLowerCase(Locale.ROOT).contains(criterio)
                || titulo.toLowerCase(Locale.ROOT).contains(criterio);
    }

}
