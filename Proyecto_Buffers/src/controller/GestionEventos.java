package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar;

	// Constructor
	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}
	
	// Método para manejar los eventos
	public void contol() {
		// Implementación del Listener del botón comparar
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				// Ejecutamos call_compararContenido envuelto en try... catch...
				try {
					call_compararContenido();
				} catch (IOException e) {
					// Mostramos el error a través del método showError de la clase LaunchView
					view.showError("Fallo al comparar contenido de los ficheros");;
				}

			}
		};
		// Añadimos el Listener al botón comparar
		view.getComparar().addActionListener(actionListener_comparar);
		
		//Implementación del listener del botón buscar
		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				// Ejecutamos call_buscarPalabra envuelto en try... catch...
				try {
					call_buscarPalabra();
				} catch (IllegalArgumentException e) {
					// Mostramos el error a través del método showError de la clase LaunchView
					view.showError("Fallo al buscar la palabra en el fichero");;
				}
			}
		};
		// Añadimos el listener al botón buscar
		view.getBuscar().addActionListener(actionListener_buscar);
	}

	// Método que llama a compararContenido de GestionDatos
	private int call_compararContenido() throws IOException {
		
		System.out.println("se pasan a model.compararContenido los ficheros: " + view.getFichero1().getText() + " y " 
				+ view.getFichero2().getText());

		// Si la llamada al método compararContenido del modelo devuelve true, mostramos la igualdad de los ficheros en el TextArea
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
			view.showError("Error al llamar al método compararContenido");
			return 2;
		}
		
	}

	// Método que llama a buscarPalabra de GestionDatos
	private int call_buscarPalabra() {
		// TODO: Llamar a la función buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		System.out.println("se pasan a model.buscarPalabra el fichero: " + view.getFichero1().getText() + ", la palabra: " 
				+ view.getPalabra().getText() + " y primera aparición = " +  view.getPrimera().isSelected());
		
		/* Si la llamada al método buscarPalabra del modelo devuelve un entero positivo, mostramos la coincidencia en el TextArea y
		 * el número de línea en el que se ha producido (para primera aparición o última aparición, según se haya marcado)*/ 
		try {
			int i = model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected());
			if(view.getPrimera().isSelected() == true && i > 0){
				view.writeTextArea("La palabra: \"" + view.getPalabra().getText() + "\" aparece por primera vez en el fichero: " 
						+ view.getFichero1().getText() + " en la línea: " + i);
				return 1;
			} else if (view.getPrimera().isSelected() == false && i > 0){
				view.writeTextArea("La palabra: \"" + view.getPalabra().getText() + "\" aparece por última vez en el fichero: " 
						+ view.getFichero1().getText() + " en la línea: " + i);
				return 2;				
			} else {
				// En cualquier otro caso, informamos que la palabra no está en el fichero
				view.writeTextArea("La palabra: \"" + view.getPalabra().getText() + "\" NO aparece en el fichero: " 
						+ view.getFichero1().getText());
				return 0;
			}
		}catch (FileNotFoundException e){
			view.showError("Error! no se encontro el fichero1");
			return 2;
		}catch (IOException e){
			view.showError("Error al ejecutar método buscarPalabra");
			return 3;
		}
	}

}
