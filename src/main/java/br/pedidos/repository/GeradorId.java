package br.pedidos.repository;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=BeanDefinition.SCOPE_PROTOTYPE)
public class GeradorId {

	private AtomicLong proximoId = new AtomicLong(1);
	
	public long getProximoId() {
		return proximoId.getAndIncrement();
	}
}
