package ua.bu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.QuoteService;

import java.util.List;

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
        List<String> activeList = issueService.getListNamesActiveIssue();
        if (!activeList.isEmpty()) {
            model.addAttribute("listIssue", activeList);
            model.addAttribute("selectedIssueName", activeList.get(0));
            model.addAttribute("quotes", quoteService.getAllQuoteByIssueName(activeList.get(0)));
        }


        //model.addAttribute("selectedIssueId", 1);
        return "quoteRetrieval";
    }

//
//    @GetMapping("")
//    public String getAllQuotes(Model model) {
//        model.addAttribute("quotes", quoteService.getAll());
//        model.addAttribute("listIssue", issueService.getAll());
//        model.addAttribute("selectedIssueName", "");
//        model.addAttribute("selectedIssueId", 1);
//        return "quoteRetrieval";
//    }


    @GetMapping("/{issueName}")
    public String getQRByName(@PathVariable("issueName") String issueName, Model model) {
        if (issueService.isIssueActiveByName(issueName)) {
            model.addAttribute("selectedIssueName", issueName);
            model.addAttribute("quotes", quoteService.getAllQuoteByIssueName(issueName));
            model.addAttribute("listIssue", issueService.getListNamesActiveIssue());
            return "quoteRetrieval";
        }else{

            String error = "dsdadasad";
            model.addAttribute("errorMsg",error);
            return "redirect:/qouteRetrieval";
        }
        // model.addAttribute("issueByName", issueService.getByName(name));



    }


}
