package br.com.yaw.sjpac.ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.com.yaw.sjpac.model.Mercadoria;

/**
 * Tela principal da aplicação. Apresenta uma lista com as mercadorias cadastradas. 
 * 
 * <p>A partir dessa tela eh possivel criar/editar ou pesquisar mercadoria.</p>
 * 
 * @author YaW Tecnologia
 */
public class ListaMercadoriasFrame extends JFrame {
	
	private MercadoriaTable tabela;
	private JScrollPane scrollPane;
	private JButton bNewMercadoria;
	private JButton bRemoveMercadoria;
	private JButton bFindMercadoria;
	private JButton bRefreshLista;
	
	public ListaMercadoriasFrame() {
		setTitle("Lista de Mercadoria");
		
		inicializaComponentes();
		adicionaComponentes();
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void inicializaComponentes() {
		tabela = new MercadoriaTable();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabela);

		bNewMercadoria = new JButton("Nova");
		bNewMercadoria.setActionCommand("novaMercadoriaAction");
		bNewMercadoria.setMnemonic(KeyEvent.VK_N);
		
		bRemoveMercadoria = new JButton("Excluir");
		bRemoveMercadoria.setActionCommand("excluirMercadoriaAction");
		bRemoveMercadoria.setMnemonic(KeyEvent.VK_E);
		
		bFindMercadoria = new JButton("Buscar");
		bFindMercadoria.setActionCommand("buscarMercadoriasAction");
		bFindMercadoria.setMnemonic(KeyEvent.VK_B);
		
		bRefreshLista = new JButton("Atualizar");
		bRefreshLista.setActionCommand("atualizarMercadoriasAction");
		bRefreshLista.setMnemonic(KeyEvent.VK_A);
	}
	
	private void adicionaComponentes(){
		add(scrollPane);
		JPanel panel = new JPanel();
		panel.add(bNewMercadoria);
		panel.add(bRemoveMercadoria);
		panel.add(bFindMercadoria);
		panel.add(bRefreshLista);
		add(panel, BorderLayout.SOUTH);
	}
	
	public JButton getNewButton() {
		return bNewMercadoria;
	}
	
	public JButton getRemoveButton() {
		return bRemoveMercadoria;
	}

	public JButton getRefreshButton() {
		return bRefreshLista;
	}
	
	public JButton getFindButton() {
		return bFindMercadoria;
	}
	
	public void refreshTable(List<Mercadoria> mercadorias) {
		tabela.reload(mercadorias);
	}
	
	public Mercadoria getSelectedMercadoria() {
		return tabela.getMercadoriaSelected();
	}
	
	public MercadoriaTable getTable() {
		return tabela;
	}
}
