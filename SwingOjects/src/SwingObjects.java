import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SwingObjects extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		System.out.println("BIENVENIDOS A MI PROGRAMA DE VENTANAS");
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.cambiarMsg("Paco probando");
		ventana.setVisible(true);
		ventana.setBounds(100, 100, 400, 300);
	}

	public SwingObjects() {

	}

}
