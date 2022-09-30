package br.com.alura.models;

public class Movie implements  Content{


    private final String title;
    private final String image;
    private final String year;
    private final String rating;

    public Movie(String title, String image, String year, String rating) {
        this.title = title;
        this.image = image;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("title='").append(title).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", year=").append(year);
        sb.append(", rating='").append(rating).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
