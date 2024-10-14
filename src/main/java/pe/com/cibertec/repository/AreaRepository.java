package pe.com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.model.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

}
