package metodo;

import javax.swing.JTextField;

import Ventanas.VentanaJuego;

/*
 * PROYECTO 08 CLASE JUGADOR
 * Esta clase contiene los atributos del jugador, con los setters y los getters que permitir�n
 * modificar el contenido de dichos atributos seg�n registremos un nuevo jugador, a�adamos puntos
 * al jugar o modifiquemos los datos de identificaci�n a trav�s de la clase Perfil
 * 
 * Adem�s contiene los m�todos de control isNumeric y sonEspacios, adem�s del m�todo toString
 * 
 * Esta clase no sufre cambios en este proyecto y se hereda tal cual de proyectos anteriores
 * */

public class Jugador {
		
	// Definimos las variables o propiedades a utilizar en la clase Jugador e inicializamos las variables con un valor por defecto
	private int id=0;	
	private String nombre="nombre";
	private String apellido1="apellido1";
	private String apellido2="apellido2";
	private String nick="nick";
	private int edad=0;
	private int puntos=0;
		
	//definimos los getter y los setter		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	//constructor
	public Jugador() {
		
	}
	
	// Sobrecarga del constructor para utilizar en el m�todo buscarUsuarios de la clase Usuarios
	public Jugador(int id, String nombre, String apellido1, String apellido2, int edad, int puntos) {
		this.id=id;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.edad=edad;
		this.puntos=puntos;
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
	
	//Comprobar si una cadena es un conjunto de espacios
	public boolean sonEspacios (String cad){
	for (int i=0; i<cad.length(); i++)
	if (cad.charAt(i) != ' ')
	return false;
	
	return true;
		
	}

	//definimos como queremos presentar los datos con un String toString
	public String toString(){
		return this.nombre+" "+this.apellido1+" "+this.apellido2+" "+this.nick+" "+this.edad+" "+this.puntos;
		
	}

}
