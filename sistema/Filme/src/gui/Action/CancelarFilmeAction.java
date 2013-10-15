package gui.Action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import gui.CadastrarFilmePanel;

public class CancelarFilmeAction extends AbstractAction {


	private static final long serialVersionUID = 1L;


	private CadastrarFilmePanel panel;

	public CancelarFilmeAction(CadastrarFilmePanel panel) {
		super("Cancelar");
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}