package arg.proyecto.persona.service.mapper;

import arg.proyecto.persona.controller.request.PersonaRequest;
import arg.proyecto.persona.domain.Persona;
import org.modelmapper.ModelMapper;


/*clase mapper:
* Esta clase nos permite pasar datos
* de una clase a otra cuando no podemos
* hacerlo de otra manera.
*
* tambien ayuda a tener el codigo mas limpio siguiendo
* el proncipio de responsabilidad unica.
*
* tambien se sigue un principio basico tanto
* en la clase entidad como en la clase request
* las columnas deben tener el mismo nombre.*/
public class PersonaMapper {

    private ModelMapper mapper = new ModelMapper();

    public Persona personaReqToPersonaEntity(PersonaRequest personaReq) {
        return mapper.map(personaReq, Persona.class);
    }
}
