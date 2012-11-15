package br.com.yaw.sjpac.event;

/**
 * Define um componente básico como estrutura de evento. 
 * 
 * <p>Um evento é um objeto que está relacionado a alguma ação no sistema, que deve ocasionar algo em outro componente.</p>
 * <p>Em conjunto com <code>AbstractEventListener</code> e <code>AbstractController</code>, esse componente é parte do trecho que implementa o design pattern <strong>Observer</strong>.</p>
 * <p><code>AbstractEvent</code> atua como observado.</p>
 * 
 * @author YaW Tecnologia
 *
 * @param <Target> tipo com qual elemento ocasionou a geração do evento.
 */
public abstract class AbstractEvent<Target> {

	private Target target;

	public AbstractEvent(Target target) {
		this.target = target;
	}
	
	public Target getTarget() {
		return target;
	}
}
