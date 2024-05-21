package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.utility.ProductHelper;

public class ProductFactory {


    public static Product buildProduct(String productId, String productName, String productDescription, double price, String imageUrl) {
        {
            if (ProductHelper.isNullorEmpty(productId) ||
                    ProductHelper.isNullorEmpty(productName) ||
                    ProductHelper.isNullorEmpty(productDescription) ||
                    !ProductHelper.isValidPrice(price)
                    || !ProductHelper.isValidImageUrl(imageUrl))
                return null;
            return new Product.Builder().setProductId(productId).setProductName(productName).setProductDescription(productDescription)
                    .setPrice(price).setImageUrl(imageUrl).build();

        }
    }
}
