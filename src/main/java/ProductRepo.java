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

    public Product findById(int id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == id) {
                return items[i];
            }
        }
        return null;
    }

    public void removeById(int id) {
            if (this.findById(id) == null) {
                throw new NotFoundException("Не найден элемент с id: " + id);
            } else {
                int copyIndex = 0;
                Product[] tmp = new Product[items.length - 1];
                for (int i = 0; i < items.length; i++) {
                    if (items[i].getId() != id) {
                        tmp[copyIndex] = items[i];
                        copyIndex++;
                    }
                }
                items = tmp;
            }
    }
}

