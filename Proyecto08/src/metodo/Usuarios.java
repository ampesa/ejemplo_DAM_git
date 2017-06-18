package metodo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

// Con esta clase interactuaremos con la tabla de la BBDD en la que tenemos los datos de los usuarios

public class Usuarios {
	
	// Definimos las variables que se relacionaran con los campos de la tabla usuario
	private String nombre="nombre";
	private String apellido1="apellido1";
	private String apellido2="apellido2";
	private String nick="nick";
	private int edad=0;

	// Conexión a la BBDD
	private Connection conexion;
	
	// Creamos un objeto con el que ejecutar la orden sobre la BBDD
	private Statement orden = null;
	
	
	//private static ConexionDB usuariosDB;
	//private static boolean connected=false;
	
	// Constructor con la conexión establecida con la base de datos desde Registro
	public Usuarios (Connection c){
		this.conexion=c;
	} // fin del constructor Usuarios
	
	// Metodo para insertar nuevos registros en la base de datos
	public void nuevoUsuario (String nombre, String apellido1, String apellido2, String nick, int edad){
		try {
			orden = conexion.createStatement();
			String sql = "INSERT INTO usuario (nombre, apellido1, apellido2, nick, edad) " +
							"VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', '"+nick+"', "+edad+")";
			orden.executeUpdate(sql);
			System.out.println("Usuario registrado con éxito en la BBDD");
			
		}catch(SQLException se){
			// En caso de producirse un error en la ejecución de la sentencia SQL
			se.printStackTrace();
		}catch(Exception e){
			// Si apareciera cualquier otro error
			e.printStackTrace();
		}finally{
			// Cerramos la conexión
			try{
				if (orden != null){
					conexion.close();
					System.out.println("Se ha cerrado la conexión a la BBDD, no hay orden de inserción de nuevos datos");
				} // Fin del if
			}catch(SQLException se){
			} // Fin del catch
			try{
				if (conexion != null){
					conexion.close();
					System.out.println("Se ha cerrado la conexión a la BBDD, no hay conexión");
				} // Fin del if
			}catch (SQLException se){
					se.printStackTrace();
				} // Fin catch
		} // Fin finally
		
	} // Fin del método nuevoUsuario

} // Fin de la clase

		/*
		//Generado el objeto
		usuariosDB=new ConexionDB("localhost","usuarios","root","SbkiFHzwK4YXYMS3");
		
		//Ejemplo para un host externo
		//usuariosDB=ConexionDB("mysql.hostinger.es","u499092340_dam20","u499092340_dam20","12345");
		
		
		//Establecemos la conexion
		connected=usuariosDB.connectDB();

        //Comprobamos si hemos conectado
		if(connected) {
			System.out.println("CONECTADOS CON EXITO");
		}
		else System.out.println("ERROR EN LA CONEXION");
	    }*/