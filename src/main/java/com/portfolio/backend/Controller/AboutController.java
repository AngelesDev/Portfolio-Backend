package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.About;
import com.portfolio.backend.Interface.IAboutService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://maria-valdez.netlify.app"})
public class AboutController {
    @Autowired IAboutService iaboutService;
    
    @GetMapping("/about/traer")
    public List<About> getAbout() {
        return iaboutService.getAbout();
    }
    
    @PostMapping("/about/crear")
    public String createAbout(@RequestBody About about) {
        iaboutService.saveAbout(about);
        return "El about fue creado correctamente";
    }
    
    @PutMapping("/about/editar/{id}")
    public About editAbout(@PathVariable Long id,
                               @RequestParam("body") String nuevoAbout) {
        About about = iaboutService.findAbout(id);
        about.setBody(nuevoAbout);
        
        iaboutService.saveAbout(about);
        return about;
    }
    
    @GetMapping("/about/traer/perfil")
    public About findAbout() {
        return iaboutService.findAbout((long)1);
    }
}