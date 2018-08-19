package br.pedidos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import br.pedidos.domain.Pedido;

@Component
public class MontaRecursoPedido extends MontaRecurso<Pedido, PedidoRecurso> {

	@Autowired
	protected EntityLinks entityLinks;
	
	private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";
	
	@Override
	public PedidoRecurso paraRecurso(Pedido pedido) {
		
		PedidoRecurso recurso = new PedidoRecurso(pedido);
		
		final Link selfLink = entityLinks.linkToSingleResource(pedido);
		
		recurso.add(selfLink.withSelfRel());
		recurso.add(selfLink.withRel(UPDATE_REL));
		recurso.add(selfLink.withRel(UPDATE_REL));
		
		return recurso;
	
	}

}
