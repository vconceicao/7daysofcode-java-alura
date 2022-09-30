package br.com.alura.parser;

import br.com.alura.models.Content;
import br.com.alura.models.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImdbJsonParser implements JsonParser {
    private String json;

    public ImdbJsonParser(String json) {
        this.json = json;
    }

    @Override
    public List<? extends Content> parse() {
        String jsonCode = this.json.replace("{", "")
                .replace("}", "")
                .replace("[", "")
                .replace("]", "");

        String[] strings = jsonCode.split(",");

        List<String> titles = new ArrayList<>();
        List<String> images = new ArrayList<>();
        List<String> years = new ArrayList<>();
        List<String> ratings = new ArrayList<>();


        Arrays.stream(strings).forEach(s -> {

            if (s.contains("\"title\"")){
                titles.add(s.split(":")[1]);
            }

            if (s.contains("\"image\"")){
                images.add(s.split(":", 2)[1]);
            }

            if (s.contains("\"year\"")){
                years.add(s.split(":")[1].replace("\"", ""));

            }

            if (s.contains("\"imDbRating\"")){
                ratings.add(s.split(":")[1]);
            }


        });


        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            movies.add(new Movie(titles.get(i), images.get(i), years.get(i), ratings.get(i) ));
        }
        return movies;
    }
}
