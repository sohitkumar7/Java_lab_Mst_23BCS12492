import java.util.*;

// Custom exception for product not found
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

public class ProductDiscountApp {
    private Map<String, Double> products = new HashMap<>();

    // Method to add product
    public void addProduct(String id, double price) {
        products.put(id, price);
    }

    // Method to apply discount
    public void applyDiscount(String id, double discountPercentage) 
            throws ProductNotFoundException {

        // Case 1: Product not found
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Error: Product ID not found!");
        }

        // Case 2: Invalid discount percentage
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Error: Discount percentage must be between 0 and 100!");
        }

        // Apply discount
        double oldPrice = products.get(id);
        double newPrice = oldPrice - (oldPrice * discountPercentage / 100);

        // Update price
        products.put(id, newPrice);

        System.out.println("New price for " + id + ": $" + newPrice);
    }

    // Main method
    public static void main(String[] args) {
        ProductDiscountApp app = new ProductDiscountApp();

        // Adding products
        System.out.println("Adding products: P001=$50.0, P002=$100.0");
        app.addProduct("P001", 50.0);
        app.addProduct("P002", 100.0);

        // Case 1: Valid discount
        System.out.println("Applying 20% discount to P001...");
        try {
            app.applyDiscount("P001", 20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Case 2: Invalid discount (>100)
        System.out.println("Applying 150% discount to P002...");
        try {
            app.applyDiscount("P002", 150);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Case 3: Invalid product ID
        System.out.println("Applying discount to P999...");
        try {
            app.applyDiscount("P999", 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
