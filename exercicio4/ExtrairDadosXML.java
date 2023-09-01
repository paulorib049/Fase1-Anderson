package exercicio4;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ExtrairDadosXML {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("C:\\Users\\pedro\\Desktop\\java\\exercicios_bd_poo\\src\\exercicio4\\arquivo.xml"); // Substitua pelo caminho correto do seu arquivo XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("passageiro");

            System.out.println("Número de passageiros: " + nodeList.getLength());
            System.out.println("Origens e destinos:");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element passageiroElement = (Element) node;
                    String origem = passageiroElement.getElementsByTagName("origem").item(0).getTextContent();
                    String destino = passageiroElement.getElementsByTagName("destino").item(0).getTextContent();
                    System.out.println("Passageiro " + (temp + 1) + ": Origem - " + origem + ", Destino - " + destino);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}