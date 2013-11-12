package gui.Action;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import pojo.Filme;

import dao.FilmeDao;


import gui.RemoverFilmesPanel;


public class RemoverFilmeAction extends AbstractAction {


	private static final long serialVersionUID = 1L;


	private RemoverFilmesPanel panel;

	public RemoverFilmeAction(RemoverFilmesPanel panel) {
		super("Remover Filmes Selecionados");
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i <= panel.getTable().getRowCount(); i++) {
			if (panel.getTable().isCellSelected(i, 1)) {
				FilmeDao dao = new FilmeDao();
				List<Filme> lista = dao.RemoverFilmes();
				dao.RemoveFilmePorNome(lista.get(i).getNome());
			}
		}
		JOptionPane.showMessageDialog(null, "Removidos com sucesso!");
		panel.alimentaTabela();
	}
}