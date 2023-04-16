package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Persona;
import com.portfolio.backend.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://maria-valdez.netlify.app"})
public class PersonaController {

    @Autowired
    IPersonaService ipersonaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "Person has been created";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable int id) {
        ipersonaService.deletePersona(id);
        return "Person has been deleted";
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable int id,
            @RequestParam("nombre") String nuevoNombre) {
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);

        ipersonaService.savePersona(persona);
        return persona;
    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((int) 1);
    }
}
