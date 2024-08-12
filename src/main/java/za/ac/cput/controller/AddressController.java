package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Address;
import za.ac.cput.service.AddressService;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        Address newAddress = addressService.create(address);
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }

}
