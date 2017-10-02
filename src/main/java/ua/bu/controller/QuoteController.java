package ua.bu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("quotes", quoteService.getAll());
        return "quoteList";
    }


    @PostMapping("/addNewQuote")
    public String createUser(@ModelAttribute("price") double price, @ModelAttribute("userId") long userId, @ModelAttribute("issueName") String issueName, @ModelAttribute("optradio") String type, @ModelAttribute("qty") long qty) {

        if (issueService.isIssueActiveByName(issueName) && price > 0 && qty > 0) {
            Quote quote = new Quote();
            quote.setQty(qty);
            quote.setIssueId(issueService.getByName(issueName));
            quote.setPrice(price);
            quote.setType(type);
            quote.setUserId(userService.getById(userId));
            quoteService.addQuote(quote);
        }

        return "redirect:/qouteRetrieval/" + issueName;
    }


    @GetMapping("/edit/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        Quote quote = quoteService.getById(id);
        if (quote == null) {
            model.addAttribute("error", "Нету котировки с таким ID");
        } else {
            model.addAttribute("quote", quote);
        }

        return "editQuote";

    }


    @GetMapping("/delete/{id}")
    public String deleteQuote(@PathVariable("id") int id) {
        quoteService.delete(quoteService.getById(id));
        return "redirect:/quote";
    }


    @PostMapping("/editQuote")
    public String editQuote(@ModelAttribute Quote quote, Model model) {

        if (quote.getPrice() > 0 && quote.getQty() > 0) {
            Quote quote1 = quoteService.getById(quote.getId());
            quote.setType(quote1.getType());
            quote.setIssueId(quote1.getIssueId());
            quote.setUserId(quote1.getUserId());
            quoteService.delete(quote);
            quoteService.addQuote(quote);
        }

        return "redirect:/quote";
    }


}
