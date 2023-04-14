package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Experience;
import com.portfolio.backend.Interface.IExperienceService;
import com.portfolio.backend.Repository.IExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService {
    @Autowired IExperienceRepository iexperienceRepository;
    
    @Override
    public List<Experience> getExperience() {
        List<Experience> experience = iexperienceRepository.findAll();
        return experience;
    }

    @Override
    public void saveExperience(Experience experience) {
        iexperienceRepository.save(experience);
    }

    @Override
    public Experience findExperience(int id) {
        Experience experience = iexperienceRepository.findById(id).orElse(null);
        return experience;
    }

    @Override
    public void deleteExperience(int id) {
        iexperienceRepository.deleteById(id);
    }
}
