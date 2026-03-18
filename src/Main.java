import entities.Order;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product(1L, "Book 1", "Books", 120.0));
        products.add(new Product(2L, "CoD", "Videogames", 80.0));
        products.add(new Product(3L, "Book 2", "Books", 90.0));
        products.add(new Product(4L, "Book 3", "Books", 150.0));
        products.add(new Product(5L, "Final Fantasy", "Videogames", 70.0));
        products.add(new Product(6L,"Toy","Baby", 30.0));

        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100)
                .toList();

        System.out.println(filteredProducts);

    }
}
