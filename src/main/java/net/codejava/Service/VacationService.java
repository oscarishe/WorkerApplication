package net.codejava.Service;


import net.codejava.Model.Vacation;
import net.codejava.Repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationService {
    @Autowired
    VacationRepository repo;
    public List<Vacation> listAll() {
        return repo.findAll();
    }

    public void save(Vacation vacation) {
        repo.save(vacation);
    }

    public Vacation get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Vacation> listById(Long id) {
        return repo.listById(id);
    }
}
