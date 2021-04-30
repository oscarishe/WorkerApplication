package net.codejava.Repository;

import net.codejava.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository <Document, Long> {
}
