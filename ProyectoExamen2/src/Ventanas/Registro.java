package Ventanas;

// Importamos métodos de la librería swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

// importamos otras clases con las que se relacionará la clase Registro
import metodo.ConexionDB;
import metodo.Jugador;
import metodo.Usuarios;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Importamos los métodos para trabajar con SQL
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;



/* PROYECTO EXAMEN CLASE REGISTRO
 * 
 * Esta clase es del tipo JFrame y define la ventana de registro de los datos del jugador
 * 
 * Los listeners iniciales de los campos de texto se han pasado al JButton, de esta manera agilizamos el juego.
 * ya no es necesario pulsar intro para capturar los datos introducidos por el jugador, sino que se comprueban y 
 * capturan al pulsar el botón "REGISTRAR Y JUGAR". 
 * De paso, limpiamos el código evitando un montón de repeticiones de public void actionPerformed (ActionEvent arg0)
 * 
 * La creación de la ventana Registro al ejecutar el programa desde la clase Principal creará también una nueva 
 * conexión a la base de datos siguiendo los métodos de la clase ConexionDB e insertará el nuevo usuario a través del 
 * listener del JButton "REGISTRAR Y JUGAR"
 * 
 * */

//Declaramos la clase login como una extensión de JFrame
public class Registro extends JFrame {
	
	//Variables de la ventana Login
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textNick;
	private JTextField textEdad;
	private JTextArea textValidacion;
	
	// Botónes de ejecución
	private JButton btnRegistrar;
	private JButton btnBuscarse;
	private JButton btnJugar;
	
	// ComboBox Jugadores
	private JComboBox comboJugadores;
	private int numItems;
	
	
	// Elementos de interacción
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
	private Jugador u;
	
	
	
