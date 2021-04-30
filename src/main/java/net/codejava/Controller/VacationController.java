package net.codejava.Controller;

import net.codejava.Model.Vacation;
import net.codejava.Model.Worker;
import net.codejava.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class VacationController {

    @Autowired
    private VacationService service;

    @Autowired
    private WorkerService workerService;
    @RequestMapping(value = "/vacate", method= RequestMethod.POST)
        public String vacateWorkers(@ModelAttribute("vacation") Vacation vacation) {
            service.save(vacation);
            Worker worker = workerService.get(vacation.getIdentity());
            worker.setStatus(2);
            workerService.save(worker);
            return "redirect:/";
        }
    @RequestMapping("/vacation_list")
    public String getVacationList(Model model) {
        List<Worker> listWorker = workerService.listAll();
        List<Vacation> listVacate = service.listActive();
        List<Vacation> listArchive = service.listArchive();
        model.addAttribute("listArchive", listArchive);
        model.addAttribute("listWorker", listWorker);
        model.addAttribute("listVacate", listVacate);
        return "vacation_list";
    }
}
