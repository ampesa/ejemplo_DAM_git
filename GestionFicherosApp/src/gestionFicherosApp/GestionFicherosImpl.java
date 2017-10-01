package gestionFicherosApp;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import gestionficheros.FormatoVistas;
import gestionficheros.GestionFicheros;
import gestionficheros.GestionFicherosException;
import gestionficheros.TipoOrden;

public class GestionFicherosImpl implements GestionFicheros {

	private File carpetaDeTrabajo=null;
	private Object [][] contenido;
	private int filas=0;
	private int columnas=3;
	private FormatoVistas formatoVistas = FormatoVistas.NOMBRES;
	private TipoOrden ordenado = TipoOrden.DESORDENADO;
	
	public GestionFicherosImpl(){
		carpetaDeTrabajo=File.listRoots()[0];
		actualiza();
		
	}
	
	public void actualiza(){
		System.out.println("Carpeta "+carpetaDeTrabajo);
		String [] ficheros = carpetaDeTrabajo.list(); //Obtenemos los nombres
		
		// Calculamos el número de filas necesario
		filas = ficheros.length / columnas;
		if (filas * columnas < ficheros.length) {
			filas++; // Si filas por columnas es menor que el número de ficheros, añadimos una fila
		}
		
		// Dimensionamos la matriz de contenido según los resultados
		
		contenido = new String [filas] [columnas];
		
		// Rellenamos el contenido con los nombres obtenidos
		for (int i = 0; i < columnas; i++){
			for (int j = 0; j < filas; j++){
				int ind = j * columnas + i; 
				if (ind < ficheros.length) {
					contenido [j][i] = ficheros [ind];					
				} else {
					contenido [j][i] = "";
				}
			}
		}
		
	}

	@Override
	public void arriba() {
		
		// Controlamos que la carpeta padre no sea nula o invalida y procedemos a asignar
		// a Carpeta de trabajo el valor de su antecesora
		if (carpetaDeTrabajo.getParentFile()!=null){
			carpetaDeTrabajo = carpetaDeTrabajo.getParentFile();
			actualiza();
		}
		
	}

	@Override
	public void creaCarpeta(String arg0) throws GestionFicherosException {
		
		File file = new File(carpetaDeTrabajo,arg0);
		
		// Comprobamos que haya permiso de escritura en la carpeta
		if (!carpetaDeTrabajo.canWrite()){
			throw new GestionFicherosException("Error. No tiene permiso para escribir en esta carpeta");
		}
		
		// Comprobamos que no exista ya
		if (file.exists()){
			throw new GestionFicherosException("Error. Ya existe una carpeta con ese nombre");
		}
		
		// Creamos la carpeta. Utilizamos try... catch para controlar otros errores
		try {
			file.mkdir();
		}catch (Exception e){
			e.printStackTrace();
			System.err.println("Error. NO se ha credo el la carpeta");
		}
		
		// Actualizamos el contenido de la carpeta		
		actualiza();
	}

	@Override
	public void creaFichero(String arg0) throws GestionFicherosException {
		
		File file = new File(carpetaDeTrabajo,arg0);
		
		// Comprobamos que haya permiso de escritura en la carpeta
		if (!carpetaDeTrabajo.canWrite()){
			throw new GestionFicherosException("Error. No tiene permiso para escribir en esta carpeta");
		}
		
		// Comprobamos que no exista ya ese fichero
		if (file.exists()){
			throw new GestionFicherosException("Error. Ya existe un fichero con ese nombre");
		}
		
		// Creamos el fichero
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error. NO se ha credo el fichero");
		}
		
