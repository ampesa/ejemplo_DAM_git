package mesestacion;

import java.util.Scanner;

public class MesEstacion {

	public static void main(String[] args) {
		
		// Declaramos las variables a utilizar
		int mes=0;
		String estacion="";
		
		Scanner teclado=new Scanner (System.in);
		
		// solicitamos el número de mes
		System.out.println("Introduzca el número de mes (del 1 al 12)");
		mes=teclado.nextInt();
		
		// creamos la estructura condicional con switch para mostrar la "estacion" que le corresponde a "numero"
		switch (mes) {
			case 3 : // dejamos en blanco los casos que obtienen el mismo reusltado, operando solo con el último de cada resultado diferente
			case 4 :
			case 5 : estacion="Primavera";break;
			case 6 : 
			case 7 : 
			case 8 : estacion="Verano";break;
			case 9 : 
			case 10 : estacion="Otoño";break;
			case 11 :
			case 12 :
			case 1 :
			case 2 : estacion="Invierno";break;
			default : estacion="Ho ha introducido un número válido";
		}
		
		// mostramos el resultado por pantalla
		System.out.println(estacion);
		
	}

}
