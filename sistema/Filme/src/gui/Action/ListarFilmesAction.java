package gui.Action;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import dao.FilmeDao;
import gui.ListarFilmePanel;
import pojo.Filme;
import sun.org.mozilla.javascript.internal.annotations.JSConstructor;

public class ListarFilmesAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private ListarFilmePanel panel;

	public ListarFilmesAction(ListarFilmePanel panel) {
		super("Listar");
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FilmeDao dao = new FilmeDao();
		int ordem = panel.getOrdena();
		String retorno = "";
		List lista = new ArrayList();

		lista = dao.listarFilmes(ordem);
		for (int i = 0; i < lista.size(); i++) {
			retorno += lista.get(i).toString() + "\n\n";
		}
		JOptionPane.showMessageDialog(null, retorno);
//		JOptionPane.showMessageDialog(null, new JScrollPane(area), retoro,   
//				JOptionPane.INFORMATION_MESSAGE); 
	}
}