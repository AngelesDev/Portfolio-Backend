package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Education;
import com.portfolio.backend.Interface.IEducationService;
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
public class EducationController {
    @Autowired IEducationService ieducationService;
    
    @GetMapping("/education/get")
    public List<Education> getEducation() {
        return ieducationService.getEducation();
    }
    
    @PostMapping("/education/create")
    public String createEducation(@RequestBody Education education) {
        ieducationService.saveEducation(education);
        return "Education was created successfully";
    }
    
    @DeleteMapping("/education/delete/{id}")
    public String deleteEducation(@PathVariable int id) {
        ieducationService.deleteEducation(id);
        return "Education has been deleted";
    }
    
    @PutMapping("/education/edit/{id}")
    public Education editEducation(@PathVariable int id,
                               @RequestParam("title") String newTitle,
                               @RequestParam("body") String newBody) {
        Education education = ieducationService.findEducation(id);
        education.setTitle(newTitle);
        education.setBody(newBody);
        
        ieducationService.saveEducation(education);
        return education;
    }    
}
