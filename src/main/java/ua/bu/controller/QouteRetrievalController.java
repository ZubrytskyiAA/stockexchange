package ua.bu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.bu.entity.Asset;
import ua.bu.service.interfaces.AssetService;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.QuoteService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/qouteRetrieval")
public class QouteRetrievalController {

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private IssueService issueService;

    @Autowired
    private AssetService assetService;

    @GetMapping("")
    public String getAllQuotes(Model model) {


        model.addAttribute("quotes", quoteService.getAll());

        //-----
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Asset> listAssetList = assetService.getListAssetsByUserName(loginName);
        List<Asset> assetListOnlyIssue = new ArrayList<>();
        List<Asset> assetListOnlyMoney = new ArrayList<>();
        if (!listAssetList.isEmpty()) {
            for (Asset asset : listAssetList) {
                if (asset.getIssueId().getName().equals("UAH")) {
                    assetListOnlyMoney.add(asset);
                } else {
                    assetListOnlyIssue.add(asset);
                }
            }

            if (!assetListOnlyMoney.isEmpty())
                model.addAttribute("assetListOnlyMoney", assetListOnlyMoney);
            if (!assetListOnlyIssue.isEmpty())
                model.addAttribute("assetListOnlyIssue", assetListOnlyIssue);
        }
        //-----
        List<String> activeList = issueService.getListNamesActiveIssue();
        if (!activeList.isEmpty()) {
            model.addAttribute("listIssue", activeList);
            model.addAttribute("selectedIssueName", activeList.get(0));
            model.addAttribute("quotes", quoteService.getAllQuoteByIssueName(activeList.get(0)));
        }

        return "quoteRetrieval";
    }


    @GetMapping("/{issueName}")
    public String getQRByName(@PathVariable("issueName") String issueName, Model model,
                              @RequestParam(value = "error", required = false) String errorAfterAddQuote) {

        //-----
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Asset> listAssetList = assetService.getListAssetsByUserName(loginName);
        List<Asset> assetListOnlyIssue = new ArrayList<>();
        List<Asset> assetListOnlyMoney = new ArrayList<>();
        if (!listAssetList.isEmpty()) {
            for (Asset asset : listAssetList) {
                if (asset.getIssueId().getName().equals("UAH")) {
                    assetListOnlyMoney.add(asset);
                } else {
                    assetListOnlyIssue.add(asset);
                }
            }

            if (!assetListOnlyMoney.isEmpty())
                model.addAttribute("assetListOnlyMoney", assetListOnlyMoney);
            if (!assetListOnlyIssue.isEmpty())
                model.addAttribute("assetListOnlyIssue", assetListOnlyIssue);
        }
        //-----


        if (issueService.isIssueActiveByName(issueName)) {
            model.addAttribute("selectedIssueName", issueName);
            model.addAttribute("quotes", quoteService.getAllQuoteByIssueName(issueName));
            model.addAttribute("listIssue", issueService.getListNamesActiveIssue());
            if (!StringUtils.isEmpty(errorAfterAddQuote)) model.addAttribute("error", errorAfterAddQuote);

            return "quoteRetrieval";
        } else {
            return "redirect:/qouteRetrieval";
        }


    }


}
