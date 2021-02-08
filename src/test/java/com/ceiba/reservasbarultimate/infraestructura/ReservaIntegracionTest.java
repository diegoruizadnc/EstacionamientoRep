package com.ceiba.reservasbarultimate.infraestructura;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.reservasbarultimate.aplicacion.ComandoReservaTestBuild;
import com.ceiba.reservasbarultimate.dominio.ReservaDtoTestDataBuild;
import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class ReservaIntegracionTest {
	
	  @Autowired
	    private ObjectMapper objectMapper;

	    @Autowired
	    private WebApplicationContext wac;

	    private MockMvc mockMvc;

	    @BeforeAll
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }
		
		
	    @Test
	    void crearReservaIntegracionTest() throws Exception {
	    
	        
	        LocalDate localDate  = LocalDate.of(2021, 02, 13);
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			ComandoReserva comandoReserva= new ComandoReservaTestBuild().build();
			ReservaDto reservaDto= new ReservaDtoTestDataBuild().conFechaReserva(date).build();

	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(comandoReserva))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	    }

}



