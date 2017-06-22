package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodo.Jugador;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	private Jugador player;
	
	//Creamos las ventanas a las aque vamos a acceder desde el menú
	private VentanaJuego vJuego = new VentanaJuego();	
	private VentanaPerfil vPerfil = new VentanaPerfil();
	
	//Identificadores de las ventanas a las que accederemos con el menú:
	final static String VENTANAJ = "Ventana Juego";
	final static String VENTANAP = "Ventana Perfil";
	

	public VentanaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		//Añadimos la barra del menú en la parte superior de la ventana
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Añadimos el menú "Menú"
		JMenu mnMen = new JMenu("Men\u00FA");
		menuBar.add(mnMen);
		
		//Añadimos el item "Juego" al menú "Menú"
		JMenuItem itemJuego = new JMenuItem("Juego");
		mnMen.add(itemJuego);
		itemJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, VENTANAJ);
			}
		});
		
		//Añadimos el item "Perfil" al menú "Menú"
		JMenuItem itemPerfil = new JMenuItem("Perfil");
		mnMen.add(itemPerfil);	
		itemPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, VENTANAP);		
			}
		});	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Añadimos las ventanas al contenedor
		contentPane.add(vJuego, VENTANAJ);
		contentPane.add(vPerfil, VENTANAP);
		
	}

	public void setJugador (Jugador player){
		this.player=player;
		vJuego.setJugador(player, vPerfil);
		vPerfil.setJugador(player, vJuego);
	}
	
}
