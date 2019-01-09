package program;

public class Direccion {

	private int id;
	private String calle;
	private String poblacion;
	private int cp;
	private Empresa empresa;
	
	public Direccion(){
		
	}
	
	public Direccion(String calle, String poblacion, int cp){
		this.calle = calle;
		this.poblacion = poblacion;
		this.cp = cp;
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
