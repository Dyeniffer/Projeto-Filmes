package gui.Action;

import gui.CadastrarFilmePanel;
import gui.CriarBKPBDPanel;

import java.awt.Panel;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;

import pojo.Filme;
import dao.FilmeDao;

public class SalvarBKPAction extends AbstractAction {


	private static final long serialVersionUID = 1L;


	private CriarBKPBDPanel panel;

	public SalvarBKPAction(CriarBKPBDPanel panel) {
		super("Escolher local para salvar BKP");
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFileChooser url = new JFileChooser();
		
	}
}