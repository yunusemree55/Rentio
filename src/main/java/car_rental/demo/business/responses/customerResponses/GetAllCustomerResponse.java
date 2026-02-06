package car_rental.demo.business.responses.customerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}
