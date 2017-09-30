package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bu.service.interfaces.AssetService;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.UserService;

import java.util.List;


@Controller
@RequestMapping("/asset")
public class AssetController {


    @Autowired
    private AssetService assetService;
    @Autowired
    private IssueService issueService;
    @Autowired
    private UserService userService;


    @GetMapping("")
    public String getAllAssets(Model model) {
        //model.addAttribute("assets", assetService.getAll());
        model.addAttribute("selectUserName", "");
        model.addAttribute("listNamesAllUsers", userService.getListNamesAllUsers());

//        List<String> activeList = issueService.getListNamesActiveIssue();
//        if (!activeList.isEmpty()) {
//            model.addAttribute("listIssue", activeList);
//            model.addAttribute("selectedIssueName", activeList.get(0));
//

            // model.addAttribute("quotes", quoteService.getAllQuoteByIssueName(activeList.get(0)));
//        }

        return "assetList";
    }


    @GetMapping("/{name}")
    public String getWithdrawByName(@PathVariable("name") String name, Model model) {

        model.addAttribute("selectUserName", name);
        model.addAttribute("listNamesAllUsers", userService.getListNamesAllUsers());
        model.addAttribute("listAssetsByUserName", assetService.getListAssetsByUserName(name));


            List<String> activeList = issueService.getListNamesActiveIssue();
            model.addAttribute("listIssue", activeList);
            model.addAttribute("selectedIssueName", "");



            return "assetList";


    }


    @GetMapping("/{userName}/{issueName}")
    public String getWithdrawInformation(@PathVariable("userName") String userName,@PathVariable("issueName") String issueName, Model model) {


        List<String> activeList = issueService.getListNamesActiveIssue();
        model.addAttribute("listIssue", activeList);
        model.addAttribute("selectedIssueName", activeList.get(0));
        model.addAttribute("listNamesAllUsers", userService.getListNamesAllUsers());
        model.addAttribute("selectUserName", userName);
        model.addAttribute("selectIssueName", issueName);
        model.addAttribute("available", 1111);
        return "assetList";


    }

}
