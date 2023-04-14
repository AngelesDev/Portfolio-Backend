package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Skill;
import com.portfolio.backend.Interface.ISkillService;
import com.portfolio.backend.Repository.ISkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
    @Autowired ISkillRepository iskillRepository;
    
    @Override
    public List<Skill> getSkill() {
        List<Skill> skill = iskillRepository.findAll();
        return skill;
    }

    @Override
    public void saveSkill(Skill skill) {
        iskillRepository.save(skill);
    }

    @Override
    public Skill findSkill(int id) {
        Skill skill = iskillRepository.findById(id).orElse(null);
        return skill;
    }

    @Override
    public void deleteSkill(int id) {
        iskillRepository.deleteById(id);
    }
}
