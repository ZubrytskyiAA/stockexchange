package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Issue;
import ua.bu.service.interfaces.IssueService;

@Controller
@RequestMapping("/issue")
public class IssueController {


    @Autowired
    private IssueService issueService;

    @GetMapping("")
    public String getAllIssues(Model model) {
        model.addAttribute("issues", issueService.getAll());
        return "issueList";
    }

    @PostMapping("/deleteIssueById")
    public String deleteById(@ModelAttribute Issue issue) {
        issueService.deleteById(issue.getId());
        return "redirect:/issue";
    }

    @PostMapping("/newIssue")
    public String createIssue(@ModelAttribute Issue issue ) {
               issueService.save(issue);
        return "redirect:/issue";
    }

    @PostMapping("/setActivities")
    public String setActive(@ModelAttribute Issue setActive, Model model) {
        Issue issue = issueService.getById(setActive.getId());
        issue.setActive(setActive.isActive());
        issueService.updateIssue(issue);
        return "redirect:/issue";
    }


    @GetMapping("/{name}")
    public String getIssueById(@PathVariable("name") String name, Model model) {
        model.addAttribute("issue", issueService.getByName(name));
        return "showIssue";
    }

}
