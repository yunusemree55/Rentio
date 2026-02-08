package car_rental.demo.business.abstracts;

import car_rental.demo.business.requests.auth.RegisterCustomerRequest;

public interface AuthService {

    void registerCustomer(RegisterCustomerRequest registerCustomerRequest);

}
