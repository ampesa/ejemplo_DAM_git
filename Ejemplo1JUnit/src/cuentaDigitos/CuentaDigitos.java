package cuentaDigitos;

//Generamos una clase con diferentes m�todoso para contar d�gitos de un n�mero entero
public class CuentaDigitos {
	
	//definimos las variables a utilizar
	private int numero, digito, contador, operador, totalDigitos;
	
	//generamos getters y setters para la variable n�mero y poder utilizarla en otras clases (test, en este caso)
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}	

	//m�todo independiente para contar los d�gitos pares
	public int pares() {
		
		contador=0;
		operador=numero;
		//operaci�n
		while (operador > 0){
			digito=operador%10;
			
			if (digito % 2 == 0){
				contador++;
			}
			operador=operador/10;
		}
		
		//salida
		return contador;
	}

	//m�todo independiente para contar los d�gitos impares
	public int impares() {
		
		contador=0;
		operador=numero;
		
		//operaci�n
		while (operador > 0){
			digito=operador%10;
			
			if (digito % 2 != 0){
				contador++;
			}
			operador=operador/10;
		}
		
		//salida
		return contador;
	}

	//m�todo dependiente para sumar todos los d�gitos (depende de los m�todos anteriores)
	public int digitos (){
		totalDigitos=pares()+impares();
		return totalDigitos;
	}
	
	//m�todo independiente para sumar todos los d�gitos
	/*public int digitos (){
		contador=0;
		operador=numero;
		
		//operaci�n
		while (operador > 0){
			contador++;
			operador=operador/10;
		}
		
		//salida
		return contador;
	}*/
}