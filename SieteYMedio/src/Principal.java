import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {
	// variables o propiedades
	private JPanel contentPane;

	// la entrada a nuestro programa
	//es el método main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * constructor
	 */
	public Principal() {
		
		//las propiedades de nuestra ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*
		 * Nuestro código
		 * */
		 //tipo nombreVariable= new tipo();
		Carta sieteBastos= new Carta();
		sieteBastos.setNumero(-5);
		sieteBastos.setPalo("PACO");
		System.out.println("Tengo una carta que es el "+sieteBastos.getNumero()+" su palo es "+sieteBastos.getPalo());
		
		/* ESTO ESTÁ COMENTADO
		 * ********************
		Carta unoOros= new Carta();
		unoOros.numero=1;
		unoOros.palo="OROS";
		System.out.println("Tengo una carta que es el "+unoOros.numero+" su palo es "+unoOros.palo);
		
		Carta c1= new Carta();
		c1.numero=12;
		c1.palo="COPAS";
		System.out.println("Tengo una carta que es el "+c1.numero+" su palo es "+c1.palo);
		***********************
		*/
		
	}

}
