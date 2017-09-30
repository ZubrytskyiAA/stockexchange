package ua.bu.dao.interfaces;

import org.springframework.stereotype.Component;
import ua.bu.entity.Issue;

import java.util.List;


@Component
public interface IssueDao {
    List<Issue> getAll();

    Issue getById(long id);
    Issue getByName(String name);

    void deleteById(long id);

    void save(Issue issue);

    boolean isLoginNameUnique(String name);

    void addIssueToUserId(long id);
    List<String> getAllActive();
    boolean isIssueActiveByName(String name);
    Issue updateIssue(Issue issue);


}
