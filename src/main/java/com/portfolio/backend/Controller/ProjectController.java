package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Project;
import com.portfolio.backend.Interface.IProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://argp-66abf.firebaseapp.com"})
public class ProjectController {
    @Autowired IProjectService iprojectService;
    
    @GetMapping("/projects/get")
    public List<Project> getProject() {
        return iprojectService.getProject();
    }
    
    @PostMapping("/projects/create")
    public String createProject(@RequestBody Project project) {
        iprojectService.saveProject(project);
        return "Project was created successfully";
    }
    
    @DeleteMapping("/projects/delete/{id}")
    public String deleteProject(@PathVariable int id) {
        iprojectService.deleteProject(id);
        return "Project has been deleted";
    }
    
    @PutMapping("/projects/edit/{id}")
    public Project editProject(@PathVariable int id,
                               @RequestParam("title") String newTitle,
                               @RequestParam("body") String newBody,
                               @RequestParam("skillsUsed") String newSkillsUsed,
                               @RequestParam("gitHubLink") String newGitHubLink,
                               @RequestParam("webPageLink") String newWebPageLink) {
        Project project = iprojectService.findProject(id);
        project.setTitle(newTitle);
        project.setBody(newBody);
        project.setSkillsUsed(newSkillsUsed);
        project.setGitHubLink(newGitHubLink);
        project.setWebPageLink(newWebPageLink);

        
        iprojectService.saveProject(project);
        return project;
    }
}
