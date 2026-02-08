package car_rental.demo.business.rules.user;

import car_rental.demo.core.exceptions.BusinessException;
import car_rental.demo.dataAccess.abstracts.UserRepository;
import car_rental.demo.entities.abstracts.User;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules<T extends User> {

    private UserRepository<T> userRepository;
    private MessageSource messageSource;

    public void checkIfEmailExists(String email){

        boolean isExists = userRepository.existsByEmail(email);

        if(isExists){
            throw new BusinessException(messageSource.getMessage("error.user.email.exists",null, LocaleContextHolder.getLocale()));
        }

    }

    public void checkIfPhoneNumberExists(String phoneNumber){

        boolean isExists = userRepository.existsByPhoneNumber(phoneNumber);

        if(isExists){
            throw new BusinessException(messageSource.getMessage("error.user.phoneNumber.exists",null,LocaleContextHolder.getLocale()));
        }

    }

    public void checkIfPasswordsMatch(String password,String confirmPassword){

        boolean isMatches = password.equals(confirmPassword);

        if(!isMatches){
            throw new BusinessException(messageSource.getMessage("error.user.password.mismatch",null,LocaleContextHolder.getLocale()));
        }

    }

}
