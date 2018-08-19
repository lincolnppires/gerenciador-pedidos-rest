package br.pedidos.repository;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class GeradorIdTest {
	
	@Autowired
	private GeradorId gerador1;
	@Autowired
	private GeradorId gerador2;
		
	@Test
	public void testaMultiplosGeradoresNaoIntefereUmNoOutro() {
		assertEquals(1l, gerador1.getProximoId());
		assertEquals(2l, gerador1.getProximoId());
		assertEquals(1l, gerador2.getProximoId());
		assertEquals(2l, gerador2.getProximoId());
	}

}
