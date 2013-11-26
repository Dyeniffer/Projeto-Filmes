package gui.Action;

import gui.CriarBKPBDPanel;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SelecionarLocalBKPAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;

	private String caminhoArquivo = "";
	private CriarBKPBDPanel panel;

	public SelecionarLocalBKPAction(CriarBKPBDPanel panel) {
		super("Escolher local para salvar BKP");
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFileChooser arquivo = new JFileChooser();
		arquivo.setFileFilter(new javax.swing.filechooser.FileFilter(){
			//Filtro, converte as letras em minúsculas antes de comparar
			public boolean accept(File f){
			return f.getName().toLowerCase().endsWith(".db") || f.isDirectory();
			}
			//Texto que será exibido para o usuário
			public String getDescription() {
			return "Banco de Dados (.db)";
			}
			});
		int retorno = arquivo.showOpenDialog(null);
		if(retorno == JFileChooser.APPROVE_OPTION){
		caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
		JOptionPane.showMessageDialog(null, caminhoArquivo);
		}else{
			JOptionPane.showMessageDialog(null, "Erro ao abrir. Contate o administrador");
		}	
	}
	
	public String getCaminho(){
		return caminhoArquivo;
	}
}
