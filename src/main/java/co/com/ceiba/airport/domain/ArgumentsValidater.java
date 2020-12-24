package co.com.ceiba.airport.domain;

import co.com.ceiba.airport.domain.exceptions.InvalidValueException;
import co.com.ceiba.airport.domain.exceptions.MandatoryValueException;

public final class ArgumentsValidater {

    private ArgumentsValidater() {}

    public static void mandatoryValidate(Object value, String message) {
        if (value == null) {
            throw new MandatoryValueException(message);
        }
    }

    public static void validatePositive(float value, String message){
        if(value <= 0){
            throw new InvalidValueException(message);
        }
    }



}
