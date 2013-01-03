package br.com.yaw.sjpac.action;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.yaw.sjpac.controller.PersistenceController;

public final class TransactionalAction extends AbstractAction {

	private AbstractAction action;
	
	private PersistenceController persistenceController;
	
	private TransactionalAction(){}
	
	@Override
	protected void action() {
		if (action == null) {
			throw new IllegalArgumentException("Indique a Ação que deve ser executada.");
		}
		
		if (persistenceController == null) {
            throw new IllegalArgumentException("Informe o dono do contexto de persistencia.");
        }
		
		EntityManager em = persistenceController.getPersistenceContext();
		if (em == null) {
            throw new IllegalArgumentException("Sem referencia para o gerenciador de persistencia.");
        }
		
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			action.action();
			tx.commit();
		} catch(Exception ex) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	protected final void preAction() {
		if (action != null) {
			action.preAction();
		}
	}
	
	@Override
	protected final void posAction() {
		if (action != null) {
			action.posAction();
		}
	}
	
	public static TransactionalAction build() {
		return new TransactionalAction();
	}
	
	public TransactionalAction addAction(AbstractAction action) {
		this.action = action;
		return this;
	}
	
	public TransactionalAction persistenceCtxOwner(PersistenceController persistenceController) {
		this.persistenceController = persistenceController;
		return this;
	}
	
}
