package martin.dev.sweethair.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDtoBase {

    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime finishTime;
}
