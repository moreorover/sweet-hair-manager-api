package martin.dev.sweethair.repositories;

import martin.dev.sweethair.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getById(Long aLong);
}
