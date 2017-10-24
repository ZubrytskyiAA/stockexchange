package ua.bu.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.bu.dao.interfaces.IssueDao;
import ua.bu.entity.Issue;
import ua.bu.service.interfaces.IssueService;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {


    private static final Logger logger = Logger.getLogger(QuoteServiceImpl.class);

    @Autowired
    private IssueDao issueDao;


    @Override
    public List<Issue> getAll() {
        return issueDao.getAll();
    }

    @Override
    public void deleteById(long id) {
        issueDao.deleteById(id);
    }

    @Override
    public void save(Issue issue) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        if (issueDao.isLoginNameUnique(issue.getName()) && !StringUtils.isEmpty(issue.getName()) && !StringUtils.isEmpty(issue.getFullName())) {
            try {
                issueDao.save(issue);
                logger.info(" issue saved by " + user + ", " + issue);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.info("User: " + user + " try save invalid issue :" + issue);
        }
    }

    @Override
    public Issue getById(long id) {
        return issueDao.getById(id);

    }


    @Override
    public List<String> getListNamesActiveIssue() {
        return issueDao.getAllActive();
    }

    @Override
    public boolean isIssueActiveByName(String name) {
        return issueDao.isIssueActiveByName(name);
    }

    @Override
    public Issue updateIssue(Issue issue) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            Issue updatedIssue = issueDao.updateIssue(issue);
            logger.info(" issue updated by " + user + ", " + updatedIssue);
            return updatedIssue;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }


    }

    @Override
    public Issue getByName(String name) {
        return issueDao.getByName(name);
    }


}
