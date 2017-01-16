package bisiesto;

import java.util.Scanner;

public class Bisiesto {

	public static void main(String[] args) {
		
		// creamos el Scanner para capturar las entradas de datos de las variables
		Scanner teclado=new Scanner (System.in);
		
		// declaramos las constantes a utilizar, en este caso una
		final int M=30;

		// declaramos las variables a utilizar
		int mes=0;
		int year=0;
		int bisiesto=0;
		int numero_dias=0;
		
		// solicitamos la entrada número de mes:
		System.out.println("Introduzca el número de mes");
		mes=teclado.nextInt();
		
		//solicitamos el número del año:
		System.out.println("Introduzca el año");
		year=teclado.nextInt();
		
		// definimos las estructuras condicionales, primero determinamos el la variable bisiesto
		// si year es multiplo de 4 y no es múltiplo de cuatro, pero si lo es de 400, entonces año bisiesto le restamos 2 dias al caso normal (constante M)
		// en caso contrario (else) restamos solo uno a la constante M, como veremos en el switch posterior
		if (year%4==0 && (year%100!=0 || year%400==0)) {
			bisiesto=-2; 
			} else {
			bisiesto=-1;
			}
		
		// definimos estructura switch para los casos de meses con 31 días (M+1), para los meses con 30 días(M) y para el caso especial de febrero
		switch (mes) {
			case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 : numero_dias=M+1; break;
			case 4 : case 6 : case 9 : case 11 : numero_dias=M; break;
			case 2 : numero_dias=M+bisiesto; break;
			default : numero_dias=0;
		}

		//mostramos el resultado en pantalla
		System.out.println ("El mes tiene " + numero_dias);
		
		teclado.close();

	}

}
