package net.codejava.Controller;

import net.codejava.Model.Product;
import net.codejava.Model.User;
import net.codejava.Model.Worker;
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

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Worker> listWorker = workService.listAll();
        model.addAttribute("workerCount", workService.getCountOfWorkers());
        model.addAttribute("listWorker", listWorker);
        return "index";
    }
    @RequestMapping("/delete/{id}")
    public String deleteWorker(@PathVariable(name = "id") Long id) {
        workService.delete(id);
        return "redirect:/";
    }
    @RequestMapping("/new")
    public String showNewProductForm(Model model) {
        Worker worker = new Worker();
        model.addAttribute("worker", worker);

        return "new_product";

    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveWorker(@ModelAttribute("worker") Worker worker) {
        workService.save(worker);
        System.out.println(worker.getBirthdayDate());
        System.out.println(worker.getEmployDate());
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");

        Worker worker = workService.get(id);
        mav.addObject("worker", worker);

        return mav;
    }
}
