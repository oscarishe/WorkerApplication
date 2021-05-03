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
    public List<Worker> listAllunactive() {
        return repo.listAllUnactive();
    }
    public List<Worker> listAllSick() {
        return repo.listAllSick();
    }
    public List<Worker> listAllVacated(){
        return repo.listAllVacated();
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
    public int getCountByGender(String gender) {
        return repo.getCountByGender(gender);
    }
    public int getCountByDepartment(Long id) {
        return repo.getCountByDepartment(id);
    }
    public List <Worker> findByDepartmentId(Long id) {
        return repo.listByDepartment(id);
    }
    public int getEmployByYear(int year) {
        return repo.getEmployByYear(year);
    }
}
