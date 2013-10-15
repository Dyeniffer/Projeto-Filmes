package gui.Action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import dao.FilmeDao;
import gui.CadastrarFilmePanel;
import pojo.Filme;

public class CadastrarFilmeAction extends AbstractAction {


	private static final long serialVersionUID = 1L;


	private CadastrarFilmePanel panel;

	public CadastrarFilmeAction(CadastrarFilmePanel panel) {
		super("Cadastrar");
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Filme c = panel.getFilme();
		FilmeDao dao = new FilmeDao();
		dao.insertFilme(c);
	}
}