package ua.bu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.QuoteService;

@Controller
@RequestMapping("/qouteRetrieval")
public class QouteRetrievalController {

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private IssueService issueService;


    @GetMapping("")
    public String getAllQuotes(Model model) {
        model.addAttribute("quotes", quoteService.getAll());
        model.addAttribute("listIssue", issueService.getAll());
        model.addAttribute("selectedIssueName", "");
        model.addAttribute("selectedIssueId", 1);
        return "quoteRetrieval";
    }

    @GetMapping("/{id}")
    public String getQRByName(@PathVariable("id") long id, Model model) {
       // model.addAttribute("issueByName", issueService.getByName(name));
        model.addAttribute("quotes", quoteService.getAllQuoteByIssueId(id));
        model.addAttribute("listIssue", issueService.getAll());
        model.addAttribute("selectedIssueName", issueService.getById(id).getName());
        model.addAttribute("selectedIssueId", issueService.getById(id).getId());
        return "quoteRetrieval";
    }


}
