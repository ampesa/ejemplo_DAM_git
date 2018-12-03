package model;

import java.io.Serializable;

public class Book implements Serializable {

	private String titulo = null;
	private String autor = null;
	private int anyo = 0;
	private String editor = null;
	private int paginas = 0;
	
	// Constructores
	public Book(){
		
	}
	
	public Book (String t, int y, String a,  String e, int p){
		titulo = t;
		anyo = y;
		autor = a;
		editor = e;
		paginas = p;
	}
	
	// Getters y Setters
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
		return paginas;
	}

	public void setNum_paginas(int num_paginas) {
		this.paginas = num_paginas;
	}
	
	// Método para mostrar los datos del objeto libro
	public String printBook() {
		StringBuilder str = new StringBuilder("\n");

		str.append("TÍTULO: "+titulo + " - ");
		str.append("AUTOR: " + autor + " - ");
		str.append("AÑO: " + anyo + " - ");
		str.append("EDITOR: " + editor + " - ");
		str.append("PÁGINAS: " + paginas);
		
		return str.toString();
	}
	
}
