package sumaNumeros;

//importamos la clase Scanner para capturar el número introducido por el usuario
import java.util.Scanner;

public class sumaNumeros {

	public static void main(String[] args) {
		
		//creamos el objto teclado de la clase Scanner
		Scanner teclado=new Scanner(System.in);
		
		//variables
		int i, numero, suma;
		
		suma=0;
		i=1;
		
		//entrada de datos
		System.out.println("Dame un número");
		numero=teclado.nextInt();
		
		//proceso
		while (i<=numero){
			suma=suma+i;
			i=i+1;
		}
		
		//salida de datos
		System.out.println("la suma total es: " + suma);

	}

}
