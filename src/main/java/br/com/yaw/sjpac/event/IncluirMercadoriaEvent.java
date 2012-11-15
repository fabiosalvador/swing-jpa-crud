package br.com.yaw.sjpac.event;

import br.com.yaw.sjpac.model.Mercadoria;

/**
 * Define um evento para a inclusão de uma <code>Mercadoria</code>.
 * 
 * @author YaW Tecnologia
 */
public class IncluirMercadoriaEvent extends AbstractEvent<Mercadoria> {
	
	public IncluirMercadoriaEvent(Mercadoria m) {
		super(m);
	}
}
