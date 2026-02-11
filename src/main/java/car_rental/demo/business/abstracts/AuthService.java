package car_rental.demo.business.abstracts;

import car_rental.demo.business.requests.auth.RegisterCustomerRequest;
import car_rental.demo.core.utilities.results.Result;

public interface AuthService {

    Result registerCustomer(RegisterCustomerRequest registerCustomerRequest);

}
