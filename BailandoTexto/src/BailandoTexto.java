import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Definimos la ventana BailandoTexto con window builder JFrame
public class BailandoTexto extends JFrame {

	private JPanel contentPane;  //se define automáticamente la caja que contendrá nuestras ediciones dentro de la ventana
	private JTextField CampoTextoIzquierda; // definimos la caja que contendrá el texto a la izquierda de la ventana y la llamamos CampoTextoIzquierda
	private JTextField CampoTextoDerecha; // definimos la caja que contendrá el texto de la derecha

	/**
	 * lanzamos la ventana para que sea visible.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BailandoTexto frame = new BailandoTexto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creamos el contentPane que va a contener nuestras cajas de texto (izquierda y derecha) y los botones para bailar el texto.
	 */
	public BailandoTexto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // definimos un layout absoluto para poder ubicar las cajas de texto y los botones donde queramos.
		
		// Creamos la caja de texto de la izquierda
		CampoTextoIzquierda = new JTextField();
		CampoTextoIzquierda.setBounds(43, 115, 86, 20);
		contentPane.add(CampoTextoIzquierda);
		CampoTextoIzquierda.setColumns(10);
		
		// Creamos la caja de texto de la derecha
		CampoTextoDerecha = new JTextField();
		CampoTextoDerecha.setBounds(284, 115, 86, 20);
		contentPane.add(CampoTextoDerecha);
		CampoTextoDerecha.setColumns(10);
		
		// Creamos el botón que nos servirá para mover el texto de la caja de la izquierda a la caja de la derecha
		JButton mueveTextoDerecha = new JButton("-->");
		
		// Creamos la escucha + evento para darle acción al botón mueveTextoDerecha
		mueveTextoDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// al hacer clic en el botón el texto cambia al campo de la derecha
				CampoTextoDerecha.setText(CampoTextoIzquierda.getText());
				// eliminamos el texto del campo de la izquierda
				CampoTextoIzquierda.setText("");
			}
		});
		mueveTextoDerecha.setBounds(176, 60, 49, 23);
		contentPane.add(mueveTextoDerecha);
		
		// Creamos el botón que moverá el texto de la caja de la derecha a la caja de la izquierda
		JButton mueveTextoIzquierda = new JButton("<--");
		
		// Creamos la escucha + darle acción al botón mueveTextoIquierda
		mueveTextoIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// al hacer clic en el botón el texto cambia al campo de la izquierda
				CampoTextoIzquierda.setText(CampoTextoDerecha.getText());
				// eliminamos el texto del campo de la derecha
				CampoTextoDerecha.setText("");
			}
		});
		mueveTextoIzquierda.setBounds(176, 173, 49, 23);
		contentPane.add(mueveTextoIzquierda);
	}
}
