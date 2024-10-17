package za.ac.cput.mapper;

import za.ac.cput.domain.Customer;
import za.ac.cput.dto.CustomerDto;

public class UserMapper {

    public static CustomerDto mapOut(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPassword(customer.getPassword());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        return customerDto;
    }

}
