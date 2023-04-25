package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Skill;
import com.portfolio.backend.Interface.ISkillService;
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
public class SkillController {
    @Autowired ISkillService iskillService;
    
    @GetMapping("/skills/get")
    public List<Skill> getSkill() {
        return iskillService.getSkill();
    }
    
    @PostMapping("/skills/create")
    public String createSkill(@RequestBody Skill skill) {
        iskillService.saveSkill(skill);
        return "Skill was created successfully";
    }
    
    @DeleteMapping("/skills/delete/{id}")
    public String deleteSkill(@PathVariable int id) {
        iskillService.deleteSkill(id);
        return "Skill has been deleted";
    }
    
    @PutMapping("/skills/edit/{id}")
    public Skill editSkill(@PathVariable int id,
                               @RequestParam("name") String newName,
                               @RequestParam("level") String newLevel) {
        Skill skill = iskillService.findSkill(id);
        skill.setLevel(newLevel);
        skill.setName(newName);
        
        iskillService.saveSkill(skill);
        return skill;
    }
}
