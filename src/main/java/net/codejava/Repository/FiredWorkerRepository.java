package net.codejava.Repository;

import net.codejava.Model.Fired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FiredWorkerRepository extends JpaRepository<Fired, Long> {


}
