package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.Experience;
import java.util.List;

public interface IExperienceService {
    public List<Experience> getExperience();
    
    public void saveExperience(Experience experience);
    
    public Experience findExperience(int id);
    
    // Eliminar un objeto pero lo buscamos por id
    public void deleteExperience(int id);
}
