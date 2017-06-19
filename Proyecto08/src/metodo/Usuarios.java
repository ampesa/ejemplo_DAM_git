package metodo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import Ventanas.Registro;

/* PROYECTO 08 CLASE USUARIOS
 * 
 * Con esta clase interactuaremos con la tabla de la BBDD en la que tenemos los datos de los usuarios
 * 
 * Hemos importado los métodos SQL necesarios. Connection para manejar la conexión a la BBDD, Statement para
 * generar y ejecutar las sentencias SQL y SQLException para manejar errores en nuestra sentencia.
 * 
 * Esta clase contiene los atributos del jugador que queremos registrar en la BBDD. El atributo id está
 * definido como auto en la tabla usuario, por lo que no lo utilizaremos en el registro, sino que la 
 * tabla lo asignará automáticamente. 
 * 
 * Cuenta además con un objeto conexión para referenciar la conexión abierta en la ventana Registro y 
 * utilizarla para introducir el nuevo registro con el método nuevoUsuario. También cuenta con un objeto
 * Statement con el que ejecutaremos la orden de inserción lanzada desde la ventana Registro.
 * 
 * Dentro del método nuevoUsuario seguimos una estructura try/catch que nos permite controlar posibles errores
 * de nuestra sentencia SQL o cualquier otro error. 
 * 
 * Contrlamos también el cierre de la conexión a la BBDD en caso de no quedar órdenes (sentencias SQL) que
 * ejecutar y si dicha conexión permaneciera abierta.
 * */

public class Usuarios {
	
	// Definimos las variables que se relacionaran con los campos de la tabla usuario
	private int id;
	private String nombre="nombre";
	private String apellido1="apellido1";
	private String apellido2="apellido2";
	private String nick="nick";
	private int edad=0;
	
	private Jugador player;
	
	private Registro vRegistro;

	// Conexión a la BBDD
	private Connection conexion;
	
	// Creamos un objeto con el que ejecutar la orden sobre la BBDD
	private Statement orden = null;
	
	// Definimos un semáforo para indicar a la vRegistro que el jugador ha sido registrado con éxito
	private static boolean registered=false;	
	
	//private static ConexionDB usuariosDB;

	
	// Constructor con la conexión establecida con la base de datos desde Registro
	public Usuarios (Connection c){
		this.conexion=c;
	} // fin del constructor Usuarios
	
	// Metodo para insertar nuevos registros en la base de datos
	public void nuevoJugador (String nombre, String apellido1, String apellido2, String nick, int edad){
		try {
			// Creamos la orden 
			orden = conexion.createStatement();
			
			// Definimos la orden/sentencia SQL de inserción
			String sqlInsert = "INSERT INTO usuario (nombre, apellido1, apellido2, nick, edad) " +
							"VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', '"+nick+"', "+edad+")";
			
			// Ejecutamos la orden
			orden.executeUpdate(sqlInsert);
			
			/*ResultSet rs;
			player=new Jugador();
						
			// Definimos la orden/sentencia SQL de consulta
			String sqlSelect = "SELECT id FROM usuario WHERE nombre='"+nombre+
					"' AND apellido1='"+apellido1+"' AND apellido2='"+apellido2+"' AND nick='"+nick+"' AND edad="+edad;
			
			// Ejecutamos la consulta
			rs= orden.executeQuery(sqlSelect);
			player.setId(rs.getInt(id));
			
			rs.close();
			return player;*/
			
			// Confirmamos por consola que se ha ejecutado con éxito
			System.out.println("Usuario registrado con éxito en la BBDD");
			
			// Pasamos el semáforo registered a true los usaremos en Registro para confirmar conexión 
			registered=true;			
			
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
	
	
	//Método que permite buscar un usuario en la base de datos
	public Jugador buscarJugador(String nombreBuscar){
		
		ResultSet rs;
		
		Jugador u=new Jugador();
		
		try{
		  orden = conexion.createStatement();
		  
	      String sql = "SELECT id, nombre, apellido1, apellido2, nick, edad, puntos FROM usuario WHERE nombre='"+nombreBuscar+"'";;
	      
	      rs = orden.executeQuery(sql);
	      
	      //Cogemos los usuarios y recorremos la BBDD mientras haya datos
	      while(rs.next()){
	    	  u.setId(rs.getInt("id"));
		      u.setNombre(rs.getString("nombre"));
		      u.setApellido1(rs.getString("apellido1"));
		      u.setApellido2(rs.getString("apellido2"));
		      u.setNick(rs.getString("nick"));
		      u.setEdad(rs.getInt("edad"));
		      u.setPuntos(rs.getInt("puntos"));
		      //Cogera los usuarios que coincidan en nombre, apellido1, apellido2, edad y puntos, pero solo devolverá el último encontrado
		      //porqué va reescribiendo el jugador u
		      System.out.println(u.getId()+" "+u.getNombre()+" "+u.getApellido1()+" "+u.getApellido2()+" "+u.getEdad()+" "+u.getPuntos()+"\n");
	      }
	      // Cerramos la conexión
	      rs.close();
	      return u;
		}catch(SQLException se){
			// En caso de producirse un error en la ejecución de la sentencia SQL
			se.printStackTrace();
			return u;
		}catch(Exception e){
			// Si apareciera cualquier otro error
			e.printStackTrace();
			return u;
		}finally{
		    //Cerramos los recursos
		    try{
		       if(orden!=null)
		    	 orden.close();
		    }catch(SQLException se){
		    }
		    try{
		       if(conexion!=null)
		       	 conexion.close();
		    }catch(SQLException se){
		       se.printStackTrace();
		    } 
		} // Fin finally
}	
	
	// Método para verificar que se ha registrado al jugador, lo usaremos en Registro para confirmar la inserción
	public static boolean isRegistered() {
		return registered;
	}
	
	// Método para recuperar los datos del jugador recogidos por la consulta en la BBDD
	public void setJugador (Jugador player, Registro vRegistro){
		this.player=player;
		this.vRegistro=vRegistro;
	}
	
} // Fin de la clase
