package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Project;
import com.portfolio.backend.Interface.IProjectService;
import com.portfolio.backend.Repository.IProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {
    @Autowired IProjectRepository iprojectRepository;
    
    @Override
    public List<Project> getProject() {
        List<Project> project = iprojectRepository.findAll();
        return project;
    }

    @Override
    public void saveProject(Project project) {
        iprojectRepository.save(project);
    }

    @Override
    public Project findProject(int id) {
        Project project = iprojectRepository.findById(id).orElse(null);
        return project;
    }

    @Override
    public void deleteProject(int id) {
        iprojectRepository.deleteById(id);
    }
}
