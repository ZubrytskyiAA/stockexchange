package ua.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bu.dao.interfaces.IssueDao;
import ua.bu.entity.Issue;
import ua.bu.service.interfaces.IssueService;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

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
        if (issueDao.isLoginNameUnique(issue.getName()))
            issueDao.save(issue);

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
        return issueDao.updateIssue(issue);
    }

    @Override
    public Issue getByName(String name) {
        return issueDao.getByName(name);
    }


}
