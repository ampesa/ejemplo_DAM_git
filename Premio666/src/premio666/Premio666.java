package premio666;

import java.util.Scanner;

public class Premio666 {

	public static void main(String[] args) {
		
		// Declaramos las variables a utilizar
		int dado1,dado2,dado3;
		String premio = null;
		
		Scanner teclado=new Scanner(System.in);
		
		// Solicitamos la introducci�n de los dados
		System.out.println("Introduzca puntuaci�n del primer dado");
		dado1=teclado.nextInt();
		
		System.out.println("Introduzca puntuaci�n del segundo dado");
		dado2=teclado.nextInt();
		
		System.out.println("Introduzca puntuaci�n del tercer dado");
		dado3=teclado.nextInt();
		
		// generamos estructura condicional para oro, plata, bronce y perdedor
		
		if(dado1+dado2+dado3==18){
			premio="Oro";
		
		}else if(dado1+dado2==12 || dado1+dado3==12 || dado2+dado3==12){
			premio="Plata";
		
		}else if (dado1==6 && dado2!=6 && dado3!=6 || dado2==6 && dado1!=6 && dado3!=6
				|| dado3==6 && dado2!=6 && dado1!=6){
			premio="Bronce";
		
		}else if (dado1<6 && dado2<6 && dado3<6){
			premio="Perdedor";
		
		}else {
			premio="ninguno";
		}
		
		// mostramos el resultado en pantalla
		System.out.println("Su resultado es: " + premio);
		
		teclado.close();
		
	}

}
