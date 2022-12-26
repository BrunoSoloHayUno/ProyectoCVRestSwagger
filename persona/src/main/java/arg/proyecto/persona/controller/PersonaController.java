package arg.proyecto.persona.controller;

import arg.proyecto.persona.controller.request.PersonaRequest;
import arg.proyecto.persona.domain.Persona;
import arg.proyecto.persona.model.Response;
import arg.proyecto.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/people")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> obtenerPersonas(){

        return personaService.ListarTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity <Persona> obtenerPersona(@PathVariable Integer id){

        return new ResponseEntity<>(personaService.findById(id), HttpStatus.OK);
    }

    //Cuando indicamos que vamos a recibir una entidad utilizamos un
    // ResponseEntity <entidad>
    @PostMapping
    public ResponseEntity <Persona> registrar(@Valid @RequestBody PersonaRequest persona){

        return new ResponseEntity<>(personaService.registrar(persona), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity <Persona> actualizar(@PathVariable Integer id, @Valid @RequestBody PersonaRequest persona){
        persona.setId(id);
        return new ResponseEntity<>(personaService.actualizar(persona), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <Response> eliminar(@PathVariable Integer id){
        personaService.eliminar(id);
        return new ResponseEntity<>(new Response("Se elimino correctamente"), HttpStatus.OK);
    }
}
