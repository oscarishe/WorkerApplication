package net.codejava.Controller;

import net.codejava.Document.DocumentCreator;
import net.codejava.Model.*;
import net.codejava.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
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
    @Autowired
    private VacationService vacationService;
    @Autowired
    SickleaveService sickleaveService;
    @RequestMapping("/workers")
    public String viewHomePage(Model model) throws IOException {
        DocumentCreator doc = new DocumentCreator();
        List<Worker> listWorker = workService.listAllActive();
        model.addAttribute("workerCount", workService.getCountOfWorkers());
        model.addAttribute("listWorker", listWorker);
        return "workers";
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
        worker.setStatus(0);
        workService.save(worker);
        Fired firedWorker = new Fired();
        firedWorker.setIdentity(id);
        fireService.save(firedWorker);
        return "redirect:/";
    }
    @RequestMapping(value = "/fire", method = RequestMethod.POST)
    public String fireWorkers(@ModelAttribute("firedWorker") Fired firedWorker, HttpServletResponse response) throws IOException {
        Worker worker = workService.get(firedWorker.getIdentity());
        Department department = depService.get(worker.getDepartmentId());
        worker.setActive(false);
        worker.setStatus(0);
        workService.save(worker);
        fireService.save(firedWorker);
        DocumentCreator doc = new DocumentCreator();
        doc.createFireOrder("fire.docx","prikaz.docx",worker,firedWorker,department);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment; filename=document.docx");
        response.setHeader("Content-Transfer-Encoding", "binary");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream("prikaz.docx");
            int len;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) > 0) {
                bos.write(buf,0,len);
            }
            bos.close();
            response.flushBuffer();
        }
        catch(IOException e) {
            e.printStackTrace();

        }
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
    @RequestMapping("/profile/{id}")
    public ModelAndView showWorkerProfile(@PathVariable(name = "id") Long id) throws IOException {
        ModelAndView mav = new ModelAndView("profile");

        Fired firedWorker = new Fired();
        Worker worker = workService.get(id);
        Vacation vacation  = new Vacation();
        Sickleave sickleave = new Sickleave();
        Department dep = depService.get(worker.getDepartmentId());
        List <Vacation> vacationList = vacationService.listById(id);
        List <Sickleave> sickleaveList = sickleaveService.listById(id);
        List <Fired> firedList = fireService.listByWorkerId(id);
        mav.addObject("vacationList",vacationList);
        mav.addObject("sickleaveList",sickleaveList);
        mav.addObject("sickleave", sickleave);
        mav.addObject("firedList", firedList);
        mav.addObject("vacation",vacation);
        mav.addObject("fired", firedWorker);
        mav.addObject("dep", dep);
        mav.addObject("worker", worker);
        DocumentCreator doc = new DocumentCreator();
        return mav;
    }
    @RequestMapping("/fired_list")
    public String getFiredList(Model model) {
        List <Worker> listWorker   = workService.listAllunactive();
        List <Fired> firedList = fireService.listAll();
        model.addAttribute("listWorker", listWorker);
        model.addAttribute("firedList",firedList);
        return "fired_list";
    }
    @RequestMapping("/employ_order/{id}")
    @ResponseBody
    public void downloadFile(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        Worker worker = workService.get(id);
        DocumentCreator doc = new DocumentCreator();
        doc.createEmployOrder("prikaz_priem_na_rabotu.docx","prikaz.docx",worker);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment; filename=document.docx");
        response.setHeader("Content-Transfer-Encoding", "binary");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream("prikaz.docx");
            int len;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) > 0) {
                bos.write(buf,0,len);
            }
            bos.close();
            response.flushBuffer();
        }
        catch(IOException e) {
            e.printStackTrace();

        }
    }

}
