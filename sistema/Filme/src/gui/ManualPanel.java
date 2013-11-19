package gui;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;

public class ManualPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManualPanel() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JTabbedPane abaPane = new JTabbedPane(JTabbedPane.TOP);
		abaPane.setForeground(Color.BLACK);
		abaPane.setBackground(Color.WHITE);
		abaPane.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		add(abaPane, BorderLayout.NORTH);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		JLabel texto1 = new JLabel("Cadastrar Novo Filme");
		panel1.add(texto1);
		abaPane.addTab("Cadastrar Novo Filme", null, panel1, "Does nothing");
			
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		JLabel texto2 = new JLabel("Remover Filme");
		panel2.add(texto2);
		abaPane.addTab("Remover Filme", null, panel2, "Does nothing");
			
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		JLabel texto3 = new JLabel("Listar Filmes");
		panel3.add(texto3);
		abaPane.addTab("Listar Filmes", null, panel3, "Does nothing");
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.WHITE);
		JLabel texto4 = new JLabel("Criar cópia de segurança do Banco de Dados");
		panel4.add(texto4);
		abaPane.addTab("Criar cópia de segurança do Banco de Dados", null, panel4, "Does nothing");
		
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.WHITE);
		JLabel texto5 = new JLabel("Restaurar cópia de segurança do Banco de Dados");
		panel5.add(texto5);
		abaPane.addTab("Restaurar cópia de segurança do Banco de Dados", null, panel5, "Does nothing");


		

		// Add the tabbed pane to this panel.
		add(abaPane);

		abaPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

	}
}
