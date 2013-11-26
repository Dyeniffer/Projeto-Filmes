package gui.Action;

import gui.CadastrarFilmePanel;
import gui.CriarBKPBDPanel;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;

import pojo.Filme;
import dao.FilmeDao;

public class SalvarBKPAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private CriarBKPBDPanel panel;
	private SelecionarLocalBKPAction sl;

	public SalvarBKPAction(CriarBKPBDPanel panel, SelecionarLocalBKPAction sl) {
		super("Escolher local para salvar BKP");
		this.panel = panel;
		this.sl = sl;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JFileChooser diretorio = new JFileChooser();
		diretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int res = diretorio.showOpenDialog(null);

		if (res == JFileChooser.APPROVE_OPTION) {
			File local = diretorio.getSelectedFile();
			JOptionPane.showMessageDialog(null, "Voce escolheu o diretório: "
					+ diretorio.getName());
		} else
			JOptionPane.showMessageDialog(null,
					"Voce nao selecionou nenhum diretorio.");
	}

	// sl.getCaminho();

}