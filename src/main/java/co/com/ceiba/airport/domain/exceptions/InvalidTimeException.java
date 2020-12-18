package co.com.ceiba.airport.domain.exceptions;

public class InvalidTimeException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public InvalidTimeException(String message) {
        super(message);
    }
}
