import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        Customer customer1 = new Customer(1L, "Ugo", 1);
        Customer customer2 = new Customer(2L, "Ciro", 2);

        products.add(new Product(1L, "Book 1", "Books", 120.0));
        products.add(new Product(2L, "CoD", "Videogames", 80.0));
        products.add(new Product(3L, "Book 2", "Books", 90.0));
        products.add(new Product(4L, "Book 3", "Books", 150.0));
        products.add(new Product(5L, "Final Fantasy", "Videogames", 70.0));
        products.add(new Product(6L,"Toy","Baby", 30.0));

        List<Product> order1Products = new ArrayList<>();
        order1Products.add(products.get(0));
        order1Products.add(products.get(5));

        List<Product> order2Products = new ArrayList<>();
        order2Products.add(products.get(1));
        order2Products.add(products.get(4));

        Order order1 = new Order(1L, "Delivered", LocalDate.now(), LocalDate.now().plusDays(2), order1Products, customer1);
        Order order2 = new Order(2L, "Shipped", LocalDate.now(), LocalDate.now().plusDays(3), order2Products, customer2);
        orders.add(order1);
        orders.add(order2);

        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100)
                .toList();

        List<Order> filteredOrders = orders.stream()
                        .filter(order -> order.getProducts().stream()
                                .anyMatch(product -> product.getCategory().equals("Baby")))
                                .toList();

        System.out.println("Lista di PRODOTTI appartenenti alla categoria Books:");
        System.out.println(filteredProducts);
        System.out.println();
        System.out.println("*****************************************************");
        System.out.println();

        System.out.println("Lista di ORDINI con prodotti appartenenti alla categoria Baby:");
        System.out.println(filteredOrders);
        System.out.println();
        System.out.println("*****************************************************");
        System.out.println();


    }
}
