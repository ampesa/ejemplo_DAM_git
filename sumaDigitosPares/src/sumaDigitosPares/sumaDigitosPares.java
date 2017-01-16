package sumaDigitosPares;

//importamos la clase Scanner para solicitar la entrada de un n�mero
import java.util.Scanner;

public class sumaDigitosPares {

	public static void main(String[] args) {
		/* Dado un determinado n�mero, mostrar el n�mero total de d�gitos pares, 
		 * por ejemplo: 786 tiene 2 d�gitos pares*/
		
		Scanner teclado=new Scanner(System.in);
		
		//variables
		int numero, digito, contadorPares=0;
		
		//entrada
		System.out.println("Dime un n�mero");
		numero=teclado.nextInt();
		
		while (numero > 0){
			digito=numero%10;
			
			if (digito % 2 == 0){
				contadorPares++;
			}
			
			numero=numero/10;
			
		}
		
		System.out.println("El n�mero tiene: " + contadorPares + " d�gitos pares");

	}

}
