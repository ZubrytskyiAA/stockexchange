package ua.bu.service.interfaces;

import ua.bu.entity.Issue;

import java.util.List;

public interface IssueService {

    List<Issue> getAll();

    void deleteById(long id);

    void save(Issue issue);

    Issue getById(long id);

    List<String> getAllActive();

    boolean isIssueActiveByName(String name);

    Issue updateIssue(Issue issue);
    Issue getByName(String name);

}
