package car_rental.demo.core.utilities.messages;

import java.util.Map;

public interface MessageService {

    String getMessage(String key);
    String getMessage(String key, Object... args);
}
