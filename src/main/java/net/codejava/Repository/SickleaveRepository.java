package net.codejava.Repository;


import net.codejava.Model.Sickleave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SickleaveRepository extends JpaRepository<Sickleave, Long> {

    @Query("select u from Sickleave u where u.identity=?1")
    List<Sickleave> listById(Long id);
    @Query("select u from Sickleave u where u.end>CURRENT_DATE")
    List<Sickleave> listActive();
    @Query("select u from Sickleave u where u.end<CURRENT_DATE order by u.end desc ")
    List<Sickleave> listArchive();
}
