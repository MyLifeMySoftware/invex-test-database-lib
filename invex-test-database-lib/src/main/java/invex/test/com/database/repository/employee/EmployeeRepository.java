package invex.test.com.database.repository.employee;

import invex.test.com.database.entity.employee.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findByFirstName(String firstName);

    @Query("""
            SELECT e FROM Employee e WHERE e.enabled = true AND e.deleted = false
            """)
    List<Employee> findAllActiveEmployees();

    @Query("""
            SELECT e FROM Employee e WHERE e.enabled = :enabled AND e.deleted = false
            """)
    List<Employee> findByEnabled(@Param("enabled") boolean enabled);

    @Query("""
            SELECT e FROM Employee e WHERE e.deleted = false AND (
            LOWER(e.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR
            LOWER(e.middleName) LIKE LOWER(CONCAT('%', :name, '%')) OR
            LOWER(e.lastNameFather) LIKE LOWER(CONCAT('%', :name, '%')) OR
            LOWER(e.lastNameMother) LIKE LOWER(CONCAT('%', :name, '%'))
            )
            """)
    List<Employee> searchEmployees(@Param("name") String name);
}
