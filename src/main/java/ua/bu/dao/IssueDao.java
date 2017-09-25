package ua.bu.dao;

import org.springframework.stereotype.Component;
import ua.bu.entity.Issue;

import java.util.List;


@Component
public interface IssueDao {
    List<Issue> getAll();

    Issue getById(int id);

    void deleteById(int id);

    void save(Issue issue);

    boolean isLoginNameUnique(String name);

    void addIssueToUserId(int id);



}
