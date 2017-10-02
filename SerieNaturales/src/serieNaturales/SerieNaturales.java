package serieNaturales;

import java.util.Scanner;

public class SerieNaturales {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		// Variables
		int num;
		
		// Entrada
		System.out.println("Introduzca un número natural:");
		num = teclado.nextInt();
		
		while (num<0){
			System.out.println("Error. Introduzca un número entero mayor o igual a 0:");
			num = teclado.nextInt();
		}
		
		for (int i=0; i<=num; i++){
			System.out.println(i);
		}
		
		// Cerramos el objeto Scanner
		teclado.close();
	}

}
