package model;

public class Product {
	
	// atributos
	private String name;
	private Double price;
	
	public Product (String n, Double p){
		this.name = n;
		this.price = p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// Método para mostrar los datos del objeto producto
	public String printProduct(){
		
		StringBuilder str = new StringBuilder("\n");
		str.append("Name: " + name + "\t");
		str.append("Price: " + price + "€");
		
		return str.toString();
	}

}
