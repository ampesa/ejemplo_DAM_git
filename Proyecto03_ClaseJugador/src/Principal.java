import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

//Creamos la clase Principal, que será del tipo JFrame y heredará sus métodos
public class Principal extends JFrame {

	private JPanel contentPane;

	//lanzamos el método main, iniciamos la ventana.
	public static void main(String[] args) {
		
		//Creamos un nuevo objeto de la clase Jugador
		Jugador player1=new Jugador ();
		player1.setNombre("Edson");
		player1.setApellido1("Arantes");
		player1.setApellido2("do Nascimeto");
		player1.setNick("Pelé");
		player1.setEdad(76);
		player1.setPuntos(1282);
		player1.setId(1940);
		System.out.println(player1.toString());
		
		
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
