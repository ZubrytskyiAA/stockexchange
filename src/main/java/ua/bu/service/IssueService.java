package ua.bu.service;

import ua.bu.entity.Issue;

import java.util.List;

public interface IssueService {

    List<Issue> getAll();

    void deleteById(int id);

    void save(Issue issue);

    Issue getById(int id);


}
