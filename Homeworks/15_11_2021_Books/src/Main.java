import book.BestSeller;
import book.Book;
import book.LiteratureBook;
import book.TechnicalBook;

public class Main {

    public static void main(String[] args) {


        Book techBook = new TechnicalBook(2, "Physics", "Nyuton",20, "High Physics");
        Book litBook = new LiteratureBook(3,"Ride to Universe", "Somebody", 20);
        Book bestBook = new BestSeller(4,"Murder on the Orient express", "Agatha Christie", 20, 2.5);

        Book[]books = {techBook,litBook,bestBook};
        for (int i = 0; i < books.length; i++) {
            System.out.println(describeBook(books[i]));
        }

    }

    static String describeBook(Book book){
        return (book.getId() +" "+ book.getAuthor() +" "+ book.getTitle() +" "+ book.computePrice()+"$.");
    }
}


