package model;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;



public class GestionDatos {
	
	private BufferedReader brFichero1 = null;
	private BufferedReader brFichero2 = null;
	private FileInputStream fiOrigen = null;
	private FileOutputStream foDestino = null;
	private String str1;
	private String str2;
	private int contador_lineas = 1;
	private int ultima;

	public GestionDatos() {

	}

	//TODO: Implementa una funci�n para abrir ficheros
	// abrirFichero recibe un String con el nombre del fichero y crea un BufferedReader sobre el fichero con ese nombre
    public BufferedReader abrirFichero(String fichero) throws IOException {
    	return new BufferedReader (new FileReader(fichero)); 
    }
    
    public File abrirFicheros(String fichero) throws IOException {
    	return  new File (fichero); 
    }
    
    //TODO: Implementa una funci�n para cerrar ficheros
    // M�todo para cerrar ficheros
    public void cerrarFichero(Closeable c) {
        try {
        	c.close();
        } catch (IOException e){
        }
      }
    
    // Creamos este m�todo para obtener el total de l�neas de un fichero a trav�s de BufferedReader
    public int contarLineas(BufferedReader br) throws IOException{
    	int total_lineas = 0;
    	while ((str1 = br.readLine()) != null)
    		total_lineas++;
    	br.close();
		return total_lineas;
    }
    
	public boolean compararContenido (String fichero1, String fichero2) throws IOException{
		//TODO: Implementa la funci�n
		// Abrimos los fichero con el m�todo abrirFichero y los pasamos a brFichero1 y brFichero2
		brFichero1 = abrirFichero(fichero1);
		brFichero2 = abrirFichero(fichero2);
		
		// Utilizamos los Strings str1 y str2 para almacenar las l�neas de cada archivo y compararlas
		str1 = brFichero1.readLine();
		str2 = brFichero2.readLine();
		/* Evaluamos la igualdad l�nea a l�nea. Si la igualdad no se cumple en alg�n momento devolvemos false, 
		 * en caso contrario devovemos true. Utilizamos un bucle while, mientras los strings no sean nulos, 
		 * si la l�nea no es igual que la del otro archivo devuelve false. En caso contrario muestra la l�nea
		 * por consola y lee una nueva l�nea con los BufferedReader e incrementa el contador de l�neas en 1
		 * Si se completa el bucle while, los dos ficheros son iguales y devuelve true.
		 */
		while (str1 != null && str2 != null){
			if (!str1.equals(str2)) {
				return false;
			} else {
				System.out.println("l�nea: " + contador_lineas + "\t" + str1 + "\t" + str2);
				str1 = brFichero1.readLine();
				str2 = brFichero2.readLine();
				contador_lineas++;
			}
			
		}
		// Cerramos los ficheros con el m�todo cerrarFichero
		cerrarFichero(brFichero1);
		cerrarFichero(brFichero2);
		// Reseteamos el contador de l�neas a 1
		contador_lineas = 1;
		return true;
	} // Fin de compararContenido
	
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		//TODO: Implementa la funci�n
		
		// Verificamos por consola lo datos recibidos por el m�todo
		System.out.println("buscarPalabra ha recibido: " + fichero1 + palabra + primera_aparicion);
		
		// abrimos el fichero
		brFichero1 = abrirFichero(fichero1);
		brFichero2 = abrirFichero(fichero1);

		// Obtenemos el total de l�neas del fichero
		int total_lineas = contarLineas(brFichero2);
		
		// Creamos un array int con el total de l�neas
		int lineas [] = new int [total_lineas];
		
		/* Recorremos el fichero con un bucle for sobre el total de l�neas. Para cada l�nea si la palabra coincide
		 * el array lineas almacenar� el valor de i+1 en la posici�n i. 
		 * Para cada iteraci�n asignamos una nueva l�nea a str1 y mostramos por consola la l�nea
		 */
		for (int i=0; i<total_lineas; i++){
			str1 = brFichero1.readLine();			
			if (str1.equals(palabra)){
				lineas [i] = i+1;
			}
			System.out.println(str1);
		}
		
		// mostramos por consola el total de l�neas
		System.out.println(lineas.length);
		
		/* El array contiene las coincidencias en las posiciones cuyo valor es diferente de 0
		 * Con el if obtenemos la primera aparici�n, pues el bucle se iterrumpira en caso de encontrar 
		 * una coincidencia, en este caso el primer valor del array que sea diferente de 0. 
		 * Como estamos trabajando con las posiciones le sumamos 1 para obtener la l�nea. Tambien podemos usar return lineas[i];
		 */
		if (primera_aparicion){
			for (int i=0; i<lineas.length; i++){
				System.out.println("l�nea: " + (i+1) + "\t" + lineas[i]);
				if (lineas[i]!=0)
					return i+1;
			}
		}
		/* Con el else hacemos lo mismo, pero para obtener el �ltimo valor, en lugar de poner el return dentro del if, 
		 * lo ponemos despu�s del for. De esta manera el if anidado sustituir� el valor del int ultima cada vez que haya una coincidencia,
		 * quedando al final del bucle for la �ltima aparici�n. */
		else {
			for (int i=0; i<lineas.length; i++){
				System.out.println("l�nea: " + (i+1) + "\t" + lineas[i]);
				if (lineas[i]!=0){
					ultima = i+1;
				}
			}
			return ultima;
		}
		// mostramos por consola el total de valores recogidos en el array
		System.out.println(lineas.length);
		
		// Cerramos los ficheros
		cerrarFichero(brFichero1);
		cerrarFichero(brFichero2);
		// Si los condicionales anteriores no han devuelto nada, la palabra no est� en el fichero y el m�todo devolver� -1
		return -1;
	}	// Fin de buscarPalabra

	public long copiarFichero (String fichero_origen, String fichero_destino) throws IOException {
		//TODO: Implementa la funci�n
		
		// Utilizamos un long para recoger el tama�o del fichero de origen en bytes
		long size = abrirFicheros(fichero_origen).length();
		
		// Creamos un buffer (array de bytes) del tama�o del archivo de origen para optimizar recursos
		byte[] buffer = new byte [(int) size];
		
		// Abrimos el flujo de entrada sobre el archivo de origen y el de salida sobre el de destino
		fiOrigen = new FileInputStream (abrirFicheros(fichero_origen));
		foDestino = new FileOutputStream (abrirFicheros(fichero_destino));
		
		// Leemos el origen en el buffer y despu�s lo escribimos
		fiOrigen.read(buffer);
		foDestino.write(buffer);
		
		// asignamos al long size el tama�o en bytes del archivo de destino despues de la copia
		size = abrirFicheros(fichero_destino).length();
		
		// cerramos los flujos de bytes
		cerrarFichero(fiOrigen);
		cerrarFichero(foDestino);
		
		// devolvemos el tama�o en bytes compiado en formato int
		return size;
	}	// Fin de copiarFichero
	
}
