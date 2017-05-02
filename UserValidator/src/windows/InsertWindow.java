package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.util.Hashtable;

import javax.naming.*;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;


// Importamos la clase InsertData para utilizar sus atributos en la ventana de introducción de datos
import insertData.InsertData;
import javax.swing.JTextArea;

public class InsertWindow extends JFrame {

	private JPanel contentPane;
	private JTextField ldapTextField;
	private JTextField user_domainTextField;
	private JTextField passwordTextField;

	// Constructor de la ventana de introducción de datos
	public InsertWindow() {
		
		//Creamos un objeto de la clase InsertData
		InsertData user1 = new InsertData();
		
		user1.setLdap("");
		user1.setUser_domain("");
		user1.setPassword("");
		
		
		// Creamos la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Creamos una etiqueta general que describe la ventana
		JLabel lblUserValidator = new JLabel("User Validator");
		lblUserValidator.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserValidator.setBounds(96, 0, 104, 20);
		contentPane.add(lblUserValidator);
				
		// Creamos la etiqueta para el campo ldap
		JLabel ldapLabel = new JLabel("Server IP");
		ldapLabel.setBounds(44, 31, 86, 14);
		contentPane.add(ldapLabel);
		
		// Creamos el campo para rellenar ldap
		ldapTextField = new JTextField();
		ldapTextField.setBounds(44, 48, 97, 20);
		contentPane.add(ldapTextField);
		ldapTextField.setColumns(15);
		
		// Creamos la etiqueta para el campo nombre de usuario y dominio
		JLabel user_domainLabel = new JLabel("user@domain");
		user_domainLabel.setBounds(44, 79, 97, 14);
		contentPane.add(user_domainLabel);
		
		// Creamos el campo de texto para rellenar el usuario y dominio
		user_domainTextField = new JTextField();
		user_domainTextField.setBounds(44, 97, 199, 20);
		contentPane.add(user_domainTextField);
		user_domainTextField.setColumns(30);
		
		// Creamos la etiqueta para el campo contraseña
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(44, 128, 86, 14);
		contentPane.add(passwordLabel);
		
		// Cremaos el campo para rellenar la contraseña
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(44, 146, 199, 20);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(30);
		
		// Creamos un JTextArea en el que confirmaremos si el usario valida o no		
		JTextArea prompt_textArea = new JTextArea();
		prompt_textArea.setLineWrap(true);
		prompt_textArea.setColumns(30);
		prompt_textArea.setBounds(44, 192, 199, 58);
		contentPane.add(prompt_textArea);
		
		// Creamos un botón que ejecutará el programa de validación (Validator.java)
		JButton btnValidate = new JButton("Validate");
		btnValidate.setBounds(154, 47, 89, 23);
		contentPane.add(btnValidate);
		
		//añadimos un listener sobre el botón Validate
		btnValidate.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent arg0) {
				//al hacer click en el botón se se asignarán los valores rellenados a las variables definidas en la clase InsertData
				user1.setLdap(ldapTextField.getText());
				user1.setUser_domain(user_domainTextField.getText());
				user1.setPassword(passwordTextField.getText());
				
				Hashtable<String, String> env = new Hashtable<String, String>();
				env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
				env.put(Context.SECURITY_AUTHENTICATION, "simple");
				
				//asignamos la ip introducida, contra la que vamos a validar
				env.put(Context.PROVIDER_URL, "ldap://" + user1.getLdap());
				
				//asignamos los datos de usuario@dominio y password introducidos
				env.put(Context.SECURITY_PRINCIPAL, user1.getUser_domain());
				env.put(Context.SECURITY_CREDENTIALS, user1.getPassword());
				
				DirContext ctx;
				
				//ejecutamos la consulta, si es correcta se muestra un mensaje de validación si no, mostramos mensaje de error
				try {
					ctx = new InitialDirContext(env);
					prompt_textArea.setText("El usuario y dominio " + user1.getUser_domain() + " se ha autenticado correctamente en " + user1.getLdap());
					ctx.close();
				} catch (NamingException E) {
					prompt_textArea.setText("Ha habido un error en la autenticación de " + user1.getUser_domain() + " en " + user1.getLdap());

				}
				// reseteamos los campos de texto para introducir otros datos de usuario y password, dejando el mismo ldap
				user_domainTextField.setText("");
				passwordTextField.setText("");
				
				}
								
		});

		
	}
}
