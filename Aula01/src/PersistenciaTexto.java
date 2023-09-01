import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaTexto {
	public static void main(String[] args) {
		String conteudo = "esse é um exemplo de persistencia de arquivos csv";
		
		try {
			FileWriter escritor = new FileWriter("arquivo.csv");
			escritor.write(conteudo);
			escritor.close();
			System.out.println("dados gravados com sucesso");
		}
		catch(IOException e) {
			System.err.println("erro ao escrever no arquivo: " + e.getMessage());
		}
		
	}
}
