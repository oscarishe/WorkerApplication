package net.codejava.Repository;

import net.codejava.Model.Fired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FiredWorkerRepository extends JpaRepository<Fired, Long> {

        @Query("select  u from Fired u where u.identity = ?1")
        public Fired getByWorkerId(Long id);

        @Query("select  u from Fired u where u.identity = ?1")
        public List<Fired> ListByWorkerId(Long id);
}
