package net.codejava.Service;

import net.codejava.Model.Department;
import net.codejava.Model.Worker;
import net.codejava.Repository.DepartmentRepository;
import net.codejava.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    @Autowired
    private WorkerRepository workerRepository;
    public List<Department> listAll() {
        return repo.findAll();
    }

    public void save(Department department) {
        repo.save(department);
    }

    public Department get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public int getCountOfWorkers(int id) {
        List <Department> listDep = repo.findAll();
        int count =0;
        List <Worker> listWorker = workerRepository.findAll();
        for(int i=0;i<listWorker.size();i++) {
            if(listWorker.get(i).getDepartmentId().equals(listDep.get(id).getId()))
                count++;
        }
        return count;
    }
}
