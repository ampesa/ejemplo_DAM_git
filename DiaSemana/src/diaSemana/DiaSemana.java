package diaSemana;

import java.util.Scanner;

public class DiaSemana {

	public static void main(String[] args) {
		// Creamos un objeto de la clase Scanner para capturar el numero introducido por teclado
		Scanner teclado = new Scanner(System.in);
		
		// Variables
		int numero;
		String dia;
		
		// Entrada
		System.out.println("Introduzca un número del 1 al 7");
		numero=teclado.nextInt();
		
		// Controlamos que el valor introducido sea válido
		while (numero<1 || numero>7){
			System.out.println("Error. Debe introducir un número entero del 1 al 7");
			numero=teclado.nextInt();
		}
		
		// Operamos con el valor introducido con un switch para cada opción válida del 1 al 7
		switch (numero) {
		case 1 : dia="lunes"; break;
		case 2 : dia="martes"; break;
		case 3 : dia="miércoles"; break;
		case 4 : dia="jueves"; break;
		case 5 : dia="viernes"; break;
		case 6 : dia="sábado"; break;
		case 7 : dia="domingo"; break;
		default : dia="No ha introducido un número válido";
		}
		
		// Salida: mostramos el día introducido
		System.out.println("El día introducido es "+dia);
		
		// Cerramos el objeto Scanner
		teclado.close();
		
	}

}
