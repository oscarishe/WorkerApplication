package net.codejava.Controller;

import net.codejava.Model.Punishment;
import net.codejava.Model.Worker;
import net.codejava.Service.PunishmentService;
import net.codejava.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PunishmentController {
    @Autowired
    private PunishmentService punishmentService;

    @Autowired
    private WorkerService workerService;
    @RequestMapping(value = "/punish", method= RequestMethod.POST)
    public String punishWorker(@ModelAttribute("punishment") Punishment punishment) {
        punishment.setStatus(1);
        punishmentService.save(punishment);
        return "redirect:/";
    }
    @RequestMapping("/archive_punishment/{id}")
    public String restoreWorker(@PathVariable(name = "id") Long id) {
        Punishment punishment = punishmentService.get(id);
        punishment.setStatus(0);
        punishmentService.save(punishment);
        return "redirect:/profile/" + punishment.getWorker();
    }
    @RequestMapping("/punishments")
    public String getVacancies(Model model) {
        List<Worker> listWorker = workerService.listAll();
        List<Punishment> listActive = punishmentService.listAllActive();
        List<Punishment> listArchive = punishmentService.listAllArchive();
        model.addAttribute("listWorker",listWorker);
        model.addAttribute("listActive", listActive);
        model.addAttribute("listArchive", listArchive);

        return "punishments";
    }
}
