package net.codejava.Controller;


import net.codejava.Model.Fired;
import net.codejava.Model.Worker;
import net.codejava.Service.FiredWorkerService;
import net.codejava.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class FiredController {
    @Autowired
    private FiredWorkerService fireService;
    @Autowired
    private WorkerService workService;

    @RequestMapping("/restore/{id}")
    public String restoreWorker(@PathVariable(name = "id") Long id) {
        Worker worker = workService.get(id);
        worker.setActive(true);
        worker.setStatus(1);
        workService.save(worker);
        Fired fired = fireService.getByWorkerId(id);
        fireService.delete(fired.getId());
        return "redirect:/fired_list";
    }

}
