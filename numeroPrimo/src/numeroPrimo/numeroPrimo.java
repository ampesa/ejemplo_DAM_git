package numeroPrimo;

import java.util.Scanner;

public class numeroPrimo {

	public static void main(String[] args) {
		
		Scanner teclado=new Scanner(System.in);
		
		//variables
		int numero;
		boolean esPrimo=true;
		
		//entrada
		System.out.println("Dime un número");
		numero=teclado.nextInt();
		
		//proceso
		for (int i=2;i<=numero/2 && esPrimo==true;i++){ //para la variable i, que empieza en 2 y mientras sea menor o igual que la mitad del número y esPrimo se cumpla, incrrementando i en 1 cada vez...
			if (numero%i==0){ //si el resto de numero/i es 0, entonces no se cumple esPrimo
				esPrimo=false;
			}
		}

		if (esPrimo==true){ 
			System.out.println("El número es primo");
		}else { 
			System.out.println("El número NO es primo");
		}
		
	}

}
