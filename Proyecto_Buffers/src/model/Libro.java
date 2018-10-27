package model;

import java.io.Serializable;

// Clase para generar los ojetos Libro
public class Libro implements Serializable{

	private String identificador = null;
	private String titulo = null;
	private String autor = null;
	private int anyo = 0;
	private String editor = null;
	private int num_paginas = 0;
	
	// Constructores
	public Libro(){
		
	}
	
	public Libro (String i, String t, String a, int y, String e, int p){
		identificador = i;
		titulo = t;
		autor = a;
		anyo = y;
		editor = e;
		num_paginas = p;
	}
	
	// Getters y Setters
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getNum_paginas() {
		return num_paginas;
	}

	public void setNum_paginas(int num_paginas) {
		this.num_paginas = num_paginas;
	}
	
	// Método para mostrar los datos del objeto libro
	public String printLibro() {
		StringBuilder str = new StringBuilder(identificador + "   ");

		str.append("TÍTULO: "+titulo + "   ");
		str.append("AUTOR: " + autor + "   ");
		str.append("AÑO: " + anyo + "   ");
		str.append("EDITOR: " + editor + "   ");
		str.append("PÁGINAS" + num_paginas + "   ");
		
		return str.toString();
	}
	
}
