package Principal;

import Ventanas.VentanaJuego;
import Ventanas.VentanaLogin;
import Ventanas.VentanaPrincipal;

//Creamos la clase Principal
public class Principal {

	//lanzamos el m�todo main, iniciamos la aplicaci�n.
	public static void main(String[] args) {
		
		//Generamos la ventana de Login y la hacemos visible
		VentanaLogin vLogin=new VentanaLogin();
		vLogin.setVisible(true);
		
		//VentanaPrincipal vPrincipal = new VentanaPrincipal();
		//vPrincipal.setVisible(true);		
		
	}
}
