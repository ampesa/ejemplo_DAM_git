/*
 * La definicición de la clase mediante la palabra reservada Carta
 * 
 * public class NombreClase
 * */
public class Carta {

	//PROPIEDADES
	private int numero;
	private String palo;
	
	//CONSTANTES
	public static final String BASTOS="BASTOS";
	public static final String COPAS="COPAS";
	public static final String ESPADAS="ESPADAS";
	public static final String OROS="OROS";
	
	//constructor
	//Punto de entrada que se ejecuta al crear un objeto de tipo Carta
	public Carta() {
		System.out.println("creo un objeto de tipo carta");
		
	}
	
	//FUNCIONES O MÉTODOS
	//public/private (qué devuelve) OUT nombreMetodo(IN)
	public void setNumero(int numero){
		// SI PASA ALGO HAZ...
		if (numero<1){
			this.numero=1;
		}else if (numero>12){
			this.numero=12;
		}else {
			this.numero=numero;
		}
	}
	
	public int getNumero(){
		return numero;
	}

	public void setPalo(String palo) {
		switch (palo){
		case Carta.BASTOS:
			this.palo="BASTOS";
			break;
		case Carta.COPAS:
			this.palo="COPAS";
			break;
		case Carta.ESPADAS:
			this.palo="ESPADAS";
			break;
		case Carta.OROS:
			this.palo="OROS";
			break;
		default: 
			this.palo="BASTOS";
		
		}
		
	}
	
	public String getPalo() {
		return palo;
	}

}
