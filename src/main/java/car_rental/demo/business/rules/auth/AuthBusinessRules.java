package car_rental.demo.business.rules.auth;

import car_rental.demo.core.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthBusinessRules {

    private MessageSource messageSource;

    public void checkIfPasswordsMatch(String password,String confirmPassword){

        boolean isMatches = password.equals(confirmPassword);

        if(!isMatches){
            throw new BusinessException(messageSource.getMessage("error.user.password.mismatch",null, LocaleContextHolder.getLocale()));
        }

    }

}
