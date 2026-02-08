package car_rental.demo.business.concretes;

import car_rental.demo.business.abstracts.CustomerService;
import car_rental.demo.business.requests.customerRequests.AddCustomerRequest;
import car_rental.demo.business.responses.customerResponses.GetAllCustomerResponse;
import car_rental.demo.business.rules.customer.CustomerBusinessRules;
import car_rental.demo.business.rules.user.UserBusinessRules;
import car_rental.demo.core.utilities.hashing.HashingService;
import car_rental.demo.core.utilities.mapper.ModelMapperService;
import car_rental.demo.dataAccess.abstracts.CustomerRepository;
import car_rental.demo.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapperService mapperService;
    private UserBusinessRules<Customer> userBusinessRules;
    private CustomerBusinessRules customerBusinessRules;
    private HashingService hashingService;

    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<GetAllCustomerResponse> responseList = customerRepository.findAll().stream().map(customer -> mapperService.forResponse().map(customer,GetAllCustomerResponse.class)).toList();
        return responseList;
    }

    @Override
    public void add(AddCustomerRequest customerRequest) {

        userBusinessRules.checkIfEmailExists(customerRequest.getEmail());
        userBusinessRules.checkIfPhoneNumberExists(customerRequest.getPhoneNumber());
        userBusinessRules.checkIfPasswordsMatch(customerRequest.getPassword(),customerRequest.getConfirmPassword());

        Customer customer = mapperService.forRequest().map(customerRequest,Customer.class);
        customer.setPassword(hashingService.encode(customer.getPassword()));

        customerRepository.save(customer);
    }
}
