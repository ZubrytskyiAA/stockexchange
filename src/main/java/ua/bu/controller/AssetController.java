package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Asset;
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

        List<Asset> assetList = assetService.getListAssetsByUserName(name);
        List<String> listIssueNamesActive = issueService.getListNamesActiveIssue();
        if (!listIssueNamesActive.isEmpty()) {
            model.addAttribute("listIssueNamesActive", listIssueNamesActive);
        }
        if (!assetList.isEmpty()) {
            model.addAttribute("listAssetsByUserName", assetList);
        }
        model.addAttribute("selectedIssueName", "");
        return "assetList";
    }


    @PostMapping("/addAsset")
    public String addAsset(@ModelAttribute("userName") String userName,
                           @ModelAttribute("issueName") String issueName,
                           @ModelAttribute("qtyAdd") double qtyAdd) {
        if (userName.equals("") || userName.equals("") || qtyAdd <= 0) {
            return "redirect:/asset/" + userName;
        }

        Asset asset = new Asset();
        asset.setFree(Math.abs(qtyAdd));
        asset.setIssueId(issueService.getByName(issueName));
        asset.setUserId(userService.getByName(userName));
        assetService.addNewAsset(asset);
        return "redirect:/asset/" + userName;
    }


    @PostMapping("/withdrawAsset")
    public String withdrawAsset(@ModelAttribute("userName") String userName,
                           @ModelAttribute("issueName") String issueName,
                           @ModelAttribute("qtyWithdraw") double qtyAdd) {
        if (userName.equals("") || userName.equals("") || qtyAdd <= 0) {
            return "redirect:/asset/" + userName;
        }

        Asset asset = new Asset();
        asset.setFree(Math.abs(qtyAdd));
        asset.setIssueId(issueService.getByName(issueName));
        asset.setUserId(userService.getByName(userName));
        assetService.withdrawAsset(asset);
        return "redirect:/asset/" + userName;
    }


}
