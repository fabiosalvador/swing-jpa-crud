package br.com.yaw.sjpac.event;

import br.com.yaw.sjpac.model.Mercadoria;

/**
 * Define um evento para a exclusão de uma <code>Mercadoria</code>.
 * 
 * @author YaW Tecnologia
 */
public class DeletarMercadoriaEvent extends AbstractEvent<Mercadoria> {
	
	public DeletarMercadoriaEvent(Mercadoria m) {
		super(m);
	}

}
