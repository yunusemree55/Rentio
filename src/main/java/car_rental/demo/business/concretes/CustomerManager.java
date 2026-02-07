package car_rental.demo.business.concretes;

import car_rental.demo.business.abstracts.CustomerService;
import car_rental.demo.business.requests.customerRequests.AddCustomerRequest;
import car_rental.demo.business.responses.customerResponses.GetAllCustomerResponse;
import car_rental.demo.core.exceptions.BusinessException;
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

    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<GetAllCustomerResponse> responseList = customerRepository.findAll().stream().map(customer -> mapperService.forResponse().map(customer,GetAllCustomerResponse.class)).toList();
        return responseList;
    }

    @Override
    public void add(AddCustomerRequest customerRequest) {

        if(!customerRequest.getPassword().equals(customerRequest.getConfirmPassword())){
            throw new BusinessException("Password fields are not matched");
        }

        Customer customer = mapperService.forRequest().map(customerRequest,Customer.class);
        customerRepository.save(customer);
    }
}
