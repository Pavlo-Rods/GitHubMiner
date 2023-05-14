package Miner.GitHub.service;

import Miner.GitHub.model.commit.Commit;
import Miner.GitHub.model.commit.CommitSearch;
import Miner.GitHub.model.issue.Issue;
import Miner.GitHub.model.issue.issueData;
import Miner.GitHub.model.project.Project;
import Miner.GitHub.model.project.ProjectSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    private static final String uri = "https://api.github.com/repos/";

    public Project findOne(String owner, String name){
        ProjectSearch p = restTemplate.getForObject(uri + owner + "/" + name,
                ProjectSearch.class);
        Project project = Project.ofFormat(p);

        project.setCommits(findAllCommits(owner, name));

        return project;
    }

    public List<Commit> findAllCommits(String owner, String name){
        CommitSearch[] c = restTemplate.getForObject(uri + owner + "/" + name + "/commits",
                CommitSearch[].class);

        return Arrays.stream(c).map(e-> Commit.ofFormat(e)).toList();
    }

    public List<Issue> findAllIssues(String owner, String name){
        issueData[] i = restTemplate.getForObject(uri + owner + "/" + name + "/issues",
                issueData[].class);

        return Arrays.stream(i).map(e-> Issue.ofFormat(e)).toList();
    }

}
