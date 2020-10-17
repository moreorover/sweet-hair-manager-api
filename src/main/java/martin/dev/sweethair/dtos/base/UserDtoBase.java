package martin.dev.sweethair.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoBase {

    private Long id;
    private String firstName;
    private String lastName;
}
