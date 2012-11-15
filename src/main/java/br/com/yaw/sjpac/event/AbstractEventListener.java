package br.com.yaw.sjpac.event;

/**
 * Estipula um contrato para componentes com a capacidade de tratar um evento gerado.
 * 
 * <p>Em conjunto com <code>AbstractController</code> e <code>AbstractEvent</code>, esse componente é parte do trecho que implementa o design pattern <strong>Observer</strong>.</p>
 * <p><code>AbstractEventListener</code> atua como observador.</p>
 * 
 * @see br.com.yaw.sjpac.event.AbstractEvent
 * 
 * @author YaW Tecnologia
 *
 * @param <M> tipo do Evento que deverá ser tratado.
 */
public interface AbstractEventListener<M extends AbstractEvent<?>> {

	 public void handleEvent(M event);

}
