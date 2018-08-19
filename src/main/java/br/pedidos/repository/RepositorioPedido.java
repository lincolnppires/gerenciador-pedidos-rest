package br.pedidos.repository;

import br.pedidos.domain.Pedido;

public class RepositorioPedido extends RepositorioEmMemoria<Pedido> {

	@Override
	protected void atualizaSeExistir(Pedido original, Pedido novo) {
		original.setDescricao(novo.getDescricao());
		original.setItems(novo.getItems());
	}

}
