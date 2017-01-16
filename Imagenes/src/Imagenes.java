import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Imagenes extends JFrame {

	private JPanel contentPane;
	private JLabel lblEtiqueta;
	
	/**
	 * ESTE ES EL MAIN.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imagenes frame = new Imagenes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Imagenes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEtiqueta = new JLabel();
		try {
			ImageIcon imagen=new ImageIcon(getClass().getResource("img/avatar1.png"));
			lblEtiqueta.setIcon(imagen);
		} catch (Exception e){
			System.out.println("LA IMAGEN NO EXISTE");
			e.printStackTrace();
		}

		lblEtiqueta.setBounds(10, 11, 256, 256);
		contentPane.add(lblEtiqueta);
	}
}
