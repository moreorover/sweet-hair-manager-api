package martin.dev.sweethair.services;

import lombok.AllArgsConstructor;
import martin.dev.sweethair.dtos.AppointmentDtoPost;
import martin.dev.sweethair.dtos.base.AppointmentDtoBase;
import martin.dev.sweethair.entities.Appointment;
import martin.dev.sweethair.entities.User;
import martin.dev.sweethair.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AppointmentService {

    private final UserService userService;
    private final AppointmentRepository appointmentRepository;

    public Appointment save(AppointmentDtoPost appointmentDtoPost) {
        User user = userService.getById(appointmentDtoPost.getUserId());
        Appointment appointment = Appointment.builder()
                .user(user)
                .date(appointmentDtoPost.getDate())
                .startTime(appointmentDtoPost.getStartTime())
                .finishTime(appointmentDtoPost.getFinishTime())
                .description(appointmentDtoPost.getDescription())
                .build();
        return appointmentRepository.save(appointment);
    }

    public Appointment getById(Long id) {
        return appointmentRepository.getById(id);
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public Appointment updateById(AppointmentDtoPost appointmentDtoBase) {
        Appointment appointment = appointmentRepository.getById(appointmentDtoBase.getId());

        appointment.setDate(appointmentDtoBase.getDate());
        appointment.setStartTime(appointmentDtoBase.getStartTime());
        appointment.setFinishTime(appointmentDtoBase.getFinishTime());
        appointment.setDescription(appointment.getDescription());
        appointmentRepository.save(appointment);
        return appointment;
    }
}
