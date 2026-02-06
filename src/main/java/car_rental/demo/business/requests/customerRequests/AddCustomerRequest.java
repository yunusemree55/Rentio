package car_rental.demo.business.requests.customerRequests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCustomerRequest {

    @Size(min = 2,message = "First name field's length should be at least 2")
    @NotBlank(message = "This field is required")
    private String firstName;

    @Size(min = 2,message = "Last name field's length should be at least 2")
    @NotBlank(message = "This field is required")
    private String lastName;

    @Email(message = "Please write valid email")
    @NotBlank(message = "This field is required")
    private String email;

    @NotBlank(message = "This field is required")
    private String phoneNumber;

    @NotBlank(message = "This field is required")
    @Size(min = 6,message = "Password field's length should be at least 6")
    private String password;

    @NotBlank(message = "This field is required")
    private String confirmPassword;

}
