package net.codejava.Repository;

import net.codejava.Model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("SELECT u FROM Worker u WHERE u.isActive = true")
    public List<Worker> listAllActive();

    @Query("SELECT u FROM Worker u WHERE u.isActive = false")
    public List<Worker> listAllUnactive();

    @Query("select u from Worker u Where u.status=2")
    public List<Worker> listAllVacated();

    @Query("select u from Worker u Where u.status=3")
    public List<Worker> listAllSick();

    @Query("SELECT u from Worker u where u.departmentId=?1")
    public List<Worker> listByDepartment(Long id);
    @Query("SELECT count(u) from Worker u where u.departmentId=?1")
    public int getCountByDepartment(Long id);
    @Query("select count(u) from Worker u where u.gender=:gender")
    public int getCountByGender(String gender);
    @Query("select count(u) from Worker u where year(u.employDate)=?1")
    public  int getEmployByYear(int year);
}
