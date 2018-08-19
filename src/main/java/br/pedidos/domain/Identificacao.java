package br.pedidos.domain;

import org.springframework.hateoas.Identifiable;

public interface Identificacao extends Identifiable<Long> {
	
	void setId(Long id);

}
