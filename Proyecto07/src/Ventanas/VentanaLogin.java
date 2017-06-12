/* ****************************************************
 * 
 * Proyecto06
 * 
 * Ventana de introducci�n de datos del jugador
 * 
 * ****************************************************
 * 
 * NOTAS DE LA VENTANA LOGIN PARA ESTA VERSI�N (Proyecto06)
 * 
 * 	+ Se han eliminado los listeners de cada campo de texto y se han pasado al JButton, de esta manera agilizamos el juego.
 * 	  ya no es necesario pulsar intro para capturar los datos introducidos por el jugador, sino que se capturan al pulsar 
 * 	  el bot�n "A JUGAR". 
 * 	  De paso, limpiamos el c�digo evitando un mont�n de repeticiones de public void actionPerformed (ActionEvent arg0)
 * 
 *  + Queda pendiente de revisi�n para la siguiente version introducir un FocusListener en la validaci�n de datos introducidos
 *    por el jugador.
 *  
 *  + Ahora el bot�n "A JUGAR" har� visible un objeto del tipo VentanaPrincipal, en lugar de ventana Juego
 * 
 **/

//Esta vetana est� dentro del paquete ventanas
package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador; //la ventana utilizar� la clase jugador

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

//Declaramos la clase login como una extensi�n de JFrame
public class VentanaLogin extends JFrame {
	
	//Variables de la ventana Login
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textNick;
	private JTextField textEdad;
	private VentanaJuego vJuego;
	private VentanaLogin vLogin;
	private VentanaPrincipal vPrincipal;
	private Jugador player;
	
	//constructor de la ventan Login
	public VentanaLogin() {
		
		//Creamos un nuevo objeto de la clase Jugador
		Jugador player=new Jugador ();

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
		JTextArea textValidacion = new JTextArea();
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
		
		//creamos la referencia para poder cerrar la ventana al validar los datos de manera correcta
		vLogin=this;
		
	
		
		//Creamos el boton para iniciar la validaci�n de datos y el juego
		JButton btnValidar = new JButton("A JUGAR");
		btnValidar.setBounds(90, 190, 249, 23);
		contentPane.add(btnValidar);		
		
		//a�adimos un listener sobre el bot�n A JUGAR
		btnValidar.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent arg0) {
					//para hacer m�s operativo el juego, al hacer click en el bot�n se rellenar�n los datos
					//esto adem�s permite limpiar el c�digo y evitar repeticiones innecesarias
					Jugador player = new Jugador();
					player.setNombre(textNombre.getText());
					player.setApellido1(textApellido1.getText());
					player.setApellido2(textApellido2.getText());
					player.setNick(textNick.getText());
					//comprobamos si el dato es n�merico con el m�todo isNumeric de la clase jugador
					if (player.isNumeric(textEdad.getText())==true){
						//si se cumple la condici�n y es num�rico lo convertimos en entero y se lo asignamos al jugador con setEdad
						player.setEdad(Integer.parseInt(textEdad.getText()));
						//si no es n�merico le asigno un valor que utilizaremos para identificar el error y comunicarlo al usuario
					}else {
						player.setEdad(999);
					}
					
					//al pulsar el bont�n A JUGAR mostramos el mensaje en la caja de texto textValidacion seg�n la estrucutra de comprobaci�n
					//si la Edad es incorrecta, setEdad le habr� asignado el valor 999, por lo que si getEdad es igual a 999 la edad no ser� correcta.
					if (player.getEdad()==999){
						textValidacion.setText("La EDAD no es correcta o falta. No olvide escribirla");
					//si Edad es correcta seguimos con la validaci�n del Nombre
					//si getNombre contiene est� vac�o, contiene solo espacios se lo indicaremos al usuario
					//lo mismo es aplicable al resto de camos Apellido1, Apellido2 y Nick
					}else if (player.sonEspacios(player.getNombre())){
						textValidacion.setText("Falta el NOMBRE. No olvide escribirlo");
					}else if (player.sonEspacios(player.getApellido1())){
						textValidacion.setText("Falta el APELLIDO 1. No olvide escribirlo");
					}else if (player.sonEspacios(player.getApellido2())){
						textValidacion.setText("Falta el APELLIDO 2. No olvide escribirlo");
					}else if (player.sonEspacios(player.getNick())){
						textValidacion.setText("Falta el NICK. No olvide escribirlo");
					//si no se cumple ninguna de las condiciones anteriores y los datos son correctos confirmamos al usuario que se ha creado un nuevo Jugador
					}else {				
					/* Si no se cumple ninguna de las condiciones anteriores y los datos son correctos confirmamos 
					 * al usuario que se ha creado un nuevo Jugador 
					 */
					textValidacion.setText("Nuevo Jugador: "+player.getNombre()+" "+player.getApellido1()+" "+player.getApellido2()
					+" "+player.getNick()+" de "+player.getEdad()+" a�os");

					//creamos un objeto de la clase VenanaPrincipal para lanzar la nueva vPrincipal al pulsar el JButton A JUGAR
					vPrincipal = new VentanaPrincipal();
					//Hacemos visible la vPrincipal
					vPrincipal.setVisible(true);
					// Pasamos los datos del jugador a la Ventana Principal
					vPrincipal.setJugador(player);
					//cerramos la ventana de Login para dejar solo visible la VentanaPrincipal
					vLogin.dispose();
					}
								
				}// Fin del acctionPerformed
				
		});// Fin del ActionListener
		
	}// Fin del constructor Login

} //Fin de la clase Login

/*La otra opci�n es ver cuando el JTextField pierde el foco, es decir, el usuario se va a escribir a otro sitio o pulsar alg�n bot�n o lo que sea. Se supone que si el usuario va a otra parte de la ventana, es que ha terminado de escribir y podemos revisar el texto escrito. El siguiente c�digo se entera de cuando se pierde el foco y escribe el contenido del JTextField en pantalla
textField.addFocusListener(new FocusListener() {
   public void focusLost(FocusEvent e) {
      System.out.println("Perdido foco");
      System.out.println(((JTextField)e.getSource()).getText());
   }
   public void focusGained(FocusEvent e) {
      // No hacemos nada
   }
});
Esta segunda opci�n es en general m�s c�moda para el usuario, ya que no le obliga a apretar <enter> cuando termine de escribir ni se puede olvidar de hacerlo. Sin embargo, es algo m�s delicada, puesto que el usuario puede ir a otra parte de la ventana a hacer algo cuando todav�a no ha terminado realmente de escribir todo el texto.
*/
