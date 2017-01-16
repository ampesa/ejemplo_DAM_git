package sumaNumeros_for;

import java.util.Scanner;

public class sumaNumerosf {

	public static void main(String[] args) {

		Scanner teclado=new Scanner(System.in);
		
		//variables
		int suma, numero;
		
		//inicializamos la variable suma a valor 0
		suma=0;
		
		//solicitamos la entrada de un número
		System.out.println("dime un número");
		numero=teclado.nextInt();
		
		//proceso
		for (int i=0; i<(numero+1); i++){
			suma=suma+i;
		}
		
		//salida
		System.out.println("La suma total es "+ suma);
		
	}

}
