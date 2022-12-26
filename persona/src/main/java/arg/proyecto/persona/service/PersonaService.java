package arg.proyecto.persona.service;

import arg.proyecto.persona.controller.request.PersonaRequest;
import arg.proyecto.persona.domain.Persona;

import java.util.List;


public interface PersonaService {

    Persona registrar(PersonaRequest persona);
    List<Persona> ListarTodos();
    Persona actualizar(PersonaRequest persona);

    void eliminar(Integer id);

    Persona findById(Integer id);
}
