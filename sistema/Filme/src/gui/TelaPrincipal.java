package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import javax.swing.Action;

import sun.awt.AWTAccessor.MenuAccessor;

import java.awt.Color;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import gui.*;

public class TelaPrincipal {

	private JFrame frame;
	private final Action action_CriarBKPBanco = new SwingAction();
	private final Action action_RestaurarBKPBanco = new SwingAction_1();
	private final Action action_Sair = new SwingAction_2();
	private final Action action_Cadastrar = new SwingAction_3();
	private final Action action_Remover = new SwingAction_4();
	private final Action action_ManualDoUsuario = new SwingAction_9();
	private final Action action_Sobre = new SwingAction_10();

	private CardLayout card;
	
	private CadastrarFilmePanel cdFilmePanel = new CadastrarFilmePanel();
	private ListarFilmePanel fdFilmePanel = new ListarFilmePanel();
	private RemoverFilmesPanel removeFilmePanel = new RemoverFilmesPanel();
	private CriarBKPBDPanel bkpPanel = new CriarBKPBDPanel();
	
	private final Action action_ListarPorDiretor = new SwingAction_5(
			fdFilmePanel);
	private final Action action_ListarPorGenero = new SwingAction_6(
			fdFilmePanel);
	private final Action action_ListarPorNome = new SwingAction_7(fdFilmePanel);
	private final Action action_ListarPorQualidade = new SwingAction_8(
			fdFilmePanel);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Filmes");
		ImageIcon icone = new ImageIcon("./src/icone.png");
		frame.setIconImage(icone.getImage());
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		card = new CardLayout(0, 0);
		frame.getContentPane().setLayout(card);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_Cadastrar");

		panel.add(cdFilmePanel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, "name_Listar");

		panel_1.add(fdFilmePanel);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_2, "name_RemoverFilme");

		panel_2.add(removeFilmePanel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_3, "name_CriarBKPBD");

		panel_3.add(bkpPanel);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		JMenu mnCadastro = new JMenu("Cadastro");
		JMenu mnConsulta = new JMenu("Consulta");
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnArquivo);
		menuBar.add(mnCadastro);
		menuBar.add(mnConsulta);
		menuBar.add(mnAjuda);

		JMenuItem mnCriarBKPBanco = new JMenuItem("New menu item");
		mnCriarBKPBanco.setAction(action_CriarBKPBanco);
		mnArquivo.add(mnCriarBKPBanco);
		//mnCriarBKPBanco.setEnabled(false);

		JMenuItem mnRestaurarBKPBanco = new JMenuItem("New menu item");
		mnRestaurarBKPBanco.setAction(action_RestaurarBKPBanco);
		mnArquivo.add(mnRestaurarBKPBanco);
		mnRestaurarBKPBanco.setEnabled(false);

		mnArquivo.addSeparator();

		JMenuItem mnSair = new JMenuItem("New menu item");
		mnSair.setAction(action_Sair);
		mnArquivo.add(mnSair);

		JMenuItem mnCadastrarNovoFilme = new JMenuItem("New menu item");
		mnCadastrarNovoFilme.setAction(action_Cadastrar);
		mnCadastro.add(mnCadastrarNovoFilme);

		JMenuItem mnRemoverFilme = new JMenuItem("New menu item");
		mnRemoverFilme.setAction(action_Remover);
		mnCadastro.add(mnRemoverFilme);

		JMenuItem mnListarPorDiretor = new JMenuItem("New menu item");
		mnListarPorDiretor.setAction(action_ListarPorDiretor);
		mnConsulta.add(mnListarPorDiretor);

		JMenuItem mnListarPorGenero = new JMenuItem("New menu item");
		mnListarPorGenero.setAction(action_ListarPorGenero);
		mnConsulta.add(mnListarPorGenero);

		JMenuItem mnListarPorNome = new JMenuItem("New menu item");
		mnListarPorNome.setAction(action_ListarPorNome);
		mnConsulta.add(mnListarPorNome);

		JMenuItem mnListarPorQualidade = new JMenuItem("New menu item");
		mnListarPorQualidade.setAction(action_ListarPorQualidade);
		mnConsulta.add(mnListarPorQualidade);

		JMenuItem mnManualDoUsuario = new JMenuItem("New menu item");
		mnManualDoUsuario.setAction(action_ManualDoUsuario);
		mnAjuda.add(mnManualDoUsuario);
		//mnManualDoUsuario.setEnabled(false);

		JMenuItem mnSobre = new JMenuItem("New menu item");
		mnSobre.setAction(action_Sobre);
		mnAjuda.add(mnSobre);
		// mnSobre.setEnabled(false);

	}

	public void mostraListaOrdenada() {
		card.show(frame.getContentPane(), "name_3");
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Criar cópia de segurança do Banco de Dados");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			card.show(frame.getContentPane(), "name_CriarBKPBD");
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Restaurar Banco de Dados");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			card.show(frame.getContentPane(), "name_RestaurarBKPBD");
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Cadastrar novo filme");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			card.show(frame.getContentPane(), "name_Cadastrar");
		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Remover filme");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			card.show(frame.getContentPane(), "name_RemoverFilme");

		}
	}

	private class SwingAction_5 extends AbstractAction {
		private ListarFilmePanel fdFilmePanel;

		public SwingAction_5(ListarFilmePanel fdFilmePanel) {
			this.fdFilmePanel = fdFilmePanel;
			putValue(NAME, "Listar por Diretor");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			fdFilmePanel.setOrdem(0);
			card.show(frame.getContentPane(), "name_Listar");
		}
	}

	private class SwingAction_6 extends AbstractAction {
		private ListarFilmePanel fdFilmePanel;

		public SwingAction_6(ListarFilmePanel fdFilmePanel) {
			this.fdFilmePanel = fdFilmePanel;
			putValue(NAME, "Listar por Gênero");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			fdFilmePanel.setOrdem(1);
			card.show(frame.getContentPane(), "name_Listar");
		}
	}

	private class SwingAction_7 extends AbstractAction {
		private ListarFilmePanel fdFilmePanel;

		public SwingAction_7(ListarFilmePanel fdFilmePanel) {
			this.fdFilmePanel = fdFilmePanel;
			putValue(NAME, "Listar por Nome");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			fdFilmePanel.setOrdem(2);
			card.show(frame.getContentPane(), "name_Listar");
		}
	}

	private class SwingAction_8 extends AbstractAction {
		private ListarFilmePanel fdFilmePanel;

		public SwingAction_8(ListarFilmePanel fdFilmePanel) {
			this.fdFilmePanel = fdFilmePanel;
			putValue(NAME, "Listar por Qualidade");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			fdFilmePanel.setOrdem(3);
			card.show(frame.getContentPane(), "name_Listar");
		}
	}

	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "Manual do usuário");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			try {
				java.awt.Desktop.getDesktop().browse( new java.net.URI( "https://github.com/Dyeniffer/Projeto-Filmes/wiki/Manual-do-Sistema" ) );
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}

	private class SwingAction_10 extends AbstractAction {
		public SwingAction_10() {
			putValue(NAME, "Sobre");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "");
			card.show(frame.getContentPane(), "name_Sobre");
		}
	}
}