package br.pedidos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Pedido {
	
	private long id;
	private List<Item> items = new ArrayList();
	
	
	public long getTotalCusto() {
		return items.stream().collect(Collectors.summingLong(item -> item.getValor()));
	}
	
	public void adicionaItem(Item item) {
		items.add(item);
	}
	
	public long getId() {
		return id;
	}
	
	public List<Item> getItems() {
		return items;
	}

}
