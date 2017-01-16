package estacion;

import java.util.Scanner;

public class Estacion {

	public static void main(String[] args) {
		
		// declaramos las variables a utilizar
		int numero=0;
		String estacion="";
		
		Scanner teclado=new Scanner (System.in);
		
		// solicitamos la introducción del número
		System.out.println("Introduzca un número del 1 al 4");
		numero=teclado.nextInt();
		
		// Creamos la estructura condicional con switch para determinar la estación correspondiente según el caso
		switch (numero) {
			case 1 : estacion="Verano";break;
			case 2 : estacion="Otoño";break;
			case 3 : estacion="Invierno";break;
			case 4 : estacion="Primavera";break;
			default : estacion="No ha introducido un número válido";
		}
		
		//mostramos el resulado por pantalla
		System.out.println(estacion);
		
		teclado.close();
		
	}

}
