package com.ceiba.reservasbarultimate.mesa.infraestructura;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class MesaIntegracionTest {
	
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
	     void listarMesasDisponiblesTest() throws Exception {
	    	mockMvc.perform(MockMvcRequestBuilders
	            .get("/mesas")
	            .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
	    }
	    
	 /*   @Test
	     void listarMesasNoHayDisponiblesTest() throws Exception {
	    	
	    	ComandoReserva reservaMesa1= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(1).build();
	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa1))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	    	ComandoReserva reservaMesa2= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(2).build();
	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa2))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	    	ComandoReserva reservaMesa3= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(3).build();
	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa3))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	    	ComandoReserva reservaMesa4= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(4).build();
	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa4))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	    	ComandoReserva reservaMesa5= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(5).build();
	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa5))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	    	ComandoReserva reservaMesa6= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(6).build();
	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa6))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	    	ComandoReserva reservaMesa7= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(7).build();
	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa7))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	    	ComandoReserva reservaMesa8= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(8).build();
	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa8))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	        ComandoReserva reservaMesa9= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(9).build();
	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa9))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	    	
	    	mockMvc.perform(MockMvcRequestBuilders
	            .get("/mesas")
	            .contentType("application/json")
               .accept("application/json"))
               .andExpect(status().is4xxClientError());
	    }*/


}
