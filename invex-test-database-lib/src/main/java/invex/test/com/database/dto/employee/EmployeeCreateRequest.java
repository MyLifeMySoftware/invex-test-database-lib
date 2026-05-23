package invex.test.com.database.dto.employee;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateRequest {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50)
    private String firstName;

    @Size(max = 50)
    private String middleName;

    @NotBlank(message = "Father last name is required")
    @Size(min = 2, max = 50)
    private String lastNameFather;

    @Size(max = 50)
    private String lastNameMother;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Employee must be at least 18 years old")
    private Integer age;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female or Other")
    private String gender;

    @NotNull(message = "Birth date is required")
    private String birthDate;

    @NotBlank(message = "Position is required")
    @Size(min = 2, max = 100)
    private String position;
}
