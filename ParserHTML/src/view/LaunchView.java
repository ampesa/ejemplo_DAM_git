package view;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LaunchView extends JFrame {
	// Ojbetos gráficos
	private JButton parserXML, parserHTML;
	private JTextArea textArea;
	private JTextField fichero, urlToParse;
	private JLabel label_fichero, label_url;
	
	private JPanel panel;
	
	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("XML/HTML Parser");	
		panel = new JPanel();
		
		// Botones
		parserXML = new JButton("Parse XML");
		parserXML.setPreferredSize(new Dimension(150, 26));
		parserHTML = new JButton("Parse HTML");
		parserHTML.setPreferredSize(new Dimension(150, 26));
		
		// JTextField
		fichero = new JTextField("",10);
		urlToParse = new JTextField("",25);
		
		// JLabel
		label_fichero = new JLabel("Fichero XML:");
		label_url = new JLabel("Dirección URL");

		// JTextArea
		textArea = new JTextArea(20, 80);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		// Añadimos los elementos gráficos
		panel.add(parserXML);
		panel.add(label_fichero);
		panel.add(fichero);
		panel.add(parserHTML);
		panel.add(label_url);
		panel.add(urlToParse);

		panel.add(textArea);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
		
	}	
	
	// Generamos los getters y setters necesarios
	
	public JButton getParser() {
		return parserXML;
	}

	public void setParser(JButton comparar) {
		this.parserXML = comparar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	public void writeTextArea(String text) {
		textArea.setText(textArea.getText() + "\n" + text); // esto añadirá lineas a modo de log
	}
			
	public JTextField getFichero() {
		return fichero;
	}

	public void setFichero(JTextField fichero) {
		this.fichero = fichero;
	}
	
		public JButton getParserHTML() {
		return parserHTML;
	}

	public void setParserHTML(JButton parserHTML) {
		this.parserHTML = parserHTML;
	}

	public JTextField getUrlToParse() {
		return urlToParse;
	}

	public void setUrlToParse(JTextField urlToParse) {
		this.urlToParse = urlToParse;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}

	
}
