package net.codejava.Repository;

import net.codejava.Model.Punishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PunishmentRepository extends JpaRepository<Punishment, Long> {

    @Query("select u from Punishment u where u.worker=?1 and u.status=1")
    List<Punishment> listByWorkerId(Long id);

    @Query("select u from Punishment u where u.status=1")
    List<Punishment> listAllActive();

    @Query("select u from Punishment u where u.status=0")
    List<Punishment> listAllArchive();
}
