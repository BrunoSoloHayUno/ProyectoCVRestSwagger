package arg.proyecto.persona.repository;

import arg.proyecto.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*JpaRepository:
* al extender de esta interface nos da
* todos los metodos basicos del CRUD
* tales como registrar, actualizar (modificar?) y borrar*/
@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer> {

}
