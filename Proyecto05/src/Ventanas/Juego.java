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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Random; //importamos la clase random para podre generar aleatoriamente los dados

import javax.swing.ImageIcon; //importamos la clase ImageIcon para poder utilizarla en Juego y asignar imagenes a los jlabel de cada dado
import javax.swing.JButton;


public class Juego extends JFrame {
	
	private JPanel contentPane;
	//Establecemos JLabel lblNewLabel como una propiedad de la clase para poder trabajar con ella fuera del constructor, ampliamos su ámbito dentro de la clase
	private JLabel lblBienvenida;
	private JTextField textNombre;
	private JTextField textField;
	private JTextField textField_1;

	//Definimos los arrays de los diferentes dados
	private ImageIcon[] dados3=new ImageIcon[3]; //los dados3 podrán tener tres valores: 1, 2 o 3
	private ImageIcon[] dados6=new ImageIcon[6]; //los dados6 podrán tener seis valores: 1, 2, 3, 4, 5 o 6
	private ImageIcon[] dados12=new ImageIcon[12]; //los dados12 podrán tener doce valores...
	private ImageIcon dadoGris;
	private Random dado=new Random();
	
	//almacenamos los numeros aleatorios de cada tipo de dados que usaremos después para realizar los cálculos
	private int[] numerosDados3=new int[3];
	private int[] numerosDados6=new int[2];
	private int numerosDados12;
	
	//Jlabel de las imagenes
	private JLabel dado1, dado2, dado3, dado4, dado5, dado6;

	
	//constructor de la clase Juego
	public Juego() {
		
		//definimos la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenida = new JLabel("Jugador");
		lblBienvenida.setFont(new Font("Calibri", Font.BOLD, 16));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(573, 29, 278, 40);
		contentPane.add(lblBienvenida);
		
		//labels para los dados
		dado1 = new JLabel("");
		dado1.setHorizontalAlignment(SwingConstants.CENTER);
		dado1.setBounds(10, 11, 150, 150);
		contentPane.add(dado1);
		
		dado2 = new JLabel("");
		dado2.setHorizontalAlignment(SwingConstants.CENTER);
		dado2.setBounds(170, 11, 150, 150);
		contentPane.add(dado2);
		
		dado3 = new JLabel("");
		dado3.setHorizontalAlignment(SwingConstants.CENTER);
		dado3.setBounds(330, 11, 150, 150);
		contentPane.add(dado3);		
		
		dado4 = new JLabel("");
		dado4.setHorizontalAlignment(SwingConstants.CENTER);
		dado4.setBounds(88, 172, 150, 150);
		contentPane.add(dado4);
		
		dado5 = new JLabel("");
		dado5.setHorizontalAlignment(SwingConstants.CENTER);
		dado5.setBounds(248, 172, 150, 150);
		contentPane.add(dado5);
		
		dado6 = new JLabel("");
		dado6.setHorizontalAlignment(SwingConstants.CENTER);
		dado6.setBounds(157, 333, 173, 173);
		contentPane.add(dado6);
		
		//botón para la suma
		JButton btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton.setBounds(573, 115, 108, 46);
		contentPane.add(btnNewButton);
		
		//botón para la resta
		JButton button = new JButton("-");
		button.setFont(new Font("Calibri", Font.BOLD, 24));
		button.setBounds(743, 115, 108, 46);
		contentPane.add(button);
		
		//campo de texto para las operaciones del jugador
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.BOLD, 24));
		textField.setBounds(573, 218, 278, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//botón para comprobar si son correctas o no las operaciones del jugador
		JButton btnNewButton_1 = new JButton("MATHDICE");
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton_1.setBounds(573, 282, 278, 40);
		contentPane.add(btnNewButton_1);
		
		//Botón para reiniciar los dados y seguir jugando
		JButton btnNewButton_2 = new JButton("REPETIR");
		btnNewButton_2.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton_2.setBounds(573, 344, 278, 40);
		contentPane.add(btnNewButton_2);
		
		//Botón para mostrar menajes/instrucciones al jugador
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 24));
		textField_1.setBounds(573, 409, 278, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
			//Cargamos las imágenes en los arrays
			for (int i=0; i<dados3.length; i++){
				dados3[i]=new ImageIcon(getClass().getResource("Imagenes/dado"+String.valueOf(i+1)+"_3.png"));
			}
			for (int i=0; i<dados6.length; i++){
				dados6[i]=new ImageIcon(getClass().getResource("Imagenes/dado"+String.valueOf(i+1)+"_6.png"));
			}
			for (int i=0; i<dados12.length; i++){
				dados12[i]=new ImageIcon(getClass().getResource("Imagenes/dadodoce_"+String.valueOf(i+1)+".png"));
			}
			dadoGris=new ImageIcon(getClass().getResource("Imagenes/dadogris.png"));
			
			//colocamos los dados de 3 caras
				for (int i=0; i<numerosDados3.length; i++) 
					numerosDados3[i]=dado.nextInt(3);
					dado1.setIcon(dados3[numerosDados3[0]]);
					dado1.setName("1");
					dado2.setIcon(dados3[numerosDados3[1]]);
					dado2.setName("2");
					dado3.setIcon(dados3[numerosDados3[2]]);
					dado3.setName("3");
			
			//colocamos los dados de 6 caras
				for (int i=0;i<numerosDados6.length; i++)
					numerosDados6[i]=dado.nextInt(6);
					dado4.setIcon(dados6[numerosDados6[0]]);
					dado4.setName("4");
					dado5.setIcon(dados6[numerosDados6[1]]);
					dado5.setName("5");
			
			//colocamos el dado de 12 caras
					numerosDados12=dado.nextInt(12);
					dado6.setIcon(dados12[numerosDados12]);
					
	}
		
		/*	//Inicializamos los botones de los dados
		private void inicializarBotones(){

			
			dado1.addMouseListener (new ListenerDados());
			dado2.addMouseListener (new ListenerDados());
			dado3.addMouseListener((new ListenerDados());
			
			//Colocamos los dados de 6 caras
			for (int i=0; i<numerosDados6.length; i++) numerosDados6[i]=dado.nextInt(6);
			dado4.nextIcon(dados6[numerosDados6[0]]);
	}*/		
	

	

	/*//Creamos un Inner Class para implmentar los ActionListener del Mouse sobre los dados
	private class ListenerDados implements MouseListener{
		
		@Override
		public void mouseClicked (MouseEvent e){
			JLabel dado = (JLabel) e-getSource();
			int numeroDado=Integer.valueOf(dado.getName());
			if (toca)
		}
	}*/
	
	//creamos un setter para utilizar el nombre introducido por el jugador en la ventana Login
	public void setJTextField (JTextField textNombre) {
		this.textNombre=textNombre;
		//definimos la etiqueta de la ventana juego como un setText de la cadena Hola + el nombre introducido por el jugador + bienvenido al juego
		lblBienvenida.setText("Bienvenido al juego " + textNombre.getText() + "\n Tu puntuación es: ");//aquí falta añadir la variable puntos
		
	}
}
