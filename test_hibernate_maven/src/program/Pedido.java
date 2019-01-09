package program;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private int id;
	private Date fecha;
	
	private List<Item> item = new ArrayList<Item>();
	
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
	
	
}
