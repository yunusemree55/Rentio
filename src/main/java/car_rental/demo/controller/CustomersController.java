package car_rental.demo.controller;

import car_rental.demo.business.abstracts.CustomerService;
import car_rental.demo.business.requests.customer.AddCustomerRequest;
import car_rental.demo.business.responses.customer.GetAllCustomerResponse;
import car_rental.demo.core.utilities.results.DataResult;
import car_rental.demo.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomersController {

    private CustomerService customerService;

    @GetMapping("/all")
    private DataResult<List<GetAllCustomerResponse>> getAll(){

        return customerService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    private Result add(@Validated @RequestBody AddCustomerRequest customerRequest){
        return customerService.add(customerRequest);
    }

}
