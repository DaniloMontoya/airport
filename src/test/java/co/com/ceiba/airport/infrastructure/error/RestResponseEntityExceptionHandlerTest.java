package co.com.ceiba.airport.infrastructure.error;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.services.CreateFlightService;
import co.com.ceiba.airport.domain.validators.ValidateCalendar;
import co.com.ceiba.airport.domain.validators.ValidateExistence;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class RestResponseEntityExceptionHandlerTest {

    @Test
    void handleConflictWithConflicServerTest(){
        //arrange
        try {
            FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
            flightTestDataBuilder.conId("London-123456789");
            Flight flight = flightTestDataBuilder.build();
            FlightRepository flightRepository = mock(FlightRepository.class);
            ValidateExistence validateExistence = mock(ValidateExistence.class);
            ValidateCalendar validateCalendar = mock(ValidateCalendar.class);
            when(validateExistence.isExist(flight.getId())).thenReturn(true);
            CreateFlightService createFlightService = new CreateFlightService(flightRepository, validateExistence, validateCalendar);
            createFlightService.run(flight);
            Assert.fail();
        }catch (Exception e){
            //act
            RestResponseEntityExceptionHandler restResponseEntityExceptionHandler = new RestResponseEntityExceptionHandler();
            ResponseEntity<Error> resultado = restResponseEntityExceptionHandler.handleConflict(e);
            //assert
            Assert.assertEquals("El vuelo ya existe", resultado.getBody().getMensaje());
        }

    }

    @Test
    void handleConflictWithConflictServerTest(){
        //arrange
        Exception exception = mock(Exception.class);
        //act
        RestResponseEntityExceptionHandler restResponseEntityExceptionHandler = new RestResponseEntityExceptionHandler();
        ResponseEntity<Error> resultado = restResponseEntityExceptionHandler.handleConflict(exception);
        //assert
        Assert.assertEquals("Ocurrió un error, favor contactar al administrador.", resultado.getBody().getMensaje());
    }

}