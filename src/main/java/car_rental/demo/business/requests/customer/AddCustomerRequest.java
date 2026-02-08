package car_rental.demo.business.requests.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {

    @Size(min = 2,message = "{validation.size}")
    @NotBlank(message = "{validation.notBlank}")
    private String firstName;

    @Size(min = 2,message = "{validation.size}")
    @NotBlank(message = "{validation.notBlank}")
    private String lastName;

    @Email(message = "{validation.email}")
    @NotBlank(message = "{validation.notBlank}")
    private String email;

    @NotBlank(message = "{validation.notBlank}")
    private String phoneNumber;

    @Size(min = 6,message = "{validation.size}")
    @NotBlank(message = "{validation.notBlank}")
    private String password;

}
