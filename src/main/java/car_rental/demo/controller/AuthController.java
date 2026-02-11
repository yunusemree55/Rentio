package car_rental.demo.controller;

import car_rental.demo.business.abstracts.AuthService;
import car_rental.demo.business.requests.auth.RegisterCustomerRequest;
import car_rental.demo.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/customer/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Result registerCustomer(@Validated @RequestBody RegisterCustomerRequest registerCustomerRequest){

        return authService.registerCustomer(registerCustomerRequest);

    }

}
