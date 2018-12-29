package model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLManager {
	
	// Objetos de la clase
	private Document htmlFile = null;
	private ArrayList<Product> weekProducts = null;

	// Constructor
	public HTMLManager (){
		weekProducts = new ArrayList<Product>();
	}
	
	public int parseHTML (String urlToParse){

		try {
			URL url = new URL(urlToParse);
			//htmlFile = Jsoup.parse(input, "UTF-8", urlToParse);

			htmlFile = Jsoup.parse(url, 10000);

		} catch (MalformedURLException mue) {
			mue.printStackTrace();
			System.out.println("error, url mal formada");
			return 1;
		} catch (IOException e){
			e.printStackTrace();
			System.out.println("error, IOException");
			return 2;
		}
	
	return 3;
		
	}
	
	// Método para parserar un Document y almacenar los elementos en un ArrayList
	public void parseDocument(){
		// Obtenemos el elemento contenedor de los destacados de la semana
		Element destacado = htmlFile.getElementById("featured-layer");
		// Pasamos a productos los elementos que contienen el atributo "class" y que coinciden con "GTM-productClick enlace-disimulado"
		// Esto lo hacemos así para evitar duplicados, al aparecer la información en más elementos de la página
		Elements productos = destacado.getElementsByAttributeValueMatching("class", "GTM-productClick enlace-disimulado");
		
		// Recorremos los "productos" con un bucle for each, extrayendo en cada caso nombre y precio.
		// Creamos un nuevo Product con esos datos y lo añadimos al ArrayList weekProduct
		for (Element producto : productos) {
			  String productName = producto.attr("data-name");
			  double productPrice = Double.parseDouble(producto.attr("data-price"));
			  Product p = new Product (productName, productPrice);
			  weekProducts.add(p);
		}
	}
	
	// Método para recorrer el ArrayList de productos y pasarlo a un string
	public String print(){
		// Creamos un Iterator para recorrer el ArrayList
		Iterator it = weekProducts.iterator();
		
		StringBuilder str = new StringBuilder();
		
		// Mientras haya un elemento siguiente
		while (it.hasNext()){
			// Creamos una Action y le pasamos el casting del Iterator siguiente
			Product x = (Product) it.next();
			// Imprimimos los datos de la acción con el método printProduct de su clase
			str.append(x.printProduct());
		}
		return str.toString();
	}


}
