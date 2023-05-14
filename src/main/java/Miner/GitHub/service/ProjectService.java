package Miner.GitHub.service;

import Miner.GitHub.model.Usuario;
import Miner.GitHub.model.commit.Committer;
import Miner.GitHub.model.gitminer.Example;
import Miner.GitHub.model.issue.User;
import Miner.GitHub.model.comment.Comment;
import Miner.GitHub.model.commit.Commit;
import Miner.GitHub.model.commit.CommitSearch;
import Miner.GitHub.model.comment.CommentSearch;
import Miner.GitHub.model.issue.Issue;
import Miner.GitHub.model.issue.issueData;
import Miner.GitHub.model.project.Project;
import Miner.GitHub.model.project.ProjectSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    private static final String uri = "https://api.github.com/repos/";
    private static final String token = "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";
    public Project findOne(String owner, String name,
                           Integer maxPage, Integer sinceCommits, Integer sinceIssues){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<ProjectSearch> response =
                restTemplate.exchange(
                        uri + owner + "/" + name,
                        HttpMethod.GET,
                        entity,
                        ProjectSearch.class
                );

        Project project = Project.ofFormat(response.getBody());

        if(!findAllCommits(owner, name, sinceCommits, maxPage).isEmpty()){
            project.setCommits(findAllCommits(owner, name, sinceCommits, maxPage));
        }
        if(!findAllIssues(owner, name, sinceIssues, maxPage).isEmpty()){
            project.setIssues(findAllIssues(owner, name, sinceIssues, maxPage));
        }

        return project;
    }

    public List<Commit> findAllCommits(String owner, String name,
                                       Integer sinceCommits, Integer maxPage){
        List<Commit> commits = new ArrayList<>();
        List<CommitSearch> cs = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        int page = 1;
        Boolean hasNext = true;

        while(hasNext && page <= maxPage){
            UriComponentsBuilder uriBuilder =
                    UriComponentsBuilder.fromUriString(uri + owner + "/" + name + "/commits")
                            .queryParam("page", page);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            ResponseEntity<CommitSearch[]> response =
                    restTemplate.exchange(
                            uriBuilder.toUriString(),
                            HttpMethod.GET,
                            entity,
                            CommitSearch[].class
                    );
            List<CommitSearch> pageCommit = Arrays.stream(response.getBody()).toList();
            cs.addAll(pageCommit);

            String linkHeader = response.getHeaders().getFirst("Link");
            if(linkHeader == null || !linkHeader.contains("rel=\"next\"")){
                hasNext = false;
            }else{
                page++;
            }
        }

        for(CommitSearch c: cs){
            Committer ct = c.getCommit().getCommitter();
            String[] d = ct.getDate().split("T")[0].split("-");

            LocalDate date = LocalDate.of(Integer.valueOf(d[0]), Integer.valueOf(d[1]),
                    Integer.valueOf(d[2]));

            if(date.datesUntil(LocalDate.now()).toList().stream().count() < sinceCommits){
                commits.add(Commit.ofFormat(c));
            }
        }

        return commits;
    }

    public List<Issue> findAllIssues(String owner, String name,
                                     Integer sinceIssues, Integer maxPage){
        List<Issue> issues = new ArrayList<>();
        List<issueData> is = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        int page = 1;
        Boolean hasNext = true;

        while(hasNext && page <= maxPage){
            UriComponentsBuilder uriBuilder =
                    UriComponentsBuilder.fromUriString(uri + owner + "/" + name + "/issues")
                            .queryParam("page", page);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            ResponseEntity<issueData[]> response =
                    restTemplate.exchange(
                            uriBuilder.toUriString(),
                            HttpMethod.GET,
                            entity,
                            issueData[].class
                    );
            List<issueData> pageCommit = Arrays.stream(response.getBody()).toList();
            is.addAll(pageCommit);

            String linkHeader = response.getHeaders().getFirst("Link");
            if(linkHeader == null || !linkHeader.contains("rel=\"next\"")){
                hasNext = false;
            }else{
                page++;
            }
        }

        for(issueData i: is){
            String[] d = i.getUpdatedAt().split("T")[0].split("-");

            LocalDate date = LocalDate.of(Integer.valueOf(d[0]), Integer.valueOf(d[1]),
                    Integer.valueOf(d[2]));

            if(date.datesUntil(LocalDate.now()).toList().stream().count() < sinceIssues){
                Issue issue = Issue.ofFormat(i);

                if(i.getAssignee() != null){
                    issue.setAsignee(Usuario.ofFormat(i.getAssignee()));
                }
                issue.setAuthor(Usuario.ofFormat(i.getUser()));
                issue.setComments(findAllComments(owner, name, Integer.valueOf(issue.getRef_id()), maxPage));
                issues.add(issue);
            }
        }

        return issues;
    }

    public List<Comment> findAllComments(String owner, String name, int issueNumber, Integer maxPage){

        List<Comment> res = new ArrayList<>();
        List<CommentSearch> cs = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        int page = 1;
        Boolean hasNext = true;

        while(hasNext && page <= maxPage){
            UriComponentsBuilder uriBuilder =
                    UriComponentsBuilder.fromUriString(uri + owner + "/" + name + "/issues/" + issueNumber + "/comments")
                            .queryParam("page", page);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            ResponseEntity<CommentSearch[]> response =
                    restTemplate.exchange(
                            uriBuilder.toUriString(),
                            HttpMethod.GET,
                            entity,
                            CommentSearch[].class
                    );
            List<CommentSearch> pageCommit = Arrays.stream(response.getBody()).toList();
            cs.addAll(pageCommit);

            String linkHeader = response.getHeaders().getFirst("Link");
            if(linkHeader == null || !linkHeader.contains("rel=\"next\"")){
                hasNext = false;
            }else{
                page++;
            }
        }

        for(CommentSearch commentSearch: cs){
                Comment comment = Comment.ofFormat(commentSearch);
                comment.setAuthor(Usuario.ofFormat(commentSearch.getUser()));
                res.add(comment);
            }

        return res;
    }

    public Example postGitMiner(String owner, String name,
                                Integer sinceIssues, Integer sinceCommit, Integer maxPages){
        String uri = "http://localhost:8080/gitminer/projects";
        Project project = findOne(owner, name, sinceCommit, sinceIssues, maxPages);
        Example e = Example.ofFormat(project);

        ResponseEntity<Example> response = restTemplate.postForEntity(uri, e, Example.class);

        return response.getBody();
    }

}
