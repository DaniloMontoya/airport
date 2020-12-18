package co.com.ceiba.airport.domain.unit;

import co.com.ceiba.airport.testdatabuilder.ArrivalTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;


public class ArrivalTest {

    private static final String NAME = "MADRID";
    private static final float LATITUDE = 40.416775f;
    private static final float LENGHT = - -3.703790f;

    @Test
    public void createArrival(){
        //arrange
        ArrivalTestDataBuilder arrivalTestDataBuilder = new ArrivalTestDataBuilder().
                withName(NAME).
                withLatitud(LATITUDE).
                withLenght(LENGHT);
        //act
        Arrival arrival = arrivalTestDataBuilder.build();

        //assert
        Assert.assertEquals(NAME, arrival.getName());
    }


}
