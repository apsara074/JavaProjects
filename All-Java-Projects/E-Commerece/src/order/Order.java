package order;

import customer.Customer;
import product.Product;
import exception.CustomException;

import java.util.List;
import java.util.Random;

public class Order {
    private String orderId;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;

    public Order(Customer customer) throws CustomException {
        if (customer.getCart().isEmpty())
            throw new CustomException("Cart is empty. Add products first.");
        this.customer = customer;
        this.products = customer.getCart();
        this.totalAmount = calculateTotal();
        generateOrderId();
    }

    private double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    private void generateOrderId() {
        Random rand = new Random();
        this.orderId = "ORD" + (rand.nextInt(9000) + 1000);
    }

    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<Product> getProducts() { return products; }
    public double getTotalAmount() { return totalAmount; }

    public void displayOrder() {
        System.out.println("OrderID: " + orderId + ", Customer: " + customer.getName() + ", Total: " + totalAmount);
        products.forEach(System.out::println);
    }
}
