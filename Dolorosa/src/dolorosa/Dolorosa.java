package dolorosa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dolorosa extends JFrame {

	private JPanel contentPane;
	private JTextField cajaTextoImporte;
	private JTextField cajaTextoDescuento;
	private JTextField cajaTextoImpuesto;
	private JTextField cajaTextoTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dolorosa frame = new Dolorosa();
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
	public Dolorosa() {
		
		// creamos las variables a utilizar en las operaciones, en este caso todas son del tipo int
		int valorImporte=0;
		int valorDescuento=0;
		int valorImpuesto=0;
		int valorTotal=0;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Definimos una etiqueta general para el programa
		JLabel etiquetaDolorosa = new JLabel("Dolorosa");
		etiquetaDolorosa.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaDolorosa.setBounds(140, 11, 78, 17);
		contentPane.add(etiquetaDolorosa);
		
		//Definimos una etiqueta para el campo importe
		JLabel etiquetaImporte = new JLabel("Importe");
		etiquetaImporte.setBounds(30, 34, 46, 14);
		contentPane.add(etiquetaImporte);
		
		//creamos una caja de texto que albergará el importe
		cajaTextoImporte = new JTextField(valorImporte);
		cajaTextoImporte.setBounds(30, 59, 86, 20);
		contentPane.add(cajaTextoImporte);
		cajaTextoImporte.setColumns(10);
		
		//creamos una etiqueta para el campo Descuento
		JLabel etiquetaDescuento = new JLabel("Descuento");
		etiquetaDescuento.setBounds(199, 100, 69, 14);
		contentPane.add(etiquetaDescuento);
		
		//creamos una caja de texto que albergará el Descuento
		cajaTextoDescuento = new JTextField(valorDescuento);
		cajaTextoDescuento.setBounds(199, 125, 86, 20);
		contentPane.add(cajaTextoDescuento);
		cajaTextoDescuento.setColumns(10);
		
		//creamos una etiqueta para el campo Impuesto
		JLabel etiquetaImpuesto = new JLabel("Impuesto");
		etiquetaImpuesto.setBounds(199, 165, 46, 14);
		contentPane.add(etiquetaImpuesto);
		
		//creamos una caja de texto que albergará el Impuesto
		cajaTextoImpuesto = new JTextField(valorImpuesto);
		cajaTextoImpuesto.setBounds(199, 192, 86, 20);
		contentPane.add(cajaTextoImpuesto);
		cajaTextoImpuesto.setColumns(10);
		
		//creamos una etiqueta para el campo Total
		JLabel etiquetaTotal = new JLabel("Total");
		etiquetaTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaTotal.setBounds(199, 233, 46, 14);
		contentPane.add(etiquetaTotal);
		
		//creamos una caja de texto que albergará el Total
		cajaTextoTotal = new JTextField(valorTotal);
		cajaTextoTotal.setBounds(199, 254, 86, 20);
		contentPane.add(cajaTextoTotal);
		cajaTextoTotal.setColumns(10);
		
		//creamos un JButton que iniciará el proceso y mostrará el resultado
		JButton botonCalcular = new JButton("Calcular");
		botonCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		botonCalcular.setBounds(188, 57, 89, 23);
		contentPane.add(botonCalcular);
	}
}
