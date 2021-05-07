package net.codejava.Service;

import net.codejava.Model.Punishment;
import net.codejava.Repository.PunishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunishmentService  {
    @Autowired
    private PunishmentRepository repo;

    public List<Punishment> listAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public void save(Punishment punishment) {
        repo.save(punishment);
    }
    public Punishment get(Long id) {
        return repo.findById(id).get();
    }
    public List <Punishment> listByWorkerId(Long id) {
        return repo.listByWorkerId(id);
    }
    public List<Punishment> listAllActive() {
        return repo.listAllActive();
    }
    public List<Punishment> listAllArchive() {
        return  repo.listAllArchive();
    }
}
