package br.pedidos.repository;

import org.springframework.stereotype.Repository;

import br.pedidos.domain.Pedido;

@Repository
public class RepositorioPedido extends RepositorioEmMemoria<Pedido> {

	@Override
	protected void atualizaSeExistir(Pedido original, Pedido novo) {
		original.setDescricao(novo.getDescricao());
		original.setItems(novo.getItems());
	}

}
