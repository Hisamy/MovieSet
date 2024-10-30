package org.itson.mapeomovieset.excepciones;

public class FindException extends  Exception {

    /**
     * Constructor por defecto de la excepción FindException.
     */
    public FindException() {
    }

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param message El mensaje que describe el error.
     */
    public FindException(String message) {
        super(message);
    }

    /**
     * Constructor que acepta un mensaje de error y una causa raíz.
     *
     * @param message El mensaje que describe el error.
     * @param cause   La causa raíz de la excepción.
     */
    public FindException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que acepta una causa raíz.
     *
     * @param cause La causa raíz de la excepción.
     */
    public FindException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que acepta un mensaje de error, una causa raíz, un indicador
     * de supresión de errores y un indicador de capacidad de escritura.
     *
     * @param message            El mensaje que describe el error.
     * @param cause              La causa raíz de la excepción.
     * @param enableSuppression  Un indicador de si la supresión de errores está
     *                           habilitada o no.
     * @param writableStackTrace Un indicador de si la traza de pila debe ser
     *                           escribible o no.
     */
    public FindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}