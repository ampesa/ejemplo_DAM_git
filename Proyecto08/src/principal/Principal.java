package principal;

import Ventanas.VentanaJuego;
import Ventanas.Registro;
import Ventanas.VentanaPrincipal;
import metodo.Usuarios;

/* PROYECTO 08 CLASE PRINCIPAL
 * 
 * Esta clase contiene el main y con ella lanzamos nuestro programa, creando una ventana de registro y
 * haciéndola visible.
 * */

public class Principal {

	//lanzamos el método main, iniciamos la aplicación.
	public static void main(String[] args) {
		
		//Generamos la ventana de Registro y la hacemos visible
		Registro vRegistro=new Registro();
		vRegistro.setVisible(true);
		
	}
}
