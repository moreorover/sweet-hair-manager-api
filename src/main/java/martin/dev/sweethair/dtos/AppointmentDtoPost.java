package martin.dev.sweethair.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentDtoPost {

    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime finishTime;
    private Long userId;
}
