package co.com.ceiba.airport.domain.exceptions;

public class DuplicityValueException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DuplicityValueException(String message) {
        super(message);
    }
}
