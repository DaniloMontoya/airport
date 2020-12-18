package co.com.ceiba.airport.domain.exceptions;

public class WithoutDataException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public WithoutDataException(String message) {
        super(message);
    }
}
