package program;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private int id;
	private Date fecha;
	
	// Para representar la relación uno a muchos entre Empresa y Pedido también añadimos Empresa a la clase Pedido
	private Empresa empresa;
	
	private List<Item> item = new ArrayList<Item>();
	
	public Pedido(){
		
	}
	
	public Pedido(Date date, ArrayList<Item> item){
		super();
		this.fecha=date;
		this.item=item;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
