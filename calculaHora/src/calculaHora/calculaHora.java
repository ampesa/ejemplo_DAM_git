package calculaHora;

import java.util.Scanner;

public class calculaHora {
	

	public static void main (String[] args){
		
		//creamos objeto teclado de la clase Scanner para captuar la hora, minuto y segundo
		Scanner teclado=new Scanner (System.in);
			
		//variables
		int hora=0, minutos=0, segundos=0;

		//Entrada de numeros
		System.out.println("Introduzca la hora");
		hora=teclado.nextInt();

		System.out.println("Introduzca los minutos");
		minutos=teclado.nextInt();	

		System.out.println("Introduzca los segundos");
		segundos=teclado.nextInt();
		
		//Proceso
		if (hora<=23 && minutos<60 && segundos<60){
			if (minutos==59 && segundos==59){
				hora=hora+1;
				minutos=0;
				segundos=0;
			}else if (segundos==59){
				hora=hora;
				minutos=minutos+1;
				segundos=0;
			}else {
				hora=hora;
				minutos=minutos;
				segundos=segundos+1;
			}
			//Salida
			System.out.println("En el siguinete segundo la hora sera: "+hora+"horas, "+minutos+"minutos, "+segundos+"segundos.");
			
		}else {
			System.out.println("INTRODUZCA UNA HORA CORRECTA");
		}
		

	
	}
}
