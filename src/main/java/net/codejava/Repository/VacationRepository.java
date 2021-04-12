package net.codejava.Repository;

import net.codejava.Model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository <Vacation, Long> {

}
