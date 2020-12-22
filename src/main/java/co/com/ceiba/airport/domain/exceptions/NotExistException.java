package co.com.ceiba.airport.domain.exceptions;

public class NotExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NotExistException(String message) {
        super(message);
    }
}
