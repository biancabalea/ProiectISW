package proiect.platformaHR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proiect.platformaHR.entity.Departament;
@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Integer> {
}
