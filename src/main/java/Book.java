import lombok.Getter;

@Getter
public class Book extends Product {
    private String author;

    public Book(int id, int cost, String name, String author) {
        super(id, cost, name);
        this.author = author;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getAuthor().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    ;
}
