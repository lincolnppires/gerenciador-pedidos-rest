package br.pedidos.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class PedidoTest {

	private Pedido pedido;
	
	@Before
	public void setUp() {
		this.pedido = new Pedido();
	}
	
	private void assertNaoPossuiItens() {
		assertTrue(pedido.getItems().isEmpty());
	}

	private void assertTotalDoCusto(Long total) {
		assertEquals(total, pedido.getTotalCusto(), 00001);	
	}

	private Item adicionarItemComCusto(Long valor) {
		Item item = new Item("item1", valor);
		pedido.adicionaItem(item);	
		return item;
	}
	
	@Test
	public void testaPedidoSemItensCustoDeveSerZero() {
		assertNaoPossuiItens();
		assertTotalDoCusto(0l);
	}

	@Test
	public void testaPedidoCom1ItemCustoDeveSerValorDoItem() {
		Item item = adicionarItemComCusto(100l);
		assertTotalDoCusto(item.getValor());
	}

	@Test
	public void testaPedidoCom2ItensCustoDeveSerASomaDosValoresDeCadaItem() {
		Item item1 = adicionarItemComCusto(100l);
		Item item2 = adicionarItemComCusto(200l);
		assertTotalDoCusto(item1.getValor() + item2.getValor());
	}
}
