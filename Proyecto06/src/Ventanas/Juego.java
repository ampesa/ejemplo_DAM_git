/* ****************************************************
 * 
 * Proyecto06
 * 
 * Ventana de Juego
 * 
 * ****************************************************
 * 
 * NOTAS DE LA VENTANA JUEGO PARA ESTA VERSIÓN (Proyecto06)
 * 
 * 	+ Se ha introducido la etiqueta Puntuación, para regoger los puntos que se almacenarán en la variable puntos de la clase jugador
 * 	  Se referencian los puntos con: setText("Tu puntuación es: "+player1.getPuntos());
 * 
 * 	+ Se introduce la estructura try catch para controlar posibles errores en la carga de las imagenes de los dados con ImageIcon
 * 
 *  + Cambiamos textOperaciones a tipo JTextArea para utilizar el metodo append y añadir tecto con cada selección del jugador
 *    Le añadimos bordes al JTextArea para resaltarlo en la ventana de juego
 *    
 *  + Te has quedado mostrando los puntos
 * 
 **/

package Ventanas;

import Juego.Jugador;
//importamos la clase Login del paquete Ventanas para poder utilizar el campo Nombre (textNombre) introducido por el jugador en la ventana Login
import Ventanas.Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random; //importamos la clase random para podre generar aleatoriamente los dados

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon; //importamos la clase ImageIcon para poder utilizarla en Juego y asignar imagenes a los jlabel de cada dado
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Juego extends JFrame {
	
	private Juego vJ;
	Jugador player1=new Jugador(); //creamos un nuevo objeto de la clase jugador para utilizar sus variables en esta ventana
	
	private JPanel contentPane;
	//Establecemos JLabel lblNewLabel como una propiedad de la clase para poder trabajar con ella fuera del constructor, ampliamos su ámbito dentro de la clase
	private JLabel lblBienvenida;
	private JLabel lblPuntuacion;
	private JTextField textNombre;
	private int Puntuacion=player1.getPuntos();
	//definimos la variable textOperaciones para contener las operaciones del jugador, es un JTextArea para añadirle cada operación con el método append
	private JTextField textOperaciones; 
	private JButton mathDice;
	private JButton reIniciar;
	private JTextArea promptJugador;

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
	
	//Creamos 2 variables tipo boolean para definir si toca clickar un dado o un operador
	private boolean tocaDado=true;//esta la inicalizamos a true porque es con la que iniciaremos el proceso
	private boolean tocaOperador=false;//confirmaremos si es necesaria o podemos prescindir de ella
	
	//creamos 2 variables JButton para utilizar los botones Suma y Resta en los procesos necesarios
	private JButton btnSuma;
	private JButton btnResta;
	
	//creamos una variable de tipo objeto para almacenar el "resultado" de las operaciones y la inciamos a null
	private Object resultado=null;


	//creamos un setter para utilizar el nombre introducido por el jugador en la ventana Login
	public void setJTextField (JTextField textNombre) {
		this.textNombre=textNombre;		
		//definimos la etiqueta de la ventana juego como un setText de la cadena Bienvenido al juego + el nombre introducido por el jugador
		lblBienvenida.setText("Bienvenido al juego " + textNombre.getText());
	}
	

	//constructor de la clase Juego
	public Juego() {
		
				
		//creamos la referencia, de manera que vJ será la ventana actual. De esta manera podremos cerrarla y llamarla
		vJ=this;
		
		//definimos la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//etiqueta para el texto de bienvenida 
		lblBienvenida = new JLabel("Jugador");
		lblBienvenida.setFont(new Font("Calibri", Font.BOLD, 16));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(573, 11, 278, 40);
		contentPane.add(lblBienvenida);
		
		//con esta etiqueta mostraremos los puntos del jugador
		lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setText("Tu puntuación es: "+Puntuacion); //mostramos los puntos acumulados en la variable puntos de la clase Jugador
		lblPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuacion.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPuntuacion.setBounds(573, 47, 278, 40);
		contentPane.add(lblPuntuacion);		
		
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
		
		//creamos el objeto botón para la suma
		btnSuma = new JButton("+");
		btnSuma.setFont(new Font("Calibri", Font.BOLD, 24));
		btnSuma.setBounds(573, 115, 108, 46);
		contentPane.add(btnSuma);
		
		//creamos el objeto botón para la resta
		btnResta = new JButton("-");
		btnResta.setFont(new Font("Calibri", Font.BOLD, 24));
		btnResta.setBounds(743, 115, 108, 46);
		contentPane.add(btnResta);
		
		//campo de texto para las operaciones del jugador
		textOperaciones = new JTextField("");//incializamos JTextArea textOperaciones como una cadena vacía
		textOperaciones.setEditable(false);
		textOperaciones.setFont(new Font("Calibri", Font.BOLD, 24));
		textOperaciones.setBounds(573, 218, 278, 40);
		contentPane.add(textOperaciones);
		textOperaciones.setColumns(10);//limitamos a 9 caracteres para finalizar operaciones al introducir en número máximo de dado (5 dados + 4 operaciones)
		Border border = BorderFactory.createLineBorder(Color.BLACK); //ponemos un borde al JTextField para resaltarlo en la ventana de juego
		textOperaciones.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		//botón para comprobar si son correctas o no las operaciones del jugador
		mathDice = new JButton("MATHDICE");
		mathDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((Integer)resultado==numerosDados12+1){
					System.out.println("El dado 12 es "+(numerosDados12+1));
					promptJugador.setText("¡¡¡CORRECTO!!!\npulsa REPETIR para seguir\njugando");
					//Jugador.setPuntos();
					Puntuacion=Puntuacion+5;
					System.out.println("la puntuación es "+Puntuacion);
				}else{
					promptJugador.setText("INCORRECTO,\npulsa REPETIR para seguir\njugando");
					System.out.println("El dado 12 es "+(numerosDados12+1));
					Puntuacion=Puntuacion-5;
					System.out.println("la puntuación es "+Puntuacion);
				}
				tocaDado=false;
				tocaOperador=false;
				mathDice.removeActionListener(this);
			}
		});
		mathDice.setFont(new Font("Calibri", Font.BOLD, 24));
		mathDice.setBounds(573, 282, 278, 40);
		contentPane.add(mathDice);
		
		//Botón para reiniciar los dados y seguir jugando
		reIniciar = new JButton("REPETIR");
		// Añadimos el ActionListener para activar la funcionalidad del botón,
		// para este caso cerramos la ventana actual vJ y abrimos una nueva
		reIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vJ.setJTextField(textNombre);
				vJ.dispose(); // cerramos la ventana actual
				Juego vJ=new Juego(); // creamos un nuevo objeto de la clase juego
				vJ.setVisible(true); //pasamos el nuevo objeto a visible. 
			}
		});
		reIniciar.setFont(new Font("Calibri", Font.PLAIN, 24));
		reIniciar.setBounds(573, 344, 278, 40);
		contentPane.add(reIniciar);
		
		//Botón para mostrar menajes/instrucciones al jugador
		promptJugador = new JTextArea();
		promptJugador.setEditable(false);
		promptJugador.setLineWrap(true);
		promptJugador.setFont(new Font("Calibri", Font.PLAIN, 24));
		promptJugador.setBounds(573, 409, 278, 97);
		contentPane.add(promptJugador);
		promptJugador.setColumns(10);
		
			//Cargamos las imágenes en los arrays
		try {
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
			
		}catch (Exception e) {
			System.out.println("Falta alguna imagen");
			e.printStackTrace();
		}
		
		
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
					
			//creamos los mouse listeners para los cinco dados
			dado1.addMouseListener (new ListenerDados());
			dado2.addMouseListener (new ListenerDados());
			dado3.addMouseListener (new ListenerDados());
			dado4.addMouseListener (new ListenerDados());
			dado5.addMouseListener (new ListenerDados());
			

	} //fin del constructor
	
	//Creamos una Inner Class para implmentar los ActionListener del Mouse sobre los dados
	private class ListenerDados implements MouseListener{
		
		@Override
		public void mouseClicked (MouseEvent e){
			
			//identificamos el JLabel sobre el que hemos hecho click
			JLabel dado = (JLabel) e.getSource();
			
			//Recuperamos el "nombre" de ese JLabel para poder identificar de qué dado/imagen se trata
			// y recuperar su valor del array en el que hemos guardado el valor asignado
			int numeroDado=Integer.valueOf(dado.getName());
					
			//Después de colocar el número, si el valor de la variable tocaDado es verdadero, se desactivará el mouselistener
			//para evitar nuevos clicks del jugador, se pondrá el dado seleccionado en gris y se pasará tocaDado a false
			if (tocaDado){
				//pasamos el valor del dado al JTextField de Operaciones. Utilizamos un switch para establecer cada una de las
				//posibilidades
				switch (numeroDado){
				case 1: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados3[0]+1) ); break;
				case 2: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados3[1]+1) ); break;
				case 3: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados3[2]+1) ); break;
				case 4: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados6[0]+1) ); break;
				case 5: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados6[1]+1) ); break;
				}
				//para realizar la operacion aritmetica contenida en el JTextField podemos optar por ejecutarla en cada JButton (+/-) o por
				//ejecutarla una vez cogiendo el String y evaluando su contenido con ScriptEngineManager, par lo que necesitamos importar
				//las correspondientes clases, incluyendo ScriptException para soportar el caso en que el String no fuera una aritmética evaluable
				ScriptEngineManager manager = new ScriptEngineManager(); 
				ScriptEngine engine = manager.getEngineByName("js"); 
				try {
					resultado = engine.eval(textOperaciones.getText());
				} catch (ScriptException e1) {
					e1.printStackTrace();
				}
				System.out.println(resultado);//imprimimos el valor de result por pantalla para comprobar que se realiza correctamente la operación.

				dado.removeMouseListener(this); // eliminamos el listener para que no se pueda elegir de nuevo este (this) dado
				dado.setIcon(dadoGris); // pasamos el dado seleccionado a color gris para indicar al jugador que lo ha seleccionado y ya no puede volver a utilizarlo
				tocaDado=false;	// pasamos tocaDado a false, para que no se puedan seleccionar otros dados in haber introducido antes un operador (signo + o -)
				tocaOperador=true; // pasamos tocaOperador a true para habilitar los listeners de los botones de signo + o -
				
				// añadimos listener al botón suma, su ejecución estará condicionada a que toque poner un operador y
				// que la cadena de texto no sea de más de 9 caracteres (5 dados y 4 operadores) de lo contrario el 
				// jugador podría introducir un último signo al clickar los botones "+" o "-"
				// hacemos que el JTextField recoja en el setText el valor anterior más el nuevo
				// pasamos el valor de tocaOperador a false para que no pueda introducir más signos seguidos
				// pasamos el valor de tocaDado a true para que se pueda pulsar el siguiente dado
				btnSuma.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (tocaOperador && textOperaciones.getText().length()<9){
							textOperaciones.setText(textOperaciones.getText()+"+");
							tocaOperador=false;
							tocaDado=true;
						}
					}
				});
				// Repetimos la operación para el botón suma, de manera que el jugador podrá optar por uno u otro, pero
				// no podrá introducir ambos seguidos ya que al pulsar alguno de los dos la variable tocaOperador pasa a falso
				btnResta.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(tocaOperador && textOperaciones.getText().length()<9){
							textOperaciones.setText(textOperaciones.getText()+"-");
							tocaOperador=false;
							tocaDado=true;
						}
					}
				});				
			}//finalizamos el if


		}//finalizamos el método mouseClicked
		

		@Override
		public void mouseEntered (MouseEvent e) {}
		@Override
		public void mouseExited (MouseEvent e) {}
		@Override
		public void mousePressed (MouseEvent e) {}
		@Override
		public void mouseReleased (MouseEvent e) {}
		
	} //fin de la inner class


}//fin método main
