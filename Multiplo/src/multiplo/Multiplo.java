package multiplo;

import java.util.Scanner;

public class Multiplo {

	public static void main(String[] args) {
		
		//definimos las variablea a utilizar
		int numero=0;
		String resultado="";
		
		// creamos el scanner para utilizar el número introducido por el usuario
		Scanner teclado=new Scanner (System.in);
		
		// solicitamos la entrada de un númmero
		System.out.println("Por favor, introduzca un número");
		numero=teclado.nextInt();
		
		// iniciamos el proceso para determinar si es múltiplo de 3 y de 5 al mismo tiempo
		// si es múltiplo el resto será 0, es por ello que utilizamos el operador % (remainder, residuo o resto)
		if (numero % 3 == 0 && numero % 5 == 0){
			resultado="Es múltiplo!!";
			
		}else {
			resultado="No es múltiplo";
		}

		// mostramos el resultado en pantalla
		System.out.println(resultado);
		
		teclado.close ();
		
	}

}
