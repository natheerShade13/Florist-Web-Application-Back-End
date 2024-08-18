package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.ProductHelper;

// is valid image url
public class ProductFactory {

    public static Product buildProduct(String name, String description, double price,
                                       String imageURL, int stockQuantity, String category) {
        if(ProductHelper.isNullOrEmpty(name) ||
                ProductHelper.isNullOrEmpty(description) || ProductHelper.isNegative(price) ||
                ProductHelper.isNullOrEmpty(imageURL) || ProductHelper.isNegative(stockQuantity) ||
                ProductHelper.isNullOrEmpty(category)) {
            return null;
        }

        return new Product.Builder()
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setImageUrl(imageURL)
                .setStockQuantity(stockQuantity)
                .setCategory(category)
                .build();
    }
}
