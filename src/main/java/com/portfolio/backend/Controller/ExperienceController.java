package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Experience;
import com.portfolio.backend.Interface.IExperienceService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {
    @Autowired IExperienceService iexperienceService;
    
    @GetMapping("/experiences/get")
    public List<Experience> getExperience() {
        return iexperienceService.getExperience();
    }
    
    @PostMapping("/experiences/create")
    public String createExperience(@RequestBody Experience experience) {
        iexperienceService.saveExperience(experience);
        return "Experience was created successfully";
    }
    
    @DeleteMapping("/experiences/delete/{id}")
    public String deleteExperience(@PathVariable int id) {
        iexperienceService.deleteExperience(id);
        return "Experience has been deleted";
    }
    
    @PutMapping("/experiences/edit/{id}")
    public Experience editExperience(@PathVariable int id,
                               @RequestParam("title") String newTitle,
                               @RequestParam("body") String newBody) {
        Experience experience = iexperienceService.findExperience(id);
        experience.setTitle(newTitle);
        experience.setBody(newBody);
        
        iexperienceService.saveExperience(experience);
        return experience;
    }
}
