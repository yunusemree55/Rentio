package car_rental.demo.business.concretes;

import car_rental.demo.business.abstracts.CustomerService;
import car_rental.demo.business.requests.customer.AddCustomerRequest;
import car_rental.demo.business.responses.customer.GetAllCustomerResponse;
import car_rental.demo.business.rules.customer.CustomerBusinessRules;
import car_rental.demo.business.rules.user.UserBusinessRules;
import car_rental.demo.core.utilities.hashing.HashingService;
import car_rental.demo.core.utilities.mapper.ModelMapperService;
import car_rental.demo.core.utilities.messages.MessageService;
import car_rental.demo.core.utilities.results.DataResult;
import car_rental.demo.core.utilities.results.Result;
import car_rental.demo.core.utilities.results.SuccessDataResult;
import car_rental.demo.core.utilities.results.SuccessResult;
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
    private MessageService messageService;

    @Override
    public DataResult<List<GetAllCustomerResponse>> getAll() {

        List<GetAllCustomerResponse> responseList = customerRepository.findAll().stream().map(customer -> mapperService.forResponse().map(customer,GetAllCustomerResponse.class)).toList();
        return new SuccessDataResult<List<GetAllCustomerResponse>>(responseList,messageService.getMessage("customer.listed"));
    }

    @Override
    public Result add(AddCustomerRequest customerRequest) {

        userBusinessRules.checkIfEmailExists(customerRequest.getEmail());
        userBusinessRules.checkIfPhoneNumberExists(customerRequest.getPhoneNumber());

        Customer customer = mapperService.forRequest().map(customerRequest,Customer.class);
        customer.setPassword(hashingService.encode(customer.getPassword()));

        customerRepository.save(customer);
        return new SuccessResult(messageService.getMessage("customer.added"));
    }
}
