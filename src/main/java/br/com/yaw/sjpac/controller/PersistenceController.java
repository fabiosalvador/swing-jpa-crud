package br.com.yaw.sjpac.controller;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import br.com.yaw.sjpac.util.JPAUtil;

/**
 * Define uma <code>Controller</code> com funcionalidades para persistência.
 * 
 * @see br.com.yaw.ssjc.controller.AbstractController
 * 
 * @author YaW Tecnologia
 */
public abstract class PersistenceController extends AbstractController {

	private static Logger log = Logger.getLogger(PersistenceController.class);

    private EntityManager persistenceContext;
    private boolean ownsPersistenceContext;
	
    public PersistenceController(){ }
    
    public PersistenceController(AbstractController parent){
    	super(parent);
    }
    
    protected void loadPersistenceContext() {
    	loadPersistenceContext(null);
    }
    
    protected void loadPersistenceContext(EntityManager persistenceContext) {
    	if (persistenceContext == null) {
            log.debug("Criando um contexto de persistência (EntityManager).");
            this.persistenceContext = JPAUtil.createEntityManager();
            this.ownsPersistenceContext = true;
        } else {
            log.debug("Utilizando contexto de persistência (EntityManager) existente.");
            this.persistenceContext = persistenceContext;
            this.ownsPersistenceContext = false;
        }
    }
    
    public EntityManager getPersistenceContext() {
		return this.persistenceContext;
	}
    
    @Override
    protected void cleanUp() {
        if (ownsPersistenceContext && getPersistenceContext().isOpen()) {
            log.debug("Fechando o contexto de persistência (EntityManager).");
            getPersistenceContext().close();
        }
        super.cleanUp();
    }
}
