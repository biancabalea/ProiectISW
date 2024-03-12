package proiect.platformaHR.service;

import org.springframework.stereotype.Service;
import proiect.platformaHR.entity.Departament;
import proiect.platformaHR.repository.DepartamentRepository;

import java.util.List;

@Service
public class DepartamentService {
    private final DepartamentRepository departamentRepository;

    public DepartamentService(DepartamentRepository departamentRepository) {
        this.departamentRepository = departamentRepository;
    }
    public List<Departament> getAllDepartements() {
        return departamentRepository.findAll();
    }

    public Departament getDepartament (Integer id) {
        return departamentRepository.findById(id).get();
    }
    public Departament createDepartament(Departament departament){
        return departamentRepository.save(departament);
    }
    public void deleteDepartament(Integer id) {
        departamentRepository.deleteById(id);
    }
}
