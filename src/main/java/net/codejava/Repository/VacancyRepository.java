package net.codejava.Repository;

import net.codejava.Model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface VacancyRepository extends JpaRepository <Vacancy, Long> {

    @Query("Select u from Vacancy u where u.status=1")
    List <Vacancy> listAllActive();

    @Query("Select u from Vacancy u where u.status=0")
    List <Vacancy> listAllArchive();
}
