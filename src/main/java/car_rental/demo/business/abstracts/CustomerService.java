package car_rental.demo.business.abstracts;

import car_rental.demo.business.requests.customerRequests.AddCustomerRequest;
import car_rental.demo.business.responses.customerResponses.GetAllCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetAllCustomerResponse> getAll();
    void add(AddCustomerRequest customerRequest);

}
