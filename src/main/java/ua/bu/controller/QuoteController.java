package ua.bu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bu.service.interfaces.QuoteService;

@Controller
@RequestMapping("/quote/")
public class QuoteController {


    @Autowired
    private QuoteService quoteService;

    @GetMapping("/allquotes")
    public String getAllQuotes(Model model) {
//        Issue issue = assetService.getAll().get(0).getIssueId();
//        User user = assetService.getAll().get(0).getUserId();
//        // user.getIssueList().add(issue);
//        System.out.println("=============================================");
//        System.out.println(issue);
//        System.out.println(user);


        model.addAttribute("quotes", quoteService.getAll());
        return "quoteList";
    }



}
