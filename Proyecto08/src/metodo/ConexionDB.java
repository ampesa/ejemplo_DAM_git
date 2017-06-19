package metodo;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection;

/* PROYECTO 08 CLASE CONEXIONDB
 * 
 * Con esta clase definimos como se ejecutará la conexión a nuestra BBDD de jugadores/usuarios
 * 
 * Hemos importado los métodos SQL necesarios. DriverManager que nos permitirá conectarnos a la BBDD,
 *  Connection para manejar la conexión a la BBDD y SQLException para manejar errores en nuestra sentencia.
 * */

public class ConexionDB {
	
	// Definimos los datos de la conexión
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	// Definimos los datos de la base de datos
	private String host; // Ubicación de la base de datos
	private String bbdd; // Identificación de la base de datos
	private String user; // Usuario con el que accederemos (normalmente root)
	private String pass; // Password de usuario
	private String url;  // Cadena que le pasaremos al DriverManager con la dirección de conexión
	
	// Conexion inicializada a null
	private Connection conexion = null; 
	
	
	// Constructor con el que pasamos los datos necesarios para la conexión
	public ConexionDB(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	
	
	// Método para conectarse con la BBDD. Devolverá true si ha logrado conectarse
	public boolean connectDB(){
		try{
			// Cargamos el controlador MySQL que efectuará el registro
			Class.forName(CONTROLADOR_MYSQL);
			
			// Nos conectamos a la BBDD
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) 
		{
			// Controlamos el error en caso de no encontrar la BBDD
			excepcionSql.printStackTrace();
			return false;
        }
		catch( ClassNotFoundException noEncontroClase) 
		{
			// Controlamos el error en caso de no econtrar el driver de conexión
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	// Creamos el getter que devolverá una instancia de la conexión para llamarla desde otras clases
	public Connection getConexion(){
		return this.conexion;
	}

}
