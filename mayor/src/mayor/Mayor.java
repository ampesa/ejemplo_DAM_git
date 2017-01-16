package mayor;

import java.util.Scanner;

public class Mayor {

	public static void main(String[] args) {
		// declaramos las variables n1, n2 y mayor
		
		int n1,n2,mayor;
		
		Scanner teclado=new Scanner(System.in);
		
		// solicitamos la introducción de los números
		
		System.out.println("Introduce el primer número");
			n1=teclado.nextInt();
		
		System.out.println("Introduce el segundo número");
			n2=teclado.nextInt();
			
		// proceso: estructura condicional
			
		if(n1>n2){
			mayor=n1;
		}else{
			mayor=n2;
		}
		
		// salida de datos
		System.out.println("El número mayor es:" + mayor);
		
		teclado.close();
		
		}
				
}
