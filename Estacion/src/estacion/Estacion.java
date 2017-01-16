package estacion;

import java.util.Scanner;

public class Estacion {

	public static void main(String[] args) {
		
		// declaramos las variables a utilizar
		int numero=0;
		String estacion="";
		
		Scanner teclado=new Scanner (System.in);
		
		// solicitamos la introducci�n del n�mero
		System.out.println("Introduzca un n�mero del 1 al 4");
		numero=teclado.nextInt();
		
		// Creamos la estructura condicional con switch para determinar la estaci�n correspondiente seg�n el caso
		switch (numero) {
			case 1 : estacion="Verano";break;
			case 2 : estacion="Oto�o";break;
			case 3 : estacion="Invierno";break;
			case 4 : estacion="Primavera";break;
			default : estacion="No ha introducido un n�mero v�lido";
		}
		
		//mostramos el resulado por pantalla
		System.out.println(estacion);
		
		teclado.close();
		
	}

}
