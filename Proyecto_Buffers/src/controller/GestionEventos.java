package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import model.Libro;

import javax.swing.JTextField;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_copiar, actionListener_guardarLibro, actionListener_limpiar,
		actionListener_recuperarLibro, actionListener_recuperarTodos;

	// Constructor
	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}
	
	// M�todo para manejar los eventos
	public void contol() {
		// Implementaci�n del Listener del bot�n comparar
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_compararContenido
				// Ejecutamos call_compararContenido envuelto en try... catch...
				try {
					call_compararContenido();
				} catch (IOException e) {
					// Mostramos el error a trav�s del m�todo showError de la clase LaunchView
					view.showError("Fallo al comparar contenido de los ficheros");
				}

			}
		};
		// A�adimos el Listener al bot�n comparar
		view.getComparar().addActionListener(actionListener_comparar);
		
		//Implementaci�n del listener del bot�n buscar
		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_buscarPalabra
				// Ejecutamos call_buscarPalabra envuelto en try... catch...
				try {
					call_buscarPalabra();
				} catch (IllegalArgumentException e) {
					// Mostramos el error a trav�s del m�todo showError de la clase LaunchView
					view.showError("Fallo al buscar la palabra en el fichero");
				}
			}
		};
		// A�adimos el listener al bot�n buscar
		view.getBuscar().addActionListener(actionListener_buscar);
		
		//Implementaci�n del listener del bot�n copiar
		actionListener_copiar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_buscarPalabra
				// Ejecutamos call_buscarPalabra envuelto en try... catch...
				try {
					call_copiarFichero();
				} catch (IllegalArgumentException e) {
					// Mostramos el error a trav�s del m�todo showError de la clase LaunchView
					view.showError("Fallo al intentar copiar el fichero");
				}
			}
		};
		// A�adimos el listener al bot�n buscar
		view.getCopiar().addActionListener(actionListener_copiar);
		
		// Implementamos el Listener del bot�n GUARDAR LIBRO
		actionListener_guardarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_guardar_libro
				// Ejecutamos call_buscarPalabra envuelto en try... catch...
				try {
					call_guardar_libro();
				} catch (IllegalArgumentException e) {
					view.showError("Fallo al intentar guardar el libro");
				}
			}
		};
		
		// A�adimos el Listener del bot�n GUARDAR LIBRO
		view.getGuardarLibro().addActionListener(actionListener_guardarLibro);	
		
		
		// Implementamos el Listener del bot�n RECUPERAR LIBRO
		actionListener_recuperarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_guardar_libro
				// Ejecutamos call_buscarPalabra envuelto en try... catch...
				try {
					call_recuperar_libro();
				} catch (IllegalArgumentException e) {
					view.showError("Fallo al intentar recuperar el libro");
				}
			}
		};		
		// A�adimos el Listener del bot�n RECUPERAR LIBRO
		view.getRecuperarLibro().addActionListener(actionListener_recuperarLibro);	
		
		
		// Implementamos el Listenter del bot�n RECUPERAR TODOS
		actionListener_recuperarTodos = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_guardar_libro
				// Ejecutamos call_buscarPalabra envuelto en try... catch...
				try {
					call_recuperar_todos();
				} catch (IllegalArgumentException e) {
					view.showError("Fallo al intentar recuperar todos los libros");
				}
			}
		};		
		// A�adimos el Listener del bot�n RECUPERAR TODOS
		view.getRecuperarTodos().addActionListener(actionListener_recuperarTodos);	
		
		// Implementamos el Listenter del bot�n LIMPIAR
		actionListener_limpiar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Ejecutamos limpiar()
				limpiar();
			}
		};		
		// A�adimos el Listener del bot�n LIMPIAR
		view.getLimpiar().addActionListener(actionListener_limpiar);	
	} // Fin del m�todo contol

	
	// M�todo que llama a compararContenido de GestionDatos
	private int call_compararContenido() throws FileNotFoundException {
		
		System.out.println("se pasan a model.compararContenido los ficheros: " + view.getFichero1().getText() + " y " 
				+ view.getFichero2().getText());

		// Si la llamada al m�todo compararContenido del modelo devuelve true, mostramos la igualdad de los ficheros en el TextArea
		try {
			if(model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText())==true){
				view.writeTextArea(view.getFichero1().getText()+" es igual que " + view.getFichero2().getText());
				return 1;
			} else {
				// En cualquier otro caso, mostramos la desigualdad de los ficheros
				view.writeTextArea(view.getFichero1().getText()+" es diferente de " + view.getFichero2().getText());
				return 0;
			}
		}catch (FileNotFoundException e){
			view.showError("Error! no se encontraron los ficheros, revise ficheros introducidos");
			return 2;
		}catch (IOException e){
			view.showError("Error al llamar al m�todo compararContenido");
			return 2;
		}
	} // Fin del m�todo call_compararContenido()

	
	// M�todo que llama a buscarPalabra de GestionDatos
	private int call_buscarPalabra() {
		// TODO: Llamar a la funci�n buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		System.out.println("se pasan a model.buscarPalabra el fichero: " + view.getFichero1().getText() + ", la palabra: " 
				+ view.getPalabra().getText() + " y primera aparici�n = " +  view.getPrimera().isSelected());
		
		/* Si la llamada al m�todo buscarPalabra del modelo devuelve un entero positivo, mostramos la coincidencia en el TextArea y
		 * el n�mero de l�nea en el que se ha producido (para primera aparici�n o �ltima aparici�n, seg�n se haya marcado)*/ 
		try {
			int i = model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected());
			if(view.getPrimera().isSelected() == true && i > 0){
				view.writeTextArea("La palabra: \"" + view.getPalabra().getText() + "\" aparece por primera vez en el fichero: " 
						+ view.getFichero1().getText() + " en la l�nea: " + i);
				return 1;
			} else if (view.getPrimera().isSelected() == false && i > 0){
				view.writeTextArea("La palabra: \"" + view.getPalabra().getText() + "\" aparece por �ltima vez en el fichero: " 
						+ view.getFichero1().getText() + " en la l�nea: " + i);
				return 2;				
			} else {
				// En cualquier otro caso, informamos que la palabra no est� en el fichero
				view.writeTextArea("La palabra: \"" + view.getPalabra().getText() + "\" NO aparece en el fichero: " 
						+ view.getFichero1().getText());
				return 0;
			}
		}catch (FileNotFoundException e){
			view.showError("Error! no se encontro el fichero1");
			return 2;
		}catch (IOException e){
			view.showError("Error al ejecutar m�todo buscarPalabra");
			return 3;
		}
	} // Fin del m�todo call_buscarPalabra
	
	// Implementaci�n del m�todo call_copiarFichero()
	private int call_copiarFichero() {
		// TODO: Llamar a la funci�n copiarFichero de GestionDatos
		// TODO: Gestionar excepciones
		System.out.println("se pasa a model.copiarFichero el fichero: " + view.getOrigen().getText());
		
		try {
			view.writeTextArea("Se ha copiado un total de: " + model.copiarFichero(view.getOrigen().getText(), view.getDestino().getText()) + " bytes");
				return 1;

		}catch (FileNotFoundException e){
			view.showError("Error! no se encontro el fichero Origen");
			return 2;
		}catch (IOException e){
			view.showError("Error al ejecutar m�todo copiarFichero");
			return 3;
		}
	} // Fin del m�todo call_copiarFichero
	
	// Implementaci�n del m�todo call_guardarLibro()
	public void call_guardar_libro() {
		// Controlamos que el a�o de publicaci�n y el n�mero de p�ginas son int
		if (!isNumeric(view.getAnyo_publicacion().getText())){
			view.showError("El a�o de publicaci�n debe ser un n�mero natural");
		}else if (!isNumeric(view.getNum_paginas().getText())){
			view.showError("El n�mero de p�ginas debe ser un n�mero natural");
		}else{
			// Creamos un objeto libro con los valores recibidos 
			Libro libro = new Libro(view.getIdentificador().getText(), view.getTitulo().getText(), view.getAutor().getText(),
					Integer.parseInt(view.getAnyo_publicacion().getText()), view.getEditor().getText(), 
					Integer.parseInt(view.getNum_paginas().getText()));
			// Pasamos el objeto libro creado al m�todo guardar_libro
			try {
				if (model.guardar_libro(libro) == 1) {
					view.writeTextArea("Se ha guardado el libro con el identificador: " + view.getIdentificador().getText());
				} else {
					view.showError("Error. No se pudo guardar el libro");
				}
			} catch (IOException e) {
				e.printStackTrace();
				view.showError("Error IO. No se pudo guardar el libro");
			}
		}
	}
	// Implementaci�n del m�todo call_recueprarLibro()
	public void call_recuperar_libro() {
		if ((view.getIdentificador().getText()).equals("")){
			view.showError("Error. Debe introducir un identificador v�lido");
		}else if (model.recuperar_libro(view.getIdentificador().getText()) == null){
			view.showError("Error al recuperar libro. No existe el identificador");
		} else {
			view.writeTextArea(model.recuperar_libro(view.getIdentificador().getText()).printLibro());
		}
		
	}
	
	// Implementaci�n del m�todo call_recuperarTodos()
	public void call_recuperar_todos() {
		ArrayList<Libro> libros = new ArrayList();
		libros=model.recuperar_todos();
		
		if (libros == null){
			view.showError("Error al recuperar la lista de libros");
		} else {
			Iterator it = libros.iterator();
			while (it.hasNext()){
			view.writeTextArea(((Libro)it.next()).printLibro());
			}
		}
	}
	
	public void limpiar(){
		view.getTextArea().setText("");
		view.getFichero1().setText("");
		view.getFichero2().setText("");
		view.getPalabra().setText("");
		view.getOrigen().setText("");
		view.getDestino().setText("");
		view.getIdentificador().setText("");
		view.getTitulo().setText("");
		view.getAutor().setText("");
		view.getAnyo_publicacion().setText("");
		view.getEditor().setText("");
		view.getNum_paginas().setText("");
		view.getPrimera().setSelected(false);
	}
	
	//comprobar si una cadena de texto es un n�mero
	public boolean isNumeric (String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		}catch (NumberFormatException nfe) {
			return false;
		}
	}
} //Fin de GestionEventos
