package ua.bu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bu.entity.Quote;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.QuoteService;
import ua.bu.service.interfaces.UserService;

@Controller
@RequestMapping("/quote")
public class QuoteController {


    @Autowired
    private QuoteService quoteService;
    @Autowired
    private IssueService issueService;
    @Autowired
    private UserService userService;

    @GetMapping("")
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


    @PostMapping("/addNewQuote")
    public String createUser(@ModelAttribute("price") double price, @ModelAttribute("userId") long userId, @ModelAttribute("issueName") String issueName, @ModelAttribute("optradio") String type, @ModelAttribute("qty") long qty) {

        if (issueService.isIssueActiveByName(issueName)) {


            Quote quote = new Quote();
            quote.setQty(qty);
            quote.setIssueId(issueService.getByName(issueName));
            quote.setPrice(price);
            quote.setType(type);
            quote.setUserId(userService.getById(userId));

            quoteService.save(quote);
        }

//        Quote quote = new Quote();
//        quote.setIssueId(issueService.getById(issueId));
//        quote.setQty();
//        quoteService.save(user);
        return "redirect:/qouteRetrieval";
    }


}
