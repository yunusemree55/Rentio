package car_rental.demo.core.utilities.hashing;

public interface HashingService {

    String encode(CharSequence rawPassword);
    boolean matches(CharSequence rawPassword, String encodedPassword);

}
