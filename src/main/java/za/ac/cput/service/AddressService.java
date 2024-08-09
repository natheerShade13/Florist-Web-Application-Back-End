package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService implements IService<Address, Long>{

    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address read(Long aLong) {
        return addressRepository.findById(aLong).orElseThrow(() -> new IllegalStateException("Address with id "
                + aLong + " does not exist"));
    }

    @Override
    public Address update(Address address) {
        if (addressRepository.existsById(address.getAddressId())){
            return addressRepository.save(address);
        } else {
            throw new IllegalStateException("Address with id " + address.getAddressId() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (addressRepository.existsById(d)){
            addressRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Address with id " + d + " does not exist");
        }
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
