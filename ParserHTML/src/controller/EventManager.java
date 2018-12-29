package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.HTMLManager;
import model.XMLManager;
import view.LaunchView;

public class EventManager {
	
	private XMLManager modelXML;
	private HTMLManager modelHTML;
	private LaunchView view;
	private ActionListener actionListener_parseXML, actionListener_parseHTML;
	
	// Constructor
	public EventManager (XMLManager model1, HTMLManager model2, LaunchView view) {
		this.modelXML = model1;
		this.modelHTML = model2;
		this.view = view;
	}
	
	// Método contenedor de los listeners
	public void control(){
		
		// Implementación del listener botón parseXML. Llama al método call_ParseXML()
		actionListener_parseXML = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Ejecutamos call_ParseLibrary()
				try {
					call_ParseXML();
				} catch (IOException e) {
					// Mostramos el error a través del método showError de la clase LaunchView
					view.showError("Fallo al parsear el fichero");
				}

			}
		};
		// Añadimos el listener al botón.
		view.getParser().addActionListener(actionListener_parseXML);
		
		// Implementación del botón parseHTML. Llama al método call_parseHTML()
		actionListener_parseHTML = new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				// Ejecutamos call_ParseHTML()
				try {
					call_ParseHTML();
				} catch (IOException e) {
					// Mostramos el error a través del método showError de la clase LaunchView
					view.showError("Fallo al parsear la url");
				}
			}
		};
		// Añadimos el listener al botón
		view.getParserHTML().addActionListener(actionListener_parseHTML);
	}
	
	// Método que llama a la función de la clase XMLManager para parsear el XML
	private void call_ParseXML() throws FileNotFoundException, IOException {
		
		// Si no se ha introducido un fichero mostramos el error. Si el método arroja alguno de las exceciones se mostrará la excecpción 
		if (view.getFichero().getText().equals("")){
			view.showError("Error. Debe introducir el nombre de un archivo xml");
		} else if (modelXML.parseXML(view.getFichero().getText()) == 1){
			view.showError("Error: ParserConfigurationException");
		} else if (modelXML.parseXML(view.getFichero().getText()) == 2){
			view.showError("Error: SAXException");
		} else if (modelXML.parseXML(view.getFichero().getText()) == 3){
			view.showError("Error: No se encuentra el archivo. FileNotFoundException");
		} else if (modelXML.parseXML(view.getFichero().getText()) == 4){
			view.showError("Error: IOException");
		}  else {
			// Si no hay errores se ejecutará el código
			modelXML.parseXML(view.getFichero().getText());
			modelXML.parseDocument();
			view.writeTextArea(modelXML.print());
		}
	}
	
	// Método que llama a la funcion de la clase HTMLmanager para parsear la url introducida
	private void call_ParseHTML() throws IOException {
		// Si no se ha introducido un fichero mostramos el error. Si el método arroja alguno de las exceciones se mostrará la excecpción 
		if (view.getUrlToParse().getText().equals("")){
			view.showError("Error. Debe introducir el nombre de un archivo xml");
		} else if (modelHTML.parseHTML(view.getUrlToParse().getText()) == 1){
			view.showError("Error: MalformedURLException");
		} else if (modelHTML.parseHTML(view.getUrlToParse().getText()) == 2){
			view.showError("Error: IOException");
		} else {
			// Si no hay errores se ejecutará el código
			modelHTML.parseHTML(view.getUrlToParse().getText());
			modelHTML.parseDocument();
			view.writeTextArea(modelHTML.print());
		}
	}

}
