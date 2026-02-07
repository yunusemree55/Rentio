package car_rental.demo.core.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@AllArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    private MessageSource messageSource;


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleBusinessException(BusinessException businessException){

        ProblemDetail problemDetail = new ProblemDetail();
        problemDetail.setMessage(businessException.getMessage());

        return problemDetail;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetail handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){

        ValidationProblemDetail validationProblemDetail = new ValidationProblemDetail();
        validationProblemDetail.setErrors(new HashMap<>());

        String errorMessage = messageSource.getMessage("error.message",null, LocaleContextHolder.getLocale());

        validationProblemDetail.setMessage(errorMessage);

        for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationProblemDetail.getErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return validationProblemDetail;

    }

}
