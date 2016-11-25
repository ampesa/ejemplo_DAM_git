import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

//Creamos la clase Principal, que será del tipo JFrame y heredará sus métodos
public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textNick;
	private JTextField textEdad;
	
	//Creamos un nuevo objeto de la clase Jugador
	Jugador player1=new Jugador ();
	
	//lanzamos el método main, iniciamos la ventana.
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//creamos un objeto de la clase Principal y lo hacemos visible (setVisible(true))
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//constructor
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		player1.setNombre("");
		player1.setApellido1("");
		player1.setApellido2("");
		player1.setNick("");
		player1.setEdad(999);
		player1.setPuntos(0);
		player1.setId(0);

		//Creamos la etiqueta principal de la ventana. La ponemos en negrita para destacarla del resto
		JLabel datosJugador = new JLabel("DATOS JUGADOR");
		datosJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		datosJugador.setBounds(160, 11, 116, 14);
		contentPane.add(datosJugador);
		
		//Creamos la etiqueta para el campo de texto Nombre
		JLabel etiquetaNombre = new JLabel("NOMBRE");
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
		
		//Creamos la caja de texto en la que mostraremos al usuario la validación de sus datos
		JTextArea textValidacion = new JTextArea();
		textValidacion.setBounds(46, 224, 333, 40);
		contentPane.add(textValidacion);
		
		//Creamos el campo de texto para introducir el Nombre
		textNombre = new JTextField();
		textNombre.setBounds(175, 49, 164, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		//añadimos un listener sobre el campo textNombre esperando el intro
		textNombre.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent arg0) {
					//al hacer intro se rellena el Nombre
					player1.setNombre(textNombre.getText());
				}
		});
		
		//Creamos el campo de texto para introducir el Apellido1
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(175, 74, 164, 20);
		contentPane.add(textApellido1);
		//añadimos un listener sobre el campo textApellido1 esperando el intro
		textApellido1.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent arg0) {
					//al hacer intro se rellena el Apellido1
					player1.setApellido1(textApellido1.getText());
				}
		});
		
		//Creamos el campo de texto para introducir el Apellido2
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(175, 99, 164, 20);
		contentPane.add(textApellido2);
		//añadimos un listener sobre el campo textApellido2 esperando el intro
		textApellido2.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent arg0) {
					//al hacer intro se rellena el Apellido2
					player1.setApellido2(textApellido2.getText());
				}
		});
		
		//Creamos el campo de texto para introducir el Nick
		textNick = new JTextField();
		textNick.setColumns(10);
		textNick.setBounds(175, 124, 164, 20);
		contentPane.add(textNick);
		//añadimos un listener sobre el campo textNick esperando el intro
		textNick.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent arg0) {
					//al hacer intro se rellena el Nick
					player1.setNick(textNick.getText());
				}
		});
		
		//Creamos el campo de texto para introducir la Edad
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(175, 149, 164, 20);
		contentPane.add(textEdad);
		//añadimos un listener sobre el campo textEdad esperando el intro
		textEdad.addActionListener (new ActionListener() {
			// al hacer intro se rellena el dato del jugador	
			public void actionPerformed (ActionEvent arg0) {
					//comprobamos si el dato es númerico con el método isNumeric de la clase jugador
					if (player1.isNumeric(textEdad.getText())==true){
						//si se cumple la condición y es numérico lo convertimos en entero y se lo asignamos al jugador con setEdad
						player1.setEdad(Integer.parseInt(textEdad.getText()));
						//si no es númerico le asigno un valor que utilizaremos para identificar el error y comunicarlo al usuario
					}else {
						player1.setEdad(999);
					}
				}
		});
		
		
		//Creamos el boton de para iniciar la validación de datos y el juego
		JButton btnValidar = new JButton("A JUGAR");
		//añadimos un listener sobre el botón A JUGAR
		btnValidar.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent arg0) {
				//al pulsar el bontón A JUGAR mostramos el mensaje en la caja de texto textValidacion según la estrucutra de comprobación
				//si la Edad es incorrecta, setEdad le habrá asignado el valor 999, por lo que si getEdad es igual a 999 la edad no será correcta.
				if (player1.getEdad()==999){
					textValidacion.setText("La EDAD no es correcta o falta. No olvide pulsar intro");
				//si Edad es correcta seguimos con la validación del Nombre
				//si getNombre contiene está vacío, contiene solo espacios se lo indicaremos al usuario
				//lo mismo es aplicable al resto de camos Apellido1, Apellido2 y Nick
				}else if (player1.sonEspacios(player1.getNombre())){
					textValidacion.setText("Falta el NOMBRE. Escríbalo y pulse intro");
				}else if (player1.sonEspacios(player1.getApellido1())){
					textValidacion.setText("Falta el APELLIDO 1. Escríbalo y pulse intro");
				}else if (player1.sonEspacios(player1.getApellido2())){
					textValidacion.setText("Falta el APELLIDO 2. Escríbalo y pulse intro");
				}else if (player1.sonEspacios(player1.getNick())){
					textValidacion.setText("Falta el NICK. Escríbalo y pulse intro");
				//si no se cumple ninguna de las condiciones anteriores y los datos son correctos confirmamos al usuario que se ha creado un nuevo Jugador
				}else {
					textValidacion.setText("Nuevo Jugador: "+player1.getNombre()+" "+player1.getApellido1()+" "+player1.getApellido2()+" "+player1.getNick()+" de "+player1.getEdad()+" años");
				}
				}
		});
		
		btnValidar.setBounds(90, 190, 249, 23);
		contentPane.add(btnValidar);
	}
}
