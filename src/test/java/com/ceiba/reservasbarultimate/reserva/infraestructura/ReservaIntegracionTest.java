package com.ceiba.reservasbarultimate.reserva.infraestructura;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.reservasbarultimate.aplicacion.ComandoReservaTestBuild;
import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;
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
	    void crearReservaConIdMesaErroneoTest() throws Exception {
	    
	        
			ComandoReserva comandoReserva= new ComandoReservaTestBuild().conIdMesa(14).build();

	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(comandoReserva))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().is4xxClientError())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value("error, El numero de mesa debe ser un valor entre 1 y 9"));
	    }
	    
	    @Test
	    void crearReservaConIdUsuarioErroneoTest() throws Exception {
	    
			ComandoReserva comandoReserva= new ComandoReservaTestBuild().conIdUsuario(1234l).build();

	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(comandoReserva))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().is4xxClientError());
	    }
	    
	    @Test
	    void crearReservaConCantidadPersonasErroneoTest() throws Exception {
	    
			ComandoReserva comandoReserva= new ComandoReservaTestBuild().conCantidadPersonas(6).build();

	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(comandoReserva))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().is4xxClientError());
	    }
	    
	    
	    @Test
	    void intentarCrearReservaMesaNoDisponibleTest() throws Exception {
	    
			ComandoReserva reservaMesa1Cliente1= new ComandoReservaTestBuild().conIdUsuario(1122334455l).conIdMesa(2).build();

	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa1Cliente1))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	        
	        ComandoReserva reservaMesa1Cliente2= new ComandoReservaTestBuild().conIdUsuario(77788899l).conIdMesa(2).build();

	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(reservaMesa1Cliente2))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().is4xxClientError())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value("Lo sentimos, La mesa que intentas reservar NO esta disponible"));
	        
	        
	        
	    }
	    
	     @Test
	    void crearReservaConDatosCorrectosTest() throws Exception {
	    
			ComandoReserva comandoReserva= new ComandoReservaTestBuild().build();

	        mockMvc.perform( MockMvcRequestBuilders
	                .post("/reserva")
	                .content(objectMapper.writeValueAsString(comandoReserva))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.idMesa").value(1))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.cantidadPersonas").value(4))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.idUsuario").value(34567899l))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.precioReserva").value(190000l));
	        
	    }

}
