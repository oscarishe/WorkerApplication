package net.codejava.Service;

import java.util.List;

import net.codejava.Model.Worker;
import net.codejava.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository repo;

    public List<Worker> listAll() {
        return repo.findAll();
    }
    public void save(Worker product) {
        repo.save(product);
    }

    public Worker get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
