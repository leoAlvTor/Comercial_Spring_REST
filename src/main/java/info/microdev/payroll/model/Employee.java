package info.microdev.payroll.model;

import info.microdev.payroll.repository.EmployeeRepository;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && name.equals(employee.name) && role.equals(employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }
}
