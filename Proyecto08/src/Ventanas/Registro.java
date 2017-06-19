package Ventanas;

// Importamos m�todos de la librer�a swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

// importamos otras clases con las que se relacionar� la clase Registro
import metodo.ConexionDB;
import metodo.Jugador;
import metodo.Usuarios;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Importamos los m�todos para trabajar con SQL
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


/* PROYECTO 08 CLASE REGISTRO
 * 
 * Esta clase es del tipo JFrame y define la ventana de registro de los datos del jugador
 * 
 * Los listeners iniciales de los campos de texto se han pasado al JButton, de esta manera agilizamos el juego.
 * ya no es necesario pulsar intro para capturar los datos introducidos por el jugador, sino que se comprueban y 
 * capturan al pulsar el bot�n "REGISTRAR Y JUGAR". 
 * De paso, limpiamos el c�digo evitando un mont�n de repeticiones de public void actionPerformed (ActionEvent arg0)
 * 
 * La creaci�n de la ventana Registro al ejecutar el programa desde la clase Principal crear� tambi�n una nueva 
 * conexi�n a la base de datos siguiendo los m�todos de la clase ConexionDB e insertar� el nuevo usuario a trav�s del 
 * listener del JButton "REGISTRAR Y JUGAR"
 * 
 * */

//Declaramos la clase login como una extensi�n de JFrame
public class Registro extends JFrame {
	
	//Variables de la ventana Login
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textNick;
	private JTextField textEdad;
	private JTextArea textValidacion;
	
	// Bot�n de ejecuci�n del registro
	private JButton btnRegistrar;
	
	// Elementos de interacci�n
	private VentanaJuego vJuego;
	private Registro vRegistro;
	private VentanaPrincipal vPrincipal;
	private Jugador player;
	
	// Manejadores de la base de datos
	private ConexionDB db;
	private Usuarios udb;
	private Usuarios playerdb;
	private Connection conexion;
	private boolean connected = false;
	
	
	
