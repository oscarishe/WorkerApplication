package net.codejava.Service;

import net.codejava.Model.Fired;
import net.codejava.Repository.FiredWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiredWorkerService {

    @Autowired
    FiredWorkerRepository repo;

    public List<Fired> listAll() {
        return repo.findAll();
    }

    public void save(Fired worker) {
        worker.setDate();
        repo.save(worker);
    }
    public Fired getByWorkerId(Long id) {
        return repo.getByWorkerId(id);
    }
    public Fired get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
