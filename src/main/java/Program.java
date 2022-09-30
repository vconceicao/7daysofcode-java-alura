import br.com.alura.client.MarvelClientApi;
import br.com.alura.htmlgen.HTMLGenerator;
import br.com.alura.models.Content;
import br.com.alura.parser.MarvelSeriesJsonParser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Program {

    public static void main(String[] args) throws FileNotFoundException {



        //Criar uma conta no IMDB para ter a chave de acesso ao serviço (apiKey),
        // mas cuidado, essa chave não deve ser commitada no Github ou em outro repositório!
        //k_5bec8071
        //Criar o código Java que executará uma requisição HTTP do tipo GET.

        // Você pode usar o pacote java.net.http e as classes HttpRequest, HttpClient e HttpResponse,
        // além da classe URI

        //Executar a requisição e pegar a resposta (o JSON)

        //Imprimir o corpo da resposta no console
          String apiKey = "";
          String privateKey = "";

        String jsonCode = new MarvelClientApi(apiKey, privateKey  ).getBody();

       List<? extends Content> contents = new MarvelSeriesJsonParser(jsonCode).parse();


        PrintWriter printer = new PrintWriter("report.html");

        HTMLGenerator htmlGenerator = new HTMLGenerator(printer);

        htmlGenerator.generate(contents);

        printer.close();


    }

}
