package program;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private String cif;
	private String nombre;
	private int empleados;
	//private String direccion;
	private Direccion direccion;

	
	// para representar la relaci�n de uno a muchos entre Empresa y Pedido a�adimos un List de Pedidos en la clase Empresa
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Empresa(){
		setDireccion(new Direccion());
	}
	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEmpleados() {
		return empleados;
	}
	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}

	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
		direccion.setEmpresa(this);
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	// Utilizaremos este m�todo para referenciar la relaci�n bidireccional, reforzando dicha relaci�n
	public void addPedido (Pedido pedido){
		pedido.setEmpresa(this);
		this.pedidos.add(pedido);
	}

	
}
