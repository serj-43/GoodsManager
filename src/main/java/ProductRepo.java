import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductRepo {
    private Product[] items = new Product[0];

    public Product[] findAll() {
        return items;
    }

    public void save(Product product) {
        Product[] tmp = new Product[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = product;
        items = tmp;
    }

    public boolean removeById(int id) {
        if (items.length > 0) {
            int copyIndex = 0;
            Product[] tmp = new Product[items.length - 1];
            for (int i = 0; i < items.length; i++) {
                if (items[i].getId() != id) {
                    if (copyIndex == tmp.length) {
                        return false;
                    }
                    tmp[copyIndex] = items[i];
                    copyIndex++;
                }
            }
            items = tmp;
            return true;
        } else return false;
    }
}

