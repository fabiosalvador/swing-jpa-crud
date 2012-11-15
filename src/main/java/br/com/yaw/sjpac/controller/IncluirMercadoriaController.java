package br.com.yaw.sjpac.controller;

import javax.swing.JFrame;

import br.com.yaw.sjpac.action.AbstractAction;
import br.com.yaw.sjpac.dao.MercadoriaDAO;
import br.com.yaw.sjpac.dao.MercadoriaDAOJPA;
import br.com.yaw.sjpac.event.IncluirMercadoriaEvent;
import br.com.yaw.sjpac.model.Mercadoria;
import br.com.yaw.sjpac.ui.IncluirMercadoriaFrame;

/**
 * Define a <code>Controller</code> responsável por gerir a tela de inclusão/edição de <code>Mercadoria</code>.
 * 
 * @see br.com.yaw.ssjc.controller.PersistenceController
 * 
 * @author YaW Tecnologia
 */
public class IncluirMercadoriaController extends PersistenceController {

	private IncluirMercadoriaFrame frame;
	
	public IncluirMercadoriaController(AbstractController parent) {
		super(parent);
		this.frame = new IncluirMercadoriaFrame();
		
		frame.addWindowListener(this);
		registerAction(frame.getCancelarButton(), new AbstractAction() {
			public void action() {
				cleanUp();
			}
		});
		
		registerAction(frame.getSalvarButton(), new AbstractAction() {
			private Mercadoria m;
			
			public void action() {
				try {
					getPersistenceContext().getTransaction().begin();
					Mercadoria m = IncluirMercadoriaController.this.frame.getMercadoria();
					MercadoriaDAO dao = new MercadoriaDAOJPA(getPersistenceContext());
					dao.save(m);
					getPersistenceContext().getTransaction().commit();
				} catch (Exception e) {
					getPersistenceContext().getTransaction().rollback();
					throw new RuntimeException(e);
				}
			}
			
			public void posAction() {
				cleanUp();
				fireEvent(new IncluirMercadoriaEvent(m));
			}
			
		});
	}
	
	@Override
	protected JFrame getFrame() {
		return frame;
	}
	
	public void show() {
		loadPersistenceContext(((PersistenceController)getParentController()).getPersistenceContext());
		frame.setVisible(true);
	}
	
	public void show(Mercadoria m) {
		((IncluirMercadoriaFrame) getFrame()).setMercadoria(m);
		show();
		frame.setTitle("Editar");
	}
	
	@Override
	protected void cleanUp() {
		frame.setTitle("Incluir");
		frame.setVisible(false);
		frame.resetForm();
		
		super.cleanUp();
	}
	
}
