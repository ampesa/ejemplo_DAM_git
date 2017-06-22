package metodo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;

import java.sql.SQLException;
import Ventanas.Registro;

/* PROYECTO EXAMEN CLASE USUARIOS
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
	private int id=0;
	private String nombre="nombre";
	private String apellido1="apellido1";
	private String apellido2="apellido2";
	private String nick="nick";
	private int edad=0;
	private int puntos=0;
	
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
				} // Fin del if
			}catch(SQLException se){
			} // Fin del catch
			try{
				if (conexion != null){
					conexion.close();
				} // Fin del if
			}catch (SQLException se){
					se.printStackTrace();
				} // Fin catch
		} // Fin finally
		
	} // Fin del método nuevoUsuario
	
	
	//Método que permite buscar un usuario en la base de datos
	public Jugador buscarJugador(String nombreBuscar){
		
		ResultSet rs;
		
		player=new Jugador();
		
		try{
			// Creamos la orden 
			orden = conexion.createStatement();
			
			// Definimos la orden/sentencia SQL de inserción
			String sql = "SELECT id, nombre, apellido1, apellido2, nick, edad, puntos FROM usuario WHERE nombre='"+nombreBuscar+"'";;
	      
			// Ejecutamos la sentencia
			rs = orden.executeQuery(sql);
	      
			// Cogemos los usuarios y recorremos la BBDD mientras haya datos
			while(rs.next()){
				player.setId(rs.getInt("id"));
				player.setNombre(rs.getString("nombre"));
				player.setApellido1(rs.getString("apellido1"));
				player.setApellido2(rs.getString("apellido2"));
				player.setNick(rs.getString("nick"));
				player.setEdad(rs.getInt("edad"));
				player.setPuntos(rs.getInt("puntos"));
				//Cogera los usuarios que coincidan en nombre, apellido1, apellido2, edad y puntos, pero solo devolverá el último encontrado
				//porqué va reescribiendo el jugador u
				System.out.println(player.getId()+" "+player.getNombre()+" "+player.getApellido1()+" "+player.getApellido2()+" "+player.getEdad()+" "+player.getPuntos()+"\n");
			}
			// Cerramos la conexión
			rs.close();
			return player;
		}catch(SQLException se){
			// En caso de producirse un error en la ejecución de la sentencia SQL
			se.printStackTrace();
			return player;
		}catch(Exception e){
			// Si apareciera cualquier otro error
			e.printStackTrace();
			return player;
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
	
	// Sobrecarga del método buscarJugador para devolver la búsqueda en un comboBox
	public void buscarJugador(String nombreBuscar, JComboBox combo){
		
		ResultSet rs;
		
		try{
			// Creamos la orden de conexión
			orden = conexion.createStatement();
			
			// Definimos la sentencia SQL para la búsqueda
		    String sql = "SELECT id, nombre, apellido1, apellido2, Nick, edad, puntos FROM usuario WHERE nombre='"+nombreBuscar+"'";
		    
		    // Ejecutamos la sentencia SQL
		    rs = orden.executeQuery(sql);
		    
			//Cogemos los usuarios
			while(rs.next()){
				// Se crea un nuevo jugador para cada coincidencia
				player=new Jugador();
				
				player.setId(rs.getInt("id"));
			    player.setNombre(rs.getString("nombre"));
			    player.setApellido1(rs.getString("apellido1"));
			    player.setApellido2(rs.getString("apellido2"));
			    player.setNick(rs.getString("nick"));
			    player.setEdad(rs.getInt("edad"));
			    player.setPuntos(rs.getInt("puntos"));
			    
			    //Añadimos el cada usuario econtrado al comboBox "combo" de manera que nos se sobreescribirá en cada bucle
			    combo.addItem(player);
			    
			    //Comprobación por monitor
			    System.out.println("Coincidencias: "+player.toString()+"\n");
			    
			    setJugador(player, vRegistro);
			}
			
			// Cerramos la conexión
			rs.close();
			// Manejamos las excepciones / posibles errores
			}catch(SQLException se){
				// Si se produce un error en la consulta
				se.printStackTrace();
			}catch(Exception e){
			    // Si se produce cualquier otro error
			    e.printStackTrace();
			}finally{
			    // Cerramos los recursos
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
				}// Fin finally try
			    
			} // Fin finally
		
	} // Fin de la sobrecarga del método buscarJugador
	
	// Sobrecarga del método buscarJugador para devolver la búsqueda en un comboBox
	public void actualizarJugador (Connection c, Jugador player){
		
		try{
			// Creamos la orden de conexión
			orden = conexion.createStatement();
			
			// Definimos la sentencia SQL para la búsqueda
		    String sql = "UPDATE usuario "+"SET nombre = '"+player.getNombre()+"', apellido1 = '"+player.getApellido1()+
		    		"', apellido2 = '"+player.getApellido2()+"', nick = '"+player.getNick()+"', edad = "+player.getEdad()+
		    		", Puntos = "+player.getPuntos()+" WHERE id = "+player.getId();
		    
		    // Ejecutamos la sentencia SQL
		    orden.executeUpdate(sql);
		    
			// Cerramos la conexión
			conexion.close();
			
			// Manejamos las excepciones / posibles errores
			}catch(SQLException se){
				// Si se produce un error en la consulta
				se.printStackTrace();
			}catch(Exception e){
			    // Si se produce cualquier otro error
			    e.printStackTrace();
			}finally{
			    // Cerramos los recursos
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
				}// Fin finally try
			    
			} // Fin finally
		
	} // Fin del método actualizarJugador
	
	/*public void actualizarPuntos(Connection c, Jugador player){
		try{
			orden=(Statement) conexion.createStatement();
			String sql = "UPDATE usario SET puntos = "+player.getPuntos()+" WHERE id = "+player.getId();
		}
		
	}*/

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
