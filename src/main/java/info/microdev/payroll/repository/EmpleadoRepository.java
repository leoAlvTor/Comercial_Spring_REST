package info.microdev.payroll.repository;

import info.microdev.payroll.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

    @Query(value = "SELECT * FROM empleado WHERE cedula = ?1 and password = ?2", nativeQuery = true)
    Optional<Empleado> findByUserAndPassword(String cedula, String password);

}
