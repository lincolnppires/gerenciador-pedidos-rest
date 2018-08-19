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

	private void assertTotalDoCusto(long total) {
		assertEquals(total, pedido.getTotalCusto());	
	}

	private Item adicionarItemComCusto(int valor) {
		Item item = new Item("item1", valor);
		pedido.adicionaItem(item);	
		return item;
	}
	
	@Test
	public void testaPedidoSemItensCustoDeveSerZero() {
		assertNaoPossuiItens();
		assertTotalDoCusto(0);
	}

	@Test
	public void testaPedidoCom1ItemCustoDeveSerValorDoItem() {
		Item item = adicionarItemComCusto(100);
		assertTotalDoCusto(item.getValor());
	}

	@Test
	public void testaPedidoCom2ItensCustoDeveSerASomaDosValoresDeCadaItem() {
		Item item1 = adicionarItemComCusto(100);
		Item item2 = adicionarItemComCusto(200);
		assertTotalDoCusto(item1.getValor() + item2.getValor());
	}
}
