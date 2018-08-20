package br.pedidos.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.pedidos.domain.Pedido;
import br.pedidos.repository.RepositorioPedido;
import br.pedidos.resource.MontaRecursoPedido;
import br.pedidos.resource.PedidoRecurso;

@CrossOrigin(origins="*")
@RestController
@ExposesResourceFor(Pedido.class)
@RequestMapping(value="/pedido", produces="application/json")
public class PedidoController {
	
	@Autowired
	private RepositorioPedido repositorio;
	
	@Autowired
	private MontaRecursoPedido montador;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Collection<PedidoRecurso>> getPedidos(){
		
		List<Pedido> pedidos = repositorio.buscaTodos();
		return new ResponseEntity<>(montador.paraColecaoRecurso(pedidos), HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<PedidoRecurso> getPedidoPorId(@PathVariable Long id){
		Optional<Pedido> pedido = repositorio.buscaPorId(id);
		
		if(pedido.isPresent()) {
			return new ResponseEntity<>(montador.paraRecurso(pedido.get()), HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PedidoRecurso> postPedido(@RequestBody Pedido pedido){
		Pedido novoPedido = repositorio.insere(pedido);
		return new ResponseEntity<>(montador.paraRecurso(novoPedido), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<PedidoRecurso> deletePedido(@PathVariable Long id){
		boolean foiDeletado = repositorio.delete(id);
		HttpStatus responseStatus = foiDeletado ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(responseStatus);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
