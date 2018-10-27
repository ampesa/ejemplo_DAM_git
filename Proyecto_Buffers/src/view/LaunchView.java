package view;

import java.awt.Dimension;

import javax.swing.*;

public class LaunchView extends JFrame {

	private JButton comparar,buscar, copiar, guardarLibro, recuperarLibro, recuperarTodos, limpiar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra, origen, destino, identificador, titulo, autor, anyo_publicacion, editor, num_paginas;
	private JLabel label_f1,label_f2,label_pal, label_or, label_des, label_ident, label_titulo, label_autor, label_anyo, label_editor, label_numpag;
	private JCheckBox primera;
	
	private JPanel panel;
	
	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		// Botones
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
		// Añadimos el botón copiar
		copiar = new JButton("Copiar fichero");
		copiar.setPreferredSize(new Dimension(150, 26));
		// Añadimos los botones para gestionar Libros
		guardarLibro = new JButton("Guardar Libro");
		guardarLibro.setPreferredSize(new Dimension(150, 26));
		recuperarLibro = new JButton("Recuperar Libro");
		recuperarLibro.setPreferredSize(new Dimension(150, 26));
		recuperarTodos = new JButton("Recuperar Todos");
		recuperarTodos.setPreferredSize(new Dimension(150, 26));
		limpiar = new JButton ("Limpiar");
		limpiar.setPreferredSize(new Dimension (150,26));
		
		
		// JTextField
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		// Añadimos los JTextField para el fichero de origen y el de destino
		origen = new JTextField("",10);
		destino = new JTextField("",10);
		// Añadimos los JTextField identificador, titulo, autor, anyo_publicacion, editor y num_paginas
		identificador = new JTextField("",10);
		titulo = new JTextField("",17);
		autor = new JTextField("",10);
		anyo_publicacion = new JTextField("",10);
		editor = new JTextField("",10);
		num_paginas = new JTextField("",10);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		// Añadimos las etiquetas que acompañan a los JTextField
		label_or = new JLabel("Origen");
		label_des = new JLabel("Destino");
		// Añadimos las etiquetas que acompañana a las funcionalidades Libro
		label_ident = new JLabel("Identificador");
		label_titulo = new JLabel("Título");
		label_autor = new JLabel("Autor");
		label_anyo = new JLabel("Año Publicación");
		label_editor = new JLabel("Editor");
		label_numpag = new JLabel("Número Paginas");
		
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
		/* Añadimos los objetos del proyecto copiar fichero al panel
		panel.add(copiar);
		panel.add(label_or);
		panel.add(origen);
		panel.add(label_des);
		panel.add(destino);*/
		// Añadimos los objtetos del proyecto gestion libros al panel
		panel.add(guardarLibro);
		panel.add(label_ident);
		panel.add(identificador);
		panel.add(label_titulo);
		panel.add(titulo);
		panel.add(label_autor);
		panel.add(autor);
		panel.add(label_anyo);
		panel.add(anyo_publicacion);
		panel.add(label_editor);
		panel.add(editor);
		panel.add(label_numpag);
		panel.add(num_paginas);
		panel.add(recuperarLibro);
		panel.add(recuperarTodos);
		panel.add(limpiar);

		panel.add(textArea);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
		
	}	
	
	// Generamos los getters y setters necesarios
	
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
	
	// Getters y Setters del proyecto Gestor de Libros

	public JButton getGuardarLibro() {
		return guardarLibro;
	}

	public void setGuardarLibro(JButton guardarLibro) {
		this.guardarLibro = guardarLibro;
	}

	public JButton getRecuperarLibro() {
		return recuperarLibro;
	}

	public void setRecuperarLibro(JButton recuperarLibro) {
		this.recuperarLibro = recuperarLibro;
	}

	public JButton getRecuperarTodos() {
		return recuperarTodos;
	}

	public void setRecuperarTodos(JButton recuperarTodos) {
		this.recuperarTodos = recuperarTodos;
	}

	public JTextField getIdentificador() {
		return identificador;
	}

	public void setIdentificador(JTextField identificador) {
		this.identificador = identificador;
	}

	public JTextField getTitulo() {
		return titulo;
	}

	public void setTitulo(JTextField titulo) {
		this.titulo = titulo;
	}

	public JTextField getAutor() {
		return autor;
	}

	public void setAutor(JTextField autor) {
		this.autor = autor;
	}

	public JTextField getAnyo_publicacion() {
		return anyo_publicacion;
	}

	public void setAnyo_publicacion(JTextField anyo_publicacion) {
		this.anyo_publicacion = anyo_publicacion;
	}

	public JTextField getEditor() {
		return editor;
	}

	public void setEditor(JTextField editor) {
		this.editor = editor;
	}

	public JTextField getNum_paginas() {
		return num_paginas;
	}

	public void setNum_paginas(JTextField num_paginas) {
		this.num_paginas = num_paginas;
	}

	public JButton getLimpiar() {
		return limpiar;
	}

	public void setLimpiar(JButton limpiar) {
		this.limpiar = limpiar;
	}
	
	

}
