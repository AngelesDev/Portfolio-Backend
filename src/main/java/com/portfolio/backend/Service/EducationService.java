package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Education;
import com.portfolio.backend.Interface.IEducationService;
import com.portfolio.backend.Repository.IEducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {
    @Autowired IEducationRepository ieducationRepository;
    
    @Override
    public List<Education> getEducation() {
        List<Education> experience = ieducationRepository.findAll();
        return experience;
    }

    @Override
    public void saveEducation(Education education) {
        ieducationRepository.save(education);
    }

    @Override
    public Education findEducation(int id) {
        Education education = ieducationRepository.findById(id).orElse(null);
        return education;
    }

    @Override
    public void deleteEducation(int id) {
        ieducationRepository.deleteById(id);
    }
}
