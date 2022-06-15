import lombok.Getter;

@Getter
public class Smartphone extends Product {
    private String producer;

    public Smartphone(int id, int cost, String name, String producer) {
        super(id, cost, name);
        this.producer = producer;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getProducer().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
