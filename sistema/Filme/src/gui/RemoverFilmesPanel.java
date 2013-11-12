package gui;

import gui.Action.RemoverFilmeAction;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.Action;

import pojo.Filme;

import dao.FilmeDao;

public class RemoverFilmesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable table;
	private CardLayout card;
	//private final Action action = new SwingAction();

	public CardLayout getCard() {
		return card;
	}
	
	public void alimentaTabela(){
		try {
			setTable(new JTable(new RemoverFilmesTableModel()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RemoverFilmesPanel() {
		setBackground(Color.WHITE);

		setLayout(new BorderLayout());
		alimentaTabela();
//		try {
//			setTable(new JTable(new RemoverFilmesTableModel()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		add(table, BorderLayout.CENTER);

		JButton btnRemover = new JButton(new RemoverFilmeAction(this));
		btnRemover.setToolTipText("Remover filme");
		btnRemover.setMnemonic(KeyEvent.VK_ENTER);
		btnRemover.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		add(btnRemover,  BorderLayout.SOUTH);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
