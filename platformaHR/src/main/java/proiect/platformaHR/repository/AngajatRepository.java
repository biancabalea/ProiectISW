package proiect.platformaHR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proiect.platformaHR.entity.Angajat;
@Repository
public interface AngajatRepository extends JpaRepository<Angajat, Integer> {
}
