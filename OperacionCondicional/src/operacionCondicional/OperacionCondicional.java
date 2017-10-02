package operacionCondicional;

import java.util.Scanner;

public class OperacionCondicional {

	public static void main(String[] args) {
		//Utilizamos un objeto de la clase Scanner para capturar los números introducidos por el usuario
		Scanner teclado=new Scanner(System.in);
		
		//variables: los tres números que solicitamos para operar
		int num1, num2, num3, valorCalculado;
		
		//Solicitamos la introducción de los números y los asignamos a las variables 
		System.out.println("Introduzca el primer número. Debe ser diferente de 0");
		num1=teclado.nextInt();
		while (num1==0){
			System.out.println("Recuerde, el primer número debe ser diferente de 0");
			num1=teclado.nextInt();
		}
		System.out.println("Introduzca el segundo número");
		num2=teclado.nextInt();
		System.out.println("Introduzca el tercer número");
		num3=teclado.nextInt();
		
		//Proceso
		if (num1>0){
			valorCalculado=num2*num3;
		}else {
			valorCalculado=num2+num3;
		}
			
		//Salida
		System.out.println("El resultado es: "+valorCalculado);
		
		teclado.close();
				
	}

}
