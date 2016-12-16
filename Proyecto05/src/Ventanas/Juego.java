package Ventanas;

import Juego.Jugador;
//importamos la clase Login del paquete Ventanas para poder utilizar el campo Nombre (textNombre) introducido por el jugador en la ventana Login
import Ventanas.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import javax.swing.JTextField;


public class Juego extends JFrame {
	
	private JPanel contentPane;
	//Establecemos JLabel lblNewLabel como una propiedad de la clase para poder trabajar con ella fuera del constructor, ampliamos su ámbito dentro de la clase
	private JLabel lblNewLabel;
	private JTextField textNombre;

	//constructor de la clase Juego
	public Juego() {
		
		//definimos la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(24, 11, 306, 14);
		contentPane.add(lblNewLabel);
		
	}
	
	//creamos un setter para utilizar el nombre introducido por el jugador en la ventana Login
	public void setJTextField (JTextField textNombre) {
		this.textNombre=textNombre;
		//definimos la etiqueta de la ventana juego como un setText de la cadena Hola + el nombre introducido por el jugador + bienvenido al juego
		lblNewLabel.setText("Hola " +textNombre.getText()+ ", bienvenido al juego");
		
	}
}
