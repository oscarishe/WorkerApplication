package net.codejava.Repository;

import net.codejava.Model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("SELECT u FROM Worker u WHERE u.isActive = true")
    public List<Worker> listAllActive();
}
