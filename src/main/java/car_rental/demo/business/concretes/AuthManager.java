package car_rental.demo.business.concretes;

import car_rental.demo.business.abstracts.AuthService;
import car_rental.demo.business.abstracts.CustomerService;
import car_rental.demo.business.requests.auth.RegisterCustomerRequest;
import car_rental.demo.business.requests.customer.AddCustomerRequest;
import car_rental.demo.business.rules.auth.AuthBusinessRules;
import car_rental.demo.core.utilities.email.EmailService;
import car_rental.demo.core.utilities.mapper.ModelMapperService;
import car_rental.demo.core.utilities.messages.MessageService;
import car_rental.demo.core.utilities.results.ErrorResult;
import car_rental.demo.core.utilities.results.Result;
import car_rental.demo.core.utilities.results.SuccessResult;
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
    private MessageService messageService;

    @Override
    public Result registerCustomer(RegisterCustomerRequest registerCustomerRequest) {

        authBusinessRules.checkIfPasswordsMatch(registerCustomerRequest.getPassword(),registerCustomerRequest.getConfirmPassword());

        AddCustomerRequest customerRequest = mapperService.forRequest().map(registerCustomerRequest,AddCustomerRequest.class);

        Result result = customerService.add(customerRequest);


        if(result.isSuccess()){
            Map<String,Object> mailVariables = new HashMap<>();
            String name = registerCustomerRequest.getFirstName() + " " + registerCustomerRequest.getLastName();
            mailVariables.put("name",name);
            emailService.sendHtmlMail(customerRequest.getEmail(),"email.welcome.subject","welcome",mailVariables, LocaleContextHolder.getLocale());

            return new SuccessResult(messageService.getMessage("auth.register.success"));
        }

        return new ErrorResult();
    }

}
