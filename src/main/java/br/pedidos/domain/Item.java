package br.pedidos.domain;

public class Item {

	private int id;
	private String nome;
	private Long valor;
	
	public Item(String nome, Long valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public Long getValor() {
		return valor;
	}
		
	
	


	
	
}
