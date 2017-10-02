package vectorRellenado;

import java.util.Random;

public class VectorRellenado {

	public static void main(String[] args) {
		
		//Variables: definimos un array de 10 enteros
		int [] vector = new int[10];
		Random rndm = new Random(); // creamos un objeto random para rellenar el array aleatorimente
		
		// Rellenamos el array con números aleatorios mediante el objeto random con un bucle for
	    for (int i = 0; i < 10; i++)
	    {
	        vector[i] = rndm.nextInt(); 
	    }
	    
	    // Mostramos los elementos del array con otro bucle for
	    for (int i = 0; i < 10; i++) {
	    	System.out.println(vector[i]);
	    }
	}
}

