package co.com.ceiba.airport.infraestructure;

import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FlightCommandControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createFlightTest() throws Exception{
        FlightCommand flightCommand = new FlightCommand(null, 1608417400, "Barcelona", 181.03f, false);
        mvc.perform(MockMvcRequestBuilders
                .post("/flight/create")
                .content(objectMapper.writeValueAsString(flightCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.value").value("Barcelona-1608417400"));
    }

    @Test
    public void updateFlightTest() throws Exception{
        FlightCommand flightCommand = new FlightCommand("Madird-1608414400", 1608416400, "Madrid", 181.03f, false);
        mvc.perform(MockMvcRequestBuilders
                .put("/flight/update")
                .content(objectMapper.writeValueAsString(flightCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteFlightTest() throws Exception{
        FlightCommand flightCommand = new FlightTestDataBuilder().buildCommand();
        mvc.perform(MockMvcRequestBuilders
                .delete("/flight/delete/{id}", "London-1608404400")
                .content(objectMapper.writeValueAsString(flightCommand))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
