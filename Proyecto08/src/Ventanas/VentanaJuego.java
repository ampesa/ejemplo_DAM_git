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
 * 	+ Se ha introducido la etiqueta Puntuación y la variable acumulado, para regoger los puntos que se almacenarán en la variable puntos de la clase jugador
 * 	  Se referencian los puntos con: setText("Tu puntuación es: "+player1.getPuntos());
 * 
 * 	+ Se introduce la estructura try catch para controlar posibles errores en la carga de las imagenes de los dados con ImageIcon
 * 
 *  + Cambiamos textOperaciones a tipo JTextArea y añadir texto con cada selección del jugador
 *    Le añadimos bordes al JTextArea para resaltarlo en la ventana de juego
 *    
 *  + Se han creado métodos e inner class para reiniciar procesos sin reiniciar la ventana
 *  
 *  + Se ha introducido el método eval de la clase EngineManager para comprobar la operación del jugador 
 * 
 **/

package Ventanas;

/* Importamos la clase Login del paquete Ventanas para poder utilizar el campo Nombre (textNombre) introducido 
 * por el jugador en la ventana Login 
 **/
import Ventanas.Registro;
import metodo.Jugador;

import java.awt.Color;

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
import javax.swing.ImageIcon; //importamos la clase ImageIcon para asignar imagenes a los jlabel de cada dado
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaJuego extends JPanel {

	private JPanel contentPane;
	//Establecemos JLabel lblNewLabel como una propiedad de la clase para poder trabajar con ella fuera del constructor, ampliamos su ámbito dentro de la clase
	private Jugador player;
	private JLabel lblBienvenida;
	private JLabel lblPuntuacion;
	private JTextField textNombre;
	private int acumulado=0;
	// Definimos la variable textOperaciones para contener las operaciones del jugador, es un JTextArea para añadirle cada operación con el método append
	private JTextField textOperaciones; 
	// Definimos el boton de juego mathDice
	private JButton mathDice;
	// Definimos el botón para reiniciar los dados
	private JButton reIniciar;
	// Definimos una caja de texto para mostrar mensajes al jugador sobre el juego
	private JTextArea promptJugador;

	// Definimos los arrays de los diferentes dados
	private ImageIcon[] dados3=new ImageIcon[3]; //los dados3 podrán tener tres valores: 1, 2 o 3
	private ImageIcon[] dados6=new ImageIcon[6]; //los dados6 podrán tener seis valores: 1, 2, 3, 4, 5 o 6
	private ImageIcon[] dados12=new ImageIcon[12]; //los dados12 podrán tener doce valores...
	private ImageIcon dadoGris;
	private Random dado=new Random(); //definimos la variable dado de tipo Random para asignar valores aleatorios a los dados
	
	// Almacenamos los numeros aleatorios de cada tipo de dados que usaremos después para realizar los cálculos
	private int[] numerosDados3=new int[3];
	private int[] numerosDados6=new int[2];
	private int numerosDados12;
	
	// Definimos los Jlabel de las imagenes
	private JLabel dado1, dado2, dado3, dado4, dado5, dado6;
	
	// Creamos 2 variables tipo boolean para definir si toca clickar un dado o un operador
	private boolean tocaDado=true; // esta la inicalizamos a true porque es con la que iniciaremos el proceso
	private boolean tocaOperador=false; // la iniciamos a false puesto que empezaremos a jugar con toca dado
	
	//creamos 2 variables JButton para utilizar los botones Suma y Resta en los procesos necesarios
	private JButton btnSuma;
	private JButton btnResta;
	
	//creamos una variable de tipo objeto para almacenar el "resultado" de las operaciones y la iniciamos a null
	private Object resultado=null;
	private VentanaPerfil vPerfil;
	private VentanaJuego vJuego;
		
		
	//CONSTRUCTOR
	public VentanaJuego() {

		// Definimos la ventana de Juego
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 550);
		//contentPane = new JPanel();
		contentPane=this;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		setLayout(null);
		
		player=new Jugador();
		
		// ETIQUETA BIENVENIDA
		// Identificamos al Jugador 
		lblBienvenida = new JLabel("Bienvenid@");
		lblBienvenida.setFont(new Font("Calibri", Font.BOLD, 16));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(573, 11, 278, 40);
		contentPane.add(lblBienvenida);
		
		// ETIQUETA PUNTUACIÓN
		// Muestra los puntos del jugador
		lblPuntuacion = new JLabel("Puntuacion");
		//mostramos los puntos iniciales en la variable puntos de la clase Jugador
		//lblPuntuacion.setText("Tu puntuación es: "); 
		lblPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuacion.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPuntuacion.setBounds(573, 47, 278, 40);
		contentPane.add(lblPuntuacion);		
		
		// ETIQUETAS PARA UBICAR LOS DADOS
		// Del 1 al 3 para los de tres caras, el 4 y el 5 para los de seis caras y el 6 para el de doce caras
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

		
		// BOTÓN PARA LA SUMA
		btnSuma = new JButton("+");
		btnSuma.setFont(new Font("Calibri", Font.BOLD, 24));
		btnSuma.setBounds(573, 115, 108, 46);
		contentPane.add(btnSuma);
		
		// BOTÓN PARA LA RESTA
		btnResta = new JButton("-");
		btnResta.setFont(new Font("Calibri", Font.BOLD, 24));
		btnResta.setBounds(743, 115, 108, 46);
		contentPane.add(btnResta);
		
		// CAMPO DE TEXTO PARA LAS OPERACIONES
		// Creamos el campo de texto para las operaciones del jugador
		// Incializamos JTextArea textOperaciones como una cadena vacía
		textOperaciones = new JTextField(""); 
		// Evitamos que el jugador pueda introducir cualquier texto en este campo, solo podrá hacerlo con los dados o los botones
		textOperaciones.setEditable(false); 
		textOperaciones.setFont(new Font("Calibri", Font.BOLD, 24));
		textOperaciones.setBounds(573, 218, 278, 40);
		contentPane.add(textOperaciones);
		textOperaciones.setColumns(10);
		// Ponemos un borde al JTextField para resaltarlo en la ventana de juego
		Border border = BorderFactory.createLineBorder(Color.BLACK); 
		textOperaciones.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		// BOTÓN MATHDICE
		// Al pulsarlo el jugador comprueba si su operación es correcta
		mathDice = new JButton("MATHDICE");	
		// Utilizamos mathAddListener para activar el botón MATHDICE
		mathAddListener();
		mathDice.setFont(new Font("Calibri", Font.BOLD, 24));
		mathDice.setBounds(573, 282, 278, 40);
		contentPane.add(mathDice);
		
		// BOTÓN REPETIR
		// Reinicia los dados para seguir jugando
		// Resetea los textos de operaciones y del promptJugador
		// Pasa tocaDado a true para poder volver a seleccionar dados
		// reactiva el botón MATHDICE
		reIniciar = new JButton("REPETIR");
		// Añadimos el ActionListener para activar la funcionalidad del botón,
		// para este caso utilizamos el método reiniciarDados para volver a cargarlos y reactivar los listeners de los JLabel
		reIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reiniciaDados();
				textOperaciones.setText("");
				promptJugador.setText("");
				tocaDado=true;
				mathAddListener();
				
			}
		});
		reIniciar.setFont(new Font("Calibri", Font.PLAIN, 24));
		reIniciar.setBounds(573, 344, 278, 40);
		contentPane.add(reIniciar);
		
		// PROMPT JUGADOR
		// Área de texto para mostrar menajes/instrucciones al jugador
		promptJugador = new JTextArea();
		// Impedimos que el jugador pueda introducir texto aquí, este área es solo para mostrarle instrucciones
		// y dar feedback sobre el resultado
		promptJugador.setEditable(false);
		promptJugador.setLineWrap(true);
		promptJugador.setFont(new Font("Calibri", Font.PLAIN, 24));
		promptJugador.setBounds(573, 409, 278, 97);
		contentPane.add(promptJugador);
		promptJugador.setColumns(10);
		
		// Cargamos los dados en la ventana Juego inicial con reiniciaDados
		reiniciaDados ();

	} // Fin del constructor
	
	// REINICIADADOS
	// creamos el metodo reinicia dados para cargarlos tanto al iniciar la ventana como al pulsar en el botón  REPETIR
	private void reiniciaDados () {
	// Cargamos las imágenes en los arrays
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
	
		// Colocamos los dados de 3 caras
			for (int i=0; i<numerosDados3.length; i++) 
				numerosDados3[i]=dado.nextInt(3);
				dado1.setIcon(dados3[numerosDados3[0]]);
				dado1.setName("1");
				dado2.setIcon(dados3[numerosDados3[1]]);
				dado2.setName("2");
				dado3.setIcon(dados3[numerosDados3[2]]);
				dado3.setName("3");
		
		// Colocamos los dados de 6 caras
			for (int i=0;i<numerosDados6.length; i++)
				numerosDados6[i]=dado.nextInt(6);
				dado4.setIcon(dados6[numerosDados6[0]]);
				dado4.setName("4");
				dado5.setIcon(dados6[numerosDados6[1]]);
				dado5.setName("5");
		
		// Colocamos el dado de 12 caras
				numerosDados12=dado.nextInt(12);
				dado6.setIcon(dados12[numerosDados12]);
				
		// Creamos los mouse listeners para los cinco dados
		dado1.addMouseListener (new ListenerDados());
		dado2.addMouseListener (new ListenerDados());
		dado3.addMouseListener (new ListenerDados());
		dado4.addMouseListener (new ListenerDados());
		dado5.addMouseListener (new ListenerDados());
		
				
	}
	
	// INNER CLASS LISTENERDADOS
	// Creamos una Inner Class para implmentar los ActionListener del Mouse sobre los dados
	private class ListenerDados implements MouseListener{
		
		@Override
		public void mouseClicked (MouseEvent e){
			
			// Identificamos el JLabel sobre el que hemos hecho click
			JLabel dado = (JLabel) e.getSource();
			
			// Recuperamos el "nombre" de ese JLabel para poder identificar de qué dado/imagen se trata
			// y recuperar su valor del array en el que hemos guardado el valor asignado
			int numeroDado=Integer.valueOf(dado.getName());
					
			// Después de colocar el número, si el valor de la variable tocaDado es verdadero, se desactivará el mouselistener
			// para evitar nuevos clicks del jugador, se pondrá el dado seleccionado en gris y se pasará tocaDado a false
			if (tocaDado) {
				// Pasamos el valor del dado al JTextField de Operaciones. Utilizamos un switch para establecer cada una de las
				// posibilidades
				switch (numeroDado) {
				case 1: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados3[0]+1) ); break;
				case 2: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados3[1]+1) ); break;
				case 3: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados3[2]+1) ); break;
				case 4: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados6[0]+1) ); break;
				case 5: textOperaciones.setText( textOperaciones.getText() + String.valueOf(numerosDados6[1]+1) ); break;
				}
				// Para realizar la operacion aritmetica contenida en el JTextField podemos optar por ejecutarla en cada JButton (+/-) o por
				// ejecutarla una vez cogiendo el String y evaluando su contenido con ScriptEngineManager, par lo que necesitamos importar
				// las correspondientes clases, incluyendo ScriptException para soportar el caso en que el String no fuera una aritmética evaluable
				ScriptEngineManager manager = new ScriptEngineManager(); 
				ScriptEngine engine = manager.getEngineByName("js"); 
				try {
					resultado = engine.eval(textOperaciones.getText());
				} catch (ScriptException e1) {
					e1.printStackTrace();
				}
				
				// Eliminamos el listener para que no se pueda elegir de nuevo este (this) dado
				dado.removeMouseListener(this); 
				// Pasamos el dado seleccionado a color gris para indicar al jugador que lo ha seleccionado y ya no puede volver a utilizarlo
				dado.setIcon(dadoGris); 
				// Pasamos tocaDado a false, para que no se puedan seleccionar otros dados in haber introducido antes un operador (signo + o -)
				tocaDado=false;	
				// Pasamos tocaOperador a true para habilitar los listeners de los botones de signo + o -
				tocaOperador=true; 
				
				// LISTENER BOTÓN SUMA
				// Añadimos listener al botón suma, su ejecución estará condicionada a que toque poner un operador y
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
				
				// LISTENER BOTON RESTA
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
			} // Finalizamos el if


		} // Finalizamos el método mouseClicked
		

		//@Override
		public void mouseEntered (MouseEvent e) {}
		//@Override
		public void mouseExited (MouseEvent e) {}
		//@Override
		public void mousePressed (MouseEvent e) {}
		//@Override
		public void mouseReleased (MouseEvent e) {}
		
	} // Fin de la inner class listenerDados

	// LISTENER BOTON MATHDICE
	// Creamos un metodo para activar el listener del botón mathDice al iniciar la ventana y cada vez que pulsemos REPETIR
	private void mathAddListener (){
		// Añadimos el listener sobre el botón
		mathDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Si "resultado" es un numero entero igual que el número aleatorio del dado de 12 caras
				// (+1 para convertir el aleatorio de 0 a 11 en el valor mostrado por la imagen del dado)
				// el área de texto para informar al jugador mostrará correcto y sumaremos 1 punto a la puntuación del jugador
				if ((Integer)resultado==numerosDados12+1){
					// Le confirmamos al jugador que ha acertado y le invitamos a seguir jugando
					promptJugador.setText("¡¡¡CORRECTO!!!\npulsa REPETIR para seguir\njugando");
					// Sumamos 1 punto a los puntos del jugador
					player.setPuntos(acumulado+1);
					// Pasamos los puntos al acumulado, de manera que se incremente en 1 para el siguiente acierto
					// cuando pasemos su valor a la siguiente ventana
					acumulado=player.getPuntos();
					// Mostramos al jugador los puntos que lleva
					lblPuntuacion.setText("Tu puntuación es: "+player.getPuntos());
					// Actualizamos los puntos de la VentanaPerfil
					vPerfil.setPuntos(acumulado);
				}else{
					// En cualquier otro caso el resultado no será correcto, se lo mostraremos al jugador y no sumaremos puntos
					promptJugador.setText("INCORRECTO,\npulsa REPETIR para seguir\njugando");
				}
				
				// Tras pulsar el botón MATHDICE no podremos seleccionar más dados ni operaciones
				tocaDado=false;
				tocaOperador=false;
				
				// Retiramos el listener del botón MATHDICE para evitar que el jugador pueda multip
				mathDice.removeActionListener(this);
			}
		});	
	} // Fin método mathAddListener

	// Método para recoger el Nombre de la Ventana Login a la VentanaJuego y los Puntos desde VentanaPerfil
	public void setJugador(Jugador player, VentanaPerfil vPerfil){
		this.player=player;
		this.vPerfil=vPerfil;
		lblBienvenida.setText("Bienvenid@ al Juego: " +player.getNombre());
		lblPuntuacion.setText("Tu Puntuación es: " +String.valueOf(player.getPuntos()));
	}

	// Método para recoger el nombre actualizado desde la VentanaPerfil
	public void setNombre (String nombre) {
		player.setNombre(nombre);
		lblBienvenida.setText("Bienvenid@ al Juego: " +player.getNombre());
	}

	
	/*
	public void setJugador(Jugador player) {
		this.player=player;
	}*/
	

} // Fin método main
