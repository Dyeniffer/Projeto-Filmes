package gui;

import gui.Action.CadastrarFilmeAction;
import gui.Action.CancelarFilmeAction;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import dao.FilmeDao;
import pojo.Filme;

public class CadastrarFilmePanel extends JPanel {
	private JTextField textNome;
	private JTextField textDiretor;
	private JTextField textGenero;
	private JTextField textField;
	
	private CardLayout card;

	public CardLayout getCard() {
		return card;
	}
	
	public Filme getFilme(){
		return new Filme(textNome.getText(), textDiretor.getText(), textGenero.getText());
	}

	public CadastrarFilmePanel() {
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
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, "2, 2");
		
		JLabel lblCadastroDeFilme = new JLabel("Cadastro de filmes");
		lblCadastroDeFilme.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeFilme.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		add(lblCadastroDeFilme, "5, 4, 28, 1");
		
		JLabel lblNomeDoFilme = new JLabel("Nome do Filme:");
		lblNomeDoFilme.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		add(lblNomeDoFilme, "6, 8");
		
		textNome = new JTextField();
		add(textNome, "10, 8, 25, 1, fill, default");
		textNome.setColumns(10);
		
		JLabel lblAutor = new JLabel("Diretor:");
		lblAutor.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		add(lblAutor, "6, 10");
		
		textDiretor = new JTextField();
		add(textDiretor, "10, 10, 25, 1, fill, default");
		textDiretor.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		add(lblGnero, "6, 12");
		
		textGenero = new JTextField();
		add(textGenero, "10, 12, 25, 1, fill, default");
		textGenero.setColumns(10);
		
		JLabel lblQualidade = new JLabel("Qualidade:");
		lblQualidade.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		add(lblQualidade, "6, 14");
		
		textField = new JTextField();
		add(textField, "10, 14, 25, 1, fill, default");
		textField.setColumns(10);
		
		JButton btnCancelar = new JButton(new CancelarFilmeAction(this));
		btnCancelar.setToolTipText("Cancelar cadastro de filme");
		btnCancelar.setMnemonic(KeyEvent.VK_ESCAPE);
		btnCancelar.setFont(new Font("Segoe UI Light", Font.PLAIN, 10));
		add(btnCancelar, "6, 16, 5, 1");
		
		JButton btnCadastrar = new JButton(new CadastrarFilmeAction(this));
		btnCadastrar.setToolTipText("Cadastrar filme");
		btnCadastrar.setMnemonic(KeyEvent.VK_ENTER);
		btnCadastrar.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		add(btnCadastrar, "15, 16, 13, 1");
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, "2, 24");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1, "46, 24");

	}
}
