import java.util.Scanner;

public class CalculaFactorial {

	
	public static void main(String[] args) {
		
		Scanner teclado=new Scanner(System.in);
		
		//variables
		int numero, factorial=1, i=1;
		
		//Entrada
		System.out.println("Introduzca su número");
		numero=teclado.nextInt();
		
		//Proceso
		if (numero!=0){
			for (i=1; i<=numero; i++){
				factorial=factorial*i;
						
			}
		}else {
			factorial=1;
		}
			
		//Salida
		System.out.println("El factorial de su número es: "+factorial);
				

	}

}
