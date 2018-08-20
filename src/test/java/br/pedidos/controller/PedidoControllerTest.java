package br.pedidos.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.pedidos.domain.Item;
import br.pedidos.domain.Pedido;
import br.pedidos.repository.RepositorioPedido;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoControllerTest extends ControllerTest {

	@Autowired
	private RepositorioPedido repositorio;

	@Before
	public void setUp() {
		repositorio.limpa();
	}
	
	@Test
	public void testaGETComRepositorioVazioGaranteConteudoVAzio() throws Exception {
		assertNenhumPedido();
		getPedido().andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
	}

	@Test
	public void testaGETParaBuscarTodosOsPedidosGaranteRetornoDeTodos() throws Exception {
		inserePedido(3);

		assertQuantidadeDePedidosE(3);

		getPedido().andExpect(status().isOk()).andExpect(content().string(containsString("Teste Produto 0")))
				.andExpect(content().string(containsString("Teste Produto 1")))
				.andExpect(content().string(containsString("Teste Produto 2")));
	}

	@Test
	public void testaGETParaPedidoEspecificoGaranteRetornoDoPedidoSolicitado() throws Exception {
		inserePedido(3);
		assertQuantidadeDePedidosE(3);
		
		Optional<Pedido> buscaPedido = repositorio.buscaPorId(2l);
		
		getPedido(buscaPedido.get().getId())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString(buscaPedido.get().getDescricao())));
	}
	

	@Test
	public void testaPOSTNovoPedidoGaranteQueFoiCriado() throws JsonProcessingException, Exception {
		assertNenhumPedido();
		Pedido pedido = new Pedido("Criado via POST");
		pedido.setItems(Arrays.asList(
				 new Item("item1", 10l), 
				 new Item("item2", 20l)	
		));		
		
		String pedidoJson = toJsonString(pedido);
		System.out.println(pedidoJson);
		
		postPedido(pedidoJson);
		assertQuantidadeDePedidosE(1);
	}
//
//	@Test
//	public void testaDELETERepositorioVazioGaranteRespostaCorreta() throws Exception {
//		assertNenhumPedido();
//		deletePedido(1).andExpect(status().isNotFound());
//	}
//
//	@Test
//	public void testaDELETEPedidoExistenteGaranteQueFoiDeletado() throws Exception {
//		inserePedido(1);
//		assertQuantidadeDePedidosE(1);
//		deletePedido(1);
//		assertNenhumPedido();
//	}
//
//	@Test
//	public void testaPUTPedidoExistenteGaranteAtualizacao() throws Exception {
//		inserePedido(1);
//		assertQuantidadeDePedidosE(1);
//
//		Pedido novo = new Pedido("Descricao Atualizada");
//		novo.setId(1l);
//
//		putPedido(novo.getId(), novo);
//
//		Optional<Pedido> retornoPedido = repositorio.buscaPorId(novo.getId());
//		assertEquals(retornoPedido.get().getDescricao(), "Descricao Atualizada");
//
//	}

	private ResultActions getPedido() throws Exception {
		return get("/pedido");
	}

	private ResultActions getPedido(long id) throws Exception {
		return get("/pedido/{id}", id);
	}

	private ResultActions postPedido(String payload) throws Exception {
		return post("/pedido", payload);
	}

	private ResultActions deletePedido(long id) throws Exception {
		return delete("/pedido/{id}", id);
	}

	private ResultActions putPedido(long id, Pedido updatePedido) throws Exception {
		return put("/pedido/{id}", updatePedido, String.valueOf(id));
	}

	private void assertNenhumPedido() {
		assertQuantidadeDePedidosE(0);
	}

	private void assertQuantidadeDePedidosE(int quantidade) {
		assertEquals(quantidade, repositorio.getQuantidade());
	}

	private void inserePedido(int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			Pedido pedido = new Pedido("Teste Produto " + i);
			repositorio.insere(pedido);
		}
	}

		
}
