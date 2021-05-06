package net.codejava.Service;

import net.codejava.Model.Vacancy;
import net.codejava.Repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository repo;

    public List<Vacancy> listAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public void save(Vacancy vacancy) {
        repo.save(vacancy);
    }
    public Vacancy get(Long id) {
        return repo.findById(id).get();
    }
    public List<Vacancy> listAllActive() {
        return repo.listAllActive();
    }
    public List<Vacancy> listAllArchive() {
        return repo.listAllArchive();
    }
}
