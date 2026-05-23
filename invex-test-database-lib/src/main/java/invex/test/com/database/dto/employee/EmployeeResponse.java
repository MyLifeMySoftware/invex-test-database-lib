package invex.test.com.database.dto.employee;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private String id;
    private String firstName;
    private String middleName;
    private String lastNameFather;
    private String lastNameMother;
    private Integer age;
    private String gender;
    private LocalDate birthDate;
    private String position;
    private Boolean enabled;
}
