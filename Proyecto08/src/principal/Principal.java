package principal;

import Ventanas.VentanaJuego;
import Ventanas.Registro;
import Ventanas.VentanaPrincipal;
import metodo.Usuarios;

//Creamos la clase Principal
public class Principal {

	//lanzamos el m�todo main, iniciamos la aplicaci�n.
	public static void main(String[] args) {
		
		//Creamos un nuevo objeto de la clase Usuarios para pobar la conexi�n.
		//Usuarios users = new Usuarios();
		//Generamos la ventana de Login y la hacemos visible
		Registro vRegistro=new Registro();
		vRegistro.setVisible(true);
		
		//VentanaPrincipal vPrincipal = new VentanaPrincipal();
		//vPrincipal.setVisible(true);		
		
	}
}
