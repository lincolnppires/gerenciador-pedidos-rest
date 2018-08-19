package br.pedidos.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.pedidos.domain.Pedido;

public class PedidoRecurso extends ResourceSupport {

	private final long id;
	private final String descricao;
	private final long custoTotal;

	public PedidoRecurso(Pedido pedido) {
		this.id = pedido.getId();
		this.descricao = pedido.getDescricao();
		this.custoTotal = pedido.getTotalCusto();
	}

	@JsonProperty("id")
	public Long getResourceId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public long getCustoTotal() {
		return custoTotal;
	}

}
