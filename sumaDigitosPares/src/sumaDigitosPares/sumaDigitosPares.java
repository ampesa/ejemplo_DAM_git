package sumaDigitosPares;

//importamos la clase Scanner para solicitar la entrada de un número
import java.util.Scanner;

public class sumaDigitosPares {

	public static void main(String[] args) {
		/* Dado un determinado número, mostrar el número total de dígitos pares, 
		 * por ejemplo: 786 tiene 2 dígitos pares*/
		
		Scanner teclado=new Scanner(System.in);
		
		//variables
		int numero, digito, contadorPares=0;
		
		//entrada
		System.out.println("Dime un número");
		numero=teclado.nextInt();
		
		while (numero > 0){
			digito=numero%10;
			
			if (digito % 2 == 0){
				contadorPares++;
			}
			
			numero=numero/10;
			
		}
		
		System.out.println("El número tiene: " + contadorPares + " dígitos pares");

	}

}
