package view;

import java.awt.Dimension;

import javax.swing.*;

public class LaunchView extends JFrame {

	private JButton comparar,buscar, copiar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra, origen, destino;
	private JLabel label_f1,label_f2,label_pal, label_or, label_des;
	private JCheckBox primera;
	
	private JPanel panel;
	
	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
		// Añadimos el botón copiar
		copiar = new JButton("Copiar fichero");
		copiar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		// Añadimos los JTextField para el fichero de origen y el de destino
		origen = new JTextField("",10);
		destino = new JTextField("",10);		
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		// Añadimos las etiquetas que acompañan a los JTextField
		label_or = new JLabel("Origen");
		label_des = new JLabel("Destino");
		
		
		primera = new JCheckBox("Primera aparición");
		primera.setSelected(false);

		textArea = new JTextArea(20, 80);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		panel.add(copiar);
		panel.add(label_or);
		panel.add(origen);
		panel.add(label_des);
		panel.add(destino);
		panel.add(textArea);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
		
	}	
	
	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
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
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	
	public JTextField getPalabra() {
		return palabra;
	}
	
	public void setPalabra (JTextField palabra) {
		this.palabra = palabra;
	}
	
	public JCheckBox getPrimera() {
		return primera;
	}
	
	public void setPrimera (JCheckBox primera) {
		this.primera = primera;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	// Getters y Setters de los nuevos elementos del ProyectoBuffers 1e
	public JButton getCopiar() {
		return copiar;
	}

	public void setCopiar(JButton copiar) {
		this.copiar = copiar;
	}

	public JTextField getOrigen() {
		return origen;
	}

	public void setOrigen(JTextField origen) {
		this.origen = origen;
	}

	public JTextField getDestino() {
		return destino;
	}

	public void setDestino(JTextField destino) {
		this.destino = destino;
	}


}
