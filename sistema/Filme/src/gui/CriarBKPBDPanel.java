package gui;

import gui.Action.SalvarBKPAction;
import gui.Action.SelecionarLocalBKPAction;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CriarBKPBDPanel extends JPanel {
	private String caminho;
	byte[] buffer = new byte[1024];
	
	/**
	 * Create the panel.
	 */
	public CriarBKPBDPanel() {
		setBackground(Color.WHITE);
		SelecionarLocalBKPAction sl = new SelecionarLocalBKPAction(this);
		
		JButton btnCriarCpiaDe = new JButton(sl);
		btnCriarCpiaDe.setText("Escolher local do Banco de Dados");
		btnCriarCpiaDe.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton(new SalvarBKPAction(this, sl));
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(125)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCriarCpiaDe, Alignment.LEADING))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addComponent(btnCriarCpiaDe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		

	
		

	}
}
