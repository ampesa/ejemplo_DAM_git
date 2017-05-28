package cuentaDigitos;

import java.util.Scanner;
import cuentaDigitos.CuentaDigitos;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduzca un número entero");

		CuentaDigitos cuenta=new CuentaDigitos();
		cuenta.setNumero(teclado.nextInt());
		
		System.out.printf("%s\n%s\n%s\n%s\n",
				"El numero "+cuenta.getNumero()+" tiene:", 
				cuenta.pares()+" dígitos pares", 
				cuenta.impares()+" dígitos impares", 
				cuenta.digitos()+" dígitos en total");
		
		teclado.close();
	}

}
