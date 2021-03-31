package net.codejava.Service;

import java.util.ArrayList;
import java.util.List;

import net.codejava.Model.Worker;
import net.codejava.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository repo;

    public List<Worker> listAll() {
        return repo.findAll();
    }
    public List<Worker> listAllActive() {
        return repo.listAllActive();
    }
    public void save(Worker worker) {
        repo.save(worker);
    }

    public Worker get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public int getCountOfWorkers() {

        return repo.findAll().size();
    }
}
