package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Issue;
import ua.bu.service.interfaces.IssueService;

@Controller
@RequestMapping("/issue/")
public class IssueController {


    @Autowired
    private IssueService issueService;

     @GetMapping("/allissues")
    public String getAllIssues(Model model) {
        model.addAttribute("issues", issueService.getAll());
        return "issueList";
    }

    @PostMapping("/deleteIssueById")
    public String deleteById(@ModelAttribute Issue issue) {
        issueService.deleteById(issue.getId());
        return "redirect:issues";
    }

    @PostMapping("/newIssue")
    public String createIssue(@ModelAttribute Issue issue) {
        issueService.save(issue);
        return "redirect:issues";
    }
//    @PostMapping("/delete")
//    public String deleteIssue(@ModelAttribute("id") int id) {
//        issueService.deleteById(id);
//        return "redirect:issues";
//    }

    @GetMapping("/issue/{id}")
    public String getIssueById(@PathVariable("id") int id, Model model) {
        model.addAttribute("issue", issueService.getById(id));
        return "showIssue";
    }

}
