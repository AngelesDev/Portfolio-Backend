package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.Education;
import java.util.List;

public interface IEducationService {
    public List<Education> getEducation();
    
    public void saveEducation(Education education);
    
    public Education findEducation(int id);
    
    public void deleteEducation(int id);
}
