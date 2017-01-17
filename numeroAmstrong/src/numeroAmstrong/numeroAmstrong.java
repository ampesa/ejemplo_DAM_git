package numeroAmstrong;

//importamos la clase Scanner para capturar el número introducido por teclado
import java.util.Scanner;
	
public class numeroAmstrong {

	public static void main(String[] args) {
		
		//creamos objeto scanner teclado para recoger el número 
		Scanner teclado=new Scanner (System.in);
		
		//variables a utlizar
		int numero, cubo=0, sumaCubos=0, compara;
		
		
		//solicitamos la entrada de un número
		System.out.println("Introduzca su número");
		numero=teclado.nextInt();
		compara=numero; // creamos una variable que guardará el valor del número introducido para poder compararla al realizar el if de salida
		
		//proceso
		while (numero>0) { //mientras el numero sea mayor que cero haremos lo siguiente
			cubo=(numero%10)*(numero%10)*(numero%10); //asignaremos a cubo el valor del resto de dividir el número entre 10 y multiplicarlo 3 veces (cubo=
			sumaCubos=sumaCubos+cubo; // sumaremos los cubos en nuestro acumulador sumaCubos
			numero=numero/10; //quitamos el último dígito del número dividiéndolo por 10
		}
		
		//salida según sea o no cubo perfecto
		if (compara==sumaCubos) {
			System.out.println("Su número es cubo perfecto!!");
		} else {
			System.out.println("Su número NO es cubo perfecto");
		}
		
	}

}
