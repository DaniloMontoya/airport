package co.com.ceiba.airport.domain;

import co.com.ceiba.airport.domain.exceptions.InvalidValueException;
import co.com.ceiba.airport.domain.exceptions.MandatoryValueException;

import java.util.List;

public class ArgumentsValidater {

    private ArgumentsValidater() {}

    public static void mandatoryValidate(Object value, String message) {
        if (value == null) {
            throw new MandatoryValueException(message);
        }
    }

}
