package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.About;
import com.portfolio.backend.Interface.IAboutService;
import com.portfolio.backend.Repository.IAboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpAboutService implements IAboutService {
    @Autowired IAboutRepository iaboutRepository;

    @Override
    public List<About> getAbout() {
        List<About> about = iaboutRepository.findAll();
        return about;
    }

    @Override
    public void saveAbout(About about) {
        iaboutRepository.save(about);
    }
    
    @Override
    public About findAbout(Long id) {
        About about = iaboutRepository.findById(id).orElse(null);
        return about;
    }
}