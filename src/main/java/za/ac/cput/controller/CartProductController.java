package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.service.CartProductService;

import java.util.List;

@RestController
@RequestMapping("/cart-products")
public class CartProductController {

    private final CartProductService cartProductService;

    @Autowired
    public CartProductController(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }

    @GetMapping
    public ResponseEntity<List<CartProduct>> getAllCartProducts() {
        List<CartProduct> cartProducts = cartProductService.getAll();
        return new ResponseEntity<>(cartProducts, HttpStatus.OK);
    }

    @GetMapping("/{cartProductId}")
    public ResponseEntity<CartProduct> getCartProduct(@PathVariable Long cartProductId) {
        CartProduct cartProduct = cartProductService.read(cartProductId);
        return cartProduct != null
                ? new ResponseEntity<>(cartProduct, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cart/{cartId}")
    public ResponseEntity<List<CartProduct>> getCartProductsByCart(@PathVariable Long cartId) {
        List<CartProduct> cartProducts = cartProductService.getCartProductsByCart(cartId);
        return new ResponseEntity<>(cartProducts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CartProduct> createCartProduct(@RequestBody CartProduct cartProduct) {
        CartProduct createdCartProduct = cartProductService.create(cartProduct);
        return new ResponseEntity<>(createdCartProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{cartProductId}")
    public ResponseEntity<CartProduct> updateCartProduct(
            @PathVariable Long cartProductId,
            @RequestBody CartProduct updatedCartProduct) {
        CartProduct existingCartProduct = cartProductService.read(cartProductId);
        if (existingCartProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Create a new CartProduct with updated fields
        CartProduct cartProductToUpdate = new CartProduct.Builder()
                .copy(existingCartProduct)
                .setQuantity(updatedCartProduct.getQuantity())
                .setUnitPrice(updatedCartProduct.getUnitPrice())
                .setTotalPrice(updatedCartProduct.getQuantity() * updatedCartProduct.getUnitPrice())
                .build();

        CartProduct result = cartProductService.update(cartProductToUpdate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{cartProductId}")
    public ResponseEntity<Void> deleteCartProduct(@PathVariable Long cartProductId) {
        boolean deleted = cartProductService.delete(cartProductId);
        return deleted
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}