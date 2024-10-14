package pe.com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String>{

}
