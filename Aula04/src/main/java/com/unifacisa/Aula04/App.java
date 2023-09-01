package com.unifacisa.Aula04;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

   
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, getPessoas());
        System.out.println(writer);

        String jsonInput = 
        		"[{\"id\":1,\"nome\":\"Lucas\",\"idade\":28,\"sobrenome\":\"Dutra\"}," +
                        "{\"id\":2,\"nome\":\"Maria\",\"idade\":22,\"sobrenome\":\"Ribeiro\"}," +
                        "{\"id\":3,\"nome\":\"Jose\",\"idade\":34,\"sobrenome\":\"Almeida\"}]";
        List<Pessoa> p = mapper.readValue(jsonInput, new TypeReference<List<Pessoa>>() {
        });
        System.out.println("Pessoa: " + p);
    }

    private static List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa p1 = new Pessoa();
        p1.setId(1);
        p1.setNome("Lucas");
        p1.setIdade(28);
        p1.setSobrenome("Dutra");
        pessoas.add(p1);

        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNome("Maria");
        p2.setIdade(22);
        p2.setSobrenome("Ribeiro");
        pessoas.add(p2);

        Pessoa p3 = new Pessoa();
        p3.setId(3);
        p3.setNome("Jose");
        p3.setIdade(34);
        p3.setSobrenome("Almeida");
        pessoas.add(p3);

        return pessoas;
    }
    
}

