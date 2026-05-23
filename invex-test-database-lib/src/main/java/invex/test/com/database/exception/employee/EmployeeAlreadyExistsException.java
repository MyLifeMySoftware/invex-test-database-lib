package invex.test.com.database.exception.employee;

import java.util.List;
import lombok.Getter;

@Getter
public class EmployeeAlreadyExistsException extends RuntimeException {
    private final List<String> conflicts;

    public EmployeeAlreadyExistsException(String message, List<String> conflicts) {
        super(message);
        this.conflicts = conflicts;
    }

}
