package br.com.alura.client;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MarvelClientApi implements APIClient {


    private String endpoint;


    public MarvelClientApi(String apiKey, String privateKey) {

        String timestamp = String.valueOf(System.currentTimeMillis());
        String hash = this.getMD5(timestamp + privateKey + apiKey);
        this.endpoint = String.format("https://gateway.marvel.com:443/v1/public/series?ts=%s&hash=%s&apikey=%s",
                timestamp, hash, apiKey);
    }

    @Override
    public String getBody() {

        HttpResponse<String> response = null;
        URI apiIMDB = URI.create(this.endpoint);
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();


            response = client.send(request, HttpResponse.BodyHandlers.ofString());


        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return response.body();
    }


    public String getMD5(String value)  {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md5.digest(value.getBytes()));
            return hash.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw  new RuntimeException(e);
        }

    }
}
