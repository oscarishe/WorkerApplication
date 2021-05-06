package net.codejava.Service;

import net.codejava.Model.Document;
import net.codejava.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository repo;

    public List<Document> listAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public void save(Document document) {
        repo.save(document);
    }
    public Document get(Long id) {
        return repo.findById(id).get();
    }
    public List<Document> getByType(String type) {
        return repo.selectByType(type);
    }
}
