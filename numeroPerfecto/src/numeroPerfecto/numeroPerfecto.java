package numeroPerfecto;

import java.util.Scanner;

public class numeroPerfecto {

	public static void main(String[] args) {
		
		Scanner teclado=new Scanner(System.in);
		
		//variables
		int numero, suma=0, divisor=1;
		
		//Entrada
		System.out.println("Dime el número");
		numero=teclado.nextInt();
		
		//proceso
		while (numero > divisor){
			if (numero%divisor==0){
				suma+=divisor; //suma=suma+divisor
			}
			
			divisor++;
			
		}
		
		//salida
		if (suma==numero){
			System.out.println("El número es perfecto");
		}else {
			System.out.println("El número No es perfecto");
		}

	}

}
