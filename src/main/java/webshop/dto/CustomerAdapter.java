package webshop.dto;

import webshop.domain.Customer;

public class CustomerAdapter {
    public static CustomerDTO toDTO(Customer customer){
        if (customer == null) return null;
        return new CustomerDTO(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), "","","","","");
    }

    public static Customer fromDTO(CustomerDTO customerDTO){
        return new Customer(customerDTO.getCustomerId(), customerDTO.getFirstName(), customerDTO.getLastName());
    }
}
