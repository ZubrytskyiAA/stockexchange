package ua.bu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Quote;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.QuoteService;
import ua.bu.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        List<Quote> quoteList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        if (auth.getAuthorities().toString().contains("ADMIN")) {
            quoteList = quoteService.getAll();
        } else {
            quoteList = quoteService.getAllQuoteByUserName(auth.getName());
        }

        if (!quoteList.isEmpty()) {
            int size = quoteList.size();
            int step = 10;


            for (int i = 0; i <= (size - 1) / step; i++) {
                intList.add(i);
            }
            if (size >= step) {
                model.addAttribute("quotes", quoteList.subList(0, step));
            } else {
                model.addAttribute("quotes", quoteList.subList(0, size));

            }
            model.addAttribute("listSize", size);
            model.addAttribute("listLinks", intList);
            model.addAttribute("currentPage", 0);
        }


        return "quoteList";


    }


    @GetMapping("/{id}")
    public String getListQuotes(@PathVariable("id") int id, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<Quote> quoteList = new ArrayList<>();

        if (auth.getAuthorities().toString().contains("ADMIN")) {
            quoteList = quoteService.getAll();
        } else {
            quoteList = quoteService.getAllQuoteByUserName(auth.getName());
        }

        if (!quoteList.isEmpty()) {
            int size = quoteList.size();
            int step = 10;

            List<Integer> intList = new ArrayList<>();
            for (int i = 0; i <= (size - 1) / step; i++) {
                intList.add(i);
            }
            if (size < id * step) {
                model.addAttribute("quotes", quoteList.subList(size / step * step, size / step * step + size % step));
                model.addAttribute("currentPage", size / step);
            } else if (size > (id + 1) * step) {
                model.addAttribute("quotes", quoteList.subList(id * step, (id + 1) * step));
                model.addAttribute("currentPage", id);
            } else {
                model.addAttribute("quotes", quoteList.subList(id * step, size));
                model.addAttribute("currentPage", id);
            }
            model.addAttribute("listSize", size);
            model.addAttribute("listLinks", intList);
        }


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
            String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
            quote.setUserId(userService.getByName(currentUserName));
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
