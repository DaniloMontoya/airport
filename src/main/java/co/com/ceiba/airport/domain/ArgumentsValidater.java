package co.com.ceiba.airport.domain;

import co.com.ceiba.airport.domain.exceptions.MandatoryValueException;

public class ArgumentsValidater {

    private ArgumentsValidater() {}

    public static void mandatoryValidate(Object value, String message) {
        if (value == null) {
            throw new MandatoryValueException(message);
        }
    }

}
