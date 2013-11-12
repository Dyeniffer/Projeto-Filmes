package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.FilmeDao;

import pojo.Filme;

public class RemoverFilmesTableModel extends AbstractTableModel {

	private List<Filme> lista;
	FilmeDao dao = new FilmeDao();

	public RemoverFilmesTableModel() throws Exception {
		try {
			lista = dao.RemoverFilmes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getColumnCount() {

		return 1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {

			return lista.get(lin).getNome();
		
	}
}