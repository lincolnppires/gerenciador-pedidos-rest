package br.pedidos.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.pedidos.domain.Pedido;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositorioPedidoTest {
	
	private static final long idInexistente = Long.MAX_VALUE;
	
	@Autowired
	private RepositorioPedido repositorio;
	
	@Before
	public void setUp() {
		repositorio.limpa();
	}
	
	@Test
	public void testaRepositorioVazioEBuscaPorIdInvalidoRetornaFalsoNoRepositorioVazio() {
		assertEquals(0, repositorio.getQuantidade());
		Optional<Pedido> pedido = repositorio.buscaPorId(idInexistente);
		assertFalse(pedido.isPresent());
	}

	@Test
	public void testaBuscaPedidoDeAcordoComId() {
		Pedido pedido = repositorio.insere(new Pedido("pedido1")); 
		Optional<Pedido> pedidoEncontrado = repositorio.buscaPorId(pedido.getId());
		assertTrue(pedidoEncontrado.isPresent());
		assertEquals("pedido1", pedido.getDescricao());
	}
	
	@Test
	private void testaRemocaoDeUmPedidoPorId() {
		Pedido pedido = repositorio.insere(new Pedido("pedido1"));
		repositorio.insere(new Pedido("pedido2"));
		
		assertTrue(repositorio.delete(pedido.getId()));
		assertEquals(1, repositorio.getQuantidade());		
	}
	
	@Test
	private void testaAtualizacaoDeUmPedido() {
		Pedido pedido1 = repositorio.insere(new Pedido("pedido1"));
		repositorio.insere(new Pedido("pedido2"));
		Pedido novo = new Pedido("pedido alterado");
		
		boolean alterado = repositorio.update(pedido1.getId(), novo);
		assertTrue(alterado);
		assertEquals("pedido alterado", pedido1.getDescricao());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
