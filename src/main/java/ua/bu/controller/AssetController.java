package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Asset;
import ua.bu.service.interfaces.AssetService;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.UserService;

import java.util.ArrayList;
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
        model.addAttribute("selectUserName", "");
        model.addAttribute("listNamesAllUsers", userService.getListNamesAllUsers());
        return "assetList";
    }


    @GetMapping("/{name}")
    public String getWithdrawByName(@PathVariable("name") String name, Model model) {

        model.addAttribute("selectUserName", name);
        model.addAttribute("listNamesAllUsers", userService.getListNamesAllUsers());

        List<String> listIssueNamesActive = issueService.getListNamesActiveIssue();

        if (!listIssueNamesActive.isEmpty()) {
            model.addAttribute("listIssueNamesActive", listIssueNamesActive);
        }


        List<Asset> assetList = assetService.getListAssetsByUserName(name);
        if (assetList.isEmpty()) {

            return "assetList";
        }


        List<Asset> listQuantityMoney = new ArrayList<>();
        List<Asset> listQuantityIssues = new ArrayList<>();

        for (Asset asset : assetList) {
            if (asset.getIssueId().getName().equalsIgnoreCase("UAH")) {
                listQuantityMoney.add(asset);
            } else {
                listQuantityIssues.add(asset);
            }
        }
        if (!listQuantityMoney.isEmpty()) {
            model.addAttribute("listQuantityMoney", listQuantityMoney);
        }
        if (!listQuantityIssues.isEmpty()) {
            model.addAttribute("listQuantityIssues", listQuantityIssues);
        }


        // model.addAttribute("listAssetsByUserName", assetList);


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
        if (userName.equals("") || issueName.equals("") || qtyAdd <= 0) {
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
