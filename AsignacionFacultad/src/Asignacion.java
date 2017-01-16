
import java.util.Scanner;

public class Asignacion {

	public static void main(String[] args) {
				
		// declaramos las variables a utilizar puntuacion=puntuación obtenida para el acceso a la universidad
		int puntuacion=0;
		
		String facultad="";
				
		Scanner teclado=new Scanner(System.in);
				
		// solictamos la introducción de la puntuación
		System.out.println("Introduzca su puntuación");
			puntuacion=teclado.nextInt();
					
		// estructuras condicionales según puntuación para cada facultad
		if(puntuacion>=100){
			facultad="Sistemas";
		
		}else if(puntuacion>=90 && puntuacion<100){
			facultad="Electrónica";
		
		}else if(puntuacion>=80 && puntuacion<90){
			facultad="Industrial";
		
		}else if(puntuacion>=70 && puntuacion<80){
			facultad="Administración";
		
		}else {
			facultad="Ninguna";
		}
		
		
		//presentamos el resultado en pantalla
		System.out.println("Su facultad es: " + facultad);
				
		teclado.close();
		
	}

}
