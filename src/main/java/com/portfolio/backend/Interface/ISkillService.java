package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.Skill;
import java.util.List;

public interface ISkillService {
    public List<Skill> getSkill();
    
    public void saveSkill(Skill skill);
    
    public Skill findSkill(int id);
    
    public void deleteSkill(int id);
}
