package co.com.ceiba.airport.domain.exceptions;

public class MandatoryValueException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MandatoryValueException(String message) {
        super(message);
    }
}
