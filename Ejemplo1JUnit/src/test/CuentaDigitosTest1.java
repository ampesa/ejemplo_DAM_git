package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cuentaDigitos.CuentaDigitos;

public class CuentaDigitosTest1 {
	CuentaDigitos test=new CuentaDigitos();
	
	@Before
	public void iniciarTest() {
		test.setNumero(123456789);
	}

	@Test
	public void testPares() {
		assertEquals(4, test.pares());
	}
	
	@Test
	public void testImpares() {
		assertEquals(5, test.impares());
	}

	@Test
	public void testDigitos() {
		assertEquals(9, test.digitos());
	}


}
