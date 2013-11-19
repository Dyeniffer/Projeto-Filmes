package gui;

import gui.Action.SalvarBKPAction;

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

public class CriarBKPBDPanel extends JPanel {
	private String caminho;
	byte[] buffer = new byte[1024];
	
	/**
	 * Create the panel.
	 */
	public CriarBKPBDPanel() {
		setBackground(Color.WHITE);
		
		JButton btnCriarCpiaDe = new JButton(new SalvarBKPAction(this));
		btnCriarCpiaDe.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(125)
					.addComponent(btnCriarCpiaDe)
					.addContainerGap(158, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addComponent(btnCriarCpiaDe)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		

	
		

	}
}
