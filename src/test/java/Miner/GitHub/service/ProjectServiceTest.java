package Miner.GitHub.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    ProjectService service;

    private static final String owner = "spring-projects";
    private static final String name = "spring-framework";
    @Test
    void findOne(){
        System.out.println(service.findOne(owner, name, 2, 20, 2));
    }

    @Test
    void findAllCommits(){
        System.out.println(service.findAllCommits(owner, name, 2, 2));
    }

    @Test
    void findAllIssues(){
        System.out.println(service.findAllIssues(owner, name, 20, 2));
    }

    @Test
    void findAllComments(){
        System.out.println(service.findAllComments(owner, name, 30482, 2));
    }
}
