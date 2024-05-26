package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartItem;
import za.ac.cput.service.CartItemService;

import java.util.Set;

@RestController
@RequestMapping("/cartItem") // Change the base mapping to "/cartItem"
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/create")
    public CartItem create(@RequestBody CartItem cartItem){
        return cartItemService.create(cartItem);
    }

    @GetMapping("/{cartItemId}") // Change the mapping to "/{cartItemId}"
    public CartItem read(@PathVariable long cartItemId){
        return cartItemService.read(cartItemId);
    }

    @PutMapping("/update") // Use PutMapping for update
    public CartItem update(@RequestBody CartItem cartItem){ // Change the parameter name to cartItem
        return cartItemService.update(cartItem);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        cartItemService.delete(id);
    }

    @GetMapping("/getAll") // Change the mapping to "/getAll"
    public Set<CartItem> getAll(){ // Change the method name to getAll
        return cartItemService.getAll();
    }
}
