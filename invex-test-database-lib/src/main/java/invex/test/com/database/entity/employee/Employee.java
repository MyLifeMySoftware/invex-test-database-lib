package invex.test.com.database.entity.employee;

import invex.test.com.database.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name = "tr_employee")
@Comment("Employees registered in the system")
public class Employee extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1234567890123456789L;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(nullable = false)
    @Comment("Employee first name")
    private String firstName;

    @Size(max = 50, message = "Middle name must be up to 50 characters")
    @Comment("Employee middle name")
    private String middleName;

    @NotBlank(message = "Last name (father) is required")
    @Size(min = 2, max = 50, message = "Last name (father) must be between 2 and 50 characters")
    @Column(nullable = false)
    @Comment("Employee paternal last name")
    private String lastNameFather;

    @Size(max = 50, message = "Last name (mother) must be up to 50 characters")
    @Comment("Employee maternal last name")
    private String lastNameMother;

    @NotNull(message = "Age is required")
    @Comment("Employee age")
    private Integer age;

    @NotBlank(message = "Gender is required")
    @Size(max = 10, message = "Gender must be up to 10 characters")
    @Comment("Employee gender")
    private String gender;

    @NotNull(message = "Birth date is required")
    @Comment("Employee birth date (dd-MM-yyyy)")
    private LocalDate birthDate;

    @NotBlank(message = "Position is required")
    @Size(min = 2, max = 100, message = "Position must be between 2 and 100 characters")
    @Column(nullable = false)
    @Comment("Employee position")
    private String position;
}
