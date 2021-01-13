package put.io.testing.audiobooks;

public class Audiobook {
    private String title;
    private double startingPrice;

    public Audiobook(String title, double startingPrice) {
        this.title = title;
        this.startingPrice = startingPrice;
    }

    public String getTitle() {
        return title;
    }

    public double getStartingPrice() {
        return startingPrice;
    }
}
