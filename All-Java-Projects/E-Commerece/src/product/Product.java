package product;

import exception.CustomException;

public class Product {
    private String name;
    private String brand;
    private double price;
    private int stock;

    public Product(String name, String brand, double price, int stock) throws CustomException {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setStock(stock);
    }

    public void setName(String name) throws CustomException {
        if (name == null || name.length() < 2)
            throw new CustomException("Product name must have at least 2 characters.");
        this.name = name;
    }

    public void setBrand(String brand) throws CustomException {
        if (brand == null || brand.length() < 2)
            throw new CustomException("Brand must have at least 2 characters.");
        this.brand = brand;
    }

    public void setPrice(double price) throws CustomException {
        if (price < 50)
            throw new CustomException("Price must be at least 50.");
        this.price = price;
    }

    public void setStock(int stock) throws CustomException {
        if (stock < 0)
            throw new CustomException("Stock cannot be negative.");
        this.stock = stock;
    }

    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return "Product{name='" + name + "', brand='" + brand + "', price=" + price + ", stock=" + stock + "}";
    }
}
