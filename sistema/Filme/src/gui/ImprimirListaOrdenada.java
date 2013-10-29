package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;

public class ImprimirListaOrdenada extends JPanel {
	JTextArea txtrTeste = new JTextArea();
	
	public ImprimirListaOrdenada() {
		setBackground(Color.WHITE);
		
		
		txtrTeste.setEditable(false);
		txtrTeste.setLineWrap(true);
		txtrTeste.setWrapStyleWord(true);
		txtrTeste.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(txtrTeste);
	}
	
	public void addTexto(String texto){
		txtrTeste.setText(texto);
	}

}
