package net.codejava.Controller;

import net.codejava.Model.Product;
import net.codejava.Model.Worker;
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

    @RequestMapping("/workers")
    public String viewWorkerPage(Model model) {
        List<Worker> listWorker = workService.listAll();
        model.addAttribute("listWorker", listWorker);
        return "workers";
    }
}
