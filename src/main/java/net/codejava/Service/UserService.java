package net.codejava.Service;

import java.util.List;

import net.codejava.Model.User;
import net.codejava.Repository.AllUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private AllUserRepository repo;
    public List<User> listAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
