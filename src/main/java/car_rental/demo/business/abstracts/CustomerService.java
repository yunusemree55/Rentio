package car_rental.demo.business.abstracts;

import car_rental.demo.business.requests.customer.AddCustomerRequest;
import car_rental.demo.business.responses.customer.GetAllCustomerResponse;
import car_rental.demo.core.utilities.results.DataResult;
import car_rental.demo.core.utilities.results.Result;

import java.util.List;

public interface CustomerService {

    DataResult<List<GetAllCustomerResponse>> getAll();
    Result add(AddCustomerRequest customerRequest);

}
