package book;

public class BestSeller extends LiteratureBook{

    private final double coef;

    public BestSeller(int id, String title, String author, int price, double coef) {
        super(id, title, author, price);
        this.coef = coef;
    }

    @Override
    public int computePrice() {
        return (int)(super.computePrice() * coef);
    }
}
