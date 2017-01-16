package clima;

import java.util.Scanner;

public class Clima {

	public static void main(String[] args) {
		
		// declaramos las variables a utilizar, para este caso un entero y una cadena de texto
		int temperatura=0;
		String clima="";
		
		Scanner teclado=new Scanner (System.in);
		
		//solicitamos la introducción de la temperatura
		System.out.println("Introduzca la temperatura");
		temperatura=teclado.nextInt();
		
		//creamos la estructura condicional para determinar el clima según la temperatura
		if (temperatura<10) {
			clima="Frío";
		} else if (temperatura>=10 && temperatura<=20) {
			clima="Templado";
		} else if (temperatura>=21 && temperatura<=30) {
			clima="Calor";
		} else if (temperatura>30) {
			clima="Tropical";
		} else {clima="La temperatura introducida no es válida";
		
		}
		
		//presentamos el resultado en pantalla
		System.out.println(clima);
		
	}

}