	//constructor de la ventan Login
	public Registro() {
		
		//Creamos un nuevo objeto de la clase Jugador
		//Jugador player=new Jugador ();
		player =new Jugador();

		//definimos la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Inicializamos los valores del Jugador
		player.setNombre("");
		player.setApellido1("");
		player.setApellido2("");
		player.setNick("");
		player.setEdad(999);
		player.setPuntos(0);
		player.setId(0);

		//Creamos la etiqueta principal de la ventana. La ponemos en negrita para destacarla del resto
		JLabel datosJugador = new JLabel("DATOS JUGADOR");
		datosJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		datosJugador.setBounds(160, 11, 116, 14);
		contentPane.add(datosJugador);
		
		//Creamos la etiqueta para el campo de texto Nombre
		JLabel etiquetaNombre = new JLabel("NOMBRE");
		etiquetaNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaNombre.setBounds(90, 49, 63, 14);
		contentPane.add(etiquetaNombre);
		
		//Creamos la etiqueta para el campo de texto Apellido1
		JLabel etiquetaApellido1 = new JLabel("APELLIDO 1");
		etiquetaApellido1.setBounds(90, 74, 75, 14);
		contentPane.add(etiquetaApellido1);
		
		//Creamos la etiqueta para el campo de texto Apellido2
		JLabel etiquetaApellido = new JLabel("APELLIDO 2");
		etiquetaApellido.setBounds(90, 99, 75, 14);
		contentPane.add(etiquetaApellido);
		
		//Creamos la etiqueta para el campo de texto Nick
		JLabel etiquetaNick = new JLabel("NICK");
		etiquetaNick.setBounds(90, 124, 63, 14);
		contentPane.add(etiquetaNick);
		
		//Creamos la etiqueta para el campo de texto Edad
		JLabel etiquetaEdad = new JLabel("EDAD");
		etiquetaEdad.setBounds(90, 149, 63, 14);
		contentPane.add(etiquetaEdad);
		
		//Creamos la caja de texto en la que mostraremos al usuario la validaci�n de sus datos
		textValidacion = new JTextArea();
		textValidacion.setWrapStyleWord(true);
		textValidacion.setLineWrap(true);
		textValidacion.setBounds(46, 224, 333, 40);
		contentPane.add(textValidacion);
		
		//Creamos el campo de texto para introducir el Nombre
		textNombre = new JTextField();
		textNombre.setBounds(175, 49, 164, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		//Creamos el campo de texto para introducir el Apellido1
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(175, 74, 164, 20);
		contentPane.add(textApellido1);
		
		//Creamos el campo de texto para introducir el Apellido2
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(175, 99, 164, 20);
		contentPane.add(textApellido2);
		
		//Creamos el campo de texto para introducir el Nick
		textNick = new JTextField();
		textNick.setColumns(10);
		textNick.setBounds(175, 124, 164, 20);
		contentPane.add(textNick);
		
		//Creamos el campo de texto para introducir la Edad
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(175, 149, 164, 20);
		contentPane.add(textEdad);
		
		//Creamos el boton para iniciar la validaci�n de datos y el juego
		btnRegistrar = new JButton("REGISTRAR Y JUGAR");
		btnRegistrar.setBounds(90, 190, 249, 23);
		contentPane.add(btnRegistrar);		
		
		//creamos la referencia para poder cerrar la ventana al validar los datos de manera correcta
		vRegistro=this;
		
		// Nos conectamos a la BBDD
		ConectarDB();
		
        //Comprobamos si hemos conectado y en ese caso a�adimos el listener RegistrarJugar
		if(connected) {
			System.out.println("CONECTADOS CON �XITO");
			textValidacion.setText("CONECTADOS CON �XITO");
			
			// Llamamos a la inner class RegistrarJugar
			RegistrarJugar();
			
		}else {
			System.out.println("ERROR EN LA CONEXI�N");
			textValidacion.setText("ERROR EN LA CONEXI�N. Revise su conexi�n y el acceso a la BBDD");
		}
				
	} // Fin del constructor Registro

	// Cramos una inner class para conectar a la BBDD cada vez que lo requiramos
	public void ConectarDB(){
		// Creamos un nuevo objeto ConexionDB para manejar la BBDD
		db = new ConexionDB ("localhost" , "usuarios" , "root" , "SbkiFHzwK4YXYMS3");
		
		// Realizamos la conexi�n
		connected=db.connectDB();
		
		// Asignamos la conexi�n establecida
		conexion = db.getConexion();
		
		// Pasamos la conexi�n a Usuarios, desde donde insertaremos los datos
		udb = new Usuarios(conexion);
	}
	
	// Creamos una inner class para el listener del bot�n REGISTRAR Y JUGAR
	public void RegistrarJugar(){
		// A�adimos un listener sobre el bot�n REGISTRAR Y JUGAR
		btnRegistrar.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent arg0) {
					// Para hacer m�s operativo el juego, al hacer click en el bot�n se rellenar�n los datos
					// Esto adem�s permite limpiar el c�digo y evitar repeticiones innecesarias
					// Jugador player = new Jugador();
					player.setNombre(textNombre.getText());
					player.setApellido1(textApellido1.getText());
					player.setApellido2(textApellido2.getText());
					player.setNick(textNick.getText());
					// Comprobamos si el dato es n�merico con el m�todo isNumeric de la clase jugador
					if (player.isNumeric(textEdad.getText())==true){
						// Si se cumple la condici�n y es num�rico lo convertimos en entero y se lo asignamos al jugador con setEdad
						player.setEdad(Integer.parseInt(textEdad.getText()));
						// Si no es n�merico le asigno un valor que utilizaremos para identificar el error y comunicarlo al usuario
					}else {
						player.setEdad(999);
					}
					
					// Al pulsar el bont�n A JUGAR mostramos el mensaje en la caja de texto textValidacion seg�n la estrucutra de comprobaci�n
					// Si la Edad es incorrecta, setEdad le habr� asignado el valor 999, por lo que si getEdad es igual a 999 la edad no ser� correcta.
					if (player.getEdad()==999){
						textValidacion.setText("La EDAD no es correcta o falta. No olvide escribirla");
					// Si Edad es correcta seguimos con la validaci�n del Nombre
					// Si getNombre contiene est� vac�o, contiene solo espacios se lo indicaremos al usuario
					// Lo mismo es aplicable al resto de camos Apellido1, Apellido2 y Nick
					}else if (player.sonEspacios(player.getNombre())){
						textValidacion.setText("Falta el NOMBRE. No olvide escribirlo");
					}else if (player.sonEspacios(player.getApellido1())){
						textValidacion.setText("Falta el APELLIDO 1. No olvide escribirlo");
					}else if (player.sonEspacios(player.getApellido2())){
						textValidacion.setText("Falta el APELLIDO 2. No olvide escribirlo");
					}else if (player.sonEspacios(player.getNick())){
						textValidacion.setText("Falta el NICK. No olvide escribirlo");
					// Si no se cumple ninguna de las condiciones anteriores y los datos son correctos confirmamos al usuario que se ha creado un nuevo Jugador
					}else {				
						// Si no se cumple ninguna de las condiciones anteriores y los datos son correctos registramos al jugador
						// en la BBDD y le confirmamos los datos de creaci�n y registro 
						// Registramos al nuevo usuario y cerramos la conexi�n con el m�todo nuevoUsuario de la clase Usuarios
						udb.nuevoJugador(textNombre.getText(), textApellido1.getText(), textApellido2.getText(), textNick.getText(), 
								Integer.valueOf(textEdad.getText()));
							
						// Si se ha registrado correctamente el jugador:	
						if (Usuarios.isRegistered()){

							// Volvemos a conectarnos a la BBDD
							ConectarDB();								
							
							// Buscamos al �ltimo jugador que coincida con el nombre introducido con el m�todo buscarJugador
							Jugador u=udb.buscarJugador(textNombre.getText());
							
							// Devolvemos por pantalla el jugador creado, insertado y consultado en la BBDD
							textValidacion.setText("Nuevo Jugador: "+u.getNombre()+" "+u.getApellido1()+" "
									+u.getApellido2()+" "+u.getNick()+" de "+u.getEdad()+
									" a�os. Se ha registrado con �xito en la BBDD con el id="+u.getId());
								
							// Creamos un objeto de la clase VenanaPrincipal para lanzar la nueva vPrincipal
							vPrincipal = new VentanaPrincipal();
							
							//Hacemos visible la vPrincipal
							vPrincipal.setVisible(true);
							
							// Pasamos los datos del jugador a la Ventana Principal
							vPrincipal.setJugador(player);
							
							// Para este proyecto 8 dejamos abierta la ventana de Registro, mostrando los mensajes de confirmaci�n 
							// o error seg�n corresponda, dejamos como comentario el cierre de la ventana
							// vRegistro.dispose();
						}else{
							textValidacion.setText("ERROR AL REGISTRAR EL USUARIO");
						}

					} // Fin del else del actionPerformed
								
				} // Fin del acctionPerformed
				
		}); // Fin del ActionListener
		
	} // Fin de la inner class RegistrarJugar
	
} //Fin de la clase Registro

