package br.pedidos.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.pedidos.domain.Identificacao;

public abstract class RepositorioEmMemoria<T extends Identificacao> {
	
	@Autowired
	private GeradorId geradorId;
	
	private List<T> elementos = Collections.synchronizedList(new ArrayList<>());
	
	public T insere(T elemento) {
		elemento.setId(geradorId.getProximoId());
		elementos.add(elemento);
		return elemento;
	}
	
	public boolean delete(Long id) {
		return elementos.removeIf(element -> element.getId().equals(id));
	}
	
	public boolean update(Long id, T elemento) {
		
		if (elemento == null)
			return false;
		else {
			Optional<T> objeto = buscaPorId(elemento.getId());
			objeto.ifPresent(original -> atualizaSeExistir(original, elemento));
			return objeto.isPresent();
		}
	}
	
	protected abstract void atualizaSeExistir(T original, T novo);
	
	public List<T> buscaTodos(){
		return elementos;
	}
	
	public Optional<T> buscaPorId(Long id){
		return elementos.stream().filter(element -> element.getId().equals(id)).findFirst();
	}
	
	public int getQuantidade() {
		return elementos.size();
	}
	
	public void limpa() {
		elementos.clear();
	}

}
