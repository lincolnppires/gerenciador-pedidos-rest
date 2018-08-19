package br.pedidos.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import junit.framework.Assert;

public class PedidoTest {

	private Pedido pedido;
	
	@Before
	public void setUp() {
		this.pedido = new Pedido();
	}
	
	private void assertNaoPossuiItens() {
		assetTrue(pedido.getItem.isEmpty());
	}

	private void assertTotalDoCusto(long total) {
		assertEquals(total, pedido.getTotalCusto);	
	}

	private Item adicionarItemComCusto(int valor) {
		Item item = new Item(valor);
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
		assertTotalDoCusto(item.getValor);
	}

	@Test
	public void testaPedidoCom2ItensCustoDeveSerASomaDosValoresDeCadaItem() {
		Item item1 = adicionarItemComCusto(100);
		Item item2 = adicionarItemComCusto(200);
		assertTotalDoCusto(item1.getValor + item2.getValor);
	}
}
