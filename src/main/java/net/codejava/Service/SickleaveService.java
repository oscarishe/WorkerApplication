package net.codejava.Service;


import net.codejava.Model.Sickleave;

import net.codejava.Repository.SickleaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SickleaveService {
    @Autowired
    SickleaveRepository repo;

    public List<Sickleave> listAll() {
        return repo.findAll();
    }

    public void save(Sickleave sickleave) {
        repo.save(sickleave);
    }

    public Sickleave get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Sickleave> listById(Long id) {
        return repo.listById(id);
    }
}
