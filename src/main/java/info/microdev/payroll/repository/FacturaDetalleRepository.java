package info.microdev.payroll.repository;

import info.microdev.payroll.model.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Long> {
}
