package simulacion;

//importamos la clase Random para utilizarla en la generación de resultados
import java.util.Random;

public class SimulacionEquipos {
	
		//definimos las constantes con los puntos en caso de ganar G o empatar E, el caso de perder es el valor inicial de las variables puntos.
		static final int G=3;
		static final int E=1;

		
	public static void main(String[] args) {

		/*
		 * Definimos las variables que almacenarán los goles, los puntos obtenidos por cada equipo (esto los inicializamos a 0) 
		 * y la variable ganador en la que almacenaremos el equipo con más puntos
		 * */
		int goles1, goles2, goles3, goles4, goles5, goles6;
		int puntos1=0, puntos2=0, puntos3=0;
		String ganador="";		
		
		//proceso // generamos los resultados con la clase Random
		Random rndm = new Random();
		goles1=rndm.nextInt(6);
		goles2=rndm.nextInt(6);
		goles3=rndm.nextInt(6);
		goles4=rndm.nextInt(6);
		goles5=rndm.nextInt(6);
		goles6=rndm.nextInt(6);

		//mostramos los resultados de los goles de cada partido por consola
		System.out.printf("%s\n%s\n%s\n%s\n%s\n",
				"Simulación Liguilla de Fútbol", 
				"",
				"Equipo1: "+goles1+" - Equipo2: "+goles2,
				"Equipo2: "+goles3+" - Equipo3: "+goles4,
				"Equipo1: "+goles5+" - Equipo3: "+goles6);
		
		//proceso // comparamos resultados y sumamos puntos del partido 1 entre equipo 1 y equipo 2
		if (goles1>goles2) {
			puntos1=puntos1+G;
		}else if (goles1<goles2) {
			puntos2=puntos2+G;
		}else {
			puntos1=puntos1+E; puntos2=puntos2+E;
		}
		
		//proceso // comparamos resultados y sumamos puntos del partido 2 entre el equipo 2 y el equipo 3
		if (goles3>goles4){
			puntos2=puntos2+G;
		}else if (goles3<goles4){
			puntos3=puntos3+G;
		}else {
			puntos2=puntos2+E; puntos3=puntos3+E;
		}
		
		//proceso // comparamos resultados y sumamos puntos del partido 3 entre el equipo 1 y el equipo 3
		if (goles5>goles6){
			puntos1=puntos1+G;
		}else if (goles5<goles6){
			puntos3=puntos3+G;
		}else {
			puntos1=puntos1+E; puntos3=puntos3+E;
		}
		
		//mostramos los resultados de puntos de cada equipo por consola
		System.out.printf("%s\n%s\n%s\n%s\n",
				"------------------------------", 
				"Los puntos del Equipo 1 son: "+puntos1, 
				"Los puntos del Equipo 2 son: "+puntos2, 
				"Los puntos del equipo 3 son: "+puntos3);

		// proceso // comparamos los puntos para determinar el ganador
		if (puntos1>puntos2 && puntos1>puntos3){
			ganador="Equipo1";
		}else if (puntos2>puntos1 && puntos2>puntos3){
			ganador="Equipo2";
		}else if (puntos3>puntos2 && puntos3>puntos1){
			ganador="Equipo3";
		}else {
			ganador="hay empate";
		}
		
		// mostramos el ganador por pantalla
		System.out.printf("%s\n%s\n",
				"------------------------------", 
				"El ganador de la liguilla es: "+ganador);

	}

}
