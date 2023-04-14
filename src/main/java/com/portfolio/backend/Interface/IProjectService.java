package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.Project;
import java.util.List;

public interface IProjectService {
    public List<Project> getProject();
    
    public void saveProject(Project project);
    
    public Project findProject(int id);
    
    public void deleteProject(int id);
}
