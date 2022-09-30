package br.com.alura.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbClientApi implements APIClient {
    private String apiKey;

    public ImdbClientApi(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String getBody() {


        HttpResponse<String> response = null;
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = null;
            request = HttpRequest
                    .newBuilder()
                    .uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
                    .GET()
                    .build();


            response = client.send(request, HttpResponse.BodyHandlers.ofString());


        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return response.body();

    }
}
