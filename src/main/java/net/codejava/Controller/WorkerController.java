package net.codejava.Controller;

import net.codejava.Model.Product;
import net.codejava.Model.User;
import net.codejava.Model.Worker;
import net.codejava.Service.UserService;
import net.codejava.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WorkerController {

    @Autowired
    private WorkerService workService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Worker> listWorker = workService.listAll();
        List<User> listUser = userService.listAll();
        model.addAttribute("listUser", listUser);
        model.addAttribute("listWorker", listWorker);
        return "index";
    }
}
