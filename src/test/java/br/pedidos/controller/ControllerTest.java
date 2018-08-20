package br.pedidos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;

@AutoConfigureMockMvc
public class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	protected ResultActions get(String url, Object... uriVars) throws Exception {
		return mockMvc.perform(MockMvcRequestBuilders.get(url, uriVars).accept(MediaType.APPLICATION_JSON));
	}
	
	protected ResultActions post(String url, String content, Object... uriVars) throws Exception {
		return mockMvc.perform(MockMvcRequestBuilders.post(url, uriVars)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(content)
			);
	}
	
	protected ResultActions delete(String url, Object... uriVars) throws Exception {
		return mockMvc.perform(MockMvcRequestBuilders.delete(url, uriVars)
				.accept(MediaType.APPLICATION_JSON)
			);
	}
	
	protected ResultActions put(String url, Object content, Object... uriVars) throws Exception {
		return mockMvc.perform(MockMvcRequestBuilders.put(url, uriVars)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJsonString(content))
			);
	}

	public String toJsonString(final Object content) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(content);
	}

}
