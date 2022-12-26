package arg.proyecto.persona.impl;

import arg.proyecto.persona.controller.request.PersonaRequest;
import arg.proyecto.persona.domain.Persona;
import arg.proyecto.persona.repository.PersonaRepository;
import arg.proyecto.persona.service.PersonaService;
import arg.proyecto.persona.service.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    /*Autowire:
    * hace lo mismo que en los beans pero
    * de manera automática
    *
    * en otras palabras hace la inyeccion de dependecia de manera automatica XD*/

    /*quizas generemos mas validaciones?*/
    @Autowired
    private PersonaRepository personaRepository;

    PersonaMapper mapper = new PersonaMapper();

    @Override
    public Persona registrar(PersonaRequest personaReq) {
        Persona persona = personaReqToPersonaEntity(personaReq);
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> ListarTodos() {
        return personaRepository.findAll();
    }

    @Override
    public Persona actualizar(PersonaRequest personaReq) {
        Persona persona = mapper.personaReqToPersonaEntity(personaReq);
        return personaRepository.save(persona);
    }

    @Override
    public void eliminar(Integer id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findById(Integer id) {
        return personaRepository.findById(id).get();
    }

    private Persona personaReqToPersonaEntity(PersonaRequest personaReq){
        Persona persona = new Persona();
        persona.setEmail(personaReq.getEmail());
        persona.setGender(personaReq.getGender());
        persona.setName(personaReq.getName());
        return persona;
    }
}