		// Actualizamos el contenido de la carpeta
		actualiza();
		
	}

	@Override
	public void elimina(String arg0) throws GestionFicherosException {
		
		File file = new File(carpetaDeTrabajo, arg0);

		// Comprobamos que haya permiso de escritura en la carpeta y en el archivo
		if (!carpetaDeTrabajo.canWrite() || !file.canWrite()){
			throw new GestionFicherosException("Error. No tiene permiso para escribir");
		}
		
		// Comprobamos que el fichero o carpeta a borrar existe
		if (!file.exists()){
			throw new GestionFicherosException("Error. No existe ningún fichero con ese nombre");
		}
		
		// Comprobamos que si es un directorio, que esté vacío
		if (file.isDirectory() && file.list().length!=0){
			throw new GestionFicherosException("Error, El directorio no está vacío");
		}
		
		// Eliminamos el fichero o carpeta
		try {
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error. NO se ha credo el fichero");
		}
		
		// Actualizamos el contenido de la carpeta
		actualiza();		
		
	}

	@Override
	public void entraA(String arg0) throws GestionFicherosException {
		File file = new File(carpetaDeTrabajo, arg0);
		
		// Controlamos que la dirección introducida exista y sea un directorio
		if (!file.isDirectory()){
			throw new GestionFicherosException ("Error. Se esperaba un directorio pero "
					+ file.getAbsolutePath() + " no es un directorio.");
		}
		
		// Controlamos que haya permiso de lectura para este fichero
		if(!file.canRead()){
			throw new GestionFicherosException ("Alerta. No se puede acceder a "
					+ file.getAbsolutePath() + "No hay permisos.");
		}
		
		// Asignamos a la carpeta de trabajo el nuevo valor introducido
		carpetaDeTrabajo = file;
		
		// Actualizamos el contenido de la carpeta con el metodo actualiza
		actualiza();
		
	}

	@Override
	public int getColumnas() {
		return columnas;
	}

	@Override
	public Object[][] getContenido() {
		return contenido;
	}

	@Override
	public String getDireccionCarpeta() {
		return carpetaDeTrabajo.getAbsolutePath();
	}

	@Override
	public String getEspacioDisponibleCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEspacioTotalCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFilas() {
		return filas;
	}

	@Override
	public FormatoVistas getFormatoContenido() {
		return formatoVistas;
	}

	@Override
	public String getInformacion(String arg0) throws GestionFicherosException {
		
		StringBuilder strBuilder = new StringBuilder();
		File file = new File(carpetaDeTrabajo, arg0);
		
		// Controlar que existe. Si no, se lanzará una excepción		
		if (!file.exists()){
			throw new GestionFicherosException ("Error. El fichero o la carpeta no existe");
		}
		// Controlar que haya permisos de lectura
		if (!file.canRead()){
			throw new GestionFicherosException ("Alerta. No hay permisos para leer el fichero o la carpeta");
		}
		
		// Título
		strBuilder.append("INFORMACIÓN DEL SISTEMA");
		strBuilder.append("\n\n");
		
		// Nombre del archivo o carpeta
		strBuilder.append("Nombre: "+arg0);
		strBuilder.append("\n");
				
		// Tipo: fichero o directorio
		if (file.isDirectory()){
			strBuilder.append("Tipo: Directorio");
		} else {
			strBuilder.append("Tipo: Fichero");
		}
		strBuilder.append("\n");
		
		// Ubicación
		strBuilder.append("Ubicación :" + file.getAbsolutePath() + "\n");
		
		// Fecha de última modificación
		// creamos un objeto de tipo Date y le pasamos el valor long para mostrar en formato fecha
		Date modificado = new Date(file.lastModified());
		strBuilder.append("Modificado: "+ modificado + "\n");
		
		// Si es fichero oculto o no
		if (!file.isHidden()){
			strBuilder.append("Oculto: No");
		} else {
			strBuilder.append("Oculto: Si");
		}
		strBuilder.append("\n");
		
		// Si es directorio: Nº archivos, Espacio libre, espacio disponible, espacio total en bytes
		// Si es un archivo el tamaño del mismo
		if (file.isDirectory()){
			strBuilder.append("Contenido: "+file.list().length+" archivos\nEspacio Libre: " + carpetaDeTrabajo.getFreeSpace()+" bytes\n"+
								"Espacio Disponible: " + carpetaDeTrabajo.getUsableSpace() +" bytes\n"+
								"Espacio Total: " + carpetaDeTrabajo.getTotalSpace()+" bytes\n");
		} else {
			strBuilder.append("Tamaño: "+file.length()+" bytes\n");
		}
		strBuilder.append("\n");
	
		return strBuilder.toString();
		
	}

	@Override
	public boolean getMostrarOcultos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNombreCarpeta() {
		return carpetaDeTrabajo.getName();
	}

	@Override
	public TipoOrden getOrdenado() {
		return ordenado;
	}

	@Override
	public String[] getTituloColumnas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUltimaModificacion(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String nomRaiz(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numRaices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void renombra(String arg0, String arg1) throws GestionFicherosException {
		
		File file = new File(carpetaDeTrabajo, arg0);
		File file2 = new File(carpetaDeTrabajo, arg1);
		
		// Comprobamos que haya permiso de escritura en la carpeta y en el archivo
		if (!carpetaDeTrabajo.canWrite() || !file.canWrite()){
			throw new GestionFicherosException("Error. No tiene permiso para escribir en esta carpeta");
		}
		
		// Comprobamos que no exista ya ese fichero
		if (file2.exists()){
			throw new GestionFicherosException("Error. Ya existe un fichero con ese nombre");
		}
		
		// Modificamos el nombre del archivo o carpeta
		try {
			file.renameTo(file2);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error. NO se ha modificado el fichero");
		}
		
		// Actualizamos el contenido de la carpeta
		actualiza();	
		
	}

	@Override
	public boolean sePuedeEjecutar(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeEscribir(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeLeer(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColumnas(int arg0) {
		columnas = arg0;
		
	}

	@Override
	public void setDirCarpeta(String arg0) throws GestionFicherosException {
		File file = new File(arg0);
		
		// Controlamos que la dirección introducida exista y sea un directorio
		if (!file.isDirectory()){
			throw new GestionFicherosException ("Error. Se esperaba un directorio pero "
					+ file.getAbsolutePath() + " no es un directorio.");
		}
		
		// Controlamos que haya permiso de lectura para este fichero
		if(!file.canRead()){
			throw new GestionFicherosException ("Alerta. No se puede acceder a "
					+ file.getAbsolutePath() + "No hay permisos.");
		}
		
		// Asignamos a la carpeta de trabajo el nuevo valor introducido
		carpetaDeTrabajo = file;
		
		// Actualizamos el contenido de la carpeta con el metodo actualiza
		actualiza();
		
	}

	@Override
	public void setFormatoContenido(FormatoVistas arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMostrarOcultos(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrdenado(TipoOrden arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSePuedeEjecutar(String arg0, boolean arg1) throws GestionFicherosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSePuedeEscribir(String arg0, boolean arg1) throws GestionFicherosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSePuedeLeer(String arg0, boolean arg1) throws GestionFicherosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUltimaModificacion(String arg0, long arg1) throws GestionFicherosException {
		// TODO Auto-generated method stub
		
	}
	
}
