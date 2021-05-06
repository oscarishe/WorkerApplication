package net.codejava.Repository;

import net.codejava.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentRepository extends JpaRepository <Document, Long> {
    @Query("Select u from Document u Where u.type=?1")
    List<Document> selectByType(String type);
}
