package Principal;

import Ventanas.VentanaJuego;
import Ventanas.VentanaLogin;
import Ventanas.VentanaPrincipal;

//Creamos la clase Principal
public class Principal {

	//lanzamos el método main, iniciamos la aplicación.
	public static void main(String[] args) {
		
		//Generamos la ventana de Login y la hacemos visible
		VentanaLogin vLogin=new VentanaLogin();
		vLogin.setVisible(true);
		
		//VentanaPrincipal vPrincipal = new VentanaPrincipal();
		//vPrincipal.setVisible(true);		
		
	}
}
