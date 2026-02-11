package car_rental.demo.business.rules.user;

import car_rental.demo.core.exceptions.BusinessException;
import car_rental.demo.core.utilities.messages.MessageService;
import car_rental.demo.dataAccess.abstracts.UserRepository;
import car_rental.demo.entities.abstracts.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules<T extends User> {

    private UserRepository<T> userRepository;
    private MessageService messageService;

    public void checkIfEmailExists(String email){

        boolean isExists = userRepository.existsByEmail(email);

        if(isExists){
            throw new BusinessException(messageService.getMessage("error.user.email.exists"));
        }

    }

    public void checkIfPhoneNumberExists(String phoneNumber){

        boolean isExists = userRepository.existsByPhoneNumber(phoneNumber);

        if(isExists){
            throw new BusinessException(messageService.getMessage("error.user.phoneNumber.exists"));
        }

    }

    public void checkIfPasswordsMatch(String password,String confirmPassword){

        boolean isMatches = password.equals(confirmPassword);

        if(!isMatches){
            throw new BusinessException(messageService.getMessage("error.user.password.mismatch"));
        }

    }

}
