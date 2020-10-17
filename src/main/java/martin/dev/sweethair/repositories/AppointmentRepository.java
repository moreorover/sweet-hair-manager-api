package martin.dev.sweethair.repositories;

import martin.dev.sweethair.entities.Appointment;
import martin.dev.sweethair.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Appointment getById(Long aLong);
}
