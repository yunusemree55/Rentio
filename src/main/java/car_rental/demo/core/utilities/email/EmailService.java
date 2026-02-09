package car_rental.demo.core.utilities.email;

import java.util.Locale;
import java.util.Map;

public interface EmailService {

    void sendHtmlMail(String to, String subject, String template, Map<String,Object> variables, Locale locale);

}
