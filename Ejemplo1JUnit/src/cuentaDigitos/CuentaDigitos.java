package cuentaDigitos;

//Generamos una clase con diferentes métodoso para contar dígitos de un número entero
public class CuentaDigitos {
	
	//definimos las variables a utilizar
	private int numero, digito, contador, operador, totalDigitos;
	
	//generamos getters y setters para la variable número y poder utilizarla en otras clases (test, en este caso)
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}	

	//método independiente para contar los dígitos pares
	public int pares() {
		
		contador=0;
		operador=numero;
		//operación
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

	//método independiente para contar los dígitos impares
	public int impares() {
		
		contador=0;
		operador=numero;
		
		//operación
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

	//método dependiente para sumar todos los dígitos (depende de los métodos anteriores)
	public int digitos (){
		totalDigitos=pares()+impares();
		return totalDigitos;
	}
	
	//método independiente para sumar todos los dígitos
	/*public int digitos (){
		contador=0;
		operador=numero;
		
		//operación
		while (operador > 0){
			contador++;
			operador=operador/10;
		}
		
		//salida
		return contador;
	}*/
}