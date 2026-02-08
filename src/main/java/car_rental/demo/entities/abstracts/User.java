package car_rental.demo.entities.abstracts;

import car_rental.demo.entities.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public abstract class User extends BaseEntity{

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "phoneNumber",unique = true)
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AccountStatus status = AccountStatus.ACTIVE;

}
