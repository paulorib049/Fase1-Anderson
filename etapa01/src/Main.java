import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://ge.globo.com/futebol/times/sao-paulo/noticia/2023/07/29/sao-paulo-anuncia-a-contratacao-do-meia-james-rodriguez.ghtml").get();
        Elements elementosP = doc.select("p:contains(futebol)");

        String caminhoArquivoCSV = "dados.csv";

        try (FileWriter escritor = new FileWriter(caminhoArquivoCSV)) {

            
            for (Element elemento : elementosP) {
                
                String texto = elemento.text();
                
                
                escritor.write(texto);
                escritor.write("\n"); 
            }

            System.out.println("Dados salvos em " + caminhoArquivoCSV);
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo CSV: " + e.getMessage());
        }
    }
}

