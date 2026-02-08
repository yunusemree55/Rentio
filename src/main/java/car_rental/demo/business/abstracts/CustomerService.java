package car_rental.demo.business.abstracts;

import car_rental.demo.business.requests.customer.AddCustomerRequest;
import car_rental.demo.business.responses.customer.GetAllCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetAllCustomerResponse> getAll();
    void add(AddCustomerRequest customerRequest);

}
