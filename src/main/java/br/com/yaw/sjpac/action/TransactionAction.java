package br.com.yaw.sjpac.action;

import javax.persistence.EntityManager;

public abstract class TransactionAction extends AbstractAction {

	private EntityManager em;
	
	public TransactionAction(){
	}
	
	@Override
    public void actionPerformed() {
        if (em == null) {
            throw new IllegalArgumentException("Informe o gerenciador de persistencia");
        }
        try {
        	skip = false;
            preAction();
            if (!skip) {
            	em.getTransaction().begin();
    			action();
    			em.getTransaction().commit();
    		}
            if (!skip) {
    			posAction();
    		}
        } catch (Exception ex) {
            em.getTransaction().rollback();
            actionFailure();
            throw new RuntimeException(ex);
        }
    }

    public void setPersistenceContext(EntityManager em) {
        this.em = em;
    }
	
}
