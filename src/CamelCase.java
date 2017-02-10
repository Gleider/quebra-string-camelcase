import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CamelCase{

	public static List<String> converterCamelCase(String texto){
		if(texto.matches("^[0-9].*"))
			throw new NumeroInicioException("Palavra inválida: Não pode começar com números");
		if(!texto.matches("(\\w)*"))
			throw new CaractereEspecialException("Palavra inválida: Não pode conter caractere especial");
		List<String> palavras = new ArrayList<>();
		palavras = quebraTexto(texto);
		return palavras;
	}

	public static String palavraMinuscula(String palavra) {
		if(palavra.matches("^[A-Z][a-z].*"))
			palavra = palavra.substring(0,1).toLowerCase()+palavra.substring(1);
		return palavra;
	}

	public static List<String> quebraTexto(String texto) {
		String palavras[] = texto.split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])");
		for(int i = 0; i < palavras.length; i++){
			palavras[i] = palavraMinuscula(palavras[i]);
		}
		List<String> lista = Arrays.asList(palavras);
		return lista;
	}
	
}
	