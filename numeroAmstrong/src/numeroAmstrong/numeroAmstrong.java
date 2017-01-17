package numeroAmstrong;

//importamos la clase Scanner para capturar el n�mero introducido por teclado
import java.util.Scanner;
	
public class numeroAmstrong {

	public static void main(String[] args) {
		
		//creamos objeto scanner teclado para recoger el n�mero 
		Scanner teclado=new Scanner (System.in);
		
		//variables a utlizar
		int numero, cubo=0, sumaCubos=0, compara;
		
		
		//solicitamos la entrada de un n�mero
		System.out.println("Introduzca su n�mero");
		numero=teclado.nextInt();
		compara=numero; // creamos una variable que guardar� el valor del n�mero introducido para poder compararla al realizar el if de salida
		
		//proceso
		while (numero>0) { //mientras el numero sea mayor que cero haremos lo siguiente
			cubo=(numero%10)*(numero%10)*(numero%10); //asignaremos a cubo el valor del resto de dividir el n�mero entre 10 y multiplicarlo 3 veces (cubo=
			sumaCubos=sumaCubos+cubo; // sumaremos los cubos en nuestro acumulador sumaCubos
			numero=numero/10; //quitamos el �ltimo d�gito del n�mero dividi�ndolo por 10
		}
		
		//salida seg�n sea o no cubo perfecto
		if (compara==sumaCubos) {
			System.out.println("Su n�mero es cubo perfecto!!");
		} else {
			System.out.println("Su n�mero NO es cubo perfecto");
		}
		
	}

}
