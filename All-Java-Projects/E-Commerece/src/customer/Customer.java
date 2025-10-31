package customer;

import exception.CustomException;
import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private List<Product> cart = new ArrayList<>();

    public Customer(String name, String email) throws CustomException {
        setName(name);
        setEmail(email);
    }

    public void setName(String name) throws CustomException {
        if (name == null || name.length() < 3)
            throw new CustomException("Customer name must be at least 3 characters.");
        this.name = name;
    }

    public void setEmail(String email) throws CustomException {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new CustomException("Invalid email format.");
        this.email = email;
    }

    public void addToCart(Product p) {
        cart.add(p);
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Product> getCart() { return cart; }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', email='" + email + "'}";
    }
}