	// Constructor de la ventan Login
	public Registro() {
		
		// Creamos un nuevo objeto de la clase Jugador
		player =new Jugador();
		u = new Jugador();

		// definimos la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Inicializamos los valores del Jugador
		player.setNombre("");
		player.setApellido1("");
		player.setApellido2("");
		player.setNick("");
		player.setEdad(999);
		player.setPuntos(0);
		player.setId(0);

		// Creamos la etiqueta principal de la ventana. La ponemos en negrita para destacarla del resto
		JLabel datosJugador = new JLabel("DATOS JUGADOR");
		datosJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		datosJugador.setBounds(145, 11, 116, 14);
		contentPane.add(datosJugador);
		
		// Creamos la etiqueta para el campo de texto Nombre
		JLabel etiquetaNombre = new JLabel("NOMBRE");
		etiquetaNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		etiquetaNombre.setBounds(46, 73, 63, 14);
		contentPane.add(etiquetaNombre);
		
		// Creamos la etiqueta para el campo de texto Apellido1
		JLabel etiquetaApellido1 = new JLabel("APELLIDO 1");
		etiquetaApellido1.setBounds(46, 98, 75, 14);
		contentPane.add(etiquetaApellido1);
		
		// Creamos la etiqueta para el campo de texto Apellido2
		JLabel etiquetaApellido = new JLabel("APELLIDO 2");
		etiquetaApellido.setBounds(46, 123, 75, 14);
		contentPane.add(etiquetaApellido);
		
		// Creamos la etiqueta para el campo de texto Nick
		JLabel etiquetaNick = new JLabel("NICK");
		etiquetaNick.setBounds(46, 148, 63, 14);
		contentPane.add(etiquetaNick);
		
		// Creamos la etiqueta para el campo de texto Edad
		JLabel etiquetaEdad = new JLabel("EDAD");
		etiquetaEdad.setBounds(46, 173, 63, 14);
		contentPane.add(etiquetaEdad);
		
		// Creamos la caja de texto en la que mostraremos al usuario la validación de sus datos
		textValidacion = new JTextArea();
		textValidacion.setWrapStyleWord(true);
		textValidacion.setLineWrap(true);
		textValidacion.setBounds(46, 232, 333, 40);
		contentPane.add(textValidacion);
		
		// Creamos el campo de texto para introducir el Nombre
		textNombre = new JTextField();
		textNombre.setBounds(145, 67, 234, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		// Creamos el campo de texto para introducir el Apellido1
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(145, 92, 234, 20);
		contentPane.add(textApellido1);
		
		// Creamos el campo de texto para introducir el Apellido2
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(145, 117, 234, 20);
		contentPane.add(textApellido2);
		
		// Creamos el campo de texto para introducir el Nick
		textNick = new JTextField();
		textNick.setColumns(10);
		textNick.setBounds(145, 142, 234, 20);
		contentPane.add(textNick);
		
		// Creamos el campo de texto para introducir la Edad
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(145, 167, 234, 20);
		contentPane.add(textEdad);
		
		// Etiqueta para el comboBox
		JLabel etiquetaCombo = new JLabel("JUGADORES");
		etiquetaCombo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		etiquetaCombo.setBounds(46, 41, 75, 14);
		contentPane.add(etiquetaCombo);
		
		// ComboBox para mostrar los jugadores que coincidan con la búsqueda
		comboJugadores = new JComboBox();
		comboJugadores.setBounds(145, 36, 234, 20);
		contentPane.add(comboJugadores);
		

		
		// Creamos el botón para registrar al jugador, lo dejamos inactivo
		btnRegistrar = new JButton("REGISTRARSE");
		btnRegistrar.setEnabled(false);		
		btnRegistrar.setBounds(46, 198, 101, 23);
		contentPane.add(btnRegistrar);	
		btnRegistrar.addActionListener (new registrarJugador());
	
		// Creamos el botón para buscarse en la BBDD, los dejamos inactivo
		btnBuscarse = new JButton("BUSCARSE");
		btnBuscarse.setEnabled(false);
		btnBuscarse.setBounds(160, 198, 101, 23);
		contentPane.add(btnBuscarse);
		btnBuscarse.addActionListener(new BuscarseBD());
		
		// Creamos el botón para lanzar la VentanaPrincipal y empezar a jugar, lo dejamos inactivo
		btnJugar = new JButton("JUGAR");
		btnJugar.setEnabled(false);
		btnJugar.setBounds(272, 198, 107, 23);
		contentPane.add(btnJugar);
		
		// Añadimos un listener sobre el botón REGISTRAR Y JUGAR
		btnJugar.addActionListener (new Jugar()); 
		
		//creamos la referencia para poder cerrar la ventana al validar los datos de manera correcta
		vRegistro=this;
		
		// Nos conectamos a la BBDD
		ConectarDB();
		
        //Comprobamos si hemos conectado y en ese caso añadimos el listener RegistrarJugar
		if(connected) {
			System.out.println("CONECTADOS CON ÉXITO");
			textValidacion.setText("Pon tu nombre y búscate en la BBDD de jugadores o registrate para poder jugar");
			// Pasamos el botón REGISTRARSE y el botón BUSCARSE a activo
			btnRegistrar.setEnabled(true);
			btnBuscarse.setEnabled(true);

		}else {
			System.out.println("ERROR EN LA CONEXIÓN");
			textValidacion.setText("ERROR EN LA CONEXIÓN. Revisa tu conexión y el acceso a la BBDD");
		}

	} // Fin del constructor Registro

	
	
	// Creamos un método para conectar a la BBDD cada vez que lo requiramos
	public void ConectarDB(){
		// Creamos un nuevo objeto ConexionDB para manejar la BBDD
		db = new ConexionDB ("localhost" , "usuarios" , "root" , "SbkiFHzwK4YXYMS3");
		
		// Realizamos la conexión
		connected=db.connectDB();
		
		// Asignamos la conexión establecida
		conexion = db.getConexion();
		
		// Pasamos la conexión a Usuarios, desde donde insertaremos los datos
		udb = new Usuarios(conexion);
	}

	// Creamos una inner class para el listener del botón REGISTRAR Y JUGAR
	public class registrarJugador implements ActionListener {
				// Añadimos un listener sobre el botón REGISTRAR Y JUGAR
				public void actionPerformed (ActionEvent e) {
					// Para hacer más operativo el juego, al hacer click en el botón se rellenarán los datos
					// Esto además permite limpiar el código y evitar repeticiones innecesarias
					// Jugador player = new Jugador();
					player.setNombre(textNombre.getText());
					player.setApellido1(textApellido1.getText());
					player.setApellido2(textApellido2.getText());
					player.setNick(textNick.getText());
					// Comprobamos si el dato es númerico con el método isNumeric de la clase jugador
					if (player.isNumeric(textEdad.getText())==true){
						// Si se cumple la condición y es numérico lo convertimos en entero y se lo asignamos al jugador con setEdad
						player.setEdad(Integer.parseInt(textEdad.getText()));
						// Si no es númerico le asigno un valor que utilizaremos para identificar el error y comunicarlo al usuario
					}else {
						player.setEdad(999);
					}
					
					// Fijamos unos métodos de controlo mediante condicionales para verificar que los datos se han introducido
					if (player.sonEspacios(player.getNombre())){
						textValidacion.setText("Falta el NOMBRE. No olvide escribirlo");
					}else if (player.sonEspacios(player.getApellido1())){
						textValidacion.setText("Falta el APELLIDO 1. No olvide escribirlo");
					}else if (player.sonEspacios(player.getApellido2())){
						textValidacion.setText("Falta el APELLIDO 2. No olvide escribirlo");
					}else if (player.sonEspacios(player.getNick())){
						textValidacion.setText("Falta el NICK. No olvide escribirlo");
					}else if (player.getEdad()==999) {
						textValidacion.setText("La EDAD no es correcta o falta. No olvide escribirla");
					}else {				
						// Si no se cumple ninguna de las condiciones anteriores y los datos son correctos registramos al jugador
						// en la BBDD y cerramos la conexión con el método nuevoJugador de la clase Usuarios
						try{
							ConectarDB();
							
							udb.nuevoJugador(textNombre.getText(), textApellido1.getText(), textApellido2.getText(), textNick.getText(), 
									Integer.valueOf(textEdad.getText()));
						 
						}catch(Exception f){
							// Si apareciera cualquier otro error
							f.printStackTrace();
							textValidacion.setText("NO HAY CONEXIÓN A LA BBDD");
						// Si se ha registrado correctamente el jugador:
						}finally{
							if (Usuarios.isRegistered()){

								// Volvemos a conectarnos a la BBDD
								ConectarDB();								
							
								// Buscamos al último jugador que coincida con el nombre introducido con el método buscarJugador
								Jugador u=udb.buscarJugador(textNombre.getText());
							
								// Devolvemos por pantalla el jugador creado, insertado y consultado en la BBDD confirmando el registro
								textValidacion.setText("Nuevo Jugador: "+u.getNombre()+" "+u.getApellido1()+" "
										+u.getApellido2()+" "+u.getNick()+" de "+u.getEdad()+
										" años. Se ha registrado con éxito en la BBDD con el id="+u.getId());
							
								// Activamos el botón JUGAR
								btnJugar.setEnabled(true);

						}else{
							textValidacion.setText("ERROR AL REGISTRAR EL USUARIO");
						}
						}
					} // Fin del else del actionPerformed
								
				} // Fin del acctionPerformed
		
	} // Fin de la inner class RegistrarJugar
	
	

	
	public class BuscarseBD implements ActionListener {
		// Listener para el botón BUSCARSE
			public void actionPerformed(ActionEvent e) {
				// Vaciamos el ComboBox de posibles búsquedas anteriores
				comboJugadores.removeAllItems();
				
				player.setNombre(textNombre.getText());
				
				if (player.sonEspacios(player.getNombre())){
					textValidacion.setText("Falta el NOMBRE. Escríbalo para poder buscarse");
				}else{
					// Conectamos con la BBDD
					ConectarDB();
					
					// Buscamos el jugador por el nombre y enviamos las coincidencias al ComboBox
					udb.buscarJugador(textNombre.getText(),comboJugadores);
					
					numItems=comboJugadores.getItemCount(); //Número de ítems en el ComboBox
					
					// Sirve para el caso en que el nombre buscado no está en la BBDD y el Combox esté vacío
					if (numItems==0){
						textValidacion.setText("Jugador no econtrado. Revisa el nombre e inténtalo de nuevo o registrate para jugar");
					}else{
						// Si hay items en el combo activamos el listener para seleccionar al jugador
						SeleccionarJugador();
					}
					
				}
				
			}	
		
	} // Fin de la InnerClass BuscarseDB
	

	
	// Creamos el método para seleccionar al jugador en el combo Box
	public void SeleccionarJugador(){
		// Añadimos un listener que cargará los datos con el jugador seleccionado desde el ComboBox
		comboJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				u=(Jugador)comboJugadores.getSelectedItem();
				
				//Si la lista del Combox no está vacía llenaremos los campos y activaremos el botón JUGAR
				if (u!=null) {
			    textNombre.setText(u.getNombre());
				textApellido1.setText(u.getApellido1());
				textApellido2.setText(u.getApellido2());
				textNick.setText(u.getNick());
				textEdad.setText(String.valueOf(u.getEdad()));

				// Mostramos al usuario qué jugador ha seleccionado
				textValidacion.setText("El jugador seleccionado es: "+u.toString());
				System.out.println("El jugador seleccionado es: "+u.toString());
				// Activamos el botón JUGAR
				btnJugar.setEnabled(true);
				}
			}
			
		});
		
	} // Fin método SeleccionarJugador
	
	public class Jugar implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
			setJugador(player);

			System.out.println("Estás jugando con: "+player.toString());
			
			// Creamos un objeto de la clase VenanaPrincipal para lanzar la nueva vPrincipal
			vPrincipal = new VentanaPrincipal();
			
			//Hacemos visible la vPrincipal
			vPrincipal.setVisible(true);
					
			// Pasamos los datos del jugador a la Ventana Principal
			vPrincipal.setJugador(player);
						
		} // Fin del acctionPerformed
		
	} // Fin de la InnerClass Jugar
	
	public Jugador getJugador(){
		return u;
	}
	
	public void setJugador(Jugador player){
		this.player=u;
	}
	
} //Fin de la clase Registro

