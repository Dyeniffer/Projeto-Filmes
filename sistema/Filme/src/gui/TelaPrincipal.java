package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import gui.*;

public class TelaPrincipal {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private CardLayout card;
	private CadastrarFilmePanel cdFilmePanel = new CadastrarFilmePanel();
	private ListarFilmePanel fdFilmePanel = new ListarFilmePanel();


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
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		card = new CardLayout(0, 0);
		frame.getContentPane().setLayout(card);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_6126640247321");

		panel.add(cdFilmePanel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, "name_6128366176959");

		panel_1.add(fdFilmePanel);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Filmes");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mntmNewMenuItem_1.setAction(action);
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setAction(action_1);
		mnNewMenu.add(mntmNewMenuItem);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cadastrar novo filme");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			card.show(frame.getContentPane(), "name_6126640247321");
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Listar Filmes");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			card.show(frame.getContentPane(), "name_6128366176959");
		}
	}
}