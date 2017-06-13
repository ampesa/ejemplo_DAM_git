// Esta vetana está dentro del paquete ventanas
package Ventanas;


// Importamos las clases necesarias
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.DebugGraphics;
import java.awt.ComponentOrientation;

import javax.swing.ImageIcon; //importamos la clase ImageIcon para asignar imagenes a los jlabel



//Declaramos la clase Perfil como una extensión de JPANEL
public class VentanaPerfil extends JPanel {
	
	//Variables de la ventana Perfil
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textNick;
	private JTextField textEdad;
	private JTextField textPuntos;	
	private JTextArea textValidacion;
	
	// Definimos un nueva etiqueta que recogerá el avatar del usuario
	private JLabel lblAvatar;
	
	// Definimos una imagen ImageIcon para el avatar del usuario
	private ImageIcon avatar;
	
	// Jugador que recogerá los datos del usuario
	private Jugador player;
	
	// Definimos las ventanas con las que interactuará la VentanaPerfil para poder llamarlas
	private VentanaJuego vJuego;
	private VentanaLogin vLogin;
	private VentanaPerfil vPerfil;
		

	//constructor de la VentanaPerfil
	public VentanaPerfil() {
		
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		
		//definimos la ventana
		setBounds(100, 100, 950, 550);
		//contentPane = new JPanel();
		contentPane=this;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		//Creamos un nuevo objeto de la clase Jugador
		player=new Jugador ();
		
		//Se genera el gridBayLayout con el que configuraremos la ventana
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100, 100, 135, 135, 30, 135, 135, 30};
		gridBagLayout.rowHeights = new int[] {34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		

		//Creamos la etiqueta principal de la ventana. La ponemos en negrita para destacarla del resto
		JLabel datosJugador = new JLabel("DATOS JUGADOR");
		datosJugador.setHorizontalAlignment(SwingConstants.CENTER);
		datosJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_datosJugador = new GridBagConstraints();
		gbc_datosJugador.gridwidth = 4;
		gbc_datosJugador.insets = new Insets(0, 0, 5, 5);
		gbc_datosJugador.gridx = 2;
		gbc_datosJugador.gridy = 1;
		contentPane.add(datosJugador, gbc_datosJugador);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 0;
		add(label_2, gbc_label_2);
		
		
		//Creamos la etiqueta para el campo de texto Nombre
		JLabel etiquetaNombre = new JLabel("NOMBRE");
		etiquetaNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.anchor = GridBagConstraints.EAST;
		gbc_etiquetaNombre.insets = new Insets(10, 10, 10, 10);
		gbc_etiquetaNombre.gridx = 2;
		gbc_etiquetaNombre.gridy = 3;
		contentPane.add(etiquetaNombre, gbc_etiquetaNombre);
		
		
		//Creamos el campo de texto para introducir el Nombre
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.fill = GridBagConstraints.BOTH;
		gbc_textNombre.insets = new Insets(10, 5, 10, 5);
		gbc_textNombre.gridx = 3;
		gbc_textNombre.gridy = 3;
		contentPane.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.BOTH;
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 1;
		add(label_4, gbc_label_4);
		
		
		//Creamos la etiqueta para el campo de texto Apellido1
		JLabel etiquetaApellido1 = new JLabel("APELLIDO 1");
		GridBagConstraints gbc_etiquetaApellido1 = new GridBagConstraints();
		gbc_etiquetaApellido1.anchor = GridBagConstraints.EAST;
		gbc_etiquetaApellido1.insets = new Insets(10, 10, 10, 10);
		gbc_etiquetaApellido1.gridx = 2;
		gbc_etiquetaApellido1.gridy = 4;
		contentPane.add(etiquetaApellido1, gbc_etiquetaApellido1);
		
		
		//Creamos el campo de texto para introducir el Apellido1
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		GridBagConstraints gbc_textApellido1 = new GridBagConstraints();
		gbc_textApellido1.fill = GridBagConstraints.BOTH;
		gbc_textApellido1.insets = new Insets(10, 5, 10, 5);
		gbc_textApellido1.gridx = 3;
		gbc_textApellido1.gridy = 4;
		contentPane.add(textApellido1, gbc_textApellido1);
		
		JLabel label_5 = new JLabel("");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.BOTH;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 2;
		add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel("");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.BOTH;
		gbc_label_6.insets = new Insets(0, 0, 5, 0);
		gbc_label_6.gridx = 3;
		gbc_label_6.gridy = 2;
		add(label_6, gbc_label_6);
		
		
		//Creamos la etiqueta para el campo de texto Apellido2
		JLabel etiquetaApellido = new JLabel("APELLIDO 2");
		GridBagConstraints gbc_etiquetaApellido = new GridBagConstraints();
		gbc_etiquetaApellido.anchor = GridBagConstraints.EAST;
		gbc_etiquetaApellido.insets = new Insets(10, 10, 10, 10);
		gbc_etiquetaApellido.gridx = 2;
		gbc_etiquetaApellido.gridy = 5;
		contentPane.add(etiquetaApellido, gbc_etiquetaApellido);
		
		
		//Creamos el campo de texto para introducir el Apellido2
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		GridBagConstraints gbc_textApellido2 = new GridBagConstraints();
		gbc_textApellido2.fill = GridBagConstraints.BOTH;
		gbc_textApellido2.insets = new Insets(10, 5, 10, 5);
		gbc_textApellido2.gridx = 3;
		gbc_textApellido2.gridy = 5;
		contentPane.add(textApellido2, gbc_textApellido2);
		
		JLabel label_7 = new JLabel("");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.fill = GridBagConstraints.BOTH;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 2;
		gbc_label_7.gridy = 3;
		add(label_7, gbc_label_7);
		
		JLabel label_8 = new JLabel("");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.fill = GridBagConstraints.BOTH;
		gbc_label_8.insets = new Insets(0, 0, 5, 0);
		gbc_label_8.gridx = 3;
		gbc_label_8.gridy = 3;
		add(label_8, gbc_label_8);
		
		
		//Creamos la etiqueta para el campo de texto Nick
		JLabel etiquetaNick = new JLabel("NICK");
		GridBagConstraints gbc_etiquetaNick = new GridBagConstraints();
		gbc_etiquetaNick.anchor = GridBagConstraints.EAST;
		gbc_etiquetaNick.fill = GridBagConstraints.VERTICAL;
		gbc_etiquetaNick.insets = new Insets(10, 10, 10, 10);
		gbc_etiquetaNick.gridx = 2;
		gbc_etiquetaNick.gridy = 6;
		contentPane.add(etiquetaNick, gbc_etiquetaNick);
		
		
		//Creamos el campo de texto para introducir el Nick
		textNick = new JTextField();
		textNick.setColumns(10);
		GridBagConstraints gbc_textNick = new GridBagConstraints();
		gbc_textNick.fill = GridBagConstraints.BOTH;
		gbc_textNick.insets = new Insets(10, 5, 10, 5);
		gbc_textNick.gridx = 3;
		gbc_textNick.gridy = 6;
		contentPane.add(textNick, gbc_textNick);
		
		JLabel label_9 = new JLabel("");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.fill = GridBagConstraints.BOTH;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 2;
		gbc_label_9.gridy = 4;
		add(label_9, gbc_label_9);
		
		JLabel label_10 = new JLabel("");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.fill = GridBagConstraints.BOTH;
		gbc_label_10.insets = new Insets(0, 0, 5, 0);
		gbc_label_10.gridx = 3;
		gbc_label_10.gridy = 4;
		add(label_10, gbc_label_10);
		
		
		//Creamos la etiqueta para el campo de texto Edad
		JLabel etiquetaEdad = new JLabel("EDAD");
		GridBagConstraints gbc_etiquetaEdad = new GridBagConstraints();
		gbc_etiquetaEdad.anchor = GridBagConstraints.EAST;
		gbc_etiquetaEdad.fill = GridBagConstraints.VERTICAL;
		gbc_etiquetaEdad.insets = new Insets(10, 10, 10, 10);
		gbc_etiquetaEdad.gridx = 2;
		gbc_etiquetaEdad.gridy = 7;
		contentPane.add(etiquetaEdad, gbc_etiquetaEdad);
		
		
		//Creamos el campo de texto para introducir la Edad
		textEdad = new JTextField();
		textEdad.setColumns(10);
		GridBagConstraints gbc_textEdad = new GridBagConstraints();
		gbc_textEdad.fill = GridBagConstraints.BOTH;
		gbc_textEdad.insets = new Insets(10, 5, 10, 5);
		gbc_textEdad.gridx = 3;
		gbc_textEdad.gridy = 7;
		contentPane.add(textEdad, gbc_textEdad);
		
		JLabel label_11 = new JLabel("");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.fill = GridBagConstraints.BOTH;
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 2;
		gbc_label_11.gridy = 5;
		add(label_11, gbc_label_11);
		
		JLabel label_12 = new JLabel("");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.fill = GridBagConstraints.BOTH;
		gbc_label_12.insets = new Insets(0, 0, 5, 0);
		gbc_label_12.gridx = 3;
		gbc_label_12.gridy = 5;
		add(label_12, gbc_label_12);
		
		
		// Creamos la etiqueta para el campo de texto Puntos
		JLabel lblPuntos = new JLabel("Puntos");
		GridBagConstraints gbc_lblPuntos = new GridBagConstraints();
		gbc_lblPuntos.anchor = GridBagConstraints.EAST;
		gbc_lblPuntos.fill = GridBagConstraints.VERTICAL;
		gbc_lblPuntos.insets = new Insets(10, 10, 10, 10);
		gbc_lblPuntos.gridx = 2;
		gbc_lblPuntos.gridy = 8;
		add(lblPuntos, gbc_lblPuntos);
		
		
		//Campo de texto que albergará los puntos que va obteniendo el jugador
		textPuntos = new JTextField();
		textPuntos.setEditable(false);
		textPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntos.setColumns(10);
		GridBagConstraints gbc_textPuntos = new GridBagConstraints();
		gbc_textPuntos.fill = GridBagConstraints.BOTH;
		gbc_textPuntos.insets = new Insets(20, 5, 20, 5);
		gbc_textPuntos.gridx = 3;
		gbc_textPuntos.gridy = 8;
		add(textPuntos, gbc_textPuntos);
		
		JLabel label_13 = new JLabel("");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.fill = GridBagConstraints.BOTH;
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 2;
		gbc_label_13.gridy = 6;
		add(label_13, gbc_label_13);
		
		JLabel label_14 = new JLabel("");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.fill = GridBagConstraints.BOTH;
		gbc_label_14.insets = new Insets(0, 0, 5, 0);
		gbc_label_14.gridx = 3;
		gbc_label_14.gridy = 6;
		add(label_14, gbc_label_14);
		
		JLabel label_15 = new JLabel("");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.fill = GridBagConstraints.BOTH;
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 0;
		gbc_label_15.gridy = 7;
		add(label_15, gbc_label_15);
		
		
		//Creamos el boton de para validar y guardar los datos del perfil
		JButton btnGuardar = new JButton("GUARDAR");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.fill = GridBagConstraints.BOTH;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 3;
		gbc_btnGuardar.gridy = 10;
		contentPane.add(btnGuardar, gbc_btnGuardar);	
		
		JLabel label_16 = new JLabel("");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.fill = GridBagConstraints.BOTH;
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 2;
		gbc_label_16.gridy = 7;
		add(label_16, gbc_label_16);
		
		JLabel label_17 = new JLabel("");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.fill = GridBagConstraints.BOTH;
		gbc_label_17.insets = new Insets(0, 0, 5, 0);
		gbc_label_17.gridx = 3;
		gbc_label_17.gridy = 7;
		add(label_17, gbc_label_17);
		
		JLabel label_18 = new JLabel("");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.fill = GridBagConstraints.BOTH;
		gbc_label_18.insets = new Insets(0, 0, 0, 5);
		gbc_label_18.gridx = 0;
		gbc_label_18.gridy = 8;
		add(label_18, gbc_label_18);

		
		//Creamos la caja de texto en la que mostraremos al usuario la validación de sus datos
		textValidacion = new JTextArea();
		textValidacion.setWrapStyleWord(true);
		textValidacion.setLineWrap(true);
		GridBagConstraints gbc_textValidacion = new GridBagConstraints();
		gbc_textValidacion.gridwidth = 2;
		gbc_textValidacion.fill = GridBagConstraints.BOTH;
		gbc_textValidacion.insets = new Insets(0, 0, 0, 5);
		gbc_textValidacion.gridx = 3;
		gbc_textValidacion.gridy = 11;
		contentPane.add(textValidacion, gbc_textValidacion);
		
		JLabel label_19 = new JLabel("");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.fill = GridBagConstraints.BOTH;
		gbc_label_19.insets = new Insets(0, 0, 0, 5);
		gbc_label_19.gridx = 2;
		gbc_label_19.gridy = 8;
		add(label_19, gbc_label_19);
		
		JLabel label_20 = new JLabel("");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.fill = GridBagConstraints.BOTH;
		gbc_label_20.gridx = 3;
		gbc_label_20.gridy = 8;
		add(label_20, gbc_label_20);

		
		// Creamos la etiqueta lbsAvatar que albergará la imagen del usuario
		lblAvatar = new JLabel("");
		GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
		gbc_lblAvatar.gridheight = 6;
		gbc_lblAvatar.gridwidth = 2;
		gbc_lblAvatar.insets = new Insets(20, 20, 20, 20);
		gbc_lblAvatar.gridx = 4;
		gbc_lblAvatar.gridy = 3;
		add(lblAvatar, gbc_lblAvatar);
		
		// Creamos un objeto avatar del tipo ImageIcon y cargamos el avatar el avatar del usuario
		avatar = new ImageIcon(getClass().getResource("Imagenes/perfil2.png"));
		
		// Asignamos el avatar al JLabel lblAvatar
		lblAvatar.setIcon(avatar);
		
		
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
