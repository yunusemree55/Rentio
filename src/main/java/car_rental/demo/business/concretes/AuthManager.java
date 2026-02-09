package car_rental.demo.business.concretes;

import car_rental.demo.business.abstracts.AuthService;
import car_rental.demo.business.abstracts.CustomerService;
import car_rental.demo.business.requests.auth.RegisterCustomerRequest;
import car_rental.demo.business.requests.customer.AddCustomerRequest;
import car_rental.demo.business.rules.auth.AuthBusinessRules;
import car_rental.demo.core.utilities.email.EmailService;
import car_rental.demo.core.utilities.mapper.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private ModelMapperService mapperService;
    private AuthBusinessRules authBusinessRules;
    private CustomerService customerService;
    private EmailService emailService;

    @Override
    public void registerCustomer(RegisterCustomerRequest registerCustomerRequest) {

        authBusinessRules.checkIfPasswordsMatch(registerCustomerRequest.getPassword(),registerCustomerRequest.getConfirmPassword());

        AddCustomerRequest customerRequest = mapperService.forRequest().map(registerCustomerRequest,AddCustomerRequest.class);

        customerService.add(customerRequest);


        Map<String,Object> mailVariables = new HashMap<>();
        String name = registerCustomerRequest.getFirstName() + " " + registerCustomerRequest.getLastName();
        mailVariables.put("name",name);
        emailService.sendHtmlMail(customerRequest.getEmail(),"email.welcome.subject","welcome",mailVariables, LocaleContextHolder.getLocale());

    }
}
