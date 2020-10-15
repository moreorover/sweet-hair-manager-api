package martin.dev.sweethair.dtos.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import martin.dev.sweethair.dtos.base.AppointmentDtoBase;
import martin.dev.sweethair.dtos.base.UserDtoBase;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoFull extends UserDtoBase {

//    private Long id;
//    private String firstName;
//    private String lastName;
    private List<AppointmentDtoBase> appointments;
}
