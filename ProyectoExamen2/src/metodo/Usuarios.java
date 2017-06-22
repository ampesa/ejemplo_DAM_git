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
 * Hemos importado los m�todos SQL necesarios. Connection para manejar la conexi�n a la BBDD, Statement para
 * generar y ejecutar las sentencias SQL y SQLException para manejar errores en nuestra sentencia.
 * 
 * Esta clase contiene los atributos del jugador que queremos registrar en la BBDD. El atributo id est�
 * definido como auto en la tabla usuario, por lo que no lo utilizaremos en el registro, sino que la 
 * tabla lo asignar� autom�ticamente. 
 * 
 * Cuenta adem�s con un objeto conexi�n para referenciar la conexi�n abierta en la ventana Registro y 
 * utilizarla para introducir el nuevo registro con el m�todo nuevoUsuario. Tambi�n cuenta con un objeto
 * Statement con el que ejecutaremos la orden de inserci�n lanzada desde la ventana Registro.
 * 
 * Dentro del m�todo nuevoUsuario seguimos una estructura try/catch que nos permite controlar posibles errores
 * de nuestra sentencia SQL o cualquier otro error. 
 * 
 * Contrlamos tambi�n el cierre de la conexi�n a la BBDD en caso de no quedar �rdenes (sentencias SQL) que
 * ejecutar y si dicha conexi�n permaneciera abierta.
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

	// Conexi�n a la BBDD
	private Connection conexion;
	
	// Creamos un objeto con el que ejecutar la orden sobre la BBDD
	private Statement orden = null;
	
	// Definimos un sem�foro para indicar a la vRegistro que el jugador ha sido registrado con �xito
	private static boolean registered=false;	
	
	//private static ConexionDB usuariosDB;

	
	// Constructor con la conexi�n establecida con la base de datos desde Registro
	public Usuarios (Connection c){
		this.conexion=c;
	} // fin del constructor Usuarios
	
	// Metodo para insertar nuevos registros en la base de datos
	public void nuevoJugador (String nombre, String apellido1, String apellido2, String nick, int edad){
		try {
			// Creamos la orden 
			orden = conexion.createStatement();
			
			// Definimos la orden/sentencia SQL de inserci�n
			String sqlInsert = "INSERT INTO usuario (nombre, apellido1, apellido2, nick, edad) " +
							"VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', '"+nick+"', "+edad+")";
			
			// Ejecutamos la orden
			orden.executeUpdate(sqlInsert);
			
			// Confirmamos por consola que se ha ejecutado con �xito
			System.out.println("Usuario registrado con �xito en la BBDD");
			
			// Pasamos el sem�foro registered a true los usaremos en Registro para confirmar conexi�n 
			registered=true;			
			
		}catch(SQLException se){
			// En caso de producirse un error en la ejecuci�n de la sentencia SQL
			se.printStackTrace();
		}catch(Exception e){
			// Si apareciera cualquier otro error
			e.printStackTrace();
		}finally{
			// Cerramos la conexi�n
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
		
	} // Fin del m�todo nuevoUsuario
	
	
	//M�todo que permite buscar un usuario en la base de datos
	public Jugador buscarJugador(String nombreBuscar){
		
		ResultSet rs;
		
		player=new Jugador();
		
		try{
			// Creamos la orden 
			orden = conexion.createStatement();
			
			// Definimos la orden/sentencia SQL de inserci�n
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
				//Cogera los usuarios que coincidan en nombre, apellido1, apellido2, edad y puntos, pero solo devolver� el �ltimo encontrado
				//porqu� va reescribiendo el jugador u
				System.out.println(player.getId()+" "+player.getNombre()+" "+player.getApellido1()+" "+player.getApellido2()+" "+player.getEdad()+" "+player.getPuntos()+"\n");
			}
			// Cerramos la conexi�n
			rs.close();
			return player;
		}catch(SQLException se){
			// En caso de producirse un error en la ejecuci�n de la sentencia SQL
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
	
	// Sobrecarga del m�todo buscarJugador para devolver la b�squeda en un comboBox
	public void buscarJugador(String nombreBuscar, JComboBox combo){
		
		ResultSet rs;
		
		try{
			// Creamos la orden de conexi�n
			orden = conexion.createStatement();
			
			// Definimos la sentencia SQL para la b�squeda
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
			    
			    //A�adimos el cada usuario econtrado al comboBox "combo" de manera que nos se sobreescribir� en cada bucle
			    combo.addItem(player);
			    
			    //Comprobaci�n por monitor
			    System.out.println("Coincidencias: "+player.toString()+"\n");
			    
			    setJugador(player, vRegistro);
			}
			
			// Cerramos la conexi�n
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
		
	} // Fin de la sobrecarga del m�todo buscarJugador
	
	// Sobrecarga del m�todo buscarJugador para devolver la b�squeda en un comboBox
	public void actualizarJugador (Connection c, Jugador player){
		
		try{
			// Creamos la orden de conexi�n
			orden = conexion.createStatement();
			
			// Definimos la sentencia SQL para la b�squeda
		    String sql = "UPDATE usuario "+"SET nombre = '"+player.getNombre()+"', apellido1 = '"+player.getApellido1()+
		    		"', apellido2 = '"+player.getApellido2()+"', nick = '"+player.getNick()+"', edad = "+player.getEdad()+
		    		", Puntos = "+player.getPuntos()+" WHERE id = "+player.getId();
		    
		    // Ejecutamos la sentencia SQL
		    orden.executeUpdate(sql);
		    
			// Cerramos la conexi�n
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
		
	} // Fin del m�todo actualizarJugador
	
	/*public void actualizarPuntos(Connection c, Jugador player){
		try{
			orden=(Statement) conexion.createStatement();
			String sql = "UPDATE usario SET puntos = "+player.getPuntos()+" WHERE id = "+player.getId();
		}
		
	}*/

	// M�todo para verificar que se ha registrado al jugador, lo usaremos en Registro para confirmar la inserci�n
	public static boolean isRegistered() {
		return registered;
	}
	
	// M�todo para recuperar los datos del jugador recogidos por la consulta en la BBDD
	public void setJugador (Jugador player, Registro vRegistro){
		this.player=player;
		this.vRegistro=vRegistro;
	}
	
} // Fin de la clase
