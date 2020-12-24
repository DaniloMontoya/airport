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

import java.time.LocalDateTime;
import java.time.Month;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class FlightCommandControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createFlightTest() throws Exception{
        FlightCommand flightCommand = new FlightCommand(null,
                LocalDateTime.of(2020, Month.DECEMBER, 19, 22,36),
                "Barcelona",
                181.03f,
                false);
        mvc.perform(MockMvcRequestBuilders
                .post("/flight/create")
                .content(objectMapper.writeValueAsString(flightCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.value").value("Barcelona-1608417360"));
    }


    @Test
    void updateFlightTest() throws Exception{
        FlightCommand flightCommand = new FlightCommand("Madird-1608414400",
                LocalDateTime.of(2020, Month.DECEMBER, 19, 22,20),
                "Madrid", 181.03f, false);
        mvc.perform(MockMvcRequestBuilders
                .put("/flight/update")
                .content(objectMapper.writeValueAsString(flightCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteFlightTest() throws Exception{
        FlightCommand flightCommand = new FlightTestDataBuilder().buildCommand();
        mvc.perform(MockMvcRequestBuilders
                .delete("/flight/delete/{id}", "Lisboa-1608520500")
                .content(objectMapper.writeValueAsString(flightCommand))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
