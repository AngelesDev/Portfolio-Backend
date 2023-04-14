package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.About;
import jakarta.transaction.Transactional;
import java.util.List;

@Transactional

public interface IAboutService {
    public List<About> getAbout();
    
    public void saveAbout(About about);
    
    public About findAbout(Long id);
    
    // Eliminar un objeto pero lo buscamos por id
    //public void deletePersona(Long id);
}