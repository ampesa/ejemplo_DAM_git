import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//añadimos extends JFrame
public class VentanaPrincipal extends JFrame{
	
	//layout
	private JPanel contentPane;
	private JTextField txtform;
	private JTextField txtMsg;
	private JTextArea textArea;
	private JButton btnComprobación;
	
	//definimos las características en el constructor. 

	public VentanaPrincipal() {
		setTitle("Mi Ventana");	
		//propiedades necesarias para lanzar nuestra ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//dimensiones de la ventana
		setBounds(100, 100, 400, 300);
		//añadimos un layout
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//lo añadimos al JFrame
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//nuestra primera etiqueta
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setBounds(162, 11, 46, 14);
		etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 11));
		etiquetaNombre.setText("Paco");
		contentPane.add(etiquetaNombre);
		
		
		//nuevo JTextField
		txtform = new JTextField();
		txtform.setText("escribe algo");
		txtform.setBounds(10, 36, 364, 20);
		contentPane.add(txtform);
		txtform.setColumns(10);
		
		//nuevo texto mensaje
		txtMsg = new JTextField();
		txtMsg.setText("escribe ago");
		txtMsg.setBounds(10, 230, 364, 20);
		contentPane.add(txtMsg);
		txtMsg.setColumns(10);
		
		//nuevo botón
		btnComprobación = new JButton("Comprobar");
		//Evento addActionListener
		btnComprobación.addActionListener(new ActionListener() {
			//Qué hacemos cuando nos llega un evento
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnComprobación.setBounds(10, 67, 158, 23);
		contentPane.add(btnComprobación);
		
		//nueva área de texto
		textArea = new JTextArea();
		textArea.setBounds(10, 101, 364, 57);
		contentPane.add(textArea);
	}
	
	public void cambiarMsg(String msg){
		txtMsg.setText(msg);
	
	}
}
