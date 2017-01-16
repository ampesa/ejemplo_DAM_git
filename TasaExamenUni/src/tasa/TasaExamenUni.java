package tasa;

import java.util.Scanner;

public class TasaExamenUni {

	public static void main(String[] args) {
		
		
		// declaramos las variables a utilizar
		int colegio,nivel,importe;
		
		Scanner teclado=new Scanner(System.in);
		
		// solicitamos introducción del colegio
		
		System.out.println("Introduzca la opción correspondiente a su colegio:\n1 para colegio nacional\n2 para colegio particular");
		colegio=teclado.nextInt();
		
		// solicitamos la introducción del nivel socioeconómico
		System.out.println("Introduzca la opción correspondiente a su nivev socioeconómico:\n1 para nivel C\n2 para nivel B\n3 para nivel A");
		nivel=teclado.nextInt();
		
		// generamos estructura condicional
		if(colegio==1){
			importe=nivel*100;
		}else{
			importe=nivel*100+100;
		}
		
		//mostramos el importe de la tasa de examen
		System.out.println("El importe de la tasa de examen es " + importe);
		
		teclado.close();
		
	}

}
