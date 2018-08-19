package br.pedidos.resource;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class MontaRecurso<TipoDominio, TipoRecurso> {
	
	public abstract TipoRecurso paraRecurso(TipoDominio elemento);	
	
	public Collection<TipoRecurso> paraColecaoRecurso(Collection<TipoDominio> elementos){
		return elementos.stream().map(o -> paraRecurso(o)).collect(Collectors.toList());
	}
}
