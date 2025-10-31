package shop;

import product.Product;
import customer.Customer;
import order.Order;
import exception.CustomException;

import java.util.*;
import java.util.stream.Collectors;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // 🔹 Input Products
            List<Product> products = new ArrayList<>();
            System.out.print("Enter number of products: ");
            int prodCount = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 0; i < prodCount; i++) {
                System.out.println("Enter details for Product " + (i + 1));
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Brand: ");
                String brand = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Stock: ");
                int stock = sc.nextInt();
                sc.nextLine();
                products.add(new Product(name, brand, price, stock));
            }

            // 🔹 Input Customers
            List<Customer> customers = new ArrayList<>();
            System.out.print("\nEnter number of customers: ");
            int custCount = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < custCount; i++) {
                System.out.println("Enter details for Customer " + (i + 1));
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                Customer customer = new Customer(name, email);

                // Add products to cart
                System.out.print("How many products to add to cart? ");
                int cartCount = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < cartCount; j++) {
                    System.out.println("Select product by number:");
                    for (int k = 0; k < products.size(); k++) {
                        System.out.println((k + 1) + ". " + products.get(k).getName() + " (" + products.get(k).getBrand() + ")");
                    }
                    int prodIndex = sc.nextInt() - 1;
                    sc.nextLine();
                    customer.addToCart(products.get(prodIndex));
                }
                customers.add(customer);
            }

            // 🔹 Create Orders
            List<Order> orders = new ArrayList<>();
            for (Customer c : customers) {
                orders.add(new Order(c));
            }

            // 🔹 Display Orders
            System.out.println("\n📌 All Orders:");
            orders.forEach(Order::displayOrder);

            // 🔹 Stream API examples
            System.out.println("\n📌 Most Expensive Product:");
            products.stream()
                    .max(Comparator.comparing(Product::getPrice))
                    .ifPresent(System.out::println);

            System.out.println("\n📌 Cheapest Product:");
            products.stream()
                    .min(Comparator.comparing(Product::getPrice))
                    .ifPresent(System.out::println);

            System.out.println("\n📌 Products grouped by Brand:");
            Map<String, List<Product>> byBrand = products.stream()
                    .collect(Collectors.groupingBy(Product::getBrand));
            byBrand.forEach((brand, prodList) -> {
                System.out.println(brand + " -> " + prodList);
            });

        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
/*Enter number of products: 3
Enter details for Product 1
Name: Laptop
Brand: Dell
Price: 50000
Stock: 10
Enter details for Product 2
Name: Phone
Brand: Samsung
Price: 25000
Stock: 20
Enter details for Product 3
Name: Headphones
Brand: Sony
Price: 3000
Stock: 15

Enter number of customers: 2
Enter details for Customer 1
Name: Apsara
Email: apsara@gmail.com
How many products to add to cart? 2
Select product by number:
1. Laptop (Dell)
2. Phone (Samsung)
3. Headphones (Sony)
1
Select product by number:
1. Laptop (Dell)
2. Phone (Samsung)
3. Headphones (Sony)
3

Enter details for Customer 2
Name: Kiran
Email: kiran@yahoo.com
How many products to add to cart? 2
Select product by number:
1. Laptop (Dell)
2. Phone (Samsung)
3. Headphones (Sony)
2
Select product by number:
1. Laptop (Dell)
2. Phone (Samsung)
3. Headphones (Sony)
3

📌 All Orders:
OrderID: ORD1234, Customer: Apsara, Total: 53000.0
Product{name='Laptop', brand='Dell', price=50000.0, stock=10}
Product{name='Headphones', brand='Sony', price=3000.0, stock=15}

OrderID: ORD5678, Customer: Kiran, Total: 28000.0
Product{name='Phone', brand='Samsung', price=25000.0, stock=20}
Product{name='Headphones', brand='Sony', price=3000.0, stock=15}

📌 Most Expensive Product:
Product{name='Laptop', brand='Dell', price=50000.0, stock=10}

📌 Cheapest Product:
Product{name='Headphones', brand='Sony', price=3000.0, stock=15}

📌 Products grouped by Brand:
Dell -> [Product{name='Laptop', brand='Dell', price=50000.0, stock=10}]
Samsung -> [Product{name='Phone', brand='Samsung', price=25000.0, stock=20}]
Sony -> [Product{name='Headphones', brand='Sony', price=3000.0, stock=15}]
 */