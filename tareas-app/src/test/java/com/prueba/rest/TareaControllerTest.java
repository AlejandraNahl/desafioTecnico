package com.prueba.rest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.prueba.rest.controller.TareaController;
import com.prueba.rest.service.TareaServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TareaController.class)
public class TareaControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TareaServiceImpl tareasService;

	@Test
	public void testGuardarSismos() throws Exception {
		String exampleTareaJson = "{\"descripcion\":\"Descripcion5\",\"fechaCreacion\":\"2019-01-31\",\"descripcion\":\"Descripcion5\"}";

		String uri = "/form";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(exampleTareaJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		System.out.println("response" + response.getStatus());

		assertEquals(HttpStatus.OK.value(), response.getStatus());


	}

}
