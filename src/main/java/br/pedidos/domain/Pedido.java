package br.pedidos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Pedido implements Identificacao{
	
	private long id;
	private List<Item> items = new ArrayList();
	
	
	public long getTotalCusto() {
		return items.stream().collect(Collectors.summingLong(item -> item.getValor()));
	}
	
	public void adicionaItem(Item item) {
		items.add(item);
	}
	
	public List<Item> getItems() {
		return items;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
