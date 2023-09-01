import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Aula3 {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://ge.globo.com/futebol/times/sao-paulo/noticia/2023/07/29/sao-paulo-anuncia-a-contratacao-do-meia-james-rodriguez.ghtml").get();
        Elements conteudo = doc.getElementsContainingOwnText("Futebol");

        try {
            FileWriter escritor = new FileWriter("arquiv.csv");
            
            for (Element elemento : conteudo) {
                escritor.write(elemento.text());
                escritor.write("\n"); 
            }
            
            escritor.close();
            System.out.println("Dados gravados com sucesso no arquivo arquiv.csv");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
