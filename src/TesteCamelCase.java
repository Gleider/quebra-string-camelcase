import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TesteCamelCase {
	ArrayList<String> palavras, palavras2, palavras3, palavras4;
	
	@Before
	public void inicializaCamelCase(){
		palavras = new ArrayList<>();
		palavras2 = new ArrayList<>();
		palavras3 = new ArrayList<>();
		palavras4 = new ArrayList<>();
		/*palavras.add("nome");
		palavras.add("composto");*/
		palavras.add("numero");
		palavras.add("CPF");
		palavras.add("contribuinte");
		palavras2.add("recupera");
		palavras2.add("10");
		palavras2.add("primeiros");
		palavras3.add("10");
		palavras3.add("primeiros");
		palavras4.add("nome");
		palavras4.add("#");
		palavras4.add("composto");
	}
	
	@Test
	public void testeConverterCamelCase(){
		
		assertArrayEquals(palavras.toArray(),CamelCase.converterCamelCase("numeroCPFContribuinte").toArray());
	}
	
	@Test
	public void testePalavraMinuscula(){
		assertEquals("nome", CamelCase.palavraMinuscula("Nome"));
	}
	
	@Test
	public void testeQuebraTexto(){
		assertArrayEquals(palavras.toArray(), CamelCase.quebraTexto("numeroCPFContribuinte").toArray());
	}
	
	@Test
	public void testeTodosInicioMaiusculo(){
		assertArrayEquals(palavras.toArray(), CamelCase.converterCamelCase("numeroCPFContribuinte").toArray());
	}
	
	@Test
	public void testeTudoMaiusculo(){
		assertArrayEquals(palavras.toArray(), CamelCase.converterCamelCase("numeroCPFContribuinte").toArray());
	}
	
	@Test
	public void testeMaiusculaNoMeio(){
		assertArrayEquals(palavras.toArray(), CamelCase.converterCamelCase("numeroCPFContribuinte").toArray());
	}
	
	@Test
	public void numeroMeio(){
		assertArrayEquals(palavras2.toArray(), CamelCase.converterCamelCase("recupera10Primeiros").toArray());
	}
	
	@Test(expected=NumeroInicioException.class)
	public void numeroInicio(){
		assertArrayEquals(palavras3.toArray(), CamelCase.converterCamelCase("10Primeiros").toArray());
	}
	
	@Test(expected=CaractereEspecialException.class)
	public void caractereEspecial(){
		assertArrayEquals(palavras4.toArray(), CamelCase.converterCamelCase("nome#Composto").toArray());
	}
}
	