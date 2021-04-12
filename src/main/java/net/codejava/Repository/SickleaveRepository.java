package net.codejava.Repository;


import net.codejava.Model.Sickleave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SickleaveRepository extends JpaRepository<Sickleave, Long> {
}
