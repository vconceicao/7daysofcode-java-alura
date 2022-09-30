package br.com.alura.models;

public class Serie implements Content {

    private String title;
    private String image;
    private String year;
    private String rating;

    public Serie(String title, String image, String year, String rating) {
        this.title = title;
        this.image = image;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getYear() {
        return year;
    }

    @Override
    public String getRating() {
        return rating;
    }
}
