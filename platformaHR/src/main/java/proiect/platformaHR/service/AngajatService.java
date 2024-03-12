package proiect.platformaHR.service;

import org.springframework.stereotype.Service;
import proiect.platformaHR.entity.Angajat;
import proiect.platformaHR.repository.AngajatRepository;

import java.util.List;

@Service
public class AngajatService {
    private AngajatRepository angajatRepository;

    public AngajatService(AngajatRepository angajatRepository) {
        this.angajatRepository = angajatRepository;
    }

    public List<Angajat> getAllAngajats() {
        return angajatRepository.findAll();
    }
    public Angajat getAngajat(Integer id){
        return angajatRepository.findById(id).get();
    }

    public Angajat createAngajat(Angajat angajat){
        return angajatRepository.save(angajat);
    }

    public Angajat updateAngajat(Integer id,Angajat angajat) {
        angajat.setId(id);
        return angajatRepository.save(angajat);
    }
    public Angajat updatePatchAngajat(Integer id,Angajat angajat) {
        Angajat modifiedAngajat = angajatRepository.findById(id).get();
        if(angajat.getName() != null) {
            modifiedAngajat.setName(angajat.getName());
        }
        if(angajat.isFulltime()) {
            modifiedAngajat.setFulltime(angajat.isFulltime());
        }
        if(angajat.getSalariu() != null){
            modifiedAngajat.setSalariu(angajat.getSalariu());
        }
        return angajatRepository.save(modifiedAngajat);
    }

    public void deleteAngajat(Integer id) {
        angajatRepository.deleteById(id);
    }

}
