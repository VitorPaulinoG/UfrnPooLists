package org.example;

import com.opencsv.*;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GeraEmailsInstitucionais {
    public static void main(String[] args) throws Exception {

        Set<String> emailsRegistrados = new HashSet<>();

        try (Reader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource("docentes.csv").toURI()))
            )
        {

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .build();

            try (CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build())
            {
                List<String[]> docentes = csvReader.readAll();

                Random random = new Random();
                for (int i = 0; i < 20; i++)
                {
                    int index = random.nextInt(0, docentes.size());
                    String nomeDoDocente = docentes.get(index)[1].toLowerCase();
                    String[] subnomesDoDocente = nomeDoDocente.split(" ");
                    String emailInstitucional = String.format("%s.%s@ufrn.br",
                            subnomesDoDocente[0],
                            subnomesDoDocente[subnomesDoDocente.length - 1]);

                    if (!emailsRegistrados.add(emailInstitucional)){
                        emailInstitucional = String.format("%s.%s.%s@ufrn.br",
                                subnomesDoDocente[0],
                                subnomesDoDocente[(int) subnomesDoDocente.length/2],
                                subnomesDoDocente[subnomesDoDocente.length - 1]);
                        emailsRegistrados.add(emailInstitucional);
                    }
                }
            }

        }
        System.out.println("Emails Institucionais: ");
        for (var item : emailsRegistrados)
        {
            System.out.println(item);
        }
    }
}
