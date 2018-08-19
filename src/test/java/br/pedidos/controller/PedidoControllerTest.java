package br.pedidos.controller;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.EntityLinks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;

import br.pedidos.domain.Item;
import br.pedidos.domain.Pedido;
import br.pedidos.repository.RepositorioPedido;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoControllerTest {

	@Autowired
	private RepositorioPedido repositorio;
	
	@Autowired
	private EntityLinks entityLinks;
	
	@Before
	public void setUp() {
		repositorio.limpa();
	}
	
	private ResultActions getPedido() {
		return (ResultActions) get("/pedido");
	}
	
	@Test
	public void testaGetRepositorioVazio() throws Exception{
		getPedido()
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("[]")));
	}
	
	@Test
	public void testaGetRepositorio2Pedido() throws Exception{
		adiciona2Pedidos();
		getPedido()
			.andExpect(status().isOk())
			.andExpect(content().string("pedido1"))
			.andExpect(content().string("pedido2"));			
	}
	
	private void adiciona2Pedidos() {
		Pedido pedido1 = new Pedido("pedido1");
		pedido1.setItems(Arrays.asList(new Item("item1", 10l), new Item("item2", 20l)));
		Pedido pedido2 = new Pedido("pedido2");
		pedido2.setItems(Arrays.asList(new Item("item1", 100l), new Item("item2", 200l)));
		repositorio.insere(pedido1);
		repositorio.insere(pedido2);
	}
	
	
	
	
}
