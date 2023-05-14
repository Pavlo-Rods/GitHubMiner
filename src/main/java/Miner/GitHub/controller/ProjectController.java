package Miner.GitHub.controller;

import Miner.GitHub.model.project.Project;
import Miner.GitHub.service.ProjectService;
import Miner.GitHub.model.gitminer.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("github/projects")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @GetMapping("/{owner}/{name}")
    public Project findOne(@PathVariable(value = "owner") String owner,
                           @PathVariable(value = "name") String name,
                           @RequestParam(defaultValue = "2") Integer sinceCommits,
                           @RequestParam(defaultValue = "20") Integer sinceIssues,
                           @RequestParam(defaultValue = "2") Integer maxPages){
        return service.findOne(owner, name, sinceCommits, sinceIssues, maxPages);
    }

    @PostMapping("/{owner}/{name}")
    public Example postGitMiner(@PathVariable(value = "owner") String owner,
                                @PathVariable(value = "name") String name,
                                @RequestParam(defaultValue = "2") Integer sinceCommits,
                                @RequestParam(defaultValue = "20") Integer sinceIssues,
                                @RequestParam(defaultValue = "2") Integer maxPages){
        return service.postGitMiner(owner, name, sinceCommits, sinceIssues, maxPages);
    }

}
