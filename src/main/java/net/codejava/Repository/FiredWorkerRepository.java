package net.codejava.Repository;

import net.codejava.Model.Fired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FiredWorkerRepository extends JpaRepository<Fired, Long> {

        @Query("select  u from Fired u where u.worker = ?1")
        public Fired getByWorkerId(Long id);
}
