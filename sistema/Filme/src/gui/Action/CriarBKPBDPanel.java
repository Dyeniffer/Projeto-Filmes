package gui.Action;

import javax.swing.JPanel;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CriarBKPBDPanel extends JPanel {
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private String caminho;
	byte[] buffer = new byte[1024];
	
	/**
	 * Create the panel.
	 */
	public CriarBKPBDPanel() {
		setBackground(Color.WHITE);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnEscolherLocal = new JButton("escolher local");
		btnEscolherLocal.setAction(action);
		add(btnEscolherLocal, "20, 6");
		
		JButton btnCriarCpiaDe = new JButton("criar c\u00F3pia de seguran\u00E7a");
		btnCriarCpiaDe.setAction(action_1);
		add(btnCriarCpiaDe, "20, 8");

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Escolher Caminho");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Criar Cópia de Segurança");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String localDoBD = "c:/filmes/";
			
			try {
				 
				// cria o arquivo zip
				ZipOutputStream saidaDeStream = new ZipOutputStream(new FileOutputStream(caminho));
				 
				// marca o modo de compreensão do arquivo
				saidaDeStream.setLevel(Deflater.BEST_COMPRESSION);
				 
				// carrega o arquivo em um stream
				FileInputStream entradaDeStream = new FileInputStream(localDoBD);
				 
				// cria uma entrada no zip para o arquivo
				saidaDeStream.putNextEntry(new ZipEntry(localDoBD));
				 
				// transfere os dados do arquivo para o zip
				saidaDeStream.write(buffer);
				
				 
				// fecha a entrada do arquivo no zip
				saidaDeStream.closeEntry();
				 
				// fecha o arquivo
				entradaDeStream.close();
				
				saidaDeStream.finish();
				
				// fecha o arquivo zip
				saidaDeStream.close();
				 
				} catch (Exception e1) {
					System.out.println("bkp não realizado");
				}
		}
	}
}
