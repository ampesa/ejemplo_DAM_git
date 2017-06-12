//Esta vetana está dentro del paquete ventanas
package Ventanas;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador; //la ventana utilizará la clase jugador

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

//Declaramos la clase login como una extensión de JFrame
public class VentanaPerfil extends JPanel {
	
	//Variables de la ventana Login
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textNick;
	private JTextField textEdad;
	private JTextField textPuntos;	
	
	private Jugador player;

	private VentanaJuego vJuego;
	private VentanaLogin vLogin;
	private VentanaPerfil vPerfil;
		

	//constructor de la VentanaPerfil
	public VentanaPerfil() {
		
		//definimos la ventana
		setBounds(100, 100, 450, 322);
		//contentPane = new JPanel();
		contentPane=this;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setLayout(null);

		//Creamos un nuevo objeto de la clase Jugador
		player=new Jugador ();		
		

		//Creamos la etiqueta principal de la ventana. La ponemos en negrita para destacarla del resto
		JLabel datosJugador = new JLabel("DATOS JUGADOR");
		datosJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		datosJugador.setBounds(160, 11, 116, 14);
		contentPane.add(datosJugador);
		
		//Creamos la etiqueta para el campo de texto Nombre
		JLabel etiquetaNombre = new JLabel("NOMBRE");
		etiquetaNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaNombre.setBounds(90, 52, 63, 14);
		contentPane.add(etiquetaNombre);
		
		//Creamos la etiqueta para el campo de texto Apellido1
		JLabel etiquetaApellido1 = new JLabel("APELLIDO 1");
		etiquetaApellido1.setBounds(90, 77, 75, 14);
		contentPane.add(etiquetaApellido1);
		
		//Creamos la etiqueta para el campo de texto Apellido2
		JLabel etiquetaApellido = new JLabel("APELLIDO 2");
		etiquetaApellido.setBounds(90, 102, 75, 14);
		contentPane.add(etiquetaApellido);
		
		//Creamos la etiqueta para el campo de texto Nick
		JLabel etiquetaNick = new JLabel("NICK");
		etiquetaNick.setBounds(90, 127, 63, 14);
		contentPane.add(etiquetaNick);
		
		//Creamos la etiqueta para el campo de texto Edad
		JLabel etiquetaEdad = new JLabel("EDAD");
		etiquetaEdad.setBounds(90, 152, 63, 14);
		contentPane.add(etiquetaEdad);
		
		//Creamos la caja de texto en la que mostraremos al usuario la validación de sus datos
		JTextArea textValidacion = new JTextArea();
		textValidacion.setWrapStyleWord(true);
		textValidacion.setLineWrap(true);
		textValidacion.setBounds(46, 271, 333, 40);
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
		
		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(90, 183, 63, 14);
		add(lblPuntos);
		
		textPuntos = new JTextField();
		textPuntos.setEditable(false);
		textPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntos.setColumns(10);
		textPuntos.setBounds(175, 180, 164, 20);
		add(textPuntos);
		
		//Creamos el boton de para validar y guardar los datos del perfil
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(90, 226, 249, 23);
		contentPane.add(btnGuardar);	
		
		//añadimos un listener sobre el botón GUARDAR
		btnGuardar.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent arg0) {
				//para hacer más operativo el juego, al hacer click en el botón se rellenarán los datos
				//esto además permite limpiar el código y evitar repeticiones innecesarias
				player.setNombre(textNombre.getText());
				player.setApellido1(textApellido1.getText());
				player.setApellido2(textApellido2.getText());
				player.setNick(textNick.getText());
				//comprobamos si el dato es númerico con el método isNumeric de la clase jugador
				if (player.isNumeric(textEdad.getText())==true){
					//si se cumple la condición y es numérico lo convertimos en entero y se lo asignamos al jugador con setEdad
					player.setEdad(Integer.parseInt(textEdad.getText()));
					//si no es númerico le asigno un valor que utilizaremos para identificar el error y comunicarlo al usuario
				}else {
					player.setEdad(999);
				}
				
				//al pulsar el bontón GUARDAR mostramos el mensaje en la caja de texto textValidacion según la estrucutra de comprobación
				//si la Edad es incorrecta, setEdad le habrá asignado el valor 999, por lo que si getEdad es igual a 999 la edad no será correcta.
				if (player.getEdad()==999){
					textValidacion.setText("La EDAD no es correcta o falta. Escríbala y pulse GUARDAR");
				//si Edad es correcta seguimos con la validación del Nombre
				//si getNombre contiene está vacío, contiene solo espacios se lo indicaremos al usuario
				//lo mismo es aplicable al resto de camos Apellido1, Apellido2 y Nick
				}else if (player.sonEspacios(player.getNombre())){
					textValidacion.setText("Falta el NOMBRE. Escríbalo y pulse GUARDAR");
				}else if (player.sonEspacios(player.getApellido1())){
					textValidacion.setText("Falta el APELLIDO 1. Escríbalo y pulse GUARDAR");
				}else if (player.sonEspacios(player.getApellido2())){
					textValidacion.setText("Falta el APELLIDO 2. Escríbalo y pulse GUARDAR");
				}else if (player.sonEspacios(player.getNick())){
					textValidacion.setText("Falta el NICK. Escríbalo y pulse GUARDAR");
				//si no se cumple ninguna de las condiciones anteriores y los datos son correctos confirmamos al usuario que se ha creado un nuevo Jugador
				}else {
					textValidacion.setText("Perfil actualizado con éxito: "+player.getNombre()+" "+player.getApellido1()+" "
							+player.getApellido2()+" "+player.getNick()+" de "+player.getEdad()+" años");
					
					//Modificamos los Valores del jugador en la VentanaJuego
					vJuego.setNombre(player.getNombre());
					//vJuego.setJugador(player, vPerfil);

					}
								
				}
				
		}); // Fin del acction listener del botón GUARDAR
		
	} // Fin del constructor Perfil
	
	// Método para obtener los datos del Jugador 
	public void setJugador(Jugador player, VentanaJuego vJuego){
		this.player=player;
		this.vJuego=vJuego;
		textNombre.setText(player.getNombre());
		textApellido1.setText(player.getApellido1());
		textApellido2.setText(player.getApellido2());
		textNick.setText(player.getNick());
		textEdad.setText(String.valueOf(player.getEdad()));
		//textID.setText(String.valueOf(player.getId()));
		textPuntos.setText(String.valueOf(player.getPuntos()));
		}
	
	// Método para Recibir los Puntos de la VentanaJuego
	public void setPuntos(int acumulado){
		player.setPuntos(acumulado);
		textPuntos.setText(String.valueOf(player.getPuntos()));
	}
	
	
} // Fin de la clase
