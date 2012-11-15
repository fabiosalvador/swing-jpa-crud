package br.com.yaw.sjpac.event;

import java.util.List;

import br.com.yaw.sjpac.model.Mercadoria;

/**
 * Define um evento para a busca de mercadorias (<code>List</code>).
 * 
 * @author YaW Tecnologia
 */
public class BuscarMercadoriaEvent extends AbstractEvent<List<Mercadoria>> {
	
	public BuscarMercadoriaEvent(List<Mercadoria> m) {
		super(m);
	}

}
