package net.codejava.Controller;

import net.codejava.Model.Fired;
import net.codejava.Model.Sickleave;
import net.codejava.Model.Vacation;
import net.codejava.Model.Worker;
import net.codejava.Service.SickleaveService;
import net.codejava.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SickleaveController {

    @Autowired
    private SickleaveService sickleaveService;

    @Autowired
    private WorkerService workerService;

    @RequestMapping(value = "/sick", method= RequestMethod.POST)
    public String vacateWorkers(@ModelAttribute("sickleave") Sickleave sickleave) {
        sickleaveService.save(sickleave);
        Worker worker = workerService.get(sickleave.getIdentity());
        worker.setStatus(3);
        workerService.save(worker);
        return "redirect:/";
    }

    @RequestMapping("/sick_list")
    public String getSickList(Model model) {
        List <Worker> listWorker = workerService.listAllSick();
        List<Sickleave> sickList = sickleaveService.listAll();
        model.addAttribute("listWorker", listWorker);
        model.addAttribute("sickList",sickList);
        return "sick_list";
    }
}
