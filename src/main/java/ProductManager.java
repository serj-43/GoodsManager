public class ProductManager {
    private ProductRepo repository;

    public ProductManager(ProductRepo repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        this.repository.save(product);
    }

    public Product[] searchBy(String text) {
        ProductRepo result = new ProductRepo();
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                result.save(product);
            }
        }
        return result.findAll();
    }

}
