package co.com.ceiba.airport.domain;

import co.com.ceiba.airport.domain.exceptions.InvalidValueException;
import co.com.ceiba.airport.domain.exceptions.MandatoryValueException;

import java.util.List;

public class ArgumentsValidater {

    private ArgumentsValidater() {}

    public static <T> void noEmptyValidate(List<T> lists, String message){
        if (lists.isEmpty()) {
            throw new MandatoryValueException(message);
        }
    }

    public static void mandatoryValidate(Object value, String message) {
        if (value == null) {
            throw new MandatoryValueException(message);
        }
    }

    public static void positiveValidate(Double value, String message) {
        if (value <= 0) {
            throw new InvalidValueException(message);
        }
    }




}
