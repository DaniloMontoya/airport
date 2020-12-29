package co.com.ceiba.airport.infrastructure.error;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;


class RestResponseEntityExceptionHandlerTest {

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