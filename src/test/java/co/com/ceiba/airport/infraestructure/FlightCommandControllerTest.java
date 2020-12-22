package co.com.ceiba.airport.infraestructure;

import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FlightCommandControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createFlightTest(){
        FlightCommand flightCommand = new FlightTestDataBuilder().buildCommand();

    }

}
