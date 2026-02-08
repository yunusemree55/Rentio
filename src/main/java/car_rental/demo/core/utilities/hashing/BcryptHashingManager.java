package car_rental.demo.core.utilities.hashing;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BcryptHashingManager implements HashingService{

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String encode(CharSequence rawPassword) {

        String encodedPassword = passwordEncoder.encode(rawPassword);

        return encodedPassword;

    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        boolean isMatches = passwordEncoder.matches(rawPassword,encodedPassword);

        return isMatches;
    }
}
