package net.codejava.Repository;

import net.codejava.Model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VacationRepository extends JpaRepository <Vacation, Long> {


    @Query("select u from Vacation u where u.identity=?1")
    List<Vacation> listById(Long id);
}
