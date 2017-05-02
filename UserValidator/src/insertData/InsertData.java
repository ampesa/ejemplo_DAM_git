package insertData;

/* Clase para contener las variables a rellenar en la ventana de ejecuci�n.
 * Estas variables las llamaremos desde la Ventana de introducci�n de datos
 * La idea es poder validar cualquier usuario en cualquier dominio sin necesidad
 * de modificar la aplicaci�n
 */
public class InsertData {

	//utilizaremos las siguientes variables para rellenar los campos de la aplicaci�n
	private String ldap="serverIP";
	private String user_domain="user@domain";
	private String password="UserPassword";
	
	
	//generamos getters y setters
	public String getLdap() {
		return ldap;
	}
	public void setLdap(String ldap) {
		this.ldap = ldap;
	}
	public String getUser_domain() {
		return user_domain;
	}
	public void setUser_domain(String user_domain) {
		this.user_domain = user_domain;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
