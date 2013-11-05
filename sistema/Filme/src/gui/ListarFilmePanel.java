package gui;


import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import dao.FilmeDao;

import java.awt.Component;
import javax.swing.Box;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JTextArea;

import pojo.Filme;
import java.awt.Font;

public class ListarFilmePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int ordem = 0;
	
	List<Filme> lista = new ArrayList<Filme>();
	private JTextArea textArea;

	public void setOrdem(int x){
		this.ordem = x;
		textArea.setText("");
		textArea.setText(alimentaString());
	}
	
	public void alimentaLista(){
		FilmeDao dao = new FilmeDao();
		this.lista = dao.listarFilmes(ordem);
	}
	
	public String alimentaString() {
		String retorno = "";

		alimentaLista();

		for (int i = 0; i < this.lista.size(); i++) {
			retorno += this.lista.get(i).toString() + "\n\n";
		}

		return retorno;
	}

	public ListarFilmePanel() {
		setBackground(Color.WHITE);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
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

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1, "36, 2");
		
		Dimension dimension = new Dimension(400, 400);
		
		textArea = new JTextArea(alimentaString());
		textArea.setEditable(false);
		textArea.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		textArea.setBackground(Color.WHITE);
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setPreferredSize(dimension);		
		
		add(scroll, "4, 4, 31, 19, fill, fill");
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, "2, 24");

		
	}
}
