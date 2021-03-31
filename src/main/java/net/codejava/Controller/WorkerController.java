package net.codejava.Controller;

import net.codejava.Model.Department;
import net.codejava.Model.Fired;
import net.codejava.Model.Worker;
import net.codejava.Service.DepartmentService;
import net.codejava.Service.FiredWorkerService;
import net.codejava.Service.UserService;
import net.codejava.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WorkerController {

    @Autowired
    private WorkerService workService;
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService depService;
    @Autowired
    private FiredWorkerService fireService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Worker> listWorker = workService.listAllActive();
        model.addAttribute("workerCount", workService.getCountOfWorkers());
        model.addAttribute("listWorker", listWorker);
        return "index";
    }
    @RequestMapping("/delete/{id}")
    public String deleteWorker(@PathVariable(name = "id") Long id) {
        workService.delete(id);
        return "redirect:/";
    }
    @RequestMapping("/fire/{id}")
    public String fireWorker(@PathVariable(name = "id") Long id) {
        Worker worker = workService.get(id);
        worker.setActive(false);
        workService.save(worker);
        Fired firedWorker = new Fired();
        firedWorker.setWorker(id);
        fireService.save(firedWorker);
        return "redirect:/";
    }
    @RequestMapping("/new")
    public String showNewProductForm(Model model) {
        Worker worker = new Worker();
        List <Department> listDep = depService.listAll();
        model.addAttribute("worker", worker);
        model.addAttribute("listDep",listDep);
        return "new_worker";

    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveWorker(@ModelAttribute("worker") Worker worker) {
        worker.setActive(true);
        workService.save(worker);

        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_worker");
        List <Department> listDep = depService.listAll();
        Worker worker = workService.get(id);
        mav.addObject("listDep",listDep);
        mav.addObject("worker", worker);

        return mav;
    }
}
