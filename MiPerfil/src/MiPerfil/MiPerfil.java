package MiPerfil;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MiPerfil extends JFrame {

	private JPanel contentPane;
	private JTextField cajaNombre;
	private JLabel etiquetaApellidos;
	private JTextField cajaApellidos;
	private JLabel etiquetaEdad;
	private JTextField cajaEdad;
	private JLabel etiquetaEmail;
	private JTextField cajaEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiPerfil ventana = new MiPerfil();
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MiPerfil() {
		
		// Introducimos Strings para utilizarlos cumplimentando cada caja para que aparezca ya completada al ejecutar
		// también podría dejar las cajas vacías y dejar que el "usuario" las complete. 
		String nombre="Amadeo";
		String apellidos="Penella Santarremigia";
		String edad="39";
		String email="penella.amadeo@gmail.com";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Etiqueta con Nombre
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setBounds(10, 11, 46, 14);
		contentPane.add(etiquetaNombre);
		
		// Caja para poner el Nombre
		cajaNombre = new JTextField(nombre);
		cajaNombre.setBounds(10, 31, 133, 20);
		contentPane.add(cajaNombre);
		cajaNombre.setColumns(10);
		
		// Etiqueta con Apellidos
		etiquetaApellidos = new JLabel("Apellidos");
		etiquetaApellidos.setBounds(10, 72, 59, 14);
		contentPane.add(etiquetaApellidos);
		
		// Caja para poner apellidos
		cajaApellidos = new JTextField(apellidos);
		cajaApellidos.setBounds(10, 97, 214, 20);
		contentPane.add(cajaApellidos);
		cajaApellidos.setColumns(10);
		
		// Etiqueta con Edad
		etiquetaEdad = new JLabel("Edad");
		etiquetaEdad.setBounds(10, 137, 46, 14);
		contentPane.add(etiquetaEdad);
		
		// Caja para poner Edad
		cajaEdad = new JTextField(edad);
		cajaEdad.setBounds(10, 162, 46, 20);
		contentPane.add(cajaEdad);
		cajaEdad.setColumns(10);
		
		// Etiqueta con Email
		etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setBounds(10, 199, 46, 14);
		contentPane.add(etiquetaEmail);
		
		// Caja para poner el Email
		cajaEmail = new JTextField(email);
		cajaEmail.setBounds(10, 224, 192, 20);
		contentPane.add(cajaEmail);
		cajaEmail.setColumns(10);
		
				

	}
}
