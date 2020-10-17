package martin.dev.sweethair.dtos.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import martin.dev.sweethair.dtos.base.AppointmentDtoBase;
import martin.dev.sweethair.dtos.base.UserDtoBase;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDtoFull extends AppointmentDtoBase {

    private UserDtoBase user;
}
