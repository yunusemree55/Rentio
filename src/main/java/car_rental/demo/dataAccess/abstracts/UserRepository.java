package car_rental.demo.dataAccess.abstracts;

import car_rental.demo.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T,Integer> {

}
